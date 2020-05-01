package uk_ac_tees_t7047098.rtsps.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the exceptions that occurs and adds them to a List that can be viewed by the user
 */
public class Debug {
    private static List<Exception> exceptionList = new ArrayList<>();

    /**
     * @param e Exception that has occured
     */
    public static void addException(Exception e){
        exceptionList.add(e);
    }

    /**
     * @return the exception list
     */
    static List<Exception> getExceptionList() {
        return exceptionList;
    }

    /**
     * Makes the exception list into a new List to clear the exceptions that are stored in it.
     */
    static void resetDebug() {
        Debug.exceptionList = new ArrayList<>();
    }
}
