package database;

import common.Constants;
import helpers.Santa;
import helpers.Visitable;
import helpers.Visitor;
import helpers.elfs.ElfFactory;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Child extends Visitable {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private double averageScore;
    private ArrayList<Double> niceScoreHistory = new ArrayList<>();
    private double assignedBudget;
    private ArrayList<Gift> receivedGifts = new ArrayList<>();
    private String city;
    private double niceScore;
    private ArrayList<String> giftsPreferences;
    private double niceScoreBonus;
    private String elf;

    public Child(final int id, final String lastname,
                 final String firstname, final int age,
                 final String city, final double niceScore,
                 final ArrayList<String> giftsPreference) {
        this.id = id;
        this.lastName = lastname;
        this.firstName = firstname;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreference;
    }

    public Child() {
    }

    /**
     * Getter pentru id
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
     * Getter pentru firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter pentru age
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter pentru city
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter pentru niceScore
     */
    public double getNiceScore() {
        return niceScore;
    }

    /**
     * Getter pentru giftsPreferences
     */
    public ArrayList<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    /**
     * Getter pentru averageScore
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Getter pentru niceScoreHistory
     */
    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * Getter pentru assignedBudget
     */
    public double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * Getter pentru receivedGifts
     */
    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * Getter pentru niceScoreBonus.
     */
    public double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    /**
     * Getter pentru elf.
     */
    public String getElf() {
        return elf;
    }

    /**
     * Setter pentru id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Setter pentru lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter pentru firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter pentru age
     */
    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * Setter pentru city
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * Setter pentru niceScore
     */
    public void setNiceScore(final double niceScore) {
        this.niceScore = niceScore;
    }

    /**
     * Setter pentru giftsPreferences
     */
    public void setGiftsPreferences(final ArrayList<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    /**
     * Setter pentru averageScore
     */
    public void setAverageScore(final double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * Setter pentru niceScoreHistory
     */
    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * Setter pentru assignedBudget
     */
    public void setAssignedBudget(final double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * Setter pentru receivedGifts
     */
    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    /**
     * Setter pentru niceScoreBonus.
     */
    public void setNiceScoreBonus(final double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    /**
     * Setter pentru elf.
     */
    public void setElf(final String elf) {
        this.elf = elf;
    }

    /**
     * Overrite metodei toString
     */
    @Override
    public String toString() {
        return "Child{"
                + "id=" + id
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", age=" + age
                + ", averageScore=" + averageScore
                + ", niceScoreHistory=" + niceScoreHistory
                + ", assignedBudget=" + assignedBudget
                + ", receivedGifts=" + receivedGifts
                + ", city='" + city + '\''
                + ", niceScore=" + niceScore
                + ", giftsPreferences=" + giftsPreferences
                + ", niceScoreBonus=" + niceScoreBonus
                + ", elf='" + elf + '\''
                + '}';
    }

    /**
     * Metoda adauga in lista cu niceScore-uri precedente niceScore-ul actual
     */
    public void addHistory() {
        this.niceScoreHistory.add(this.niceScore);
    }

    /**
     * Metoda incrementeaza varsta copilului
     */
    public void updateAge() {
        this.age += 1;
    }

    /**
     * Metoda updateaza copilul in functie de un index "i" (indexul penru annualChange-ul
     * pe care vrem sa il facem), aceasta schmba niceScore-ul curent si il adauga in lista
     * cu niceScore-uri si schimba preferintele pentru cadouri
     */
    public void updateChild(final int i, final ChildUpdate child) {
        ArrayList<String> toRemove = new ArrayList<>();
        Set<String> set = new LinkedHashSet<>();

        if (child.getNiceScore() != null) {
            this.niceScore = child.getNiceScore();
            this.niceScoreHistory.add(child.getNiceScore());
        }

        this.elf = child.getElf();

        for (int j = 0; j < child.getGiftsPreferences().size(); j++) {
            for (int k = 0; k < this.giftsPreferences.size(); k++) {
                if (this.giftsPreferences.get(k).equals(child.getGiftsPreferences().get(j))) {
                    toRemove.add(this.getGiftsPreferences().get(k));
                }
            }
        }

        this.giftsPreferences.removeAll(toRemove);

        for (int j = 0; j < child.getGiftsPreferences().size(); j++) {
            this.giftsPreferences.add(j, child.getGiftsPreferences().get(j));
        }

        set.addAll(this.giftsPreferences);
        this.giftsPreferences.clear();
        this.giftsPreferences.addAll(set);

    }

    /**
     * Metoda calculeaza averageScore-ul copilului in functie de varsta
     */
    public void calculateAverageScore() {
        double s = 0;
        double sp = 0;
        if (this.age < Constants.FIVE && this.age > 0) {
            this.averageScore = Constants.TEN;
        } else if (this.age >= Constants.FIVE && this.age < Constants.TWELVE) {
            for (Double score : this.niceScoreHistory) {
                s += score;
            }
            this.averageScore = s / this.niceScoreHistory.size();
            this.averageScore += this.averageScore * this.niceScoreBonus / Constants.ONE_HUNDRED;
            if (this.averageScore > Constants.TEN) {
                this.averageScore = Constants.TEN;
            }
        } else if (this.age >= Constants.TWELVE && this.age <= Constants.EIGHTEEN) {
            for (int i = 1; i <= this.niceScoreHistory.size(); i++) {
                sp += this.niceScoreHistory.get(i - 1) * i;
            }
            double sum = (this.niceScoreHistory.size() * (this.niceScoreHistory.size() + 1)) / 2;
            this.averageScore = sp / sum;
            this.averageScore += this.averageScore * this.niceScoreBonus / Constants.ONE_HUNDRED;
            if (this.averageScore > Constants.TEN) {
                this.averageScore = Constants.TEN;
            }
        }
    }

    /**
     * Metoda calculeaza assignedBudget-ul pentru copil cu ajutorul unui Elf
     */
    public void calculateAsignedBudget() {
        Santa helper = new Santa();
        double score = helper.calculateBudgetUnit();
        this.assignedBudget = this.averageScore * score;
        ElfFactory elfFactory = new ElfFactory();
        if (elfFactory.create(this.getElf()) != null) {
            elfFactory.create(this.getElf()).changeBudget(this);
        }
    }

    /**
     * Metoda sterge toate cadourile primite de catre un copil
     */
    public void clearList() {
        this.receivedGifts.clear();
    }

    /**
     * Metoda specifica pentru a accepta un visitor.
     */
    public void accept(final Visitor v) {
        v.visit(this);
    }

}
