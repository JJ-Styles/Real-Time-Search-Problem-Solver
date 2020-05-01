package uk_ac_tees_t7047098.rtsps.myClojure;

import fyp.a_star;
import uk_ac_tees_t7047098.rtsps.app.Debug;

/**
 * Class handles the A* algorithm.
 * Extends the super class Search algorithm.
 */
public class AStar extends SearchAlgorithm {

    private final String heuristic;

    /**
     * @param goal property required for the algorithm to run, passes it to super.
     * @param graph property required for the algorithm to run, passes it to super.
     * @param start property required for the algorithm to run, passes it to super.
     * @param heuristic property required for the algorithm to run, stored in the class.
     */
    AStar(String goal, String graph, String start, String heuristic) {
        super(graph, start, goal);
        this.heuristic = heuristic;
    }

    /**
     * Runs the Clojure code for A* with the properties required.
     * Calls the super to check if the result is a valid result.
     * Adds the exception to the Debug class if one occurs.
     */
    @Override
    public void run() {
        try{
            checkResult(a_star.aStarMethod(getStart(), getGoal(), getGraph(), heuristic));
        } catch (Exception e) {
            Debug.addException(e);
        }
    }

    /**
     * @return The name of the algorithm that will be returned to the User.
     */
    @Override
    public String toString(){
        return "A*";
    }
}
