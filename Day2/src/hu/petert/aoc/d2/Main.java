package hu.petert.aoc.d2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int paper = 0;
        int ribbon = 0;

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNext()){
                String s = scanner.next();
                String[] splitter = s.split("x");
                int w = Integer.parseInt(splitter[0]);
                int h = Integer.parseInt(splitter[1]);
                int l = Integer.parseInt(splitter[2]);
                int sizes[] = {w, h, l};
                Arrays.sort(sizes);
                int size = 2*l*w + 2*w*h + 2*h*l + Math.min(l*w, Math.min(w*h, h*l));
                paper += size;
                ribbon += 2 * sizes[0] + 2 * sizes[1] + w * h * l;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Paper: " + paper);
        System.out.println("Ribbon: " + ribbon);

    }

}
