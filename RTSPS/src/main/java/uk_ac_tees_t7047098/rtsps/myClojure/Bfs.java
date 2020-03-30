package uk_ac_tees_t7047098.rtsps.myClojure;

import fyp.bfs;

public class Bfs extends SearchAlgorithm {
    private String graph;
    private String start;
    private String goal;

    Bfs(String goal, String graph, String start) {
        super();
        this.goal = goal;
        this.graph = graph;
        this.start = start;
    }

    @Override
    public void run() {
        String tempResult = bfs.bfsMethod(graph, start, goal);
        checkResult(tempResult);
    }

    @Override
    public String toString(){
        return "BFS";
    }
}
