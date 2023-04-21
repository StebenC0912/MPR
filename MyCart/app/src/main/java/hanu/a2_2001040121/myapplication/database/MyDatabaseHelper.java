package hanu.a2_2001040121.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import hanu.a2_2001040121.myapplication.models.Product;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "product.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_Name = "product";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_THUMBNAIL = "thumbnail";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_UNIT_PRICE = "unitPrice";
    private static final String COLUMN_CATEGORY = "category";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_Name + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_THUMBNAIL + " TEXT,"
            + COLUMN_QUANTITY + " INTEGER,"
            + COLUMN_UNIT_PRICE + " INTEGER,"
            + COLUMN_CATEGORY + " TEXT"
            + ")";
    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_Name);
        onCreate(sqLiteDatabase);
    }

    public void insertProduct(Product product, SQLiteDatabase db) {
        String query = "INSERT INTO " + TABLE_Name + " VALUES ("
                + product.getId() + ", '"
                + product.getName() + "', '"
                + product.getThumbnail() + "', "
                + product.getQuantity() + ", "
                + product.getUnitPrice() + ", '"
                + product.getCategory() + "')";
        db.execSQL(query);
    }

    public List<Product> getAllProducts(SQLiteDatabase db) {
        List<Product> productList = new ArrayList<>();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_THUMBNAIL,
                COLUMN_QUANTITY,
                COLUMN_UNIT_PRICE,
                COLUMN_CATEGORY
        };

        // Define the sort order for the query.
        String sortOrder =
                COLUMN_NAME + " ASC";

        Cursor cursor = db.query(
                TABLE_Name,   // The table to query
                projection,            // The array of columns to return (pass null to get all)
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // don't group the rows
                null,                  // don't filter by row groups
                sortOrder              // The sort order
        );

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME));
            String thumbnail = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_THUMBNAIL));
            int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUANTITY));
            int unitPrice = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_UNIT_PRICE));
            String category = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY));

            Product product = new Product(id, name, thumbnail, quantity, unitPrice, category);
            productList.add(product);
        }
        cursor.close();

        return productList;
    }


}
