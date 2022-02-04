package database;

import common.Constants;
import utils.Utils;

import java.util.ArrayList;

public class InitialData {
    private ArrayList<Child> children;
    private ArrayList<Gift> santaGiftsList;

    public InitialData(final ArrayList<Child> children, final ArrayList<Gift> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    public InitialData() { }

    /**
     * Getter pentru children.
     */
    public ArrayList<Child> getChildren() {
        return children;
    }

    /**
     * Getter pentru santaGiftsList.
     */
    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    /**
     * Setter pentru children.
     */
    public void setChildren(final ArrayList<Child> children) {
        this.children = children;
    }

    /**
     * Setter pentru santaGiftsList.
     */
    public void setSantaGiftsList(final ArrayList<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    /**
     * Override metodei toString.
     */
    @Override
    public String toString() {
        return "InitialData{"
                + "children=" + children
                + ", santaGiftsList=" + santaGiftsList
                + '}';
    }

    /**
     * Metoda ce updateaza lista santaGiftsList in functie de un index
     * (index primit in functie de pozitia in AnnualChanges).
     */
    public void updateGifts(final int i) {
        for (int j = 0; j < MyDatabase.getInstance().
                getAnnualChanges().get(i).getNewGifts().size(); j++) {
            this.santaGiftsList.add(MyDatabase.getInstance().
                    getAnnualChanges().get(i).getNewGifts().get(j));
        }
    }

    /**
     * Metoda ce updateaza lista children in funcite de un index si
     * de varsa copiilor noi adaugati(sa fie sub 19).
     */
    public void updateChildren(final int i) {
        for (int j = 0; j < MyDatabase.getInstance().getAnnualChanges().
                get(i).getNewChildren().size(); j++) {
            if (MyDatabase.getInstance().getAnnualChanges().
                    get(i).getNewChildren().get(j).getAge() <= Constants.EIGHTEEN) {
                this.children.add(MyDatabase.getInstance().getAnnualChanges().
                        get(i).getNewChildren().get(j));
               Child child = Utils.searchChildPrim(MyDatabase.getInstance().
                       getAnnualChanges().get(i).getNewChildren().get(j).getId());
               child.addHistory();
            }
        }
    }

    /**
     * Metoda ce updateaza datele unui copil in functie de un index
     * (index primit in functie de pozitia in AnnualChanges).
     */
    public void updateChildrenInfo(final int i) {
        for (int j = 0; j < MyDatabase.getInstance().getAnnualChanges().get(i).
                getChildrenUpdates().size(); j++) {
            for (Child child : this.children) {
                if (child.getId() == MyDatabase.getInstance().getAnnualChanges().
                        get(i).getChildrenUpdates().get(j).getId()) {
                    child.updateChild(i, MyDatabase.getInstance().getAnnualChanges().
                            get(i).getChildrenUpdates().get(j));
                }
            }
        }
    }

    /**
     * Metoda apeleaza addHistory pentru toti copiii.
     */
    public void addInHistory() {
        for (Child child : this.children) {
            child.addHistory();
        }
    }

    /**
     * Metoda apeleaza calculateAverageScore pentru toti copiii.
     */
    public void updateChildrenAverageScore() {
        for (Child child : this.children) {
            child.calculateAverageScore();
        }
    }

    /**
     * Metoda apeleaza calculateAsignedBudget pentru toti copiii.
     */
    public void updateChildrenBudget() {
        for (Child child : this.children) {
            child.calculateAsignedBudget();
        }
    }

    /**
     * Metoda apeleaza clearList pentru toti copiii.
     */
    public void clearLists() {
        for (Child child : this.children) {
            child.clearList();
        }
    }

    /**
     * Metoda apeleaza updateAge pentru toti copiii.
     */
    public void adjustAge() {
        for (Child child : this.children) {
            child.updateAge();
        }
    }
}
