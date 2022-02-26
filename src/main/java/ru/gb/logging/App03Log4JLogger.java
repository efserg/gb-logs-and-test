package ru.gb.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// уровни логгирования
// FATAL < ERROR < WARN < INFO < DEBUG < TRACE
public class App03Log4JLogger {
    private static final Logger logger = LogManager.getLogger(App03Log4JLogger.class);

    public static void main(String[] args) {
        logger.info("Program started");
        final App03Log4JLogger app = new App03Log4JLogger();
        app.run(31);
    }

    private void run(int a) {
        logger.debug("Method run call a = {}", a);
        try {
            doSomething();
        } catch (Exception e) {
            logger.error("Something wrong", e);
        }
    }

    private void doSomething() {
        logger.log(Level.WARN, "Method doSomething call");
        throw new RuntimeException();
    }

}
