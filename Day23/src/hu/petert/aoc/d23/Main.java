package hu.petert.aoc.d23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int a, b, pc;

    static List<String> instructions;

    public static void main(String[] args){
        a = 0;
        b = 0;
        pc = 0;
        instructions = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext())
                instructions.add(scanner.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (pc < instructions.size())
            execute();

        System.out.println(b);

        a = 1;
        b = 0;
        pc = 0;

        while (pc < instructions.size())
            execute();

        System.out.println(b);

    }

    public static void execute(){
        String[] splitter = instructions.get(pc).split(" ");
        switch (splitter[0]){
            case "hlf":
                if(splitter[1].equals("a")) a /= 2;
                if(splitter[1].equals("b")) b /= 2;
                pc++;
                break;
            case "tpl":
                if(splitter[1].equals("a")) a *= 3;
                if(splitter[1].equals("b")) b *= 3;
                pc++;
                break;
            case "inc":
                if(splitter[1].equals("a")) a++;
                if(splitter[1].equals("b")) b++;
                pc++;
                break;
            case "jmp":
                pc += Integer.valueOf(splitter[1]);
                break;
            case "jie":
                int r = 0;
                if(splitter[1].replaceAll(",", "").equals("a")) r = a;
                if(splitter[1].replaceAll(",", "").equals("b")) r = b;
                if(r % 2 == 0) pc += Integer.valueOf(splitter[2]);
                else pc++;
                break;
            case "jio":
                int r2 = 0;
                if(splitter[1].replaceAll(",", "").equals("a")) r2 = a;
                if(splitter[1].replaceAll(",", "").equals("b")) r2 = b;
                if(r2 == 1) pc += Integer.valueOf(splitter[2]);
                else pc++;
                break;
        }
        a = Math.max(0, a);
        b = Math.max(0, b);
    }

}
