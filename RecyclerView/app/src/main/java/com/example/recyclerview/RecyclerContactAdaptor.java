package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerContactAdaptor extends  RecyclerView.Adapter<RecyclerContactAdaptor.ViewHolder>{
    Context context;
    ArrayList<ContactModal> arrayList;
    RecyclerContactAdaptor(Context contect, ArrayList<ContactModal> arrayList) {
        this.arrayList = arrayList;
        this.context = contect;


    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(context).inflate(R.layout.recycle_cpntact_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textImage.setImageResource(arrayList.get(position).img);
        holder.edtName.setText(arrayList.get(position).name);
        holder.edtContact.setText(arrayList.get(position).contact);


        setAnimation( holder.itemView);
        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_layout);
                TextView name = dialog.findViewById(R.id.edtName);
                TextView contact = dialog.findViewById(R.id.edtContact);

                name.setText(arrayList.get(position).name);
                contact.setText(arrayList.get(position).contact);

                Button actionButton = dialog.findViewById(R.id.actionButton);
                actionButton.setText("Update Contact");
                actionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name2  =  name.getText().toString();
                        String contact2 = contact.getText().toString();
                        arrayList.set(position,new ContactModal(name2,contact2));
                        notifyItemChanged(position);

                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });



        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setIcon(R.drawable.baseline_delete_24)
                        .setTitle("Delete Contact")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.remove(position);
                                notifyItemRemoved(position);

                            }
                        });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });



                builder.show();




                return true;
            }
        });




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView edtName,edtContact;
        ImageView textImage;
        LinearLayout llrow;

        ViewHolder(View itemView){
            super(itemView);

            edtContact = itemView.findViewById(R.id.edtLayoutContat);
            edtName = itemView.findViewById(R.id.edtLayoutName);
            textImage = itemView.findViewById(R.id.edtLayoutImage);
            llrow = itemView.findViewById(R.id.llrow);

        }
    }

    private  void setAnimation(View view ){
        Animation animation =  AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        view.startAnimation(animation);



    }

}
