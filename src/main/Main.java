package main;

import common.Constants;

import IO.FileReader;
import IO.FileWriter;
import checker.Checker;
import database.*;
import helpers.Santa;
import helpers.elfs.YellowElf;
import strategy.StrategyFactory;
import utils.Utils;
import java.util.ArrayList;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * This method is used to call the checker which calculates the score
     *
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) {

        for (int k = 1; k <= Constants.TESTS_NUMBER; k++) {

            FileReader fileReader = new FileReader(Constants.TEST_PATH + k + Constants.FILE_EXTENSION);
            Input database = fileReader.readData();

            MyDatabase.getInstance().assignValues(database);

            ArrayList<AnnualChildren> list = new ArrayList<>();
            AnnualChildren annualChildren = new AnnualChildren();

            MyDatabase.getInstance().getInitialData().addInHistory();
            MyDatabase.getInstance().getInitialData().updateChildrenAverageScore();
            MyDatabase.getInstance().getInitialData().updateChildrenBudget();
            for (Child child : MyDatabase.getInstance().getInitialData().getChildren()) {
                Santa santa = new Santa();
                if (child.getAge() <= Constants.EIGHTEEN) {
                    santa.visit(child);
                }
            }

            for (Child child : MyDatabase.getInstance().getInitialData().getChildren()) {
                ArrayList<GiftOutput> giftOutputs = new ArrayList<>();

                for (Gift gift : child.getReceivedGifts()) {
                    GiftOutput giftOutput = new GiftOutput();
                    giftOutput.convert(gift);
                    giftOutputs.add(giftOutput);
                }

                ChildrenOutput childrenOutput = new ChildrenOutput();
                childrenOutput.convert(child, giftOutputs);
                annualChildren.getChildren().add(childrenOutput);
            }

            list.add(annualChildren);

            for (int i = 0; i < MyDatabase.getInstance().getNumberOfYears(); i++) {

                AnnualChildren annualChildren1 = new AnnualChildren();

                MyDatabase.getInstance().getInitialData().clearLists();
                MyDatabase.getInstance().getInitialData().adjustAge();
                MyDatabase.getInstance().updateSantaBudget(i);
                MyDatabase.getInstance().getInitialData().updateChildren(i);
                MyDatabase.getInstance().getInitialData().updateGifts(i);
                MyDatabase.getInstance().getInitialData().updateChildrenInfo(i);
                MyDatabase.getInstance().getInitialData().updateChildrenAverageScore();
                MyDatabase.getInstance().getInitialData().updateChildrenBudget();

                if (MyDatabase.getInstance().getAnnualChanges().
                        get(i).getStrategy().equals("niceScoreCity")) {
                    StrategyFactory strategyFactory = new StrategyFactory();
                    strategyFactory.create(MyDatabase.getInstance().
                            getAnnualChanges().get(i).getStrategy()).assignGiftsOrder();
                } else {
                    StrategyFactory strategyFactory = new StrategyFactory();
                    strategyFactory.create(MyDatabase.getInstance().
                            getAnnualChanges().get(i).getStrategy()).assignGiftsOrder();
                    for (Child child : MyDatabase.getInstance().getInitialData().getChildren()) {
                        Santa santa = new Santa();
                        if (child.getAge() <= Constants.EIGHTEEN) {
                            santa.visit(child);
                        }
                    }
                }

                for (Child child : MyDatabase.getInstance().getInitialData().getChildren()) {
                    if (child.getElf().equals("yellow")) {
                        YellowElf yellowElf = new YellowElf();
                        yellowElf.changeBudget(child);
                    }
                }

                Utils.sortIdOrder();

                for (Child child : MyDatabase.getInstance().getInitialData().getChildren()) {
                    ArrayList<GiftOutput> giftOutputs = new ArrayList<>();

                    for (Gift gift : child.getReceivedGifts()) {
                        GiftOutput giftOutput = new GiftOutput();
                        giftOutput.convert(gift);
                        giftOutputs.add(giftOutput);
                    }

                    ChildrenOutput childrenOutput1 = new ChildrenOutput();
                    childrenOutput1.convert(child, giftOutputs);
                    annualChildren1.getChildren().add(childrenOutput1);
                }
                list.add(annualChildren1);
            }

            for (AnnualChildren annualChildren1 : list) {
                annualChildren1.getChildren().removeIf(child
                        -> child.getAge() > Constants.EIGHTEEN);
            }

            Output output = new Output(list);
            FileWriter fileWriter = new FileWriter(Constants.OUTPUT_PATH + k + Constants.FILE_EXTENSION, output);
            fileWriter.writeFile();

      }
        Checker.calculateScore();
    }
}
