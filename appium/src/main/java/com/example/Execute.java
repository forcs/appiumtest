package com.example;

import com.google.common.util.concurrent.ExecutionList;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

/**
 * @author eva
 * @date 2017/5/16
 */
public class Execute {

    private static final int COUNTS = 5;
    private static int count = 0;
    private static int successCount = 0, failureCount = 0;

    public static void main(String[] args) {
        run(AndroidContactTest.class);
    }

    private static void run(Class clazz) {
        JUnitCore runner = new JUnitCore();

        runner.addListener(new RunListener() {

            @Override
            public void testFinished(Description description) throws Exception {
//                System.out.println(description.getMethodName() + " end");
            }

            @Override
            public void testRunStarted(Description description) throws Exception {
                System.out.println("--------- START " + ++count + " ----------");

            }

            @Override
            public void testRunFinished(Result result) throws Exception {
                if (result.wasSuccessful()) {
                    successCount++;
                } else {
                    failureCount++;
                }

                System.out.println("执行结果 : " + result.wasSuccessful());
                System.out.println("--------- END " + count + " ----------");

                if (count < COUNTS) {
                    run(AndroidContactTest.class);
                } else {
                    System.out.println("成功次数 : " + successCount + ", 失败次数 : " + failureCount);
                }
            }
        });
        runner.run(clazz);
    }
}
