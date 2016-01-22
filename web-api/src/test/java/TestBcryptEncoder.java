import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class TestBcryptEncoder {
    @Autowired
    BCryptPasswordEncoder cryptPasswordEncoder;

    static final Logger logger = Logger.getRootLogger();

    @BeforeClass
    public static void setUpClass() throws Exception{
    }

    @Before
    public void setUp() throws Exception{
//        cryptPasswordEncoder = new BCryptPasswordEncoder();
    }
    @Test
    public void testPasswordGeneration() throws Exception{
        String encoderedString = cryptPasswordEncoder.encode("root");
        logger.info("Example of encodered string: " + encoderedString);
        Assert.assertEquals("Problem with password encoding: ",true, cryptPasswordEncoder.matches("root", encoderedString));
    }

}
