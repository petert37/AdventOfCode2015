package hu.petert.aoc.d8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int stringLength = 0;
    static int memoryLenght = 0;
    static int encodedLength = 0;

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            String line;

            while (scanner.hasNext()){
                line = scanner.nextLine();
                stringLength += line.length();
                memoryLenght += getMemoryLenght(line);
                encodedLength += getEncodedLength(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Difference: " + (stringLength - memoryLenght));
        System.out.println("Difference2: " + (encodedLength - stringLength));

    }

    public static int getMemoryLenght(String line){
        int length = 0;

        char[] chars = line.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            length++;
            if(chars[i] == '\\'){
                if(chars[i+1] == '\\' || chars[i+1] == '\"') i++;
                else if(chars[i+1] == 'x') i += 3;
            }
        }

        return length - 2;
    }

    public static int getEncodedLength(String line){
        int length = 0;

        char[] chars = line.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            length++;
            if(chars[i] == '\\' || chars[i] == '\"'){
                length++;
            }
        }

        return length + 2;
    }

}
