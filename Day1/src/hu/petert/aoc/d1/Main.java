package hu.petert.aoc.d1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int floor = 0;
            int lines = 0;
            boolean hasFloor = false;
            while (scanner.hasNext()){
                lines++;
                String s = scanner.next();
                char[] c = s.toCharArray();
                for(int i = 0; i < c.length; i++){
                    if(c[i] == '(') floor++;
                    if(c[i] == ')') floor--;
                    if(floor == -1 && !hasFloor){
                        System.out.println("Entered -1 at: " + lines * (i+1));
                        hasFloor = true;
                    }
                }
            }
            System.out.println("Ended up on floor: " + floor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
