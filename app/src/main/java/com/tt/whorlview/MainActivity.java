package com.tt.whorlview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tt.whorlviewlibrary.WhorlViewProgressDialog;
import com.tt.whorlviewlibrary.WhorlView;

public class MainActivity extends AppCompatActivity {
    private WhorlViewProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new WhorlViewProgressDialog(this)
                .withLayout(R.layout.whorl_progress_dialog_example);
        final Button button=(Button )this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
        super.onBackPressed();
    }
}
