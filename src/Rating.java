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

    public static String[] getNames(Rating[] ratings) {
        String[] people = new String[ratings.length];
        for (int i=0; i<ratings.length; i++) {
            people[i] = ratings[i].getName();
        }
        return people;
    }
}
