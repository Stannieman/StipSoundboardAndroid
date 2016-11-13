package be.stip.soundboard.models;

public class Sound {

    //region Name

    private String name;

    public String getName() {
        return name;
    }

    //endregion

    //region FileName

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    //endregion

    public Sound(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }
}
