package com.example.hp.retrofitrecycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.retrofitrecycleview.POJO.RanksPojo;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.MyView> {
    ArrayList<RanksPojo> ranksPojos;
    Context context;
    public RankAdapter(ArrayList<RanksPojo> ranksPojos ,Context context) {
        this.context=context;
        this.ranksPojos=ranksPojos;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rank_row,parent,false);
       return  new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ranj_id.setText(ranksPojos.get(position).getRank());

        holder.rank_name.setText(ranksPojos.get(position).getRank());


    }

    @Override
    public int getItemCount() {
        return ranksPojos.size();
    }

    public  class  MyView  extends  RecyclerView.ViewHolder {
        private TextView ranj_id,rank_name;
        public MyView(View itemView) {
            super(itemView);

            ranj_id = (TextView)itemView.findViewById(R.id.tv_name);
            rank_name = (TextView)itemView.findViewById(R.id.tv_version);
        }
    }
}

