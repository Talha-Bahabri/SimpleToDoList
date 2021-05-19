package com.example.todolistsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView itemNameField ;
    private TextView itemQuantityField ;
    private ArrayList<ItemsList> list =  new ArrayList<>();
    private Button addToList;
    private Button viewListButton;

    private RecyclerView displayList;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemNameField = findViewById(R.id.itemNameField);
        itemQuantityField = findViewById(R.id.itemQuantityField);
        addToList = findViewById(R.id.addToList);

        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickAdd();
            }
        });



        //this happened ... you need to check those there to learn more
        displayList = findViewById(R.id.displayList);
        displayList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdapterToUser(list);

        displayList.setLayoutManager(mLayoutManager);
        displayList.setAdapter(mAdapter);

        viewListButton = findViewById(R.id.viewList);

        viewListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewListOnClick(viewListButton);

            }
        });



    }

    public void buttonClickAdd() {


        ItemsList itemsList ;
        try {
            String name = String.valueOf(itemNameField.getText());
            int quantity = Integer.parseInt(String.valueOf(itemQuantityField.getText()));
            //the first one is for arraylist , in the future it can be deleted
            list.add(new ItemsList(name, quantity));
            //this one is for the database ,,,
            itemsList = new ItemsList(name,quantity);
            itemNameField.setText("");
            itemQuantityField.setText("");
        }
        catch (Exception e) {
            Toast.makeText( MainActivity.this,"Make sure you enter values in the fields",Toast.LENGTH_LONG).show();
            //this one might not be important , only for testing , delete this after you ensure it works
            // =============
            itemsList = new ItemsList("FAILED ATTEMPT" , 0);
        }

        DataBaseForItems databasehelper = new DataBaseForItems(MainActivity.this);
        boolean b = databasehelper.addOne(itemsList);
        Toast.makeText(MainActivity.this, "success= " + b ,  Toast.LENGTH_LONG).show();
    }

    public void viewListOnClick(Button viewList) {
        for (ItemsList item : list) {

            displayList.setAdapter(mAdapter);
        }
    }



}