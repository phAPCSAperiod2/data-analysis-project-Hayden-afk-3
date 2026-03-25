/**
 * Represents one cereal from the dataset.
 */
public class Data {

    private String name;
    private int calories;
    private int sugars;
    private double rating;

    /**
     * Constructor to initialize a Data object.
     * 
     * @param name cereal name
     * @param calories number of calories
     * @param sugars grams of sugar
     * @param rating cereal rating
     */
    public Data(String name, int calories, int sugars, double rating) {
        this.name = name;
        this.calories = calories;
        this.sugars = sugars;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getSugars() {
        return sugars;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return name + " | Calories: " + calories +
               " | Sugars: " + sugars +
               " | Rating: " + rating;
    }
}