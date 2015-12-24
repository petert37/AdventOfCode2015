package hu.petert.aoc.d22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

//    Magic Missile - 53 mana - 4 damage.
//    Drain - 73 mana - 2 damage - 2 heal.
//    Shield - 113 mana. - 6 turns - 7 armor
//    Poison - 173 mana - 6 turns - 3 damage.
//    Recharge - 229 mana - 5 turns - 101 new mana.

    enum Spell{
        MISSILE, DRAIN, SHIELD, POISON, RECHARGE
    }

    public static final int HP = 50;
    public static final int MANA = 500;
    public static final int BOSS_HP = 71;
    public static final int BOSS_DAMAGE = 10;

    static List<Integer> manaCosts = new ArrayList<>();
    static boolean hard = false;

    public static void main(String[] args){
        for (Spell s : Spell.values())
            turn(s, HP, MANA, BOSS_HP, 0, 0, 0, 0);

        System.out.println(Collections.min(manaCosts));

        hard = true;
        manaCosts = new ArrayList<>();

        for (Spell s : Spell.values())
            turn(s, HP, MANA, BOSS_HP, 0, 0, 0, 0);

        System.out.println(Collections.min(manaCosts));

    }

    public static void turn(Spell spell, int hp, int mana, int bossHp, int manaUsed, int shieldTimer, int poisonTimer, int rechargeTimer){

        //Player turn

        if(hard){
            hp--;
            if(hp <= 0) return;
        }

        boolean shield = shieldTimer > 0;
        if(shield) shieldTimer--;

        if(poisonTimer > 0){
            bossHp -= 3;
            poisonTimer--;
        }

        if(bossHp <= 0){
            manaCosts.add(manaUsed);
            return;
        }

        if(rechargeTimer > 0){
            mana += 101;
            rechargeTimer--;
        }

        switch (spell){
            case MISSILE:
                mana -= 53;
                manaUsed += 53;
                bossHp -= 4;
                break;
            case DRAIN:
                mana -= 73;
                manaUsed += 73;
                bossHp -= 2;
                hp += 2;
                break;
            case SHIELD:
                if(shieldTimer > 0) return;
                mana -= 113;
                manaUsed += 113;
                shieldTimer = 6;
                break;
            case POISON:
                if(poisonTimer > 0) return;
                mana -= 173;
                manaUsed += 173;
                poisonTimer = 6;
                break;
            case RECHARGE:
                if(rechargeTimer > 0) return;
                mana -= 229;
                manaUsed += 229;
                rechargeTimer = 5;
                break;
        }

        if(mana <= 0 && bossHp > 0) return;

        if(bossHp <= 0){
            manaCosts.add(manaUsed);
            return;
        }

        //Boss turn

        shield = shieldTimer > 0;
        if(shield) shieldTimer--;

        if(poisonTimer > 0){
            bossHp -= 3;
            poisonTimer--;
        }

        if(bossHp <= 0){
            manaCosts.add(manaUsed);
            return;
        }

        if(rechargeTimer > 0){
            mana += 101;
            rechargeTimer--;
        }

        hp -= Math.max(1, shield ? BOSS_DAMAGE - 7 : BOSS_DAMAGE);

        if(hp <= 0) return;

        for (Spell s : Spell.values())
            turn(s, hp, mana, bossHp, manaUsed, shieldTimer, poisonTimer, rechargeTimer);

    }

}
