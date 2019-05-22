import java.util.Arrays;

public class Randomizer {

    public static Rating[] getPersonRatings(String[] names) {
        Rating[] ratings = new Rating[names.length];
        for (int i=0; i<names.length; i++) {
            double rating = Math.random();
            ratings[i] = new Rating(names[i], rating);
        }
        Arrays.sort(ratings);
        return ratings;
    }
}
