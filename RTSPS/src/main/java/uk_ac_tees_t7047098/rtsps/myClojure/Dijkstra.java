package uk_ac_tees_t7047098.rtsps.myClojure;

import fyp.dijkstra;

public class Dijkstra extends SearchAlgorithm {
    private String graph;
    private String start;
    private String goal;

    Dijkstra(String goal, String graph, String start) {
        super();
        this.goal = goal;
        this.graph = graph;
        this.start = start;
    }

    @Override
    public void run() {
        String tempResult = dijkstra.dijkstraMethod(start, goal, graph);
        checkResult(tempResult);
    }

    @Override
    public String toString(){
        return "Dijkstra's";
    }
}
