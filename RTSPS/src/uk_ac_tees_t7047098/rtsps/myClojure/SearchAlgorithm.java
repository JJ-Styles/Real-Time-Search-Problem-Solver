package uk_ac_tees_t7047098.rtsps.myClojure;

import java.util.function.Function;

abstract class SearchAlgorithm implements Runnable {

    private String result;
    private boolean valid;

    SearchAlgorithm() {
        this.result = null;
    }

    String getResult() {
        return result;
    }

    private void setResult(String result) {
        this.result = result;
    }

    boolean isValid() {
        return valid;
    }

    private void setValid(boolean valid) {
        this.valid = valid;
    }

    void checkResult(String tempResult) {
        if (tempResult.equals("Not Found")) {
            setValid(false);
        } else {
            setValid(true);
        }
        setResult(tempResult);
    }
}
