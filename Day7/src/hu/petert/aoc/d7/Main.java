package hu.petert.aoc.d7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static Map<String, Wire> wires = new HashMap<>();

    public static void main(String[] args){

        loadWires();
        int out = wires.get("a").getOutput();
        loadWires();
        wires.put("b", new Wire(String.valueOf(out)));
        int out2 = wires.get("a").getOutput();
        System.out.println("Output: " + out);
        System.out.println("new output: " + out2);

    }

    public static void loadWires(){
        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            String line;

            while (scanner.hasNext()){
                line = scanner.nextLine();
                String[] splitter = line.split(" -> ");
                wires.put(splitter[1], new Wire(splitter[0]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
