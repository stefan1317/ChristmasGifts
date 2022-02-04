package database;

import java.util.ArrayList;

public final class MyDatabase {
    private static MyDatabase instance = null;
    private int numberOfYears;
    private double santaBudget;
    private InitialData initialData;
    private ArrayList<AnnualChange> annualChanges;

    private MyDatabase() { }

    /**
     * Instantiere pentru Singleton.
     */
    public static MyDatabase getInstance() {
        if (instance == null) {
            instance = new MyDatabase();
        }
        return instance;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getSantaBudget() {
        return santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public ArrayList<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public static void setInstance(final MyDatabase instance) {
        MyDatabase.instance = instance;
    }

    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    public void setAnnualChanges(final ArrayList<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    /**
     * Metoda adauga in database input-ul.
     */
    public void assignValues(final Input input) {
        this.numberOfYears = input.getNumberOfYears();
        this.santaBudget = input.getSantaBudget();
        this.initialData = input.getInitialData();
        this.annualChanges = input.getAnnualChanges();
    }

    /**
     * Metoda updateaza santaBudget in functie de un index "i"
     * (pozitia in AnnualChanges).
     */
    public void updateSantaBudget(final int i) {
        this.santaBudget = this.getAnnualChanges().get(i).getNewSantaBudget();
    }

    /**
     * Override metodei toString.
     */
    @Override
    public String toString() {
        return "MyDatabase{"
                + "numberOfYears=" + numberOfYears
                + ", santaBudget=" + santaBudget
                + ", initialData=" + initialData
                + ", annualChanges=" + annualChanges
                + '}';
    }
}
