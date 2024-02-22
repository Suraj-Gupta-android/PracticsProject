package com.example.recyclerview;

public class ContactModal {

    int img;
    String name,contact;

    ContactModal(int img, String name, String contact){

        this.img = img;
        this.name = name;
        this.contact = contact;

    }
    ContactModal( String name, String contact){


        this.name = name;
        this.contact = contact;

    }

}
