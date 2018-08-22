package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.Library;

// class, which is responsible for writing and reading files data

public class FileManager {
    public static final String FILE_NAME = "Library.o";

    public void writeLibraryToFile(Library lib) {
        try(
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ) {
            oos.writeObject(lib);

        } catch (FileNotFoundException e) {
            System.out.println("File has not found " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error while saving data");
        }
    }

    public Library readLibraryFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        Library library = null;
        try(
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
            library = (Library) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("File has not found " + FILE_NAME);
            throw e;
        } catch (IOException e) {
            System.out.println("Error while reading data " + FILE_NAME);
            throw e;
        } catch (ClassNotFoundException e) {
            System.out.println("Incorrect file format");
            throw e;
        }

        return library;
    }
}
