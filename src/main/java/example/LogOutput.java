package example;

import org.apache.log4j.Logger;

public class LogOutput {

    Logger logger = Logger.getLogger(LogOutput.class);

    LogOutput(){}

    void outputLog(){
        logger.info("Hello Logger!!");
    }
}
