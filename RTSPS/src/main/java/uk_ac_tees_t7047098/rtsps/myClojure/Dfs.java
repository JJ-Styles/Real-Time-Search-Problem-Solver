package uk_ac_tees_t7047098.rtsps.myClojure;

import fyp.dfs;

public class Dfs extends SearchAlgorithm {
    private String graph;
    private String start;
    private String goal;

    Dfs(String goal, String graph, String start) {
        super();
        this.goal = goal;
        this.graph = graph;
        this.start = start;
    }

    @Override
    public void run() {
        String tempResult = dfs.dfsMethod(graph, start, goal);
        checkResult(tempResult);
    }

    @Override
    public String toString(){
        return "DFS";
    }
}
