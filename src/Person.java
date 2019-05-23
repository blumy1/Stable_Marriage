import net.sourceforge.gxl.GXLEdge;
import net.sourceforge.gxl.GXLNode;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Person {
    private String name;
    private String partner;
    private LinkedHashSet<String> possibilities;

    public Person(String name, LinkedHashSet<String> possibilities) {
        this.name = name;
        this.possibilities = possibilities;
    }

    public String getName() {
        return name;
    }

    public LinkedHashSet<String> getPossibilities() {
        return possibilities;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getNextPossibility() {
        return possibilities.iterator().next();
    }

    public void removePossibility(String name) {
        possibilities.remove(name);
    }

    public boolean isBetterPartner(String name) {
        if (partner == null) return true;

        Iterator<String> iterator = possibilities.iterator();
        while (iterator.hasNext()) {
            String possibility = iterator.next();
            if (possibility.equals(partner))
                return false;

            if (possibility.equals(name))
                return true;
        }
        return true;
    }

    public GXLNode toNode() {
        return new GXLNode(name);
    }

    public GXLEdge getEdge() {
        return new GXLEdge(name, partner);
    }
}
