package com.example.listviewreport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
    
    public static final String KEY_COFFEE = "coffee";
    private static final int REQ_CODE_LIST = 8968;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  
        findViewById(R.id.btn_coffee).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), CoffeeListActivity.class), REQ_CODE_LIST);
            }
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE_LIST && resultCode == RESULT_OK) {
            String coffee = data.getStringExtra(KEY_COFFEE);
            if (!TextUtils.isEmpty(coffee))
                Toast.makeText(this, coffee + " ordered.", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Nothing ordered!", Toast.LENGTH_SHORT).show();
        }
    }
}
