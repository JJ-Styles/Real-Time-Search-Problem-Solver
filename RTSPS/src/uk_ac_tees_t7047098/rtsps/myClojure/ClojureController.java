package uk_ac_tees_t7047098.rtsps.myClojure;

import java.util.ArrayList;
import java.util.List;

public class ClojureController {
    private List<SearchAlgorithm> algorithms = new ArrayList<>();
    private List<Thread> threads = new ArrayList<>();
    private boolean isComplete = false;
    private String solution;

    public String runAlgorithms(String graph, String start, String goal, String heur) {
        algorithms.add(new Dfs(goal, graph, start));
        algorithms.add(new Bfs(goal, graph, start));
        algorithms.add(new AStar(goal, graph, start, heur));
        algorithms.add(new Dijkstra(goal, graph, start));

        for (SearchAlgorithm item : algorithms) {
            threads.add(new Thread(item, item.toString()));
        }

        threads.forEach(Thread::start);

        while (!isComplete) {
            for (SearchAlgorithm algorithm : algorithms) {
                if (algorithm.isValid()) {
                    solution = "The algorithm used was: " + algorithm.toString() + ". The Solution is: " + algorithm.getResult();
                    isComplete = true;
                    break;
                }
            }
        }

        return solution;
    }
}
