package strategy;

import database.Child;
import database.MyDatabase;
import java.util.Comparator;

public class NiceScoreStrategy implements Strategy {

    /**
     * Metoda care sorteaza copiii in functie de averageScore-ul lor,
     * iar mai apoi in main se vor asigna cadourile in functie de averageScore.
     */
    @Override
    public void assignGiftsOrder() {
        MyDatabase.getInstance().getInitialData().getChildren().sort(new Comparator<Child>() {
            @Override
            public int compare(final Child o1, final Child o2) {
                if (o1.getAverageScore() - o2.getAverageScore() < 0) {
                    return 1;
                } else if (o1.getAverageScore() - o2.getAverageScore() > 0) {
                    return -1;
                } else {
                    if (o1.getId() - o2.getId() < 0) {
                        return -1;
                    } else if  (o1.getId() - o2.getId() > 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
    }
}
