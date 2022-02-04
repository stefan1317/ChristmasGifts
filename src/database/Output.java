package database;

import java.util.ArrayList;

public class Output {
    private ArrayList<AnnualChildren> annualChildren;

    public Output(final ArrayList<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    /**
     * Getter pentru annualChildren.
     */
    public ArrayList<AnnualChildren> getAnnualChildren() {
        return annualChildren;
    }

    /**
     * Setter pentru annualChildren.
     */
    public void setAnnualChildren(final ArrayList<AnnualChildren> annualChildren) {
        this.annualChildren = annualChildren;
    }

    /**
     * Override metodei toString.
     */
    @Override
    public String toString() {
        return "Output{"
               + "annualChildren=" + annualChildren
               + '}';
    }
}


