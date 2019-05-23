import java.util.LinkedHashSet;

public class Rating implements Comparable<Rating>{
    private String name;
    private double rating;

    public Rating(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public int compareTo(Rating o) {
        if (rating > o.getRating()) return -1;
        else if (rating < o.getRating()) return 1;
        return 0;
    }

    public static LinkedHashSet<String> getNames(Rating[] ratings) {
        LinkedHashSet<String> people = new LinkedHashSet<>(ratings.length);
        for (Rating value : ratings) {
            people.add(value.getName());
        }
        return people;
    }
}
