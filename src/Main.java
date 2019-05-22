import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        String[] women = new String[]{"Katarzyna", "Anna", "Beata"};
//        String[] men = new String[]{"Janusz", "Karol", "Tomasz"};

        LinkedHashMap<String, Person> women = new LinkedHashMap<>();
        women.put("A", new Person("A", new String[]{"6","2","3","1","5","4"}));
        women.put("B", new Person("B", new String[]{"4","3","1","6","2","5"}));
        women.put("C", new Person("C", new String[]{"5","2","6","1","4","3"}));
        women.put("D", new Person("D", new String[]{"4","2","6","5","1","3"}));
        women.put("E", new Person("E", new String[]{"6","1","3","2","5","4"}));
        women.put("F", new Person("F", new String[]{"2","6","4","1","5","3"}));

        LinkedHashMap<String, Person> men = new LinkedHashMap<>();
        men.put("1", new Person("1", new String[]{"A","F","B","C","D","E"}));
        men.put("2", new Person("2", new String[]{"E","F","A","D","C","B"}));
        men.put("3", new Person("3", new String[]{"E","C","B","D","A","F"}));
        men.put("4", new Person("4", new String[]{"C","B","A","F","E","D"}));
        men.put("5", new Person("5", new String[]{"A","B","C","D","E","F"}));
        men.put("6", new Person("6", new String[]{"F","B","A","E","D","C"}));

        /*
            Correct answer for this mock is:
            A - 6
            B - 4
            C - 5
            D - 1
            E - 3
            F - 2
        */

        StableMarriage marriage = new StableMarriage(women, men);
        marriage.connectPeople();

        for (Map.Entry<String, Person> woman : marriage.getWomen().entrySet()) {
            System.out.println(woman.getValue().getName() + " - " + woman.getValue().getPartner());
        }
    }
}
