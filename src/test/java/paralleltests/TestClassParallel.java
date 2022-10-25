package paralleltests;

import listeners.Listener;
import org.junit.jupiter.api.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.JUnitCore;
import unittests.TricentisTests1;
import unittests.TricentisTest2;

@ExtendWith(Listener.class)
public class TestClassParallel {  //Dont worry about, rather use Parallel Execution class methodJava
    @Test
    public void test(){
        Class[] cls = { TricentisTests1.class, TricentisTest2.class};

//        // Parallel among classes
//        JUnitCore.runClasses(ParallelComputer.classes(), cls);
//
//        System.out.println("----------------------------");
//
//        // Parallel among methods in a class
//        JUnitCore.runClasses(ParallelComputer.methods(), cls);
//
//        System.out.println("----------------------------");

        // Parallel all methods in all classes <--This one works to open only 2 chromes
        JUnitCore.runClasses(new ParallelComputer(true, false), cls);
    }

  }

