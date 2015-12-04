package hu.petert.aoc.d3;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        HashSet<Point> houses = new HashSet<>();
        HashSet<Point> housesY2 = new HashSet<>();
        Point pos = new Point(0, 0);
        Point santa = new Point(0, 0);
        Point robo = new Point(0, 0);
        houses.add(new Point(pos));
        housesY2.add(new Point(santa));

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext()){
                String line = scanner.next();
                for(char c : line.toCharArray()){
                    switch (c){
                        case '<' : pos.translate(-1, 0); break;
                        case '>' : pos.translate(1, 0); break;
                        case '^' : pos.translate(0, 1); break;
                        case 'v' : pos.translate(0, -1); break;
                    }
                    houses.add(new Point(pos));
                }

                char[] chars = line.toCharArray();

                for(int i = 0; i < chars.length; i++){
                    char c = chars[i];
                    Point tmp;
                    if(i % 2 == 0) tmp = santa;
                    else tmp = robo;
                    switch (c){
                        case '<' : tmp.translate(-1, 0); break;
                        case '>' : tmp.translate(1, 0); break;
                        case '^' : tmp.translate(0, 1); break;
                        case 'v' : tmp.translate(0, -1); break;
                    }
                    housesY2.add(new Point(tmp));
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Houses visited: " + houses.size());
        System.out.println("Houses visited year 2: " + housesY2.size());

    }

}
