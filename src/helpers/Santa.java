package helpers;

import common.Constants;
import database.Child;
import database.Gift;
import database.MyDatabase;
import utils.Utils;

import java.util.ArrayList;

public class Santa extends Visitor {
    private ArrayList<Double> averageScoreList = new ArrayList<>();

    /**
     * Metoda calculeaza budgetUnit.
     */
    public double calculateBudgetUnit() {
        double s = 0;
        for (Child child : MyDatabase.getInstance().getInitialData().getChildren()) {
            if (child.getAge() <= Constants.EIGHTEEN) {
                this.averageScoreList.add(child.getAverageScore());
            }
        }
        for (Double score : this.averageScoreList) {
            s += score;
        }
        return MyDatabase.getInstance().getSantaBudget() / s;
    }

    /**
     * Metoda asigneaza cadouri copiilor in functie de preferintele lor si
     * bugetul care le-a fost asignat.(Este specifica pentru Visitor-denumire).
     */
    public void visit(final Child child) {
        Utils.sortGifts();
        double price = child.getAssignedBudget();

        for (String string : child.getGiftsPreferences()) {
            for (int i = 0; i < MyDatabase.getInstance().
                    getInitialData().getSantaGiftsList().size(); i++) {
                if (MyDatabase.getInstance().getInitialData().
                        getSantaGiftsList().get(i).getCategory().equals(string)
                        && price >= MyDatabase.getInstance().
                        getInitialData().getSantaGiftsList().get(i).getPrice()
                        && MyDatabase.getInstance().getInitialData().
                        getSantaGiftsList().get(i).getQuantity() > 0) {
                    child.getReceivedGifts().add(new Gift(MyDatabase.getInstance().
                            getInitialData().getSantaGiftsList().get(i)));
                    price = price - MyDatabase.getInstance().
                            getInitialData().getSantaGiftsList().get(i).getPrice();
                    MyDatabase.getInstance().getInitialData().getSantaGiftsList().
                            get(i).setQuantity(MyDatabase.getInstance().
                                    getInitialData().getSantaGiftsList().
                                    get(i).getQuantity() - 1);
                    break;
                }
            }
        }
    }
}
