package hanu.a2_2001040121.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

import hanu.a2_2001040121.myapplication.R;
import hanu.a2_2001040121.myapplication.database.MyDatabaseHelper;
import hanu.a2_2001040121.myapplication.detail_product;
import hanu.a2_2001040121.myapplication.models.Product;

public class ProductAdapter extends RecyclerView.Adapter {
    private ArrayList<Product> productList;
    private Context context;
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;


    public ProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = productList.get(position);
        // Load the image from the URL into the ImageView
        new ImageDownloader(((ProductViewHolder) holder).productImage).execute(product.getThumbnail());
        // Trim the name string if it's longer than 2 lines
        if (product.getName().length() > 40) {
            String trimmed = product.getName().substring(0, 37) + "...";
            ((ProductViewHolder) holder).productName.setText(trimmed);
        } else {
            ((ProductViewHolder) holder).productName.setText(product.getName());
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedPrice = formatter.format(product.getUnitPrice());
        ((ProductViewHolder) holder).productPrice.setText("đ" + formattedPrice);
        ((ProductViewHolder) holder).productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, detail_product.class);
                intent.putExtra("productID", product.getId().toString());
                intent.putExtra("productName", product.getName());
                intent.putExtra("productPrice", String.valueOf(product.getUnitPrice()));
                intent.putExtra("productThumbnail", product.getThumbnail());
                intent.putExtra("productCategory", product.getCategory());

                context.startActivity(intent);
            }
        });
        ((ProductViewHolder) holder).shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();
                dbHelper = new MyDatabaseHelper(context);
                db = dbHelper.getWritableDatabase();
                if (dbHelper.checkProduct(product, db)) {
                    dbHelper.updateProduct(product, db);
                    return;
                }
                product.setQuantity(1);
                dbHelper.insertProduct(product, db);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;
        private ImageView shoppingCart;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            shoppingCart = itemView.findViewById(R.id.shoppingCart);
        }
    }
}

