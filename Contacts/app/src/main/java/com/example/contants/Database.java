package com.example.contants;

public class Database {
    private static final Contact contacts[] = {new Contact("Bekbolat", "87054321878", "Yandex"),
            new Contact("Adil Semey", "87759693553", "KBTU"),
            new Contact("Zangar", "87718877671", "KBTU"),
            new Contact("Merlan", "87473647001"),
            new Contact("Erma", "87079188185"),
            new Contact("Aleke", "87751875959", "OneFit"),
            new Contact("Aidana Sister D","87774578002","Student"),
            new Contact("Alikan","87071651026","KBTU"),
            new Contact("Jumpman","87752550240",""),
            new Contact("","87780211200",""),
            new Contact("Toray","87086974155",""),

    };

    public static Contact[] getContacts(){
        return contacts;
    }

    public static Contact getContact(int position){
        return contacts[position];
    }
}
