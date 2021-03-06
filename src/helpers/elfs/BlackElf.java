package helpers.elfs;

import common.Constants;
import database.Child;

public class BlackElf implements Elf {

    /**
     * Metoda ce schimba bugetul asignat unui copil specific unui elf negru.
     */
    @Override
    public void changeBudget(final Child child) {
        child.setAssignedBudget(child.getAssignedBudget()
                - child.getAssignedBudget() * Constants.THIRTY / Constants.ONE_HUNDRED);
    }
}
