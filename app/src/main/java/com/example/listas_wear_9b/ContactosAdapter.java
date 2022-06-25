package com.example.listas_wear_9b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactosAdapter
        extends RecyclerView.Adapter<ContactosAdapter.RecyclerViewHolder>{

    private ArrayList<Contacto> elementos = new ArrayList<>();
    private Context context;

    private AdapterCallback callback;


    public interface AdapterCallback{
        void onItemClicked(Integer itemPosition);
    }

    public ContactosAdapter(ArrayList<Contacto> elementos, Context context, AdapterCallback callback) {
        this.elementos = elementos;
        this.context = context;
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Contacto contacto = elementos.get(position);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null){
                    callback.onItemClicked(position);
                }
            }
        });

        holder.imageContact.setImageResource(contacto.getImage());
        holder.nameContact.setText(contacto.getName());
    }

    @Override
    public int getItemCount() {
        return elementos.size(); // 15 [ 0 - 14 ]
    }

    public static class RecyclerViewHolder
            extends RecyclerView.ViewHolder {

            // Definir los elementos del diseño
            RelativeLayout relativeLayout;
            ImageView imageContact;
            TextView nameContact;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.container);
            imageContact = itemView.findViewById(R.id.imageContact);
            nameContact = itemView.findViewById(R.id.nameContact);

        }
    }

}
