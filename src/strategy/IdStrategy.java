package strategy;

import utils.Utils;

public class IdStrategy implements Strategy {

    /**
     * Metoda specifica strategiei "id", sorteaza copiii dupa id
     * iar mai apoi se vor asigna in main cadourile in functie de id.
     */
    @Override
    public void assignGiftsOrder() {
        Utils.sortIdOrder();
    }
}
