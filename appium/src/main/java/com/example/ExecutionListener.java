package com.example;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/**
 * @author eva
 * @date 2017/5/16
 */

public class ExecutionListener extends RunListener {


    private int index;

    public ExecutionListener(int index) {
        this.index = index;
    }

    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("--------- START " + index + " ----------");
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("执行结果 : " + result.wasSuccessful());
        System.out.println("--------- END " + index + " ----------");
    }
}
