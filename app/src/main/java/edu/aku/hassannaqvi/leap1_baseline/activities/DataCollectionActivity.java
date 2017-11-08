package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;

public class DataCollectionActivity extends AppCompatActivity
{

    private static final String TAG = DataCollectionActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.studyID)
    EditText studyID;
    @BindView(R.id.aQ01)
    RadioGroup aQ01;
    @BindView(R.id.aQ01a)
    RadioButton aQ01a;
    @BindView(R.id.aQ01b)
    RadioButton aQ01b;
    @BindView(R.id.aQ01c)
    RadioButton aQ01c;
    @BindView(R.id.aQ01d)
    RadioButton aQ01d;
    @BindView(R.id.aQ01e)
    RadioButton aQ01e;
    @BindView(R.id.AQ02)
    RadioGroup aQ02;
    @BindView(R.id.AQ02a)
    RadioButton aQ02a;
    @BindView(R.id.AQ02b)
    RadioButton aQ02b;
    @BindView(R.id.AQ02c)
    RadioButton aQ02c;
    @BindView(R.id.AQ02d)
    RadioButton aQ02d;
    @BindView(R.id.AQ02e)
    RadioButton aQ02e;
    @BindView(R.id.AQ03)
    RadioGroup aQ03;
    @BindView(R.id.AQ03a)
    RadioButton aQ03a;
    @BindView(R.id.AQ03b)
    RadioButton aQ03b;
    @BindView(R.id.AQ03c)
    RadioButton aQ03c;
    @BindView(R.id.AQ03d)
    RadioButton aQ03d;
    @BindView(R.id.AQ03e)
    RadioButton aQ03e;
    @BindView(R.id.AQ03f)
    RadioButton aQ03f;
    @BindView(R.id.AQ04)
    RadioGroup aQ04;
    @BindView(R.id.AQ04a)
    RadioButton aQ04a;
    @BindView(R.id.AQ04b)
    RadioButton aQ04b;
    @BindView(R.id.AQ04c)
    RadioButton aQ04c;
    @BindView(R.id.AQ04d)
    RadioButton aQ04d;
    @BindView(R.id.AQ05)
    RadioGroup aQ05;
    @BindView(R.id.AQ05a)
    RadioButton aQ05a;
    @BindView(R.id.AQ05b)
    RadioButton aQ05b;
    @BindView(R.id.AQ05c)
    RadioButton aQ05c;
    @BindView(R.id.AQ05d)
    RadioButton aQ05d;
    @BindView(R.id.AQ05e)
    RadioButton aQ05e;
    @BindView(R.id.AQ06)
    RadioGroup aQ06;
    @BindView(R.id.AQ06a)
    RadioButton aQ06a;
    @BindView(R.id.AQ06b)
    RadioButton aQ06b;
    @BindView(R.id.AQ06c)
    RadioButton aQ06c;
    @BindView(R.id.AQ06d)
    RadioButton aQ06d;
    @BindView(R.id.AQ07)
    RadioGroup aQ07;
    @BindView(R.id.AQ07a)
    RadioButton aQ07a;
    @BindView(R.id.AQ07b)
    RadioButton aQ07b;
    @BindView(R.id.AQ07c)
    RadioButton aQ07c;
    @BindView(R.id.AQ07d)
    RadioButton aQ07d;
    @BindView(R.id.AQ07e)
    RadioButton aQ07e;
    @BindView(R.id.AQ08)
    RadioGroup aQ08;
    @BindView(R.id.AQ08a)
    RadioButton aQ08a;
    @BindView(R.id.AQ08b)
    RadioButton aQ08b;
    @BindView(R.id.AQ08c)
    RadioButton aQ08c;
    @BindView(R.id.AQ08d)
    RadioButton aQ08d;
    @BindView(R.id.AQ08e)
    RadioButton aQ08e;
    @BindView(R.id.AQ09)
    RadioGroup aQ09;
    @BindView(R.id.AQ09a)
    RadioButton aQ09a;
    @BindView(R.id.AQ09b)
    RadioButton aQ09b;
    @BindView(R.id.AQ09c)
    RadioButton aQ09c;
    @BindView(R.id.AQ09d)
    RadioButton aQ09d;
    @BindView(R.id.AQ10)
    RadioGroup aQ10;
    @BindView(R.id.AQ10a)
    RadioButton aQ10a;
    @BindView(R.id.AQ10b)
    RadioButton aQ10b;
    @BindView(R.id.AQ10c)
    RadioButton aQ10c;
    @BindView(R.id.AQ10d)
    RadioButton aQ10d;
    @BindView(R.id.AQ10e)
    RadioButton aQ10e;
    @BindView(R.id.AQ11)
    RadioGroup aQ11;
    @BindView(R.id.AQ11a)
    RadioButton aQ11a;
    @BindView(R.id.AQ11b)
    RadioButton aQ11b;
    @BindView(R.id.AQ11c)
    RadioButton aQ11c;
    @BindView(R.id.AQ11d)
    RadioButton aQ11d;
    @BindView(R.id.AQ12)
    RadioGroup aQ12;
    @BindView(R.id.AQ12a)
    RadioButton aQ12a;
    @BindView(R.id.AQ12b)
    RadioButton aQ12b;
    @BindView(R.id.AQ12c)
    RadioButton aQ12c;
    @BindView(R.id.AQ12d)
    RadioButton aQ12d;
    @BindView(R.id.AQ12e)
    RadioButton aQ12e;
    @BindView(R.id.AQ13)
    RadioGroup aQ13;
    @BindView(R.id.AQ13a)
    RadioButton aQ13a;
    @BindView(R.id.AQ13b)
    RadioButton aQ13b;
    @BindView(R.id.AQ13c)
    RadioButton aQ13c;
    @BindView(R.id.AQ13d)
    RadioButton aQ13d;
    @BindView(R.id.AQ13e)
    RadioButton aQ13e;
    @BindView(R.id.AQ14)
    RadioGroup aQ14;
    @BindView(R.id.AQ14a)
    RadioButton aQ14a;
    @BindView(R.id.AQ14b)
    RadioButton aQ14b;
    @BindView(R.id.AQ14c)
    RadioButton aQ14c;
    @BindView(R.id.AQ14d)
    RadioButton aQ14d;
    @BindView(R.id.AQ14e)
    RadioButton aQ14e;
    @BindView(R.id.AQ15)
    RadioGroup aQ15;
    @BindView(R.id.AQ15a)
    RadioButton aQ15a;
    @BindView(R.id.AQ15b)
    RadioButton aQ15b;
    @BindView(R.id.AQ15c)
    RadioButton aQ15c;
    @BindView(R.id.AQ15d)
    RadioButton aQ15d;
    @BindView(R.id.AQ15e)
    RadioButton aQ15e;
    @BindView(R.id.AQ15f)
    RadioButton aQ15f;
    @BindView(R.id.AQ16)
    RadioGroup aQ16;
    @BindView(R.id.AQ16a)
    RadioButton aQ16a;
    @BindView(R.id.AQ16b)
    RadioButton aQ16b;
    @BindView(R.id.AQ16c)
    RadioButton aQ16c;
    @BindView(R.id.AQ16d)
    RadioButton aQ16d;
    @BindView(R.id.AQ16e)
    RadioButton aQ16e;
    @BindView(R.id.AQ17)
    RadioGroup aQ17;
    @BindView(R.id.AQ17a)
    RadioButton aQ17a;
    @BindView(R.id.AQ17b)
    RadioButton aQ17b;
    @BindView(R.id.AQ17c)
    RadioButton aQ17c;
    @BindView(R.id.AQ17d)
    RadioButton aQ17d;
    @BindView(R.id.AQ17e)
    RadioButton aQ17e;
    @BindView(R.id.AQ18)
    RadioGroup aQ18;
    @BindView(R.id.AQ18a)
    RadioButton aQ18a;
    @BindView(R.id.AQ18b)
    RadioButton aQ18b;
    @BindView(R.id.AQ18c)
    RadioButton aQ18c;
    @BindView(R.id.AQ18d)
    RadioButton aQ18d;
    @BindView(R.id.AQ18e)
    RadioButton aQ18e;
    @BindView(R.id.AQ19)
    RadioGroup aQ19;
    @BindView(R.id.AQ19a)
    RadioButton aQ19a;
    @BindView(R.id.AQ19b)
    RadioButton aQ19b;
    @BindView(R.id.AQ19c)
    RadioButton aQ19c;
    @BindView(R.id.AQ19d)
    RadioButton aQ19d;
    @BindView(R.id.AQ19e)
    RadioButton aQ19e;
    @BindView(R.id.AQ20)
    RadioGroup aQ20;
    @BindView(R.id.AQ20a)
    RadioButton aQ20a;
    @BindView(R.id.AQ20b)
    RadioButton aQ20b;
    @BindView(R.id.AQ20c)
    RadioButton aQ20c;
    @BindView(R.id.AQ20d)
    RadioButton aQ20d;
    @BindView(R.id.AQ20e)
    RadioButton aQ20e;
    @BindView(R.id.AQ21)
    RadioGroup aQ21;
    @BindView(R.id.AQ21a)
    RadioButton aQ21a;
    @BindView(R.id.AQ21b)
    RadioButton aQ21b;
    @BindView(R.id.AQ21c)
    RadioButton aQ21c;
    @BindView(R.id.AQ21d)
    RadioButton aQ21d;
    @BindView(R.id.AQ21e)
    RadioButton aQ21e;
    @BindView(R.id.AQ22)
    RadioGroup aQ22;
    @BindView(R.id.AQ22a)
    RadioButton aQ22a;
    @BindView(R.id.AQ22b)
    RadioButton aQ22b;
    @BindView(R.id.AQ22c)
    RadioButton aQ22c;
    @BindView(R.id.AQ22d)
    RadioButton aQ22d;
    @BindView(R.id.AQ23)
    RadioGroup aQ23;
    @BindView(R.id.AQ23a)
    RadioButton aQ23a;
    @BindView(R.id.AQ23b)
    RadioButton aQ23b;
    @BindView(R.id.AQ23c)
    RadioButton aQ23c;
    @BindView(R.id.AQ23d)
    RadioButton aQ23d;
    @BindView(R.id.AQ23e)
    RadioButton aQ23e;
    @BindView(R.id.AQ24)
    RadioGroup aQ24;
    @BindView(R.id.AQ24a)
    RadioButton aQ24a;
    @BindView(R.id.AQ24b)
    RadioButton aQ24b;
    @BindView(R.id.AQ24c)
    RadioButton aQ24c;
    @BindView(R.id.AQ24d)
    RadioButton aQ24d;
    @BindView(R.id.AQ24e)
    RadioButton aQ24e;
    @BindView(R.id.AQ25)
    RadioGroup aQ25;
    @BindView(R.id.AQ25a)
    RadioButton aQ25a;
    @BindView(R.id.AQ25b)
    RadioButton aQ25b;
    @BindView(R.id.AQ25c)
    RadioButton aQ25c;
    @BindView(R.id.AQ25d)
    RadioButton aQ25d;
    @BindView(R.id.AQ25e)
    RadioButton aQ25e;
    @BindView(R.id.AQ26)
    RadioGroup aQ26;
    @BindView(R.id.AQ26a)
    RadioButton aQ26a;
    @BindView(R.id.AQ26b)
    RadioButton aQ26b;
    @BindView(R.id.AQ26c)
    RadioButton aQ26c;
    @BindView(R.id.AQ26d)
    RadioButton aQ26d;
    @BindView(R.id.AQ26e)
    RadioButton aQ26e;
    @BindView(R.id.AQ27)
    RadioGroup aQ27;
    @BindView(R.id.AQ27a)
    RadioButton aQ27a;
    @BindView(R.id.AQ27b)
    RadioButton aQ27b;
    @BindView(R.id.AQ27c)
    RadioButton aQ27c;
    @BindView(R.id.AQ27d)
    RadioButton aQ27d;
    @BindView(R.id.AQ27e)
    RadioButton aQ27e;
    @BindView(R.id.AQ28)
    RadioGroup aQ28;
    @BindView(R.id.AQ28a)
    RadioButton aQ28a;
    @BindView(R.id.AQ28b)
    RadioButton aQ28b;
    @BindView(R.id.AQ28c)
    RadioButton aQ28c;
    @BindView(R.id.AQ28d)
    RadioButton aQ28d;
    @BindView(R.id.AQ28e)
    RadioButton aQ28e;
    @BindView(R.id.AQ28f)
    RadioButton aQ28f;
    @BindView(R.id.AQ29)
    RadioGroup aQ29;
    @BindView(R.id.AQ29a)
    RadioButton aQ29a;
    @BindView(R.id.AQ29b)
    RadioButton aQ29b;
    @BindView(R.id.AQ29c)
    RadioButton aQ29c;
    @BindView(R.id.AQ29d)
    RadioButton aQ29d;
    @BindView(R.id.AQ29e)
    RadioButton aQ29e;
    @BindView(R.id.AQ30)
    RadioGroup aQ30;
    @BindView(R.id.AQ30a)
    RadioButton aQ30a;
    @BindView(R.id.AQ30b)
    RadioButton aQ30b;
    @BindView(R.id.AQ30c)
    RadioButton aQ30c;
    @BindView(R.id.AQ30d)
    RadioButton aQ30d;
    @BindView(R.id.AQ30e)
    RadioButton aQ30e;
    @BindView(R.id.AQ31)
    RadioGroup aQ31;
    @BindView(R.id.AQ31a)
    RadioButton aQ31a;
    @BindView(R.id.AQ31b)
    RadioButton aQ31b;
    @BindView(R.id.AQ31c)
    RadioButton aQ31c;
    @BindView(R.id.AQ31d)
    RadioButton aQ31d;
    @BindView(R.id.AQ31e)
    RadioButton aQ31e;
    @BindView(R.id.AQ32)
    RadioGroup aQ32;
    @BindView(R.id.AQ32a)
    RadioButton aQ32a;
    @BindView(R.id.AQ32b)
    RadioButton aQ32b;
    @BindView(R.id.AQ32c)
    RadioButton aQ32c;
    @BindView(R.id.AQ32d)
    RadioButton aQ32d;
    @BindView(R.id.AQ32e)
    RadioButton aQ32e;
    @BindView(R.id.AQ32f)
    RadioButton aQ32f;
    @BindView(R.id.AQ33)
    RadioGroup aQ33;
    @BindView(R.id.AQ33a)
    RadioButton aQ33a;
    @BindView(R.id.AQ33b)
    RadioButton aQ33b;
    @BindView(R.id.AQ33c)
    RadioButton aQ33c;
    @BindView(R.id.AQ33d)
    RadioButton aQ33d;
    @BindView(R.id.AQ33e)
    RadioButton aQ33e;
    @BindView(R.id.AQ33f)
    RadioButton aQ33f;
    @BindView(R.id.AQ34)
    RadioGroup aQ34;
    @BindView(R.id.AQ34a)
    RadioButton aQ34a;
    @BindView(R.id.AQ34b)
    RadioButton aQ34b;
    @BindView(R.id.AQ34c)
    RadioButton aQ34c;
    @BindView(R.id.AQ34d)
    RadioButton aQ34d;
    @BindView(R.id.AQ34e)
    RadioButton aQ34e;
    @BindView(R.id.AQ35)
    RadioGroup aQ35;
    @BindView(R.id.AQ35a)
    RadioButton aQ35a;
    @BindView(R.id.AQ35b)
    RadioButton aQ35b;
    @BindView(R.id.AQ35c)
    RadioButton aQ35c;
    @BindView(R.id.AQ35d)
    RadioButton aQ35d;
    @BindView(R.id.AQ35e)
    RadioButton aQ35e;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection);
        ButterKnife.bind(this);

        studyID.setText(AppMain.fc.getmStudyID());
        studyID.setEnabled(false);
    }

    @OnClick(R.id.btnNext)
    void onBtnNextClick() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();


                Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
                Intent endSec = new Intent(this, EndingActivity.class);
                endSec.putExtra("check", true);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @OnClick(R.id.btnEnd)
    void onBtnEndClick() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();

        /*if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
                Intent endSec = new Intent(this, EndingActivity.class);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/

        AppMain.endActivity(this, this);
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSAQ();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();


        JSONObject sa = new JSONObject();

        sa.put("aQ01", aQ01a.isChecked() ? "1" : aQ01b.isChecked() ? "2" : aQ01c.isChecked() ? "3" : aQ01d.isChecked() ? "4" : aQ01e.isChecked() ? "5" : "0");
        sa.put("aQ02", aQ02a.isChecked() ? "1" : aQ02b.isChecked() ? "2" : aQ02c.isChecked() ? "3" : aQ02d.isChecked() ? "4" : aQ02e.isChecked() ? "5" : "0");
        sa.put("aQ03", aQ03a.isChecked() ? "1" : aQ03b.isChecked() ? "2" : aQ03c.isChecked() ? "3" : aQ03d.isChecked() ? "4" : aQ03e.isChecked() ? "5" : "0");
        sa.put("aQ04", aQ04a.isChecked() ? "1" : aQ04b.isChecked() ? "2" : aQ04c.isChecked() ? "3" : aQ04d.isChecked() ? "4" : "0");
        sa.put("aQ05", aQ05a.isChecked() ? "1" : aQ05b.isChecked() ? "2" : aQ05c.isChecked() ? "3" : aQ05d.isChecked() ? "4" : aQ05e.isChecked() ? "5" : "0");
        sa.put("aQ06", aQ06a.isChecked() ? "1" : aQ06b.isChecked() ? "2" : aQ06c.isChecked() ? "3" : aQ06d.isChecked() ? "4" : "0");
        sa.put("aQ07", aQ07a.isChecked() ? "1" : aQ07b.isChecked() ? "2" : aQ07c.isChecked() ? "3" : aQ07d.isChecked() ? "4" : aQ07e.isChecked() ? "5" : "0");
        sa.put("aQ08", aQ08a.isChecked() ? "1" : aQ08b.isChecked() ? "2" : aQ08c.isChecked() ? "3" : aQ08d.isChecked() ? "4" : aQ08e.isChecked() ? "5" : "0");
        sa.put("aQ09", aQ09a.isChecked() ? "1" : aQ09b.isChecked() ? "2" : aQ09c.isChecked() ? "3" : aQ09d.isChecked() ? "4" : "0");
        sa.put("aQ10", aQ10a.isChecked() ? "1" : aQ10b.isChecked() ? "2" : aQ10c.isChecked() ? "3" : aQ10d.isChecked() ? "4" : aQ10e.isChecked() ? "5" : "0");
        sa.put("aQ11", aQ11a.isChecked() ? "1" : aQ11b.isChecked() ? "2" : aQ11c.isChecked() ? "3" : aQ11d.isChecked() ? "4" : "0");
        sa.put("aQ12", aQ12a.isChecked() ? "1" : aQ12b.isChecked() ? "2" : aQ12c.isChecked() ? "3" : aQ12d.isChecked() ? "4" : aQ12e.isChecked() ? "5" : "0");
        sa.put("aQ13", aQ13a.isChecked() ? "1" : aQ13b.isChecked() ? "2" : aQ13c.isChecked() ? "3" : aQ13d.isChecked() ? "4" : aQ13e.isChecked() ? "5" : "0");
        sa.put("aQ14", aQ14a.isChecked() ? "1" : aQ14b.isChecked() ? "2" : aQ14c.isChecked() ? "3" : aQ14d.isChecked() ? "4" : aQ14e.isChecked() ? "5" : "0");
        sa.put("aQ15", aQ15a.isChecked() ? "1" : aQ15b.isChecked() ? "2" : aQ15c.isChecked() ? "3" : aQ15d.isChecked() ? "4" : aQ15e.isChecked() ? "5" : "0");
        sa.put("aQ16", aQ16a.isChecked() ? "1" : aQ16b.isChecked() ? "2" : aQ16c.isChecked() ? "3" : aQ16d.isChecked() ? "4" : aQ16e.isChecked() ? "5" : "0");
        sa.put("aQ17", aQ17a.isChecked() ? "1" : aQ17b.isChecked() ? "2" : aQ17c.isChecked() ? "3" : aQ17d.isChecked() ? "4" : aQ17e.isChecked() ? "5" : "0");
        sa.put("aQ18", aQ18a.isChecked() ? "1" : aQ18b.isChecked() ? "2" : aQ18c.isChecked() ? "3" : aQ18d.isChecked() ? "4" : aQ18e.isChecked() ? "5" : "0");
        sa.put("aQ19", aQ19a.isChecked() ? "1" : aQ19b.isChecked() ? "2" : aQ19c.isChecked() ? "3" : aQ19d.isChecked() ? "4" : aQ19e.isChecked() ? "5" : "0");
        sa.put("aQ20", aQ20a.isChecked() ? "1" : aQ20b.isChecked() ? "2" : aQ20c.isChecked() ? "3" : aQ20d.isChecked() ? "4" : aQ20e.isChecked() ? "5" : "0");
        sa.put("aQ21", aQ21a.isChecked() ? "1" : aQ21b.isChecked() ? "2" : aQ21c.isChecked() ? "3" : aQ21d.isChecked() ? "4" : aQ21e.isChecked() ? "5" : "0");
        sa.put("aQ22", aQ22a.isChecked() ? "1" : aQ22b.isChecked() ? "2" : aQ22c.isChecked() ? "3" : aQ22d.isChecked() ? "4" : "0");
        sa.put("aQ23", aQ23a.isChecked() ? "1" : aQ23b.isChecked() ? "2" : aQ23c.isChecked() ? "3" : aQ23d.isChecked() ? "4" : aQ23e.isChecked() ? "5" : "0");
        sa.put("aQ24", aQ24a.isChecked() ? "1" : aQ24b.isChecked() ? "2" : aQ24c.isChecked() ? "3" : aQ24d.isChecked() ? "4" : aQ24e.isChecked() ? "5" : "0");
        sa.put("aQ25", aQ25a.isChecked() ? "1" : aQ25b.isChecked() ? "2" : aQ25c.isChecked() ? "3" : aQ25d.isChecked() ? "4" : aQ25e.isChecked() ? "5" : "0");
        sa.put("aQ26", aQ26a.isChecked() ? "1" : aQ26b.isChecked() ? "2" : aQ26c.isChecked() ? "3" : aQ26d.isChecked() ? "4" : aQ26e.isChecked() ? "5" : "0");
        sa.put("aQ27", aQ27a.isChecked() ? "1" : aQ27b.isChecked() ? "2" : aQ27c.isChecked() ? "3" : aQ27d.isChecked() ? "4" : aQ27e.isChecked() ? "5" : "0");
        sa.put("aQ28", aQ28a.isChecked() ? "1" : aQ28b.isChecked() ? "2" : aQ28c.isChecked() ? "3" : aQ28d.isChecked() ? "4" : aQ28e.isChecked() ? "5" : "0");
        sa.put("aQ29", aQ29a.isChecked() ? "1" : aQ29b.isChecked() ? "2" : aQ29c.isChecked() ? "3" : aQ29d.isChecked() ? "4" : aQ29e.isChecked() ? "5" : "0");
        sa.put("aQ30", aQ30a.isChecked() ? "1" : aQ30b.isChecked() ? "2" : aQ30c.isChecked() ? "3" : aQ30d.isChecked() ? "4" : aQ30e.isChecked() ? "5" : "0");
        sa.put("aQ31", aQ31a.isChecked() ? "1" : aQ31b.isChecked() ? "2" : aQ31c.isChecked() ? "3" : aQ31d.isChecked() ? "4" : aQ31e.isChecked() ? "5" : "0");
        sa.put("aQ32", aQ32a.isChecked() ? "1" : aQ32b.isChecked() ? "2" : aQ32c.isChecked() ? "3" : aQ32d.isChecked() ? "4" : aQ32e.isChecked() ? "5" : "0");
        sa.put("aQ33", aQ33a.isChecked() ? "1" : aQ33b.isChecked() ? "2" : aQ33c.isChecked() ? "3" : aQ33d.isChecked() ? "4" : aQ33e.isChecked() ? "5" : aQ33f.isChecked() ? "5" : "0");
        sa.put("aQ34", aQ34a.isChecked() ? "1" : aQ34b.isChecked() ? "2" : aQ34c.isChecked() ? "3" : aQ34d.isChecked() ? "4" : aQ34e.isChecked() ? "5" : "0");
        sa.put("aQ35", aQ35a.isChecked() ? "1" : aQ35b.isChecked() ? "2" : aQ35c.isChecked() ? "3" : aQ35d.isChecked() ? "4" : aQ35e.isChecked() ? "5" : "0");

        AppMain.fc.setsAQ(String.valueOf(sa));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }


    public boolean ValidateForm() {

        if (aQ01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.AQ01), Toast.LENGTH_SHORT).show();
            aQ01e.setError("This data is Required!");
            Log.i(TAG, "aQ01: This Data is Required!");
            aQ01e.setFocusable(true);
            aQ01e.setFocusableInTouchMode(true);
            aQ01e.requestFocus();
            return false;
        } else {
            aQ01e.setError(null);
        }


        if (aQ02.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.AQ02), Toast.LENGTH_SHORT).show();
            aQ02e.setError("Thia data is required");
            Log.d(TAG, "AQ02: This data is required ");
            aQ02e.setFocusable(true);
            aQ02e.setFocusableInTouchMode(true);
            aQ02e.requestFocus();
            return false;
        } else {
            aQ02e.setError(null);
        }

        if (aQ03.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ03), Toast.LENGTH_SHORT).show();
            aQ03f.setError("This data is required");
            Log.i(TAG, "AQ03: This data is required");
            aQ03f.setFocusable(true);
            aQ03f.setFocusableInTouchMode(true);
            aQ03f.requestFocus();
            return false;
        } else {
            aQ03f.setError(null);
        }

        if (aQ04.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ04), Toast.LENGTH_SHORT).show();
            aQ04d.setError("This data is required");
            Log.i(TAG, "AQ04: This data is required ");
            aQ04d.setFocusable(true);
            aQ04d.setFocusableInTouchMode(true);
            aQ04d.requestFocus();
            return false;
        } else {
            aQ04d.setError(null);
        }

        if (aQ05.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ05), Toast.LENGTH_SHORT).show();
            aQ05e.setError("This data is required");
            Log.i(TAG, "AQ05: This data is required ");
            aQ05e.setFocusable(true);
            aQ05e.setFocusableInTouchMode(true);
            aQ05e.requestFocus();
            return false;
        } else {
            aQ05e.setError(null);
        }

        if (aQ06.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ06), Toast.LENGTH_SHORT).show();
            aQ06d.setError("This data is required");
            Log.i(TAG, "AQ06: This data is required");
            aQ06d.setFocusable(true);
            aQ06d.setFocusableInTouchMode(true);
            aQ06d.requestFocus();
            return false;
        } else {
            aQ06d.setError(null);
        }

        if (aQ07.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ07), Toast.LENGTH_SHORT).show();
            aQ07e.setError("This data is required");
            Log.i(TAG, "AQ07: This data is required ");
            aQ07e.setFocusable(true);
            aQ07e.setFocusableInTouchMode(true);
            aQ07e.requestFocus();
            return false;
        } else {
            aQ07e.setError(null);
        }

        if (aQ08.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ08), Toast.LENGTH_SHORT).show();
            aQ08e.setError("This data is required");
            Log.i(TAG, "AQ08: this data is required");
            aQ08e.setFocusable(true);
            aQ08e.setFocusableInTouchMode(true);
            aQ08e.requestFocus();
            return false;
        } else {
            aQ08e.setError(null);
        }

        if (aQ09.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ09), Toast.LENGTH_SHORT).show();
            aQ09d.setError("This data is required");
            Log.i(TAG, "AQ09: this data is required ");
            aQ09d.setFocusable(true);
            aQ09d.setFocusableInTouchMode(true);
            aQ09d.requestFocus();
            return false;
        } else {
            aQ09d.setError(null);
        }

        if (aQ10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ10), Toast.LENGTH_SHORT).show();
            aQ10e.setError("this data is required");
            Log.i(TAG, "AQ10: This data is required ");
            aQ10e.setFocusable(true);
            aQ10e.setFocusableInTouchMode(true);
            aQ10e.requestFocus();
            return false;
        } else {
            aQ10e.setError(null);
        }

        if (aQ11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ11), Toast.LENGTH_SHORT).show();
            aQ11d.setError("This data is required");
            Log.i(TAG, "AQ11: this data is required ");
            aQ11d.setFocusable(true);
            aQ11d.setFocusableInTouchMode(true);
            aQ11d.requestFocus();
            return false;
        } else {
            aQ11d.setError(null);
        }

        if (aQ12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ12), Toast.LENGTH_SHORT).show();
            aQ12e.setError("This data is required");
            Log.i(TAG, "AQ12: this data is required ");
            aQ12e.setFocusable(true);
            aQ12e.setFocusableInTouchMode(true);
            aQ12e.requestFocus();
            return false;
        } else {
            aQ12e.setError(null);
        }

        if (aQ13.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ13), Toast.LENGTH_SHORT).show();
            aQ13e.setError("This data is required");
            Log.i(TAG, "AQ13: this data is required ");
            aQ13e.setFocusable(true);
            aQ13e.setFocusableInTouchMode(true);
            aQ13e.requestFocus();
            return false;
        } else {
            aQ13e.setError(null);
        }

        if (aQ14.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ14), Toast.LENGTH_SHORT).show();
            aQ14e.setError("this data is required");
            Log.i(TAG, "AQ14: this data is required ");
            aQ14e.setFocusable(true);
            aQ14e.setFocusableInTouchMode(true);
            aQ14e.requestFocus();
            return false;
        } else {
            aQ14e.setError(null);
        }

        if (aQ15.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ15), Toast.LENGTH_SHORT).show();
            aQ15f.setError("this data is requied");
            Log.i(TAG, "AQ15: this data is required ");
            aQ15f.setFocusable(true);
            aQ15f.setFocusableInTouchMode(true);
            aQ15f.requestFocus();
            return false;
        } else {
            aQ15f.setError(null);
        }

        if (aQ16.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ16), Toast.LENGTH_SHORT).show();
            aQ16e.setError("This data is required");
            Log.i(TAG, "AQ16: This data is required ");
            aQ16e.setFocusable(true);
            aQ16e.setFocusableInTouchMode(true);
            aQ16e.requestFocus();
            return false;
        } else {
            aQ16e.setError(null);
        }

        if (aQ17.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ17), Toast.LENGTH_SHORT).show();
            aQ17e.setError("This data is required");
            Log.i(TAG, "AQ17: This data is required ");
            aQ17e.setFocusable(true);
            aQ17e.setFocusableInTouchMode(true);
            aQ17e.requestFocus();
            return false;
        } else {
            aQ17e.setError(null);
        }

        if (aQ18.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ18), Toast.LENGTH_SHORT).show();
            aQ18e.setError("This data is required");
            Log.i(TAG, "AQ18:This data is required ");
            aQ18e.setFocusable(true);
            aQ18e.setFocusableInTouchMode(true);
            aQ18e.requestFocus();
            return false;
        } else {
            aQ18e.setError(null);
        }

        if (aQ19.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ19), Toast.LENGTH_SHORT).show();
            aQ19e.setError("This data is required");
            Log.i(TAG, "AQ19: This data is required ");
            aQ19e.setFocusable(true);
            aQ19e.setFocusableInTouchMode(true);
            aQ19e.requestFocus();
            return false;
        } else {
            aQ19e.setError(null);
        }

        if (aQ20.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ20), Toast.LENGTH_SHORT).show();
            aQ20e.setError("This data is required");
            Log.i(TAG, "AQ20:This data is required ");
            aQ20e.setFocusable(true);
            aQ20e.setFocusableInTouchMode(true);
            aQ20e.requestFocus();
            return false;
        } else {
            aQ20e.setError(null);
        }

        if (aQ21.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ21), Toast.LENGTH_SHORT).show();
            aQ21e.setError("This data is required");
            Log.i(TAG, "AQ21: This data is required");
            aQ21e.setFocusable(true);
            aQ21e.setFocusableInTouchMode(true);
            aQ21e.requestFocus();
            return false;
        } else {
            aQ21e.setError(null);
        }

        if (aQ22.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.AQ22), Toast.LENGTH_SHORT).show();
            aQ22d.setError("This data is requied");
            Log.i(TAG, "AQ22: This data is required");
            aQ22d.setFocusable(true);
            aQ22d.setFocusableInTouchMode(true);
            aQ22d.requestFocus();
            return false;
        } else {
            aQ22d.setError(null);
        }

        if (aQ23.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ23), Toast.LENGTH_SHORT).show();
            aQ23e.setError("This data is required");
            Log.i(TAG, "AQ23: This data is required ");
            aQ23e.setFocusable(true);
            aQ23e.setFocusableInTouchMode(true);
            aQ23e.requestFocus();
            return false;
        } else {
            aQ23e.setError(null);
        }

        if (aQ24.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ24), Toast.LENGTH_SHORT).show();
            aQ24e.setError("This data is required");
            Log.i(TAG, "AQ24:This data is required ");
            aQ24e.setFocusable(true);
            aQ24e.setFocusableInTouchMode(true);
            aQ24e.requestFocus();
            return false;
        } else {
            aQ24e.setError(null);
        }

        if (aQ25.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ25), Toast.LENGTH_SHORT).show();
            aQ25e.setError("This data is required");
            Log.i(TAG, "AQ25: This data is required ");
            aQ25e.setFocusable(true);
            aQ25e.setFocusableInTouchMode(true);
            aQ25e.requestFocus();
            return false;
        } else {
            aQ25e.setError(null);
        }

        if (aQ26.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ26), Toast.LENGTH_SHORT).show();
            aQ26e.setError("This data is required");
            Log.i(TAG, "AQ26: This data is required");
            aQ26e.setFocusable(true);
            aQ26e.setFocusableInTouchMode(true);
            aQ26e.requestFocus();
            return false;
        } else {
            aQ26e.setError(null);
        }

        if (aQ27.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.AQ27), Toast.LENGTH_SHORT).show();
            aQ27e.setError("This data is required");
            Log.i(TAG, "AQ27: This data is required ");
            aQ27e.setFocusable(true);
            aQ27e.setFocusableInTouchMode(true);
            aQ27e.requestFocus();
            return false;
        } else {
            aQ27e.setError(null);
        }

        if (aQ28.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ28), Toast.LENGTH_SHORT).show();
            aQ28f.setError("This data is required");
            Log.i(TAG, "AQ28: This data is required");
            aQ28f.setFocusable(true);
            aQ28f.setFocusableInTouchMode(true);
            aQ28f.requestFocus();
            return false;
        } else {
            aQ28f.setError(null);
        }

        if (aQ29.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ29), Toast.LENGTH_SHORT).show();
            aQ29e.setError("This data is required");
            Log.i(TAG, "AQ29: This data is required ");
            aQ29e.setFocusable(true);
            aQ29e.setFocusableInTouchMode(true);
            aQ29e.requestFocus();
            return false;
        } else {
            aQ29e.setError(null);
        }

        if (aQ30.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ30), Toast.LENGTH_SHORT).show();
            aQ30e.setError("This data is required");
            Log.i(TAG, "AQ30: This data is required ");
            aQ30e.setFocusable(true);
            aQ30e.setFocusableInTouchMode(true);
            aQ30e.requestFocus();
            return false;
        } else {
            aQ30e.setError(null);
        }

        if (aQ31.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ31), Toast.LENGTH_SHORT).show();
            aQ31e.setError("This data is required");
            Log.i(TAG, "AQ31: This data is required");
            aQ31e.setFocusable(true);
            aQ31e.setFocusableInTouchMode(true);
            aQ31e.requestFocus();
            return false;
        } else {
            aQ31e.setError(null);
        }

        if (aQ32.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ32), Toast.LENGTH_SHORT).show();
            aQ32f.setError("This data is required");
            Log.i(TAG, "AQ32: This data is required");
            aQ32f.setFocusable(true);
            aQ32f.setFocusableInTouchMode(true);
            aQ32f.requestFocus();
            return false;
        } else {
            aQ32f.setError(null);
        }

        if (aQ33.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ33), Toast.LENGTH_SHORT).show();
            aQ33f.setError("This data is required");
            Log.i(TAG, "AQ33:This data is required ");
            aQ33f.setFocusable(true);
            aQ33f.setFocusableInTouchMode(true);
            aQ33f.requestFocus();
            return false;
        } else {
            aQ33f.setError(null);
        }

        if (aQ34.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ34), Toast.LENGTH_SHORT).show();
            aQ34e.setError("This data is required");
            Log.i(TAG, "AQ34: This data is required");
            aQ34e.setFocusable(true);
            aQ34e.setFocusableInTouchMode(true);
            aQ34e.requestFocus();
            return false;
        } else {
            aQ34e.setError(null);
        }

        if (aQ35.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.AQ35), Toast.LENGTH_SHORT).show();
            aQ35e.setError("This data is required");
            Log.i(TAG, "AQ35: This data is required ");
            aQ35e.setFocusable(true);
            aQ35e.setFocusableInTouchMode(true);
            aQ35e.requestFocus();
            return false;
        } else {
            aQ35e.setError(null);
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}
