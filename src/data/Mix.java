package data;

import java.time.LocalDate;
import java.util.Objects;

public class Mix extends File {

    // constant, which allows versioning classes
    private static final long serialVersionUID = -7907331751072277846L;

    // added fields + file.fields
    private String artist;
    private String genre;
    private LocalDate date;

    // SETTERS AND GETTERS
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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

    public void setDate(LocalDate year) {
        this.date = date;
    }

    // CONSTRUCTOR
    public Mix(String title, String artist, String genre, int year, String length) {
        super(title, length);  // shortened by using super()
        setArtist(artist);
        setGenre(genre);
        setDate(LocalDate.of(year,1,1));
    }

    // METHOD toString() - print info about mix
    public String toString() {
        StringBuilder print = new StringBuilder(64);
        print.append(getArtist());
        print.append(" - ");
        print.append(getTitle());
        print.append(" ");
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
        if (!(o instanceof Mix)) return false;
        if (!super.equals(o)) return false;
        Mix mix = (Mix) o;
        return Objects.equals(artist, mix.artist) &&
                Objects.equals(genre, mix.genre) &&
                Objects.equals(date, mix.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), artist, genre, date);
    }


}
