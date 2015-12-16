package hu.petert.aoc.d16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static List<Sue> sues = new ArrayList<>(500);

    static Map<String, Integer> properties;

    static {
        properties = new HashMap<>(10);
        properties.put("children", 3);
        properties.put("cats", 7);
        properties.put("samoyeds", 2);
        properties.put("pomeranians", 3);
        properties.put("akitas", 0);
        properties.put("vizslas", 0);
        properties.put("goldfish", 5);
        properties.put("trees", 3);
        properties.put("cars", 2);
        properties.put("perfumes", 1);
    }

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext()){
                String[] splitter = scanner.nextLine().split(" ");
                Sue sue = new Sue(Integer.parseInt(splitter[1].substring(0, splitter[1].length() - 1)));
                for (int i = 2; i < splitter.length; i += 2) {
                    String name = splitter[i].substring(0, splitter[i].length() - 1);
                    int value = Integer.parseInt(splitter[i+1].replaceAll(",", ""));
                    sue.addProperty(name, value);
                }
                sues.add(sue);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Sue> sueCopy = new ArrayList<>(500);
        sueCopy.addAll(sues);
        Iterator<Sue> iter = sueCopy.iterator();

        sueiter:
        while (iter.hasNext()){
            Sue sue = iter.next();
            for(String name : properties.keySet()){
                if(sue.getProperty(name) != -1 && sue.getProperty(name) != properties.get(name)){
                    iter.remove();
                    continue sueiter;
                }
            }
        }

        System.out.print("Remaining Sues: ");
        for(Sue sue : sueCopy)
            System.out.print(sue.index + " ");

        sueCopy = new ArrayList<>(500);
        sueCopy.addAll(sues);
        iter = sueCopy.iterator();

        sueiter:
        while (iter.hasNext()){
            Sue sue = iter.next();
            for(String name : properties.keySet()){
                if(sue.hasProperty(name) && !sue.isPropertyInRange(name, properties.get(name))){
                    iter.remove();
                    continue sueiter;
                }
            }
        }

        System.out.println();
        System.out.print("Remaining Sues round 2: ");
        for(Sue sue : sueCopy)
            System.out.print(sue.index + " ");

    }

}
