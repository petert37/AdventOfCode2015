package hu.petert.aoc.d15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static String input =   "Sprinkles: capacity 5, durability -1, flavor 0, texture 0, calories 5\n" +
                            "PeanutButter: capacity -1, durability 3, flavor 0, texture 0, calories 1\n" +
                            "Frosting: capacity 0, durability -1, flavor 4, texture 0, calories 6\n" +
                            "Sugar: capacity -1, durability 0, flavor 0, texture 2, calories 8";

    static List<Ingredient> ingredients = new ArrayList<>();

    public static void main(String[] args){

        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()){
            String[] splitter = scanner.nextLine().split(" ");
            int capacity = Integer.parseInt(splitter[2].substring(0, splitter[2].length() - 1));
            int durability = Integer.parseInt(splitter[4].substring(0, splitter[4].length() - 1));
            int flavor = Integer.parseInt(splitter[6].substring(0, splitter[6].length() - 1));
            int texture = Integer.parseInt(splitter[8].substring(0, splitter[8].length() - 1));
            int calories = Integer.parseInt(splitter[10]);
            ingredients.add(new Ingredient(capacity, durability, flavor, texture, calories));
        }

        int score = 0;
        int scoreCal = 0;

        for (int i = 0; i <= 100 ; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    int s = getScore(i, j, k, 100 - i - j - k);
                    if(s > score) score = s;
                    if(getCalories(i, j, k, 100 - i - j - k) == 500 && s > scoreCal){
                        scoreCal = s;
                    }
                }
            }
        }

        System.out.println("Max score: " + score);
        System.out.println("Max score with 500 calories: " + scoreCal);

    }

    public static int getScore(int spoon1, int spoon2, int spoon3, int spoon4){
        int capacity = ingredients.get(0).capacity * spoon1 + ingredients.get(1).capacity * spoon2 + ingredients.get(2).capacity * spoon3 + ingredients.get(3).capacity * spoon4;
        int durability = ingredients.get(0).durability * spoon1 + ingredients.get(1).durability * spoon2 + ingredients.get(2).durability * spoon3 + ingredients.get(3).durability * spoon4;
        int flavor = ingredients.get(0).flavor * spoon1 + ingredients.get(1).flavor * spoon2 + ingredients.get(2).flavor * spoon3 + ingredients.get(3).flavor * spoon4;
        int texture = ingredients.get(0).texture * spoon1 + ingredients.get(1).texture * spoon2 + ingredients.get(2).texture * spoon3 + ingredients.get(3).texture * spoon4;
        return Math.max(capacity, 0) * Math.max(durability, 0) * Math.max(flavor, 0) * Math.max(texture, 0);
    }

    public static int getCalories(int spoon1, int spoon2, int spoon3, int spoon4){
        return ingredients.get(0).calories * spoon1 + ingredients.get(1).calories * spoon2 + ingredients.get(2).calories * spoon3 + ingredients.get(3).calories * spoon4;
    }

}
