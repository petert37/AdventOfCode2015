package hu.petert.aoc.d5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int nice1 = 0;
        int nice2 = 0;

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            String line;

            while (scanner.hasNext()){
                line = scanner.next();
                if(hasThreeVowels(line) && hasDoubleLetter(line) && !containsBadSubStrings(line)) nice1++;
                if(hasOneSpaceRepeat(line) && hasDoubleLetterRepeat(line)) nice2++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Nice1: " + nice1);
        System.out.println("Nice2: " + nice2);

    }

    public static boolean hasThreeVowels(String line){
        char[] chars = line.toCharArray();
        int wovels = 0;
        for(char c : chars)
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') wovels++;
        return wovels >= 3;
    }

    public static boolean hasDoubleLetter(String line){
        char[] chars = line.toCharArray();
        char prev = '-';
        for(char c : chars){
            if(c == prev) return true;
            prev = c;
        }
        return false;
    }

    public static boolean containsBadSubStrings(String line){
        return line.contains("ab") || line.contains("cd") || line.contains("pq") || line.contains("xy");
    }

    public static boolean hasOneSpaceRepeat(String line){
        char[] chars = line.toCharArray();
        for(int i = 2; i < chars.length; i++)
            if(chars[i] == chars[i-2]) return true;
        return false;
    }

    public static boolean hasDoubleLetterRepeat(String line){
        for(int i = 0; i < line.length() - 2; i++)
            if(line.substring(i+2).contains(line.substring(i, i+2))) return true;
        return false;
    }

}
