package hu.petert.aoc.d17;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

//Combinatorics package: https://github.com/dpaukov/combinatoricslib

public class Main {

    public static final int LITERS = 150;
    static Integer[] input = {33, 14, 18, 20, 45, 35, 16, 35, 1, 13, 18, 13, 50, 44, 48, 6, 24, 41, 30, 42};

    public static void main(String[] args){
        ICombinatoricsVector<Integer> initialVector = Factory.createVector(input);
        int combo = 0;
        boolean hasMin = false;
        int minCombo = 0;
        int minSize = 0;

        for (int i = 1; i <= input.length; i++) {
            Generator<Integer> gen = Factory.createSimpleCombinationGenerator(initialVector, i);
            for(ICombinatoricsVector<Integer> combination : gen){
                int sum = 0;
                for(int n : combination.getVector()){
                    sum += n;
                }
                if(sum == LITERS) {
                    combo++;
                    if(!hasMin){
                        hasMin = true;
                        minSize = i;
                    }
                    if(i == minSize) minCombo++;
                }
            }
        }
        System.out.println("Combinations: " + combo);
        System.out.println("Minimum combinations: " + minCombo);

    }

}
