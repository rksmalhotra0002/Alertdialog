package com.alert.alertdialog.alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alert.alertdialog.R;
import com.alert.alertdialog.customalert.CustomAlertdialog;

import java.util.Objects;

import butterknife.BindView;

public class Alertdialog extends AppCompatActivity {

private AlertDialog.Builder builder;

@BindView(R.id.tv_alert)
TextView tv_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);

        getids();
    }

    private void getids()
    {

        builder=new AlertDialog.Builder(Alertdialog.this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("AlertDialog");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onBackPressed() {
        builder.setMessage("Do you want to close this Application ?")
               .setCancelable(false)
               .setTitle("AlertDialog Example")
               .setIcon(R.drawable.download)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       dialog.cancel();

                    }
                })

              .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent(Alertdialog.this, CustomAlertdialog.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();

    }
}

