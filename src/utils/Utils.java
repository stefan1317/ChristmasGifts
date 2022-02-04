package utils;

import database.Child;
import database.Gift;
import database.MyDatabase;
import java.util.Collections;
import java.util.Comparator;

public class Utils {

    /**
     * Metoda cauta un copil din database in functie de id
     */
    public static Child searchChildPrim(final int id) {
        for (Child child: MyDatabase.getInstance().getInitialData().getChildren()) {
            if (id == child.getId()) {
                return child;
            }
        }
        return null;
    }

    /**
     * Metoda sorteaza crescator dupa pret cadourile din
     * santaGiftsList.
     */
    public static void sortGifts() {
        Collections.sort(MyDatabase.getInstance().getInitialData().
                getSantaGiftsList(), new Comparator<Gift>() {
            @Override
            public int compare(final Gift o1, final Gift o2) {
                if (o1.getPrice() - o2.getPrice() < 0) {
                    return -1;
                } else if (o1.getPrice() - o2.getPrice() > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }

    /**
     * Metoda ce sorteaza copiii in functie de id.
     */
    public static void sortIdOrder() {
        MyDatabase.getInstance().getInitialData().getChildren().sort(new Comparator<Child>() {
            @Override
            public int compare(final Child o1, final Child o2) {
                if (o1.getId() - o2.getId() < 0) {
                    return -1;
                } else if (o1.getId() - o2.getId() > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
}
