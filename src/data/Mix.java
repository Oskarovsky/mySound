package data;

public class Mix extends File {

    // constant, which allows versioning classes
    private static final long serialVersionUID = -7907331751072277846L;

    // added fields + file.fields
    private String artist;
    private String genre;
    private int year;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // CONSTRUCTOR
    public Mix(String title, String artist, String genre, int year, String length) {
        super(title, length);  // shortened by using super()
        setArtist(artist);
        setGenre(genre);
        setYear(year);
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
        print.append(getYear());
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

        if (getYear() != mix.getYear()) return false;
        if (getArtist() != null ? !getArtist().equals(mix.getArtist()) : mix.getArtist() != null) return false;
        return getGenre() != null ? getGenre().equals(mix.getGenre()) : mix.getGenre() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getArtist() != null ? getArtist().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + getYear();
        return result;
    }
}
