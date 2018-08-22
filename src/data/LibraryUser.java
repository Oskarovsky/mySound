package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User {

    private static final long serialVersionUID = 1704976407311180890L;

    private List<File> playlistHistory;
    private List<File> playedFiles;

    public List<File> getPlaylistHistory() {
        return playlistHistory;
    }

    public List<File> getPlayedFiles() {
        return playedFiles;
    }

    public LibraryUser(String login, String email, String password) {
        super(login, email, password);
        playlistHistory = new ArrayList<>();
        playedFiles = new ArrayList<>();
    }

    private void addFileToHistory(File file) {
        playlistHistory.add(file);
    }

    public void playFile(File file) {
        playedFiles.add(file);
    }

    public boolean returnFile(File file) {
        boolean result = false;
        if (playedFiles.remove(file)) {
            result = true;
            addFileToHistory(file);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(playlistHistory, that.playlistHistory) &&
                Objects.equals(playedFiles, that.playedFiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), playlistHistory, playedFiles);
    }
}
