package uk_ac_tees_t7047098.rtsps.myClojure;

/**
 * Super class for each of the algorithms which allows future algorithms to be added effectively
 */
abstract class SearchAlgorithm implements Runnable {

    private final String graph;
    private final String start;
    private final String goal;
    private String result;
    private boolean valid;

    /**
     * @param graph sets the graph property
     * @param start sets the start property
     * @param goal sets the goal property
     */
    SearchAlgorithm(String graph, String start, String goal) {
        this.goal = goal;
        this.graph = graph;
        this.start = start;
        this.result = null;
    }

    /**
     * @return the graph property
     */
    String getGraph() {
        return graph;
    }

    /**
     * @return the start property
     */
    String getStart() {
        return start;
    }

    /**
     * @return the goal property
     */
    String getGoal() {
        return goal;
    }

    /**
     * @return the result property
     */
    String getResult() {
        return result;
    }

    /**
     * @param result sets the result property
     */
    private void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the valid property
     */
    boolean isValid() {
        return valid;
    }

    /**
     * @param valid sets the valid property
     */
    private void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * @param tempResult the result returned by the algorithm, held in a temp variable to determine if the result is not "Not Found"
     */
    void checkResult(String tempResult) {
        setValid(!tempResult.equals("Not Found")); //Result checked so that if i valid answer is found the user gets the result rather than "Not Found"
        setResult(tempResult);
    }
}
