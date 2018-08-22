package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {

    // constant, which allows versioning classes
    private static final long serialVersionUID = 2995794334600947814L;

    // variables in the form of a map
    private Map<String, File> files;
    private Map<String, LibraryUser> users;


    // GETTERS - File[] & filesNumber

    // return size of the map with files
    public int getFilesNumber() {
        return files.size();
    }

    // return files
    public Map<String, File> getFiles() {
        return files;
    }

    // return users
    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Library() {
        files = new HashMap<>();
        users = new HashMap<>();
    }

    // Add new track to the library
    public void addTrack(Track track) {
        addFile(track);
    }

    // Add new mix to the library
    public void addMix(Mix mix) {
        addFile(mix);
    }

    // Add user to the application
    public void addUser(LibraryUser user) {
        users.put(user.getLogin(), user);
    }

    // Method, which deletes files from library
    public void removeFile(File file) {
        if (files.containsValue(file)) {
            files.remove(file.getTitle());
        }
    }

    // MAIN METHOD - add new file (mix and track)
    private void addFile(File file) {
        files.put(file.getTitle(), file);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (File f: files.values()) {
            builder.append(f);
            builder.append("\n");
        }
        return builder.toString();
    }

    // sorting titles by alphabet
    public static class AlphaBeticalComparator implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            if(o1==null && o2==null) {
                return 0;
            }
            if(o1 == null){
                return 1;
            }
            if(o2 == null){
                return -1;
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }




    // sorting tracks by length
    public static class LengthComparator implements Comparator<File> {
        @Override
        public int compare(File o1, File o2) {
            if(o1==null && o2== null) {
                return 0;
            }
            if(o1 == null){
                return 1;
            }
            if(o2 == null){
                return -1;
            }
            String i1 = o1.getLength();
            String i2 = o2.getLength();
            return -i1.compareTo(i2);
        }
    }
}
