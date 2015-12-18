package hu.petert.aoc.d18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Board board = new Board();

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            for (int y = 0; y < Board.SIZE; y++) {
                String line = scanner.nextLine();
                for (int x = 0; x < Board.SIZE; x++) {
                    char c = line.charAt(x);
                    board.addLight(x, y, c == '#');
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            board.nextFrame();
        }

        System.out.println("Lights on: " + board.getOnCount());

    }

}
