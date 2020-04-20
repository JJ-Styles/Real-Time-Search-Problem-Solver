package uk_ac_tees_t7047098.rtsps.myClojure;

import fyp.a_star;

public class AStar extends SearchAlgorithm {
    private String graph;
    private String start;
    private String goal;
    private String heuristic;

    AStar(String goal, String graph, String start, String heuristic) {
        super();
        this.goal = goal;
        this.graph = graph;
        this.start = start;
        this.heuristic = heuristic;
    }

    @Override
    public void run() {
        String tempResult = a_star.aStarMethod(start, goal, graph, heuristic);
        checkResult(tempResult);
    }

    @Override
    public String toString(){
        return "A*";
    }
}
