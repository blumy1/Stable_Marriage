import net.sourceforge.gxl.GXLGraph;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class StableMarriage {
    private LinkedHashMap<String, Person> women;
    private LinkedHashMap<String, Person> men;

    public StableMarriage(String[] women, String[] men) {
        this.women = createPeople(women, men);
        this.men = createPeople(men, women);
    }

    public StableMarriage(LinkedHashMap<String, Person> women, LinkedHashMap<String, Person> men) {
        this.women = women;
        this.men = men;
    }

    private LinkedHashMap<String, Person> createPeople(String[] group1, String[] group2) {
        LinkedHashMap<String, Person> people = new LinkedHashMap<>(group1.length);
        System.out.println();
        for (int i=0; i<group1.length; i++) {
            Rating[] ratings = Randomizer.getPersonRatings(group2);
            System.out.print(group1[i] + ":");
            for (Rating rating : ratings) {
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.print(" " + rating.getName() + " (" + df.format(rating.getRating()) + ")");
            }
            System.out.println();
            people.put(group1[i], new Person(group1[i], Rating.getNames(ratings)));
        }
        return people;
    }

    public void connectPeople() {
        int freePeople = women.size();
        while (freePeople > 0) {
            for (Map.Entry<String, Person> personEntry : women.entrySet()) {
                Person currentWoman = personEntry.getValue();
                if (currentWoman.getPartner() != null)
                    continue;

                currentWoman.setPartner(currentWoman.getNextPossibility());
                Person currentMan = men.get(currentWoman.getPartner());
                freePeople--;
                if (currentMan.isBetterPartner(currentWoman.getName())) {
                    if (currentMan.getPartner() != null) {
                        Person rejectedWoman = women.get(currentMan.getPartner());
                        rejectedWoman.removePossibility(currentMan.getName());
                        rejectedWoman.setPartner(null);
                        freePeople++;
                    }
                    currentMan.setPartner(currentWoman.getName());
                } else {
                    currentWoman.setPartner(null);
                    currentWoman.removePossibility(currentMan.getName());
                    currentMan.removePossibility(currentWoman.getName());
                    freePeople++;
                }
            }
        }
    }

    public GXLGraph asGraph() {
        GXLGraph gxlGraph = new GXLGraph("Marriage");
        for (Map.Entry<String, Person> entry : women.entrySet()) {
            Person person = entry.getValue();
            gxlGraph.add(person.toNode());
        }

        for (Map.Entry<String, Person> entry : men.entrySet()) {
            Person person = entry.getValue();
            gxlGraph.add(person.toNode());
        }

        for (Map.Entry<String, Person> entry : women.entrySet()) {
            Person person = entry.getValue();
            gxlGraph.add(person.getEdge());
        }

        return gxlGraph;
    }

    public LinkedHashMap<String, Person> getWomen() {
        return women;
    }

    public LinkedHashMap<String, Person> getMen() {
        return men;
    }

    public void printPossibilities() {
        printPossibility(women);
        System.out.println();
        printPossibility(men);
    }

    private void printPossibility(LinkedHashMap<String, Person> people) {
        for (Map.Entry<String, Person> entry : people.entrySet()) {
            Person person = entry.getValue();
            System.out.print(person.getName() + ":");
            for (String possibility : person.getPossibilities()) {
                System.out.print(" " + possibility);
            }
            System.out.println();
        }
    }

    public void printMarriages() {
        for (Map.Entry<String, Person> woman : women.entrySet()) {
            System.out.println(woman.getValue().getName() + " - " + woman.getValue().getPartner());
        }
    }
}
