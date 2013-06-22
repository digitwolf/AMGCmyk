package com.digitwolf.cmyk.client.impl.avatar;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GravatarUrlBuilder {
   

    /**
     * Build the url
     * 
     * @param email
     * @return
     */
    public static String build(String email) {
	return "http://www.gravatar.com/avatar/" + GravatarUrlBuilder.md5Hex(email);
    }


    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
        sb.append(Integer.toHexString((array[i]
            & 0xFF) | 0x100).substring(1,3));        
        }
        return sb.toString();
    }
    public static String md5Hex (String message) {
        try {
        MessageDigest md = 
            MessageDigest.getInstance("MD5");
        return hex (md.digest(message.getBytes("CP1252")));
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }
}
