package hanu.a2_2001040121.myapplication.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import hanu.a2_2001040121.myapplication.R;
import hanu.a2_2001040121.myapplication.models.Product;

public class ProductAdapter extends RecyclerView.Adapter {
    private ArrayList<Product> productList;
    private Context context;

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
        try {
            URL url = new URL(product.getThumbnail());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            ((ProductViewHolder) holder).productImage.setImageBitmap(bmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Trim the name string if it's longer than 2 lines
        if (product.getName().length() > 40) {
            String trimmed = product.getName().substring(0, 37) + "...";
            ((ProductViewHolder) holder).productName.setText(trimmed);
        } else {
            ((ProductViewHolder) holder).productName.setText(product.getName());
        }
        ((ProductViewHolder) holder).productPrice.setText("$" + String.valueOf(product.getUnitPrice()));

    }

    @Override
    public int getItemCount() {
        return productList != null ? productList.size() : 0;
    }


    public void updateData(List<Product> newData) {
        productList.clear();
        productList.addAll(newData);
        notifyDataSetChanged();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView productImage;
        public TextView productName;
        public TextView productPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}

