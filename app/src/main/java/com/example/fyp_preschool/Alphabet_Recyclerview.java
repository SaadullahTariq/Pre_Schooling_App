package com.example.fyp_preschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Alphabet_Recyclerview extends RecyclerView.Adapter<Alphabet_Recyclerview.MyViewHolder> {
    Context context;
    ArrayList<AlphabetItem>  alphabetItems;

    public Alphabet_Recyclerview(Context context, ArrayList<AlphabetItem>  alphabetItems){
        this.context = context;
        this.alphabetItems = alphabetItems;
    }

    @NonNull
    @Override
    public Alphabet_Recyclerview.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Alphabet_Recyclerview.MyViewHolder holder, int position) {
        holder.tv_word.setText(alphabetItems.get(position).getWord());
        holder.imageview.setImageResource(alphabetItems.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return alphabetItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageview;
        TextView tv_word;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.Image_view_recycler);
            tv_word = itemView.findViewById(R.id.text_view_recycler);

        }
    }
}
