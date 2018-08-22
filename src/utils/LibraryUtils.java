package utils;

import data.Library;
import data.Mix;
import data.File;


import java.util.Collection;


public class LibraryUtils {

    // Printing info about tracks
    public static void printTracks(Library lib) {
        Collection<File> files = lib.getFiles().values();
        int countTracks = 0;
        for (File f : files) {
            if (f instanceof File) {
                System.out.println(f);
                countTracks++;
            }
        }

        if (countTracks == 0) {
            System.out.println("There is no tracks in library");
        }
    }


    // Printing info about mixes
    public static void printMixes(Library lib) {
        Collection<File> files = lib.getFiles().values();
        int countMixes = 0;
        for (File f : files) {
            if (f instanceof Mix) {
                System.out.println(f);
                countMixes++;
            }
        }

        if (countMixes == 0) {
            System.out.println("There is no mixes in library");
        }
    }
}
