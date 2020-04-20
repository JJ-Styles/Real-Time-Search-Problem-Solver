package uk_ac_tees_t7047098.rtsps.Problem;

public class SearchProperties {
    private String graph;
    private String Start;
    private String End;
    private String heuristic;

    public SearchProperties() {
        this.graph = null;
        this.End = null;
        this.heuristic = null;
        this.Start = null;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(String heuristic) {
        this.heuristic = heuristic;
    }
}
