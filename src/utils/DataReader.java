package utils;

import java.util.Scanner;
import java.util.InputMismatchException;

import data.File;
import data.LibraryUser;
import data.Mix;
import data.Track;

public class DataReader {
    private Scanner sc;

    public DataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    // taking number from user (for choosing one of the options)
    public int getInt() throws NumberFormatException {
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("The number entered in an incorrect form");
        } finally {
            sc.nextLine();
        }
        return number;
    }


    // loading new users data
    public LibraryUser readAndCreateLibraryUser() {
        System.out.println("Login: ");
        String login = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        // return new user
        return new LibraryUser(login, email, password);
    }

    // taking data from user - TRACK
    public Track readAndCreateTrack() throws InputMismatchException {
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Artist: ");
        String artist = sc.nextLine();
        System.out.println("Version: ");
        String version = sc.nextLine();
        System.out.println("Genre: ");
        String genre = sc.nextLine();
        System.out.println("Release: ");
        int year = 0;
        try {
            year = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }
        System.out.println("Length: ");
        String length = sc.nextLine();

        // return the track data
        return new Track(title, artist, version, genre, year, length);
    }

    // taking data from user - MIX
    public Mix readAndCreateMix() {
        System.out.println("Title: ");
        String title = sc.nextLine();
        System.out.println("Artist: ");
        String artist = sc.nextLine();
        System.out.println("Genre: ");
        String genre = sc.nextLine();
        System.out.println("Release: ");
        int year = 0;
        try {
            year = sc.nextInt();
        } catch (InputMismatchException e) {
            throw e;
        } finally {
            sc.nextLine();
        }
        System.out.println("Length: ");
        String length = sc.nextLine();

        // return the mix data
        return new Mix(title, artist, genre, year, length);

    }

}
