import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        File file = new File("src/cereal.csv");

        ArrayList<Data> dataList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            // Skip header
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String name = parts[0];
                int calories = Integer.parseInt(parts[3]);
                int sugars = Integer.parseInt(parts[9]);
                double rating = Double.parseDouble(parts[15]);

                Data d = new Data(name, calories, sugars, rating);
                dataList.add(d);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome! This program analyzes cereal data.");
            System.out.println("What analysis would you like to see? (1) Total cereals, (2) Highest rating, (3) Lowest rating, (4) Average rating, (5) High sugar cereals (>10), (6) Exit");
            int choice = inputScanner.nextInt();
            if (choice == 1) {
                System.out.println("Total cereals: " + dataList.size());
            } else if (choice == 2) {
                System.out.println("Highest rating: " + findMaxRating(dataList));
            } else if (choice == 3) {
                System.out.println("Lowest rating: " + findMinRating(dataList));
            } else if (choice == 4) {
                System.out.println("Average rating: " + computeAverageRating(dataList));
            } else if (choice == 5) {
                System.out.println("\nHigh sugar cereals (>10):");
                printHighSugar(dataList);
            } else if (choice == 6) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid input. Please enter 1, 2, 3, 4, 5, or 6.");
            }
        }
        inputScanner.close();
    }

    /**
     * Finds max rating.
     */
    public static double findMaxRating(ArrayList<Data> list) {
        double max = list.get(0).getRating();

        for (Data d : list) {
            if (d.getRating() > max) {
                max = d.getRating();
            }
        }
        return max;
    }

    /**
     * Finds min rating.
     */
    public static double findMinRating(ArrayList<Data> list) {
        double min = list.get(0).getRating();

        for (Data d : list) {
            if (d.getRating() < min) {
                min = d.getRating();
            }
        }
        return min;
    }

    /**
     * Computes average rating.
     */
    public static double computeAverageRating(ArrayList<Data> list) {
        double sum = 0;

        for (Data d : list) {
            sum += d.getRating();
        }

        return sum / list.size();
    }

    /**
     * Prints cereals with high sugar.
     */
    public static void printHighSugar(ArrayList<Data> list) {
        for (Data d : list) {
            if (d.getSugars() > 10) {
                System.out.println(d);
            }
        }
    }
}