package edu.monmouth.jzemartis.firebaseauthmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private EditText productNameInput;
    private EditText productQuantityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme_Dialog);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        productNameInput = (EditText) findViewById(R.id.productName);
        productQuantityInput = (EditText) findViewById(R.id.productQuantity);
    }

    public void addOnClick(View view) {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("products");

        String name = productNameInput.getText().toString();
        int quantity = Integer.parseInt(productQuantityInput.getText().toString());

        Product product = new Product(name, quantity);
        myRef.push().setValue(product);

        //close the activity
        this.finish();

    }

    public void cancelOnClick(View view) {
        this.finish();
    }
}
