package helpers.elfs;

public class ElfFactory {

    /**
     * Metoda ce creeaza clasa elfului specific unui copil.
     */
    public Elf create(final String elfType) {
        switch (elfType) {
            case "pink":
                return new PinkElf();
            case "black":
                return new BlackElf();
            case "white":
                return new WhiteElf();
            default:
                return null;
        }
    }
}
