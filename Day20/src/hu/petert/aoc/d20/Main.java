package hu.petert.aoc.d20;

public class Main {

    public static void main(String[] args){

        int counter = 0;

        while (true){
            counter++;
            int sum = getSumOfDivisors(counter) * 10;
            if(sum >= 29000000) break;
        }

        System.out.println(counter);

        counter = 0;

        while (true){
            counter++;
            int sum = getSumOfDivisorsP2(counter) * 11;
            if(sum >= 29000000) break;
        }

        System.out.println(counter);
    }

    public static int getSumOfDivisors(int number){
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                sum += i;
                int d = number / i;
                if(d != i) sum += d;
            }
        }
        return sum + number;
    }

    public static int getSumOfDivisorsP2(int number){
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                if(number <= i * 50) sum += i;
                int d = number / i;
                if(d != i && number <= d * 50) sum += d;
            }
        }
        return sum + number;
    }

}
