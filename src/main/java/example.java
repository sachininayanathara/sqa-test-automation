import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class example {
    private static final Logger logger = LogManager.getLogger(example.class);
//    static Logger logger = Logger.getLogger("Main.class");
    public static void main(String[] args)
    {
        //PropertiesConfigurator is used to configure logger from properties file
        PropertyConfigurator.configure("C:\\Users\\Sachini Nayanathara\\Documents\\Projects\\SQA_Assignment_Test\\src\\log4j.properties");

        //Log in console in and log file
        logger.info("Log4j appender configuration is successful !!!");
    }
}

