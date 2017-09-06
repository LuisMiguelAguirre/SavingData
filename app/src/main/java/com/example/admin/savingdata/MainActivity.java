package com.example.admin.savingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String MY_PREF_FILE = "com.example.admin.savingdata.mypreffile";
    EditText etSaveData;
    TextView tvRetrieveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSaveData = (EditText) findViewById(R.id.etData);
        tvRetrieveData = (TextView) findViewById(R.id.tvRetrieveData);

    }


    public void usingSharedPref(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);

        switch (view.getId()){
            case R.id.btnSaveData:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("data", etSaveData.getText().toString());
                boolean isSaved = editor.commit(); //editor.apply();

                if (isSaved){
                    Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show();
                }

            break;

            case R.id.btnRetrieveData:
                String retrievedData  =  sharedPreferences.getString("data", "default");
                tvRetrieveData.setText(retrievedData);
                break;
        }
    }
}
