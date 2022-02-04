package database;

import java.util.ArrayList;

public class ChildUpdate {
    private int id;
    private Double niceScore;
    private ArrayList<String> giftsPreferences;
    private String elf;

    public ChildUpdate(final int id, final double niceScore,
                       final ArrayList<String> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public ChildUpdate() { }

    /**
     * Getter pentru id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter pentru niceScore.
     */
    public Double getNiceScore() {
        return niceScore;
    }

    /**
     * Getter pentru giftsPreferences.
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Getter pentru elf.
     */
    public String getElf() {
        return elf;
    }

    /**
     * Setter pentru id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Setter pentru niceScore.
     */
    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * Setter pentru giftsPreferences.
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Setter pentru elf.
     */
    public void setElf(final String elf) {
        this.elf = elf;
    }

    /**
     * Override metodei toString.
     */
    @Override
    public String toString() {
        return "ChildUpdate{"
                + "id=" + id
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + ", elf='" + elf + '\''
                + '}';
    }
}
