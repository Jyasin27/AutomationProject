package paralleltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import unittests.TricentisTest2;
import unittests.TricentisTests1;

@RunWith(Suite.class)
@SuiteClasses({TricentisTests1.class, TricentisTest2.class})
public class TestSuite  {

}