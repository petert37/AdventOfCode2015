package hu.petert.aoc.d11;

public class Main {

    public static void main(String[] args){

        char[] input = "vzbxkghb".toCharArray();

        makeNextPassword(input);
        System.out.println(input);
        makeNextPassword(input);
        System.out.println(input);


    }

    public static void makeNextPassword(char[] input){
        while (true){
            increase(input);
            if(hasThreeFollowing(input) && hasDoubleLetters(input) && !containIllegalCharacters(input)) break;
        }
    }

    public static void increase(char[] input){
        for (int i = input.length - 1; i >= 0 ; i--) {
            input[i]++;
            if(input[i] > 'z') input[i] = 'a';
            else return;
        }
    }

    public static boolean hasThreeFollowing(char[] input){
        for (int i = 0; i < input.length - 2; i++) {
            if(input[i] == input[i+1] -1 && input[i] == input[i+2] - 2) return true;
        }
        return false;
    }

    public static boolean containIllegalCharacters(char[] input){
        for (char c : input){
            if(c == 'i' || c == 'o' || c == 'l') return true;
        }
        return false;
    }

    public static boolean hasDoubleLetters(char[] input){
        int doubles = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if(input[i] == input[i+1]){
                doubles++;
                i++;
            }
        }
        return doubles >= 2;
    }

}
