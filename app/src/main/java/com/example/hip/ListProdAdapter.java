package com.example.hip;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hip.model.Product;

import java.util.List;

public class ListProdAdapter extends RecyclerView.Adapter<ListProdAdapter.ProductHolder> {
    private List<Product> mList;
    private Activity activity;
    public ListProdAdapter(Activity activity, List<Product> list){
        mList = list;
        this.activity = activity;
    }
    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = activity.getLayoutInflater().inflate(R.layout.item_rcv,parent,false);
        return new ProductHolder(v);
    }
    public void add(Product p){
        mList.add(p);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product p = mList.get(position);
        holder.img.setImageResource(p.getrsImg());
        holder.price.setText(""+p.getPrice());
        holder.quantity.setText(""+p.getQuantity());
        holder.conhang.setText((p.isConhang())?"con hang":"het hang");
        holder.name.setText(p.getName());
        holder.date.setText(p.getDate());
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(position);
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }
    class ProductHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private Button btnRemove;
        private TextView name,date,conhang, quantity,price;
        public ProductHolder(@NonNull View v) {
            super(v);
            btnRemove = v.findViewById(R.id.btnRemove);
            img = v.findViewById(R.id.img);
            name = v.findViewById(R.id.name);
            date = v.findViewById(R.id.date);
            conhang = v.findViewById(R.id.tinhtrang);
            quantity = v.findViewById(R.id.quantity);
            price = v.findViewById(R.id.price);
        }
    }
}
