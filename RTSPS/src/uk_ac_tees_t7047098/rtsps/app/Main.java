package uk_ac_tees_t7047098.rtsps.app;

import uk_ac_tees_t7047098.rtsps.Problem.NaturalLanguageProcessing;
import uk_ac_tees_t7047098.rtsps.Problem.SearchNLP;
import uk_ac_tees_t7047098.rtsps.Problem.SearchProperties;
import uk_ac_tees_t7047098.rtsps.myClojure.ClojureController;
import java.util.Scanner;

/**
 * Default starter Class. Setup just demonstrates how all the classes and methods work together.
 */
public class Main {

    /**
     * Default starter Method. Setup just demonstrates how all the classes and methods work together.
     */
    public static void main(String[] args) {
        // String input = "Tom wishes to Start at A and End at C within the graph :A [{:B 20 :E 10 :D 4 :G 9 :J 15}] :B [{:A 20 :C 11 :D 9 :E 21}] :C [{:B 11 :H 13 :I 14 :D 3}] :D [{:B 9 :A 4 :C 3 :H 15 :J 10}] :E [{:A 10 :B 21 :F 16 :G 17}] :F [{:E 16 :G 24}] :G [{:E 17 :F 24 :K 5 :J 7 :A 9}] :H [{:C 13 :I 2 :D 15 :J 4 :K 23}] :I [{:H 2 :C 14}] :J [{:G 7 :K 10 :H 4 :D 10 :A 15}] :K [{:G 5 :J 10 :H 23}]. This graph uses the heuristic :A 7 :B 11 :C 0 :D 3 :E 17 :F 33 :G 20 :H 13 :I 14 :J 13 :K 23";

        while (true) {
            System.out.println("If you wish to exit please enter exit.");
            System.out.println("If you would like to review the Exceptions enter Debug");
            System.out.println("Please enter your input");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();

            if (input.toLowerCase().equals("exit")){
                break;
            } else if (input.toLowerCase().equals("debug")) {
                Debug.getExceptionList().forEach(System.out::println);
                Debug.resetDebug();
            }else {
                System.out.println(solver(input));
            }
        }
    }

    /**
     * @param input the input from the user
     * @return the solution to the user
     * Method is how the solver works, it runs the Classes and methods that define the actual solver
     */
    private static String solver(String input){
        NaturalLanguageProcessing nlp = new NaturalLanguageProcessing(input.toLowerCase());
        SearchNLP searchNLP = new SearchNLP();
        SearchProperties searchProperties = searchNLP.getSearchProperties();

        searchNLP.search(nlp.getLemmas(), nlp.getTokens());

        if (searchProperties.getGraph() == null || searchProperties.getStart() == null || searchProperties.getEnd() == null) {
            return ("Input was invalid. \nPlease try again.");
        } else {
            ClojureController algorithms = new ClojureController();
            return algorithms.runAlgorithms(searchProperties.getGraph(), searchProperties.getStart(), searchProperties.getEnd(), searchProperties.getHeuristic());
        }
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
