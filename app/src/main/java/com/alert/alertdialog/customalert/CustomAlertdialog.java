package com.alert.alertdialog.customalert;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.alert.alertdialog.R;
import java.util.Objects;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomAlertdialog extends AppCompatActivity {

private  final static String Tag="CustomAlertdialog";

@OnClick(R.id.btn_customdialog)
public void onclick(View v)
{
    Dialog dialog = new Dialog(CustomAlertdialog.this);
    dialog.setContentView(R.layout.dialoglayout);
    dialog.setCancelable(false);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    Button dialogbutton=dialog.findViewById(R.id.btn_cancel);
    dialogbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e(Tag,"onclick:cancel");
            dialog.dismiss();
        }
    });
    dialog.show();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_alertdialog);
        ButterKnife.bind(this);
    }
}
