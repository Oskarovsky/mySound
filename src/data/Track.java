package data;

import java.time.LocalDate;
import java.util.Objects;

public class Track extends File {

    // constant, which allows versioning classes
    private static final long serialVersionUID = 2061400934707882805L;

    // added fields + file.fields
    private String artist;
    private String version;
    private String genre;
    private LocalDate date;



    // GETTERS AND SETTERS
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    // CONSTRUCTOR
    public Track(String title, String artist, String version, String genre, int year, String length) {
        super(title, length);  // shortened by using super()
        this.setArtist(artist);
        this.setVersion(version);
        this.setGenre(genre);
        this.setDate(LocalDate.of(year,1,1));
    }

    // METHOD toString() - print info about track
    public String toString() {
        StringBuilder print = new StringBuilder(32);
        print.append(getArtist());
        print.append(" - ");
        print.append(getTitle());
        print.append(" (");
        print.append(getVersion());
        print.append(") ");
        print.append(getGenre());
        print.append(" ");
        print.append(getDate());
        print.append(" ");
        print.append(getLength());
        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        if (!super.equals(o)) return false;
        Track track = (Track) o;
        return Objects.equals(artist, track.artist) &&
                Objects.equals(version, track.version) &&
                Objects.equals(genre, track.genre) &&
                Objects.equals(date, track.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), artist, version, genre, date);
    }
}
