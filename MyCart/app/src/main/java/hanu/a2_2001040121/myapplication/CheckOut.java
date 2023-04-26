package hanu.a2_2001040121.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hanu.a2_2001040121.myapplication.adapters.CheckOutAdapter;
import hanu.a2_2001040121.myapplication.database.MyDatabaseHelper;
import hanu.a2_2001040121.myapplication.models.Product;

public class CheckOut extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CheckOutAdapter checkOutAdapter;
    private List<Product> productList;
    private MyDatabaseHelper myDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

       myDatabaseHelper = new MyDatabaseHelper(this);
         sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
         productList = myDatabaseHelper.getAllProducts(sqLiteDatabase);

        recyclerView = findViewById(R.id.checkoutRecyclerView);
        checkOutAdapter = new CheckOutAdapter(productList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(checkOutAdapter);
    }
}