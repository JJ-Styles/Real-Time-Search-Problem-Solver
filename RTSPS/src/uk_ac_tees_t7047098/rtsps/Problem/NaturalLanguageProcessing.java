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

public class NaturalLanguageProcessing {
    private String input;
    private List<String> sentences = new ArrayList<>();
    private List<String> tokens = new ArrayList<>();
    private List<String> lemmas = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    public NaturalLanguageProcessing(String input) {
        this.input = input;
    }

    static SentenceModel getSentenceModel(String file) {
        try (InputStream modelIn = new FileInputStream(file)) {
            return new SentenceModel(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    static TokenizerModel getTokenModel(String file) {
        try (InputStream modelIn = new FileInputStream(file)) {
            return new TokenizerModel(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    static LemmatizerModel getLemmaModel(String file){
        try (InputStream modelIn = new FileInputStream(file)) {
            return new LemmatizerModel(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    static DictionaryLemmatizer getDictionary(String file){
        try (InputStream modelIn = new FileInputStream(file)) {
            return new DictionaryLemmatizer(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    static POSModel getTagModel(String file){
        try (InputStream modelIn = new FileInputStream(file)) {
            return new POSModel(modelIn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getSentences() {
        if (sentences.isEmpty()){
            generateSentences();
        }
        return sentences;
    }

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

    public List<String> getTokens() {
        if (tokens.isEmpty()){
            generateTokens();
        }
        return tokens;
    }

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

    public List<String> getTags(){
        if (tags.isEmpty()) {
            generateTags();
        }
        return tags;
    }

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

    public List<String> getLemmas(){
        if (lemmas.isEmpty()){
            generateLemmas();
        }
        return lemmas;
    }

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