package data;

import java.io.Serializable;

public class File implements Serializable, Comparable<File> {

    // constant, which allows versioning classes
    private static final long serialVersionUID = 7910452641164094454L;

    // main variables
    private String title;
    private String length;

    // setters and getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    // constructor - range limited to the package
    protected File(String title, String length) {
        setTitle(title);
        setLength(length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof File))
            return false;

        File file = (File) o;

        if (getTitle() != null ? !getTitle().equals(file.getTitle()) : file.getTitle() != null)
            return false;
        return getLength() != null ? getLength().equals(file.getLength()) : file.getLength() == null;
    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getLength() != null ? getLength().hashCode() : 0);
        return result;
    }

    // sorting method
    @Override
    public int compareTo(File o) {
        return title.compareTo(o.getTitle());
    }
}
