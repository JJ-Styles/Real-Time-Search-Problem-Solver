package uk_ac_tees_t7047098.rtsps.Problem;

public class SearchProperties {
    private String graph;
    private String Start;
    private String End;
    private String heuristic;

    SearchProperties() {
        this.graph = null;
        this.End = null;
        this.heuristic = null;
        this.Start = null;
    }

    public String getGraph() {
        return graph;
    }

    void setGraph(String graph) {
        this.graph = graph;
    }

    public String getStart() {
        return Start;
    }

    void setStart(String start) {
        Start = start;
    }

    public String getEnd() {
        return End;
    }

    void setEnd(String end) {
        End = end;
    }

    public String getHeuristic() {
        return heuristic;
    }

    void setHeuristic(String heuristic) {
        this.heuristic = heuristic;
    }
}
