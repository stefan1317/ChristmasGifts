package database;

import java.util.ArrayList;

public class AnnualChange {
    private double newSantaBudget;
    private ArrayList<Gift> newGifts;
    private ArrayList<Child> newChildren;
    private ArrayList<ChildUpdate> childrenUpdates;
    private String strategy;

    public AnnualChange(final double newSantaBudget, final ArrayList<Gift> newGifts,
                       final ArrayList<Child> newChildren,
                        final ArrayList<ChildUpdate> childUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childUpdates;
    }

    public AnnualChange() { }

    /**
     * Getter pentru newSantaBudget.
     */
    public double getNewSantaBudget() {
        return newSantaBudget;
    }

    /**
     * Getter pentru newGifts.
     */
    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    /**
     * Getter pentru newChildren.
     */
    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    /**
     * Getter pentru newChildrenUpdates.
     */
    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    /**
     * Getter pentru strategy.
     */
    public String getStrategy() {
        return strategy;
    }

    /**
     * Setter pentru newSantaBudget
     */
    public void setNewSantaBudget(final double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    /**
     * Setter pentru newGifts
     */
    public void setNewGifts(final ArrayList<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    /**
     * Setter pentru newChildren
     */
    public void setNewChildren(final ArrayList<Child> newChildren) {
        this.newChildren = newChildren;
    }

    /**
     * Setter pentru newChildrenUpdates
     */
    public void setChildrenUpdates(final ArrayList<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    /**
     * Setter pentru strategy.
     */
    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }

    /**
     * Override metodei toString
     */

    @Override
    public String toString() {
        return "AnnualChange{"
                + "newSantaBudget=" + newSantaBudget
                + ", newGifts=" + newGifts
                + ", newChildren=" + newChildren
                + ", childrenUpdates=" + childrenUpdates
                + ", strategy='" + strategy + '\''
                + '}';
    }
}
