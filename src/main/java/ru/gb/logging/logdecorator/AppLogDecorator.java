package ru.gb.logging.logdecorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppLogDecorator implements AppLog {
    private static final Logger logger = LogManager.getLogger(AppLog.class);

    private AppLog app;

    public AppLogDecorator(final AppLog app) {
        this.app = app;
    }

    @Override
    public void run() {
        logger.info("run() call");
        app.run();
        logger.info("run() done");
    }

}
