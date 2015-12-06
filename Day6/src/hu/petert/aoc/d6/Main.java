package hu.petert.aoc.d6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static Light[][] lights;

    static {
        lights = new Light[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                lights[i][j] = new Light();
            }
        }
    }

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] splitter = line.split(" ");
                String xCoords[] = null;
                String yCoords[] = null;
                String operation = null;
                if(splitter[0].equals("turn")){
                    xCoords = splitter[2].split(",");
                    yCoords = splitter[4].split(",");
                    operation = splitter[1];
                } else if(splitter[0].equals("toggle")){
                    xCoords = splitter[1].split(",");
                    yCoords = splitter[3].split(",");
                    operation = "toggle";
                }
                doOperation(operation, Integer.valueOf(xCoords[0]),Integer.valueOf(xCoords[1]), Integer.valueOf(yCoords[0]), Integer.valueOf(yCoords[1]));
            }

        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        int on = 0;
        int brightness = 0;

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if(lights[i][j].isOn()) on++;
                brightness += lights[i][j].getBrightness();
            }
        }

        System.out.println("Lights on: " + on);
        System.out.println("Total brightness: " + brightness);

    }

    public static void doOperation(String operation, int x1, int y1, int x2, int y2){
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if(operation.equals("on")) lights[x][y].on();
                if(operation.equals("off")) lights[x][y].off();
                if(operation.equals("toggle")) lights[x][y].toggle();
            }
        }
    }

}
