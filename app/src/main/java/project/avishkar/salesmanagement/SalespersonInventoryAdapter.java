package project.avishkar.salesmanagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mehul Garg on 22-09-2018.
 */

public class SalespersonInventoryAdapter extends RecyclerView.Adapter<SalespersonInventoryAdapter.MyViewHolder> {

    private ArrayList <InventoryItem> list;
    private Context context;

    public SalespersonInventoryAdapter(){

    }

    public SalespersonInventoryAdapter(Context context,ArrayList<InventoryItem> list){
        this.list=list;
        this.context=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_item_salesperson,parent,false);

        return new SalespersonInventoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.itemName.setText(list.get(position).getItemName());
        holder.sold.setText(String.valueOf(list.get(position).getSold()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView itemName,sold,remaining;
        private ImageView edit;

        public MyViewHolder(View itemView){
            super(itemView);
            itemName=itemView.findViewById(R.id.item_name);
            sold=itemView.findViewById(R.id.items_sold);
            remaining=itemView.findViewById(R.id.remaining_items);
            edit=itemView.findViewById(R.id.edit_icon);
        }
    }
}
