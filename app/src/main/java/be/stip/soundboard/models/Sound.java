package be.stip.soundboard.models;

public class Sound {

    //region Name

    private String name;

    public String getName() {
        return name;
    }

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    private char id;

    public char getId() {
        return id;
    }

    //endregion

    public Sound(String name, String fileName, char id) {
        this.name = name;
        this.fileName = fileName;
        this.id = id;
    }
}
