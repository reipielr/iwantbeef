package com.example.listviewreport;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CoffeeListActivity extends ListActivity {
    
    private ArrayAdapter<String> adapter;
    private Intent data = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] coffeeArray = getResources().getStringArray(R.array.coffee_array);
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, coffeeArray);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String selectedCoffee = adapter.getItem(position);
        data.putExtra(MainActivity.KEY_COFFEE, selectedCoffee);
        finish();
    }
    
    @Override
    public void finish() {
        setResult(RESULT_OK, data);
        super.finish();
    }
}
