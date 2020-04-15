package uk_ac_tees_t7047098.rtsps.app;

import uk_ac_tees_t7047098.rtsps.Problem.NaturalLanguageProcessing;
import uk_ac_tees_t7047098.rtsps.Problem.SearchNLP;
import uk_ac_tees_t7047098.rtsps.Problem.SearchProperties;
import uk_ac_tees_t7047098.rtsps.myClojure.ClojureController;

public class Main {

    public static void main(String[] args) {
        String input = "Tom wishes to Start at :A and End at :C within the graph :A [{:B 20 :E 10 :D 4 :G 9 :J 15}]\n" +
                ":B [{:A 20 :C 11 :D 9 :E 21}]\n" +
                ":C [{:B 11 :H 13 :I 14 :D 3}]\n" +
                ":D [{:B 9 :A 4 :C 3 :H 15 :J 10}]\n" +
                ":E [{:A 10 :B 21 :F 16 :G 17}]\n" +
                ":F [{:E 16 :G 24}]\n" +
                ":G [{:E 17 :F 24 :K 5 :J 7 :A 9}]\n" +
                ":H [{:C 13 :I 2 :D 15 :J 4 :K 23}]\n" +
                ":I [{:H 2 :C 14}]\n" +
                ":J [{:G 7 :K 10 :H 4 :D 10 :A 15}]\n" +
                ":K [{:G 5 :J 10 :H 23}]. This graph uses the heuristic :A 7\n" +
                ":B 11\n" +
                ":C 0\n" +
                ":D 3\n" +
                ":E 17\n" +
                ":F 33\n" +
                ":G 20\n" +
                ":H 13\n" +
                ":I 14\n" +
                ":J 13\n" +
                ":K 23";

        NaturalLanguageProcessing nlp = new NaturalLanguageProcessing(input.toLowerCase());
        SearchNLP searchNLP = new SearchNLP();
        SearchProperties searchProperties = searchNLP.getSearchProperties();

        searchNLP.search(nlp.getLemmas(), nlp.getTokens());
        ClojureController algorithms = new ClojureController();
        String solution = algorithms.runAlgorithms(searchProperties.getGraph(), searchProperties.getStart(), searchProperties.getEnd(), searchProperties.getHeuristic());

        System.out.println(solution);
    }
}

/*
String file = "uk_ac_tees_t7047098/rtsps/app/testfile";

        try{
            IFn require = Clojure.var("clojure.core", "require");
            require.invoke(Clojure.read(file));

            Clojure.var(file, "hello-world").invoke();

            IFn add = Clojure.var(file, "add");
            String add56 = add.invoke(5, 6).toString();
            System.out.println(add56);
        } catch (Exception e)
        {
            System.out.println(e.toString() + "" + Arrays.toString(e.getStackTrace()));
        }
 */
