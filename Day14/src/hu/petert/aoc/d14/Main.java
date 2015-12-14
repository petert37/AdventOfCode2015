package hu.petert.aoc.d14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final int TIME = 2503;

    static Map<String, Reindeer> reindeers = new HashMap<>();

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()){
                String[] splitter = scanner.nextLine().split(" ");
                reindeers.put(splitter[0], new Reindeer(Integer.parseInt(splitter[3]), Integer.parseInt(splitter[6]), Integer.parseInt(splitter[13])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> distances = reindeers.values().stream().map(r -> r.getDistance(TIME)).collect(Collectors.toList());

        System.out.println("Winning distance: " + Collections.max(distances));


        for (int i = 1; i <= TIME; i++) {
            Map<Reindeer, Integer> dist = new HashMap<>();
            for(Reindeer r : reindeers.values()){
                dist.put(r, r.getDistance(i));
            }
            int max = Collections.max(dist.values());
            dist.keySet().stream().filter(r -> dist.get(r) == max).forEach(r -> r.points += 1);
        }

        int maxPoints = 0;
        Reindeer winner = null;
        for(Reindeer r : reindeers.values()){
            if(r.points > maxPoints){
                maxPoints = r.points;
                winner = r;
            }
        }

        System.out.println("Second method winner points: " + winner.points);

    }

}
