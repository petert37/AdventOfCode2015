package hu.petert.aoc.d24;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class Main {

    static Integer[] input = {1, 2, 3, 5, 7, 13, 17, 19, 23, 29, 31, 37, 41, 43, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113};

    public static void main(String[] args){

        ICombinatoricsVector<Integer> initialVector = Factory.createVector(input);

        long minProduct = Long.MAX_VALUE;
        int minPackages = Integer.MAX_VALUE;

        int sum = 0;
        for(int x : input) sum += x;
        sum /= 3;

        for (int i = 5; i < input.length - 9; i++) {
            Generator<Integer> groupOneGen = Factory.createSimpleCombinationGenerator(initialVector, i);
            if(i > minPackages) break;
            for(ICombinatoricsVector<Integer> vec1 : groupOneGen.generateAllObjects()){

                int sum1 = 0;
                long product = 1;
                for(int i1 : vec1){
                    sum1 += i1;
                    product *= i1;
                }
                if(sum1 != sum) continue;
                if(product > minProduct) continue;

                ICombinatoricsVector<Integer> newVector = Factory.createVector();
                for(int i1 : input)
                    if(!vec1.contains(i1)) newVector.addValue(i1);

                for (int j = 5; j < input.length - i - 5; j++) {
                    Generator<Integer> groupTwoGen = Factory.createSimpleCombinationGenerator(newVector, j);
                    for(ICombinatoricsVector<Integer> vec2 : groupTwoGen.generateAllObjects()){
                        int sum2 = 0;
                        for(int j2 : vec2) {
                            sum2 += j2;
                        }
                        if(sum1 != sum2) continue;

                        int sum3 = 0;
                        for(int k2 : input){
                            if(vec1.contains(k2) || vec2.contains(k2)) continue;
                            sum3 += k2;
                        }

                        if(sum2 == sum3) {
                            minProduct = product;
                            minPackages = i;
                        }

                    }
                }

            }
        }

        System.out.println(minProduct);

    }

}
