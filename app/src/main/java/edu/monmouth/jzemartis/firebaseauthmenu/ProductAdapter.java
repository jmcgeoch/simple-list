package edu.monmouth.jzemartis.firebaseauthmenu;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class ProductAdapter extends FirebaseRecyclerAdapter<Product, ProductAdapter.ProductViewHolder>
{

    class ProductViewHolder extends RecyclerView.ViewHolder
    {

        public TextView itemName;
        public TextView itemQuantity;

        public ProductViewHolder(View itemView)
        {
            super(itemView);

            itemName = (TextView)itemView.findViewById(R.id.card_product_name);
            itemQuantity = (TextView)itemView.findViewById(R.id.card_product_quantity);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });

        }
    }


    public ProductAdapter(Context context, DatabaseReference ref)
    {
        super(new FirebaseRecyclerOptions.Builder<Product>()
                .setQuery(ref, Product.class)
                .build());
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //TODO
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ProductViewHolder viewHolder = new ProductViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder viewHolder, int i, Product model) {
        viewHolder.itemName.setText(model.getName());
        viewHolder.itemQuantity.setText(Integer.toString(model.getQuantity()));
    }

}
