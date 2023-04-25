package hanu.a2_2001040121.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import hanu.a2_2001040121.myapplication.adapters.CheckOutAdapter;
import hanu.a2_2001040121.myapplication.models.Product;

public class CheckOut extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CheckOutAdapter checkOutAdapter;
    private ArrayList<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        recyclerView = findViewById(R.id.recycler_view);
        checkOutAdapter = new CheckOutAdapter(productList,this);
        recyclerView.setAdapter(checkOutAdapter);
    }
}