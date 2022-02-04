package database;

import java.util.ArrayList;

public class ChildrenOutput {
    private int id;
    private String lastName;
    private String firstName;
    private String city;
    private int age;
    private ArrayList<String> giftsPreferences;
    private double averageScore;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private double assignedBudget;
    private ArrayList<GiftOutput> receivedGifts = new ArrayList<>();

    public ChildrenOutput(final int id, final String lastName, final String firstName,
                          final String city, final int age,
                          final ArrayList<String> giftsPreferences,
                          final double averageScore, final ArrayList<Double> niceScoreHistory,
                          final double assignedBudget, final ArrayList<GiftOutput> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = averageScore;
        this.niceScoreHistory = niceScoreHistory;
        this.assignedBudget = assignedBudget;
        this.receivedGifts = receivedGifts;
    }

    public ChildrenOutput() { }

    /**
     * Getter pentru id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter pentru lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter pentru firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter pentru city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter pentru age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter pentru giftsPreferences.
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Getter pentru averageScore.
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Getter pentru niceScoreHistory.
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * Getter pentru assignedBudget.
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * Getter pentru receivedGifts.
     */
    public ArrayList<GiftOutput> getReceivedGifts() {
        return receivedGifts;
    }


    /**
     * Setter pentru id.
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Setter pentru lastName.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter pentru firstName.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter pentru city.
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Setter pentru age.
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * Setter pentru giftsPreferences.
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Setter pentru averageScore.
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Setter pentru niceScoreHistory.
     */
    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * Setter pentru assignedBudget.
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * Setter pentru receivedGifts.
     */
    public void setReceivedGifts(final ArrayList<GiftOutput> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * Metoda ce converteste o clasa de tip Child la o clasa de tip
     * ChildrenOutput.
     */
    public void convert(final Child child, final ArrayList<GiftOutput> gifts) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.city = child.getCity();
        this.age = child.getAge();
        this.giftsPreferences = new ArrayList<>(child.getGiftsPreferences());
        this.averageScore = child.getAverageScore();
        this.niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
        this.assignedBudget = child.getAssignedBudget();
        this.receivedGifts = new ArrayList<>(gifts);
    }

    /**
     * Override la metoda toString.
     */
    @Override
    public String toString() {
        return "ChildrenOutput{"
                + "id=" + id
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", city='" + city + '\''
                + ", age=" + age
                + ", giftsPreferences=" + giftsPreferences
                + ", averageScore=" + averageScore
                + ", niceScoreHistory=" + niceScoreHistory
                + ", assignedBudget=" + assignedBudget
                + ", receivedGifts=" + receivedGifts
                + '}';
    }
}
