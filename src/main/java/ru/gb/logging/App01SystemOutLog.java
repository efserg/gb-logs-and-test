package ru.gb.logging;

public class App01SystemOutLog {
    public static void main(String[] args) {
        final App01SystemOutLog app = new App01SystemOutLog();
        System.out.println("Program started");
        app.run();
    }

    private void run() {
        System.out.println("Method run call, line number " + new Exception().getStackTrace()[0].getLineNumber());
        try {
            doSomething();
        } catch (Exception e) {
            System.err.println("Something wrong, line number " + new Exception().getStackTrace()[0].getLineNumber());
            e.printStackTrace();
        }
    }

    private void doSomething() {
        System.out.println("Method doSomething call, line number " + new Exception().getStackTrace()[0].getLineNumber());
        throw new RuntimeException();
    }
}
