package hu.petert.aoc.d10;

public class Main {

    public static final int STEPS = 50;

    public static void main(String[] args){

        String input = "3113322113";

        for (int i = 0; i < STEPS; i++) {
            char[] chars = input.toCharArray();
            String newInput = "";
            int count = 1;
            char c = chars[0];
            for (int j = 1; j < chars.length; j++) {
                if(chars[j] == c) count++;
                else {
                    newInput = newInput.concat(String.valueOf(count) + c);
                    count = 1;
                    c = chars[j];
                }
            }
            newInput = newInput.concat(String.valueOf(count) + c);
            input = newInput;
            System.out.println(i);
        }

        System.out.println("Result length " + input.length());

    }

}
