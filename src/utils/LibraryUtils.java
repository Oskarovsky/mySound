package utils;

import data.Library;
import data.Mix;
import data.File;
import data.Track;
import data.LibraryUser;


import java.util.*;


public class LibraryUtils {

    // Printing list of user
    public static void printUsers(Library lib) {
        lib.getUsers().values()
                .stream()
                .sorted((a,b) -> a.getLogin().compareTo(b.getLogin()))
                .forEach(System.out::println);

    }


    // Printing info about tracks
    public static void printTracks(Library lib) {
        printFiles(lib, Track.class);
    }


    // Printing info about mixes
    public static void printMixes(Library lib) {
        printFiles(lib, Mix.class);
    }


    // Printing info about files (this method is importing to both printing methods above)
    private static void printFiles(Library lib, Class cl) {
        long countFiles = lib.getFiles()
                .values()
                .stream()
                .filter(cl::isInstance)
                .sorted(new Library.AlphaBeticalComparator())
                .peek(System.out::println).count();

        if (countFiles == 0) {
            System.out.println("There are no following type files in library: " + cl.getSimpleName());
        }
    }
}
