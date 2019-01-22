package com.example.iptv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.PersonViewHolder>   {











    List<Chanel> chanel;

    ListAdapter(List<Chanel> chanel){
        this.chanel = chanel;


    }


    @NonNull
    @Override
    public ListAdapter.PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context=viewGroup.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list,viewGroup,false);
        return new ListAdapter.PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.PersonViewHolder personViewHolder, int i) {
        personViewHolder.nameChanel.setText(chanel.get(i).nameChanel);
      //  personViewHolder.nameBroadcast.setText(chanel.get(i).nameBroadcast);
     //   personViewHolder.Picture.setImageResource(chanel.get(i).Picture);
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return chanel.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nameChanel;
      //  TextView timeBroadcast;
      //  TextView nameBroadcast;
      //  ImageView Picture;




        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.mycv);
           // timeBroadcast=(TextView)itemView.findViewById(R.id.time);
            nameChanel = (TextView)itemView.findViewById(R.id.chanel);
          //  nameBroadcast = (TextView)itemView.findViewById(R.id.broadcast);
       //    Picture = (ImageView)itemView.findViewById(R.id.picture);
        }
    }
}
