package ru.gb.logging;

import java.io.IOException;
import java.util.logging.*;

// SEVERE < WARNING < INFO < CONFIG < FINE < FINER < FINEST

public class App02JavaLogger {
    public static final Logger logger = Logger.getLogger(App02JavaLogger.class.getName());

    public static void main(String[] args) {
        logger.fine("Program started");
        final App02JavaLogger app = new App02JavaLogger();

        Handler h = null;
        try {
            logger.setLevel(Level.FINEST);
            h = new FileHandler("mylogsimple.log");
            h.setFormatter(new SimpleFormatter());
            logger.addHandler(h);
            h = new FileHandler("mylogxml.log");
            h.setFormatter(new XMLFormatter());
            logger.addHandler(h);
            // h = new SocketHandler();
            // h = new ConsoleHandler();
            // h = new StreamHandler();
            // h = new MemoryHandler();
            System.out.println("Handlers");
            for (Handler o : logger.getHandlers()) {
                System.out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.run();
    }

    private void run() {
        logger.fine("Method run call");
        try {
            doSomething();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Something wrong", e);
        }
    }

    private void doSomething() {
        logger.log(Level.FINE, "Method doSomething call");
        throw new RuntimeException();
    }
}
