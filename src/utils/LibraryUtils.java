package utils;

import data.Track;
import data.Library;
import data.Mix;
import data.File;

import java.util.Arrays;

public class LibraryUtils {
    
    // Printing info about tracks
    public static void printTracks(Library lib) {
        File[] files = lib.getFiles();
        Arrays.sort(files, new Library.AlphaBeticalComparator());
        int filesNumber = lib.getFilesNumber();
        int countTracks = 0;
        for (int i = 0; i < filesNumber; i++) {
            if (files[i] instanceof Track) {
                System.out.println(files[i]);
                countTracks++;
            }
        }
        
        if(countTracks == 0) {
            System.out.println("There is no tracks in library");
        }
    }
    
    // Printing info about mixes
    public static void printMixes(Library lib) {
        File[] files = lib.getFiles();
        Arrays.sort(files, new Library.AlphaBeticalComparator());
        int filesNumber = lib.getFilesNumber();
        int countMixes = 0;
        for (int i = 0; i < filesNumber; i++) {
            if (files[i] instanceof Mix) {
                System.out.println(files[i]);
                countMixes++;
            }
        }
        
        if(countMixes == 0) {
            System.out.println("There is no mixes in library");
        }
    }
}
