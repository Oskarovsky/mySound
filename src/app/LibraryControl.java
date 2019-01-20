package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.LibraryUser;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;
import data.Track;
import data.Library;
import data.Mix;

public class LibraryControl {


    // variables for communication with the user
    private DataReader dataReader;
    private FileManager fileManager;

    // "library" stores data
    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();
        try {
            library = fileManager.readLibraryFromFile();
            System.out.println("The program data has been read from file");
        } catch (ClassNotFoundException | IOException e) {
            library = new Library();
            System.out.println("New application base has been created");
        }

    }

    /*
     * The main program loop, which allows you choose the option and interaction
     */

    public void controlLoop() {
        Option option = null;
        while (option != Option.EXIT)
        {
            try
            {
                printOptions();
                option = Option.createFromInt(dataReader.getInt());
                switch(option)
                {
                    case ADD_TRACK:
                        addTrack();
                        break;
                    case ADD_MIX:
                        addMix();
                        break;
                    case PRINT_TRACKS:
                        printTracks();
                        break;
                    case PRINT_MIXES:
                        printMixes();
                        break;
                    case ADD_USER:
                        addUser();
                        break;
                    case PRINT_USERS:
                        printUsers();
                        break;
                    case EXIT:
                        exit();
                }
            } catch(InputMismatchException e) {
                System.out.println("You've entered incorrect data. The files hasn't been added");
            } catch(NumberFormatException e) {
                System.out.println("There is no that option. Try again!");
            }
        }
        // closing the input stream
        dataReader.close();
    }

    // display all options
    private void printOptions() {
        System.out.println("Choose the option: ");
        for(Option o: Option.values()) {
            System.out.println(o);
        }
    }

    // add new track to the library
    private void addTrack() {
        Track track = dataReader.readAndCreateTrack();
        library.addTrack(track);
    }

    // print info about all tracks
    private void printTracks() {
        LibraryUtils.printTracks(library);
    }


    // add new mix to the library
    private void addMix() {
        Mix mix = dataReader.readAndCreateMix();
        library.addMix(mix);
    }

    // print info about all mixes
    private void printMixes() {
        LibraryUtils.printMixes(library);
    }

    // add user to the application
    private void addUser() {
        LibraryUser user = dataReader.readAndCreateLibraryUser();
        library.addUser(user);
    }

    // print info about all users
    private void printUsers() {
        LibraryUtils.printUsers(library);
    }

    private void exit() {
        fileManager.writeLibraryToFile(library);
    }

    // enumeration type (enum)
    private enum Option {
        EXIT(0, "Exit the program"),
        ADD_TRACK(1, "Add track"),
        ADD_MIX(2, "Add mix"),
        PRINT_TRACKS(3, "Display all available tracks"),
        PRINT_MIXES(4, "Display all available mixes"),
        ADD_USER(5, "Add new user"),
        PRINT_USERS(6, "Display list of users");


        private int value;
        private String description;

        Option(int value, String desc) {
            this.value = value;
            this.description = desc;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException("There is no element with the indicated ID");
            }
            return result;

        }
    }
}
