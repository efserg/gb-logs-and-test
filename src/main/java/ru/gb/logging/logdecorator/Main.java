package ru.gb.logging.logdecorator;

public class Main {
    public static void main(String[] args) {
        final AppLogImpl app = new AppLogImpl();
        final AppLogDecorator appLogDecorator = new AppLogDecorator(app);
        appLogDecorator.run();
    }
}
