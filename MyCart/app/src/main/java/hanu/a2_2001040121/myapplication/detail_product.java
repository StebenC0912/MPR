package hanu.a2_2001040121.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hanu.a2_2001040121.myapplication.adapters.ImageDownloader;
import hanu.a2_2001040121.myapplication.database.MyDatabaseHelper;
import hanu.a2_2001040121.myapplication.models.Product;

public class detail_product extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private ImageView productImage;
    private TextView productName;
    private TextView productPrice;
    private TextView productDescription;
    private Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        productImage = findViewById(R.id.product_image);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        productDescription = findViewById(R.id.description);
        addToCart = findViewById(R.id.buy_button);
        String id = getIntent().getStringExtra("productID");
        String name = getIntent().getStringExtra("productName");
        String unitPrice = getIntent().getStringExtra("productPrice");
        String thumbnail = getIntent().getStringExtra("productThumbnail");
        String category = getIntent().getStringExtra("productCategory");
        (new ImageDownloader(productImage)).execute(thumbnail);
        productName.setText(name);
        productPrice.setText(unitPrice);
        productDescription.setText(category);
        addToCart.setOnClickListener(v -> {
            dbHelper = new MyDatabaseHelper(this);
            db = dbHelper.getWritableDatabase();
            Product product = new Product(Long.parseLong(id), thumbnail, name, category, Integer.parseInt(unitPrice));
            if (dbHelper.checkProduct(product, db)) {
                dbHelper.updateProduct(product, db);
                Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
                return;
            }
            product.setQuantity(1);
            dbHelper.insertProduct(product, db);
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();
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
}