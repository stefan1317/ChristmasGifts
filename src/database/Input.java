package database;

import java.util.ArrayList;

public class Input {
    private int numberOfYears;
    private double santaBudget;
    private InitialData initialData;
    private ArrayList<AnnualChange> annualChanges;

    public Input(final int numberOfYears, final double santaBudget,
                 final InitialData initialData, final ArrayList<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    public Input() { }

    /**
     * Getter pentru numberOfYears.
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Getter pentru santaBudget.
     */
    public double getSantaBudget() {
        return santaBudget;
    }

    /**
     * Getter pentru initialData.
     */
    public InitialData getInitialData() {
        return initialData;
    }

    /**
     * Getter pentru annualChanges.
     */
    public ArrayList<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    /**
     * Setter pentru numberOfYears.
     */
    public void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Setter pentru santaBudget.
     */
    public void setSantaBudget(final double santaBudget) {
        this.santaBudget = santaBudget;
    }

    /**
     * Setter pentru initialData.
     */
    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    /**
     * Setter pentru annualChanges.
     */
    public void setAnnualChanges(final ArrayList<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    /**
     * Override metodei toString.
     */
    @Override
    public String toString() {
        return "Database{"
                + "numberOfYears=" + numberOfYears
                + ", santaBudget=" + santaBudget
                + ", initialDataList=" + initialData
                + ", annualChanges=" + annualChanges
                + '}';
    }
}

