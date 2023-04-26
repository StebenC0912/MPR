package hanu.a2_2001040121.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

import hanu.a2_2001040121.myapplication.R;
import hanu.a2_2001040121.myapplication.database.MyDatabaseHelper;
import hanu.a2_2001040121.myapplication.models.Product;

public class CheckOutAdapter extends RecyclerView.Adapter {
    private List<Product> productList;
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public CheckOutAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_out_product, parent, false);
        return new CheckOutAdapter.CheckoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product product = productList.get(position);
        new ImageDownloader(((CheckOutAdapter.CheckoutViewHolder) holder).productImage).execute(product.getThumbnail());
        if (product.getName().length() > 40) {
            String trimmed = product.getName().substring(0, 37) + "...";
            ((CheckOutAdapter.CheckoutViewHolder) holder).productName.setText(trimmed);
        } else {
            ((CheckOutAdapter.CheckoutViewHolder) holder).productName.setText(product.getName());
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        ((CheckOutAdapter.CheckoutViewHolder) holder).productPrice.setText("đ" + formatter.format(product.getUnitPrice()));
        ((CheckOutAdapter.CheckoutViewHolder) holder).quantity.setText(String.valueOf(product.getQuantity()));

        int quantity = Integer.parseInt(((CheckOutAdapter.CheckoutViewHolder) holder).quantity.getText().toString());
        String formattedPrice = formatter.format(product.getUnitPrice() * quantity);
        ((CheckOutAdapter.CheckoutViewHolder) holder).sum.setText("đ" + formattedPrice);
        ((CheckOutAdapter.CheckoutViewHolder) holder).plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(((CheckOutAdapter.CheckoutViewHolder) holder).quantity.getText().toString());
                quantity++;
                ((CheckOutAdapter.CheckoutViewHolder) holder).quantity.setText(String.valueOf(quantity));
                DecimalFormat formatter = new DecimalFormat("#,###");
                String formattedPrice = formatter.format(product.getUnitPrice() * quantity);
                ((CheckOutAdapter.CheckoutViewHolder) holder).sum.setText("đ" + formattedPrice);
                dbHelper = new MyDatabaseHelper(view.getContext());
                db = dbHelper.getWritableDatabase();
                dbHelper.updateProduct(product, db);
            }
        });
        ((CheckOutAdapter.CheckoutViewHolder) holder).minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(((CheckOutAdapter.CheckoutViewHolder) holder).quantity.getText().toString());
                if (quantity > 0) {
                    quantity--;
                    ((CheckOutAdapter.CheckoutViewHolder) holder).quantity.setText(String.valueOf(quantity));
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    String formattedPrice = formatter.format(product.getUnitPrice() * quantity);
                    ((CheckOutAdapter.CheckoutViewHolder) holder).sum.setText("đ" + formattedPrice);
                    dbHelper = new MyDatabaseHelper(view.getContext());
                    db = dbHelper.getWritableDatabase();
                    dbHelper.deleteQuantity(product, db);
                }
                if (quantity == 0) {
                    productList.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, productList.size());
                    dbHelper = new MyDatabaseHelper(view.getContext());
                    db = dbHelper.getWritableDatabase();
                    dbHelper.deleteProduct(product, db);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }
    public static class CheckoutViewHolder extends RecyclerView.ViewHolder {
        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;
        public TextView quantity;
        public ImageView plus;
        public ImageView minus;
        public TextView sum;
        public CheckoutViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            quantity = itemView.findViewById(R.id.quantity);
            plus = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);
            sum = itemView.findViewById(R.id.sum);
        }
    }

}
