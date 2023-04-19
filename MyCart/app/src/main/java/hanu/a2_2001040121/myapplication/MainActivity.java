package hanu.a2_2001040121.myapplication;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import hanu.a2_2001040121.myapplication.models.Product;
import hanu.a2_2001040121.myapplication.adapters.ProductAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Initialize the product list
        productList = new ArrayList<>();

        // Initialize ProductAdapter with the Product list
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);

        // Fetch data from the API
        fetchData();
    }

    public void fetchData() {
        String url = "https://hanu-congnv.github.io/mpr-cart-api/products.json";
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, url, null,
                response -> {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject obj = response.getJSONObject(i);
                            Product product = new Product(
                                    obj.getLong("id"),
                                    obj.getString("thumbnail"),
                                    obj.getString("name"),
                                    obj.getString("category"),
                                    obj.getInt("unitPrice")
                            );
                            productList.add(product);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    // Update the RecyclerView adapter with the fetched data
                    adapter.notifyDataSetChanged();
                },
                error -> {
                    // Handle error
                });

        // Add the request to the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}