package app;

public class LibraryApp {

    // the version of the program
    public static final String APP_NAME = "mySound v0.8";

    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libControl = new LibraryControl();
        libControl.controlLoop();
    }
}
