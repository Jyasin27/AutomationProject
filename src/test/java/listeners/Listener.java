package listeners;

import application.SQLQueries;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import unittests.TricentisTest2;
import unittests.TricentisTests1;

import java.lang.reflect.Method;
import java.sql.*;

public class Listener implements TestWatcher, BeforeTestExecutionCallback {

    private static final String START_TIME = "start time";
    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    //Stores all test information
    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getClass()));
    }

    public void result(){
        Result result = new JUnitCore().run(TricentisTests1.class, TricentisTest2.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.getTrace());
        }
    }


    @Override
    public void testSuccessful(ExtensionContext context) {
        SQLQueries sq = new SQLQueries();
           Method testMethod = context.getRequiredTestMethod(); //Prints out test method used
            long startTime = getStore(context).remove(START_TIME, long.class);
            long duration = System.currentTimeMillis() - startTime;

        try {
            sq.reportToDB(testMethod.getName(),  "Pass", String.valueOf(duration/1000));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Listener ls = new Listener();
        ls.result();
        SQLQueries sq = new SQLQueries();

           Method testMethod = context.getRequiredTestMethod();
            long startTime = getStore(context).remove(START_TIME, long.class);
            long duration = System.currentTimeMillis() - startTime;

        try {
            sq.reportToDB(testMethod.getName(), "Fail", cause.getClass().getCanonicalName(), String.valueOf(duration/1000));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }



}
