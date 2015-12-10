package hu.petert.aoc.d10;

public class Main {

    public static final int STEPS = 50;

    public static void main(String[] args){
        StringBuffer input = new StringBuffer("3113322113");
        for (int i = 0; i < STEPS; i++) {
            StringBuffer newInput = new StringBuffer();
            int count = 1;
            char c = input.charAt(0);
            for (int j = 1; j < input.length(); j++) {
                if(input.charAt(j) == c) count++;
                else {
                    newInput.append(count).append(c);
                    count = 1;
                    c = input.charAt(j);
                }
            }
            newInput.append(count).append(c);
            input = newInput;
        }
        System.out.println("Result length: " + input.length());
    }

}
