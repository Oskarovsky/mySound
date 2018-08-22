package data;

public class Track extends File {

    // constant, which allows versioning classes
    private static final long serialVersionUID = 2061400934707882805L;

    // added fields + file.fields
    private String artist;
    private String version;
    private String genre;
    private int year;



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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    // CONSTRUCTOR
    public Track(String title, String artist, String version, String genre, int year, String length) {
        super(title, length);  // shortened by using super()
        this.setArtist(artist);
        this.setVersion(version);
        this.setGenre(genre);
        this.setYear(year);
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
        print.append(getYear());
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

        if (getYear() != track.getYear()) return false;
        if (getArtist() != null ? !getArtist().equals(track.getArtist()) : track.getArtist() != null) return false;
        if (getVersion() != null ? !getVersion().equals(track.getVersion()) : track.getVersion() != null) return false;
        return getGenre() != null ? getGenre().equals(track.getGenre()) : track.getGenre() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getArtist() != null ? getArtist().hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + getYear();
        return result;
    }
}
