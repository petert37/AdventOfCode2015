package hu.petert.aoc.d9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static Map<String, City> cities = new HashMap<>();
    static List<String> routes = new ArrayList<>();

    public static void main(String[] args){


        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()){
                String[] splitter = scanner.nextLine().replace(" to", "").replace(" =", "").split(" ");
                getCity(splitter[0]).addConnection(getCity(splitter[1]), Integer.parseInt(splitter[2]));
                getCity(splitter[1]).addConnection(getCity(splitter[0]), Integer.parseInt(splitter[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int shortest = Integer.MAX_VALUE;
        int longest = 0;

        for(City c : cities.values()){
            List<City> parents = new ArrayList<>();
            int min = c.getShortestRoute(parents, 0);
            if(min < shortest) shortest = min;
        }

        for(City c : cities.values()){
            List<City> parents = new ArrayList<>();
            int max = c.getLongestRoute(parents, 0);
            if(max > longest) longest = max;
        }

//        for(City c : cities.values()){
//            List<City> parents = new ArrayList<>();
//            c.listAllRoutes(parents);
//        }

        System.out.println("Shortest route: " + shortest);
        System.out.println("Longest route: " + longest);

    }

    public static City getCity(String name){
        if(cities.containsKey(name)) return cities.get(name);
        City city = new City(name);
        cities.put(name, city);
        return city;
    }

}
