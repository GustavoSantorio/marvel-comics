package com.example.gusta.marvelcomics.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by gusta on 06/05/2017.
 */

public class Encryption {

    public static String md5(String s) throws NoSuchAlgorithmException {
        MessageDigest digest = java.security.MessageDigest
                .getInstance("MD5");
        digest.update(s.getBytes());
        byte messageDigest[] = digest.digest();

        StringBuilder hexString = new StringBuilder();
        for (byte aMessageDigest : messageDigest) {
            String h = Integer.toHexString(0xFF & aMessageDigest);
            while (h.length() < 2)
                h = "0" + h;
            hexString.append(h);
        }
        return hexString.toString();
    }
}
