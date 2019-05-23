import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Mock {
    /*
        Correct answer for this mock is:
        A - 6
        B - 4
        C - 5
        D - 1
        E - 3
        F - 2
     */

    public static LinkedHashMap<String, Person> getWomen1() {
        LinkedHashMap<String, Person> women = new LinkedHashMap<>();
        women.put("A", new Person("A", new LinkedHashSet<>(Arrays.asList("6","2","3","1","5","4"))));
        women.put("B", new Person("B", new LinkedHashSet<>(Arrays.asList("4","3","1","6","2","5"))));
        women.put("C", new Person("C", new LinkedHashSet<>(Arrays.asList("5","2","6","1","4","3"))));
        women.put("D", new Person("D", new LinkedHashSet<>(Arrays.asList("4","2","6","5","1","3"))));
        women.put("E", new Person("E", new LinkedHashSet<>(Arrays.asList("6","1","3","2","5","4"))));
        women.put("F", new Person("F", new LinkedHashSet<>(Arrays.asList("2","6","4","1","5","3"))));
        return women;
    }

    public static LinkedHashMap<String, Person> getMen1() {
        LinkedHashMap<String, Person> men = new LinkedHashMap<>();
        men.put("1", new Person("1", new LinkedHashSet<>(Arrays.asList("A","F","B","C","D","E"))));
        men.put("2", new Person("2", new LinkedHashSet<>(Arrays.asList("E","F","A","D","C","B"))));
        men.put("3", new Person("3", new LinkedHashSet<>(Arrays.asList("E","C","B","D","A","F"))));
        men.put("4", new Person("4", new LinkedHashSet<>(Arrays.asList("C","B","A","F","E","D"))));
        men.put("5", new Person("5", new LinkedHashSet<>(Arrays.asList("A","B","C","D","E","F"))));
        men.put("6", new Person("6", new LinkedHashSet<>(Arrays.asList("F","B","A","E","D","C"))));
        return men;
    }

    public static String[] getWomen1Strings() {
        return new String[]{"Katarzyna", "Anna", "Beata", "Agnieszka", "Alicja", "Paulina", "Magda"};
    }

    public static String[] getMen1Strings() {
        return new String[]{"Janusz", "Karol", "Tomasz", "Piotr", "Przemek", "Dawid", "Dominik"};
    }
}
