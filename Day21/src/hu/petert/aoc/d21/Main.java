package hu.petert.aoc.d21;

public class Main {

    public final static int HP = 100;
    public final static int BOSS_HP = 103;
    public final static int BOSS_DAMAGE = 9;
    public final static int BOSS_ARMOR = 2;


    public static void main(String[] args){

        int minCost = Integer.MAX_VALUE;
        int maxCost = 0;

        for (int armor = 1; armor <= 8; armor++) {
            for(int damage = 4; damage <= 11; damage++){
                if(doesPlayerWin(damage, armor)){
                    int cost = getMinArmorCost(armor) + getMinDamageCost(damage);
                    if(cost < minCost) minCost = cost;
                } else {
                    int cost = getMaxArmorCost(armor) + getMaxDamageCost(damage);
                    if(cost > maxCost) maxCost = cost;
                }
            }
        }

        System.out.println("Min cost: " + minCost);
        System.out.println("Max cost: " + maxCost);

    }

    public static boolean doesPlayerWin(int damage, int armor){

        int bossHp = BOSS_HP;
        int playerHp = HP;

        while (true){
            bossHp -= Math.max(1, damage - BOSS_ARMOR);
            if(bossHp <= 0) break;
            playerHp -= Math.max(1, BOSS_DAMAGE - armor);
            if(playerHp <= 0) break;
        }

        return playerHp > 0;
    }

    public static int getMinDamageCost(int damage){
        switch (damage){
            case 4: return 8;
            case 5: return 10;
            case 6: return 25;
            case 7: return 40;
            case 8: return 65;
            case 9: return 90;
            case 10: return 124;
            case 11: return 174;
        }
        return Integer.MAX_VALUE;
    }

    public static int getMinArmorCost(int armor){
        switch (armor){
            case 1: return 13;
            case 2: return 31;
            case 3: return 51;
            case 4: return 73;
            case 5: return 93;
            case 6: return 115;
            case 7: return 142;
            case 8: return 182;
        }
        return Integer.MAX_VALUE;
    }

    public static int getMaxDamageCost(int damage){
        switch (damage){
            case 4: return 8;
            case 5: return 33;
            case 6: return 58;
            case 7: return 108;
            case 8: return 75;
            case 9: return 125;
            case 10: return 140;
            case 11: return 174;
        }
        return Integer.MAX_VALUE;
    }

    public static int getMaxArmorCost(int armor){
        switch (armor){
            case 1: return 20;
            case 2: return 40;
            case 3: return 53;
            case 4: return 93;
            case 5: return 111;
            case 6: return 133;
            case 7: return 155;
            case 8: return 182;
        }
        return Integer.MAX_VALUE;
    }

}
