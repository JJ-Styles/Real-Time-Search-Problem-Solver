package uk_ac_tees_t7047098.rtsps.myClojure;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Controllers the algorithms and gets the result with the best time complexity by running them concurrently.
 */
public class ClojureController {
    private List<SearchAlgorithm> algorithms = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();
    private boolean isComplete = false;
    private String solution;

    /**
     * @param graph the value that should represent the graph for the search algorithm
     * @param start the value that should represent the start for the search algorithm
     * @param goal the value that should represent the goal for the search algorithm
     * @param heur the value that should represent the heuristic for the search algorithm, can be null
     * @return the solution to the search and the name of the algorithm that returned a result the quickest.
     */
    public String runAlgorithms(String graph, String start, String goal, String heur) {
        algorithms.add(new Dfs(goal, graph, start));
        algorithms.add(new Bfs(goal, graph, start));
        algorithms.add(new AStar(goal, graph, start, heur));
        algorithms.add(new Dijkstra(goal, graph, start));

        for (SearchAlgorithm item : algorithms) {
            threads.add(new Thread(item, item.toString()));
        }

        threads.forEach(Thread::start);

        int counter = 0;
        while (!isComplete) {
            for (SearchAlgorithm algorithm : algorithms) {
                if (algorithm.isValid()) {
                    solution = "The algorithm used was: " + algorithm.toString() + ". The Solution is: " + algorithm.getResult();
                    isComplete = true;
                    break;
                } else if (algorithm.getResult().equals("Not Found")) {
                    counter += 1;
                    if (counter == algorithms.size()){
                        solution = "Not Found";
                        break;
                    }
                }
            }
        }

        return solution;
    }
}
