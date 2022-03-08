package model;

public class Town {
    private String nameTown;
    private int id;

    public Town() {
    }

    public String getNameTown() {
        return nameTown;
    }

    public void setNameTown(String nameTown) {
        this.nameTown = nameTown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Town{" +
                "nameTown='" + nameTown + '\'' +
                '}';
    }
}
