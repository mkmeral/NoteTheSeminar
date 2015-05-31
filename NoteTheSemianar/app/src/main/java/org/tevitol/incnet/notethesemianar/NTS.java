package org.tevitol.incnet.notethesemianar;

/**
 * Created by mkmer on 30.05.2015.
 */
public class NTS {
    public static String TOKEN;
    public static String username;
    public static String IP = "http://104.155.44.142";

    public void changeInfo(String token, String username){
        TOKEN = token;
        NTS.username = username;
    }


    public void LogOut (){
        TOKEN = null;
        username = null;
    }

}
