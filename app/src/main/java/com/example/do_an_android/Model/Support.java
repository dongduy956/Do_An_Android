package com.example.do_an_android.Model;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Support {
    public static String EndcodeMD5(String passWord) {
        String str = "";
        try {
            MessageDigest msd = MessageDigest.getInstance("MD5");
            byte[] srcTextBytes = passWord.getBytes("UTF-8");
            byte[] enrTextBytes = msd.digest(srcTextBytes);
            BigInteger bigInt = new BigInteger(1, enrTextBytes);
            str = bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

}
