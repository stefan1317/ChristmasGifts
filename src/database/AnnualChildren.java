package database;

import java.util.ArrayList;

public class AnnualChildren {
    private ArrayList<ChildrenOutput> children = new ArrayList<>();

    public AnnualChildren(final ArrayList<ChildrenOutput> children) {
        this.children = children;
    }

    public AnnualChildren() { }

    /**
     * Getter pentru children
     */
    public ArrayList<ChildrenOutput> getChildren() {
        return children;
    }

    /**
     * Setter pentru children
     */
    public void setChildren(final ArrayList<ChildrenOutput> children) {
        this.children = children;
    }

    /**
     * Overrite metodei toString
     */
    @Override
    public String toString() {
        return "AnnualChildren{"
                + "children=" + children
                + '}';
    }
}
