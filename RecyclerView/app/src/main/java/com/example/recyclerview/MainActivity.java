package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  RecyclerView recyclerView;
  FloatingActionButton floatingActionButton;
  RecyclerContactAdaptor adepter;
  ArrayList<ContactModal> arrContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        floatingActionButton = findViewById(R.id.floatingButton);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_layout);

                TextView name = findViewById(R.id.edtName);
                TextView contact = findViewById(R.id.edtContact);
                Button actionButton = findViewById(R.id.actionButton);

                actionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String contactName = name.getText().toString();
                        String contactNumber = contact.getText().toString();

                        arrContact.add(new ContactModal(contactName,contactNumber));
                        adepter.notifyItemInserted(arrContact.size()-1);
                        recyclerView.scrollToPosition(arrContact.size()-1);

                        dialog.dismiss();

                    }
                });
                dialog.show();




            }
        });



        arrContact.add(new ContactModal(R.drawable.p1,"A","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p2,"b","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p3,"f","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p4,"g","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p1,"h","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p2,"s","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p3,"A","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p4,"Af","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p1,"As","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p2,"As","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p3,"A","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p4,"Af","1234567890"));

        arrContact.add(new ContactModal(R.drawable.p1,"Af","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p2,"A","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p3,"Aw","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p4,"A","1234567890"));

        arrContact.add(new ContactModal(R.drawable.p1,"Ae","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p2,"Ae","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p3,"Ar","1234567890"));
        arrContact.add(new ContactModal(R.drawable.p4,"Ah","1234567890"));








      adepter = new RecyclerContactAdaptor(this,arrContact);
      recyclerView.setAdapter(adepter);







    }
}