package helpers.elfs;

import common.Constants;
import database.Child;
import database.Gift;
import database.MyDatabase;

public class YellowElf implements Elf {

    /**
     * Metoda ofera unui copil un cadou folosind strategia specifica
     * a unui elf galben, copilul trebuie sa nu aiba niciun cadou si
     * se alege cel mai ieftin cadou din categoria preferata a copilului
     * daca mai sunt valabile.
     */
    @Override
    public void changeBudget(final Child child) {
        for (Gift gift : MyDatabase.getInstance().getInitialData().getSantaGiftsList()) {
            if (gift.getCategory().equals(child.getGiftsPreferences().get(0))
                     && child.getReceivedGifts().isEmpty()
                    && child.getAge() <= Constants.EIGHTEEN) {
                if (gift.getQuantity() > 0) {
                    child.getReceivedGifts().add(gift);
                    gift.setQuantity(gift.getQuantity() - 1);
                }
                return;
            }
        }
    }
}
