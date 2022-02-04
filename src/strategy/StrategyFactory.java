package strategy;

public class StrategyFactory {

    /**
     * Metoda ce creeaza o strategie specifica stringType-ului.
     */
    public Strategy create(final String strategyType) {
        switch (strategyType) {
            case "id":
                return new IdStrategy();
            case "niceScore":
                return new NiceScoreStrategy();
            case "niceScoreCity":
                return new NiceScoreCityStrategy();
            default:
                return null;
        }
    }
}
