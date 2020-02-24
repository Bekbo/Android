package com.example.contants;

public class Database {
    private static final Contact contacts[] = {new Contact("Bekbolat", "87054321878", "Yandex"),
            new Contact("Abylay", "87771234567", "KBTU"),
            new Contact("Zangar", "87024567898", "KBTU"),
            new Contact("Merlan", "87076817561"),
            new Contact("Erma", "87051234567"),
            new Contact("Aleke", "87751875959", "OneFit")};

    public static Contact[] getContacts(){
        return contacts;
    }

    public static Contact getContact(int position){
        return contacts[position];
    }
}
