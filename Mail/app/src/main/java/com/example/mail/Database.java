package com.example.mail;

public class Database {
    private static int pos;
    private static final Mail mails[] ={
            new Mail("title1", "body1", "Alik"),
            new Mail("title2asdf", "asdfsad", "Bekbolat"),
            new Mail("title3asdf", "bofasdfady3", "Google"),
            new Mail("titleasd4", "basdfody4", "Yandex"),
            new Mail("title5ff", "body5", "WSP"),
            new Mail("title6ghj", "fdsafbody6", "Notification"),

    };
    public static Mail[] getMails(){
        return mails;
    }
    public static  Mail getMail(int position){
        return mails[position];
    }

    public static void putPos(int pos2){
        pos = pos2;
    }

    public static int getPos(){
        return pos;
    }
}
