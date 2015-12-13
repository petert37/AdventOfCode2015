package hu.petert.aoc.d13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static Map<String, Person> people = new HashMap<>();

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            String line;

            while (scanner.hasNext()){
                line = scanner.nextLine();
                String[] data = line.substring(0, line.length() - 1).split(" ");
                Person p = getPerson(data[0]);
                int multiplier = data[2].equals("gain") ? 1 : -1;
                p.addHappiness(data[10], multiplier * Integer.parseInt(data[3]));
            }

            List<Integer> happinesses = new ArrayList<>();
            String name = people.keySet().iterator().next();
            people.get(name).constructHappinessList(new ArrayList<>(), 0, happinesses);
            System.out.println("Optimal happiness: " + Collections.max(happinesses));

            //Part 2

            Person me = getPerson("Me");
            for(Person p : people.values()){
                me.addHappiness(p.name, 0);
                p.addHappiness(me.name, 0);
            }

            List<Integer> happinesses2 = new ArrayList<>();
            people.get("Alice").constructHappinessList(new ArrayList<>(), 0, happinesses2);
            System.out.println("Optimal happiness with me: " + Collections.max(happinesses2));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static Person getPerson(String name){
        if(people.containsKey(name)) return people.get(name);
        Person p = new Person(name);
        people.put(name, p);
        return p;
    }

}
