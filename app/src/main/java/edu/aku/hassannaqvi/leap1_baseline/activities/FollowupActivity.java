package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.databinding.ActivityFollowupBinding;

public class FollowupActivity extends AppCompatActivity {
    ActivityFollowupBinding bi;
    String fup_type;
    int fup_type_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_followup);
        bi.setCallback(this);
        this.setTitle(getResources().getString(R.string.fuptitle));
        Intent intent = getIntent();
        fup_type_id = intent.getIntExtra(MainActivity.ACTIVITY_TYPE_ID_KEY, AppMain.Fupdefault);
        if(fup_type_id != AppMain.Fupdefault) {
            fup_type = intent.getStringExtra(MainActivity.ACTIVITY_TYPE_KEY);
        }
        else {
        fup_type = "Follow Ups";
        }
        bi.fheading.setText(fup_type);

        if(fup_type_id == AppMain.Fupantenatal){
            bi.fldGrp03.setVisibility(View.GONE);
            bi.fldGrp06.setVisibility(View.GONE);
        }else if(fup_type_id == AppMain.Fup30day){
            bi.fldGrp03.setVisibility(View.VISIBLE);
            bi.fldGrp06.setVisibility(View.VISIBLE);
        }


    }
}
