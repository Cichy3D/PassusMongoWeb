package pl.passus.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pl.passus.test.dao.RecordDAOTest;

@RunWith(Suite.class)
@SuiteClasses({ RecordDAOTest.class })
public class AllTests {

}
