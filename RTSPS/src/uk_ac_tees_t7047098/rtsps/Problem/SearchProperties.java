package uk_ac_tees_t7047098.rtsps.Problem;

/**
 * Data Classes which holds the properties that are required for the search algorithms to work.
 */
public class SearchProperties {
    private String graph;
    private String Start;
    private String End;
    private String heuristic;

    /**
     * Constructor nulls the properties so that they have a default value.
     */
    SearchProperties() {
        this.graph = null;
        this.End = null;
        this.heuristic = null;
        this.Start = null;
    }

    /**
     * @return the graph value to the user
     */
    public String getGraph() {
        return graph;
    }

    /**
     * @param graph String that should represent a graph.
     */
    void setGraph(String graph) {
        this.graph = graph;
    }

    /**
     * @return the start value to the user
     */
    public String getStart() {
        return Start;
    }

    /**
     * @param start String that should represent the start node.
     */
    void setStart(String start) {
        Start = start;
    }

    /**
     * @return the end value to the user
     */
    public String getEnd() {
        return End;
    }

    /**
     * @param end String that should represent the end node.
     */
    void setEnd(String end) {
        End = end;
    }

    /**
     * @return the heuristic value to the user
     */
    public String getHeuristic() {
        return heuristic;
    }

    /**
     * @param heuristic String that should represent a heuristic.
     */
    void setHeuristic(String heuristic) {
        this.heuristic = heuristic;
    }
}
