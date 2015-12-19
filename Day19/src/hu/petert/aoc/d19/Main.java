package hu.petert.aoc.d19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static List<Replacement> replacements = new ArrayList<>();
    static String molecule;

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            String line;
            while (scanner.hasNext()){
                line = scanner.nextLine();
                if(line.equals("")) break;
                String[] splitter = line.split(" => ");
                replacements.add(new Replacement(splitter[0], splitter[1]));
            }
            molecule = scanner.nextLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Different molecules: " + getAllReplacements(molecule).size());

        String input = molecule;
        int counter = 0;

        while (!input.equals("e")){
            for (Replacement rep : replacements){
                if(input.contains(rep.out)) {
                    input = input.replaceFirst(rep.out, rep.in);
                    counter++;
                }
            }
        }

        System.out.println("Got desired molecule in " + counter + " steps");

    }

    public static Set<String> getAllReplacements(String input){
        Set<String> set = new HashSet<>();
        for(Replacement rep : replacements){
            for (int i = 0; i < input.length(); i++) {
                int index = input.indexOf(rep.in, i);
                if(index == -1) break;
                String firstHalf = input.substring(0, index);
                String secondHalf = input.substring(index, input.length()).replaceFirst(rep.in, rep.out);
                set.add(firstHalf + secondHalf);
            }
        }
        return set;
    }

}
