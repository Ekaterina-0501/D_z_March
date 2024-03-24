package org.example.crud;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hesh_Password {
    public static String HeshPassword(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String args[]) throws NoSuchAlgorithmException {
//
//
//        String s1 = "ttt77777";
//        System.out.println("\n" + s1 + " : " + HeshPassword(s1));
//
//    }
}

