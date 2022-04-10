package com.example.contactbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.ViewHolder>{
    private ArrayList<ContactModal> contactModalArrayList;
    private Context context;
    @NonNull
    @Override
    public ContactRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.contact_item, parent, false);
        return new ViewHolder(view);

    }

    public ContactRVAdapter(ArrayList<ContactModal> contactModalArrayList, show_contacts show_contacts) {
        this.contactModalArrayList = contactModalArrayList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactRVAdapter.ViewHolder holder, int position) {
        ContactModal modal = contactModalArrayList.get(position);
        holder.name.setText(modal.getName());
        holder.phone.setText(modal.getPhone());
        holder.email.setText(modal.getEmail());
    }

    @Override
    public int getItemCount() {
        return contactModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name, phone, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
                name = (TextView) itemView.findViewById(R.id.Txt_name);
                phone = (TextView) itemView.findViewById(R.id.Txt_phone);
                email = (TextView) itemView.findViewById(R.id.Txt_email);
        }
    }
}
