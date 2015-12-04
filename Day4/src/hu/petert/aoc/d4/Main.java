package hu.petert.aoc.d4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args){


        String key = "ckczppom";
        int number = 0;
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        while (true){
            byte[] digest = m.digest((key + "" + ++number).getBytes());
            String hashtext = new BigInteger(1,digest).toString(16);
            if(hashtext.length() <= 32-5) System.out.println("Five zeroes: " + number);
            if(hashtext.length() <= 32-6) break;
        }

        System.out.println("Six zeroes: " + number);

    }

}
