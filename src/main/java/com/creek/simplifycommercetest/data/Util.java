package com.creek.simplifycommercetest.data;

/**
 * 
 * @author andreypereverzin
 */
public class Util {
    public static boolean getBoolean(final String value) {
        try {
            return Boolean.parseBoolean(value);
        } catch (final Exception ex) {
            return false;
        }
    }
}
