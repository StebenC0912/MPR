package hanu.a2_2001040121.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import hanu.a2_2001040121.myapplication.adapters.CheckOutAdapter;
import hanu.a2_2001040121.myapplication.database.MyDatabaseHelper;
import hanu.a2_2001040121.myapplication.models.Product;

public class CheckOut extends AppCompatActivity implements ChangeTotalResult {
    private RecyclerView recyclerView;
    private CheckOutAdapter checkOutAdapter;
    private List<Product> productList;
    private MyDatabaseHelper myDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private TextView totalView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

       myDatabaseHelper = new MyDatabaseHelper(this);
         sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
         productList = myDatabaseHelper.getAllProducts(sqLiteDatabase);
        totalView = findViewById(R.id.totalPrice);
        recyclerView = findViewById(R.id.checkoutRecyclerView);
        checkOutAdapter = new CheckOutAdapter(productList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(checkOutAdapter);
        changeTotalResult();
    }
    @Override
    public void changeTotalResult() {
        int total = 0;
        // query again
        productList = myDatabaseHelper.getAllProducts(sqLiteDatabase);
        for (Product product : productList) {
            total += product.getUnitPrice() * product.getQuantity();
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedPrice = formatter.format(total);
        totalView.setText("đ" + formattedPrice);
    }
}