package elkDemo;

import org.apache.log4j.Logger;

/**
 * Created by Andrew  on 2017/7/12.
 */
public class ApplicationLog4j {
    private static final Logger LOGGER = Logger.getLogger(ApplicationLog4j.class);
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            LOGGER.error("Info log [" + i + "].");
            Thread.sleep(500);
        }
    }
}
