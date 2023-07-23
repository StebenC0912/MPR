package hanu.a2_2001040121.myapplication;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import hanu.a2_2001040121.myapplication.adapters.ProductAdapter;
import hanu.a2_2001040121.myapplication.database.MyDatabaseHelper;
import hanu.a2_2001040121.myapplication.models.Product;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private ArrayList<Product> productList;
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private FirebaseAnalytics mFirebaseAnalytics;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        // Text to speech
        textToSpeech = new TextToSpeech(this, this);
        // message from the notification
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }
                    }
                });
        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        // Initialize the product list
        productList = new ArrayList<>();
        // Fetch data from the API
        fetchData();
        // Initialize ProductAdapter with the Product list
        adapter = new ProductAdapter(this, productList);
        recyclerView.setAdapter(adapter);
        TextView searchKeyword = findViewById(R.id.search_bar_edit_text);
        ImageView searchIcon = findViewById(R.id.search_bar_image_view);
        searchIcon.setOnClickListener(v -> {
            String keyword = searchKeyword.getText().toString();
            if (keyword.isEmpty()) {
                Toast.makeText(this, "Please enter a keyword", Toast.LENGTH_SHORT).show();
                adapter = new ProductAdapter(this, productList);
                recyclerView.setAdapter(adapter);
            } else {
                ArrayList<Product> filteredList = new ArrayList<>();
                for (Product product : productList) {
                    if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                        filteredList.add(product);
                    }
                }
                adapter = new ProductAdapter(this, filteredList);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_out_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_checkout) {
            Intent intent = new Intent(this, CheckOut.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.US);
            textToSpeech.speak("Welcome to the shopping cart app", TextToSpeech.QUEUE_FLUSH, null);

        } else {
            Toast.makeText(this, "Text to speech not supported", Toast.LENGTH_SHORT).show();
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        // Release the TextToSpeech resources when the activity is destroyed.
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}