package strategy;

import common.Constants;
import database.Child;
import database.MyDatabase;
import helpers.Santa;
import utils.Utils;
import java.util.*;

public class NiceScoreCityStrategy implements Strategy {

    /**
     * Metoda care sorteaza orasele dupa averageScore-ul copiilor ce
     * locuiesc acolo si apoi ofera cadouri acestora. Am luat 2 hashmap-uri,
     * in unul am bagat toate averagescorurile in functie de oras, iar in celalalt numarul de
     * aparitii ale oraselor. In averageMap am impartit ce ma retinut
     * in countMap pentru a afla media fiecarui oras si apoi am sortat-o
     * descrescator.
     */
    @Override
    public void assignGiftsOrder() {
        HashMap<String, Double> averageMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        Utils.sortIdOrder();

        for (int i = 0; i < MyDatabase.getInstance().getInitialData().getChildren().size(); i++) {
            averageMap.put(MyDatabase.getInstance().
                    getInitialData().getChildren().get(i).getCity(), 0.0);
        }
        for (int i = 0; i < MyDatabase.getInstance().getInitialData().getChildren().size(); i++) {
            countMap.put(MyDatabase.getInstance().
                    getInitialData().getChildren().get(i).getCity(), 0);
        }


        for (int i = 0; i < MyDatabase.getInstance().getInitialData().getChildren().size(); i++) {
            if (MyDatabase.getInstance().getInitialData().
                    getChildren().get(i).getAge() <= Constants.EIGHTEEN) {
                averageMap.put(MyDatabase.getInstance().
                                getInitialData().getChildren().get(i).getCity(),
                        MyDatabase.getInstance().getInitialData().
                                getChildren().get(i).getAverageScore()
                                + averageMap.get(MyDatabase.getInstance().
                                getInitialData().getChildren().get(i).getCity()));
                countMap.put(MyDatabase.getInstance().getInitialData().
                                getChildren().get(i).getCity(),
                        countMap.get(MyDatabase.getInstance().getInitialData().
                                getChildren().get(i).getCity()) + 1);
            }
        }
        for (Map.Entry<String, Double> entry : averageMap.entrySet()) {
            for (Map.Entry<String, Integer> entrySec : countMap.entrySet()) {
                if (entry.getKey().equals(entrySec.getKey())) {
                    averageMap.put(entry.getKey(), entry.getValue() / entrySec.getValue());
                }
            }
        }

        Set<Map.Entry<String, Double>> entrySet = averageMap.entrySet();
        List<Map.Entry<String, Double>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(final Map.Entry<String, Double> o1,
                               final Map.Entry<String, Double> o2) {
                if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else {
                    if (o1.getKey().compareTo(o2.getKey()) < 0) {
                        return -1;
                    } else if (o1.getKey().compareTo(o2.getKey()) > 0) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (Map.Entry<String, Double> map : list) {
            for (Child child : MyDatabase.getInstance().getInitialData().getChildren()) {
                if (child.getCity().equals(map.getKey()) && child.getAge() <= Constants.EIGHTEEN) {
                    Santa santa = new Santa();
                    if (child.getAge() <= Constants.EIGHTEEN) {
                        santa.visit(child);
                    }
                    }
                }
            }
        }
    }

