package com.test.thomas.vacvoy;

import android.net.Uri;


public class ContactList {

    private String _name, _phone, _email;
    private int _id;
    private Uri _imageURI;

    public ContactList( int id,String name, String phone, String email, Uri imageUri ){
        _id = id;
        _name = name;
        _phone = phone;
        _email = email;
        _imageURI = imageUri;
    }

    public int get_id() {return _id; }
    public String getCName(){
        return _name;
    }
    public String getCPhone(){
        return _phone;
    }
    public String getCEmail(){
        return _email;
    }
    public Uri getImageURI(){return _imageURI;}
}
