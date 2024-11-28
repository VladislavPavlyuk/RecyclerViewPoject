package com.example.recyclerviewpoject.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewpoject.MainActivity;
import com.example.recyclerviewpoject.R;
import com.example.recyclerviewpoject.data.Client;

import java.util.List;

//2 step
public class ClientAdaptor extends RecyclerView.Adapter<ClientAdaptor.ClientViewHolder>{
    private List<Client> list;
    private MainActivity mainActivity;

    public ClientAdaptor(MainActivity mainActivity, List<Client> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    //В методах дожны быть правильные типы
    // ClientViewHolder для возвращения значения i в параметрах
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //1
        //LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        //attacheToRoot = false !!!!!
        View item =  inflater.inflate(R.layout.item_client,parent,false);
        return new ClientViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client client = list.get(position);
        //1
        holder.idItem.setText(String.valueOf(client.getId()));
        holder.surnameItem.setText(client.getSurname());
        holder.nameItem.setText(client.getName());
        holder.phoneItem.setText(client.getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //1 step
    public static class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView idItem;
        TextView surnameItem;
        TextView nameItem;
        TextView phoneItem;
        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            idItem = itemView.findViewById(R.id.id);
            surnameItem = itemView.findViewById(R.id.surnameItem);
            nameItem = itemView.findViewById(R.id.nameItem);
            phoneItem = itemView.findViewById(R.id.phoneItem);
        }
    }
}
