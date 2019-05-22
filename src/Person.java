public class Person {
    private String name;
    private String partner;
    private String[] possibilities;
    private int currentPos;

    public Person(String name, String[] possibilities) {
        this.name = name;
        this.possibilities = possibilities;
        this.currentPos = 0;
    }

    public String getName() {
        return name;
    }

    public String[] getPossibilities() {
        return possibilities;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
        for (int i=0; i<possibilities.length; i++) {
            if (possibilities[i] != null && possibilities[i].equals(partner))
                currentPos = i;
        }
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public String getNextPossibility() {
        for (int i=currentPos; i<possibilities.length; i++) {
            if (possibilities[i] != null) {
                this.currentPos = i;
                return possibilities[i];
            }
        }
        return null;
    }

    public void removePossibility(String name) {
        for (int i=0; i<possibilities.length; i++) {
            if (possibilities[i] != null && possibilities[i].equals(name)) {
                possibilities[i] = null;
            }
        }
    }

    public boolean isBetterPartner(String name) {
        if (partner == null) return true;

        for (int i=0; i<currentPos; i++) {
            if (possibilities[i] != null && possibilities[i].equals(name))
                return true;
        }
        return false;
    }
}
