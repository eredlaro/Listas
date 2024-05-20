package com.example.practica_3_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     ListView listFruit;
     Spinner spiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFruit=(ListView)findViewById(R.id.List);
        spiner=(Spinner) findViewById(R.id.spiner1);
        final String[] frutas={"Manzana","Pera","Tomate","Manzana","Pera","Tomate","Manzana","Pera","Tomate","Manzana","Pera","Tomate","Manzana","Pera","Tomate","Manzana","Pera","Tomate"};
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,frutas);
        listFruit.setAdapter(adapter);
        spiner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,frutas));

       spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(parent.getContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show ();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        listFruit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(getApplicationContext(),"Seleccionaste el elemento: "+frutas[position], Toast.LENGTH_LONG).show();
            }
        });
      listFruit.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
          @Override
          public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
              return false;
          }
      });
    }
}