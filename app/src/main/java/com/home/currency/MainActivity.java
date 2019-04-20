package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button result;
    private EditText ntd;
    private TextView jp;
    private TextView us;
    private float ntdNumber;
    private float exchangeRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews(); // Ctri + Alt + M
    }

    private void findViews() {
        result = findViewById(R.id.result);
        ntd = findViewById(R.id.ntd);
        jp = findViewById(R.id.jp);
        us = findViewById(R.id.us);
    }

    public void runResult(View view){
        Log.d("執行結果","成功");



        if (ntd.getText().toString().trim().equals("")){
        new AlertDialog.Builder(this)
                .setTitle(R.string.problem)
                .setMessage(R.string.please_enter_ntd)
                .setPositiveButton(R.string.ok,null)
                .show();
        } else {

            try {
                ntdNumber = Float.parseFloat(ntd.getText().toString().trim());
                exchangeRate = 30.9f;
                new AlertDialog.Builder(this)
                        .setTitle(R.string.result)
                        .setMessage(getString(R.string.usd_is) + ntdNumber * exchangeRate)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ntd.setText("");
                            }
                        })
                        .show();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Log.d("檢查","格式錯誤");
            }
        }
    }


}
