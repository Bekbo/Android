package com.example.contants;

public class Contact{
    String name;
    String number;
    String work;


    public Contact(String name, String number){
        this.name = name;
        this.number = number;
        this.work = "Not Chosen";
    }

    public Contact(String name, String number, String work){
        this.name = name;
        this.number = number;
        this.work = work;
    }

}
