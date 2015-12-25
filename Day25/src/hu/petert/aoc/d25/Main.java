package hu.petert.aoc.d25;

public class Main {

    public static final int ROW = 2947;
    public static final int COLUMN = 3029;
    public static final int MULTIPLIER = 252533;
    public static final int DIVIDER = 33554393;
    public static final int STARTER_CODE = 20151125;

    public static void main(String[] args){

        System.out.println(getCode(ROW, COLUMN));

    }

    public static long getCode(int r, int c){

        long code = STARTER_CODE;

        for (int i = 3; i <= r + c; i++) {
            for (int column = 1; column < i; column++){
                int row = i - column;
                code = (code * MULTIPLIER) % DIVIDER;
                if(row == r && column == c){
                    return code;
                }
            }
        }
        return -1;
    }

}
