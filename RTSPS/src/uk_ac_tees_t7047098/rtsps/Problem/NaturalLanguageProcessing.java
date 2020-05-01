package uk_ac_tees_t7047098.rtsps.Problem;

import opennlp.tools.lemmatizer.LemmatizerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.lemmatizer.DictionaryLemmatizer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Uses Apache Open NLP to carry out Natural Language Processing
 * Will define several properties from the input that can be used by the solver
 */
public class NaturalLanguageProcessing {
    private String input;
    private List<String> sentences = new ArrayList<>();
    private List<String> tokens = new ArrayList<>();
    private List<String> lemmas = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    /**
     * @param input String from the user that is a natural language text. There is no limit to how big the input could be.
     */
    public NaturalLanguageProcessing(String input) {
        this.input = input;
    }

    /**
     * @param file that contains the model which allows the Sentence Model to be created
     * @return the created Sentence Model
     */
    private static SentenceModel getSentenceModel(String file) {
        try (InputStream modelIn = new FileInputStream(file)) {
            return new SentenceModel(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param file that contains the model which allows the Tokenizer Model to be created
     * @return the created Tokenizer Model
     */
    private static TokenizerModel getTokenModel(String file) {
        try (InputStream modelIn = new FileInputStream(file)) {
            return new TokenizerModel(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param file that contains the model which allows the Dictionary Lemmatizer to be created
     * @return the created Dictionary Lemmatizer
     */
    private static DictionaryLemmatizer getDictionary(String file){
        try (InputStream modelIn = new FileInputStream(file)) {
            return new DictionaryLemmatizer(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param file that contains the model which allows the POS Model to be created
     * @return the created POS Model
     */
    private static POSModel getTagModel(String file){
        try (InputStream modelIn = new FileInputStream(file)) {
            return new POSModel(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return the sentences that make up the input in a List. If no sentences have been generated the method generates them.
     */
    List<String> getSentences() {
        if (sentences.isEmpty()){
            generateSentences();
        }
        return sentences;
    }

    /**
     * Generates the sentences from the input using a specified model.
     * Assigns the generated sentences to the sentences list.
     */
    private void generateSentences(){
        SentenceModel model = getSentenceModel("lib/en-sent.bin");

        if (model == null) {
            sentences = null;
        }
        else {
            SentenceDetector sentenceDetector = new SentenceDetectorME(model);
            sentences = Arrays.asList(sentenceDetector.sentDetect(input));
        }
    }

    /**
     * @return the tokens that make up the input in a List. If no tokens have been generated the method generates them.
     */
    public List<String> getTokens() {
        if (tokens.isEmpty()){
            generateTokens();
        }
        return tokens;
    }

    /**
     * Generates the tokens from the input using a specified model.
     * Assigns the generated tokens to the sentences list.
     */
    private void generateTokens(){
        TokenizerModel model = getTokenModel("lib/en-token.bin");

        if (model == null){
            tokens = null;
        } else {
            Tokenizer tokenizer = new TokenizerME(model);

            if (sentences.isEmpty()){
                generateSentences();
            }

            for (String sentence : sentences) {
                tokens.addAll(Arrays.asList(tokenizer.tokenize(sentence)));
            }
        }
    }

    /**
     * @return the POSTags that make up the input in a List. If no POSTags have been generated the method generates them.
     */
    List<String> getTags(){
        if (tags.isEmpty()) {
            generateTags();
        }
        return tags;
    }

    /**
     * Generates the POSTags from the input using a specified model.
     * Assigns the generated POSTags to the sentences list.
     */
    private void generateTags(){
        POSModel model = getTagModel("lib/en-pos-maxent.bin");

        if (model == null) {
            tags = null;
        } else {
            POSTaggerME tagger = new POSTaggerME(model);

            if (tokens.isEmpty()) {
                generateTokens();
            }

            String[] temp = new String[tokens.size()];
            temp = tokens.toArray(temp);

            tags = Arrays.asList(tagger.tag(temp));
        }
    }

    /**
     * @return the lemmas that make up the input in a List. If no lemmas have been generated the method generates them.
     */
    public List<String> getLemmas(){
        if (lemmas.isEmpty()){
            generateLemmas();
        }
        return lemmas;
    }

    /**
     * Generates the lemmas from the input using a specified model.
     * Assigns the generated lemmas to the sentences list.
     */
    private void generateLemmas(){
        DictionaryLemmatizer dictionary = getDictionary("lib/dictionary.txt");

        if (dictionary == null){
            lemmas = null;
        } else {
            if (tags.isEmpty()) {
                generateTags();
            }

            if (tokens.isEmpty()) {
                generateTokens();
            }

            String[] tempToks = new String[tokens.size()];
            tempToks = tokens.toArray(tempToks);
            String[] tempTags = new String[tags.size()];
            tempTags = tags.toArray(tempTags);

            lemmas = Arrays.asList(dictionary.lemmatize(tempToks, tempTags));
        }
    }
}