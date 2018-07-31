package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1_baseline.databinding.ActivityFetalAbnormalityBinding;
import edu.aku.hassannaqvi.leap1_baseline.validatorClass;

public class FetalAbnormalityActivity extends AppCompatActivity {
ActivityFetalAbnormalityBinding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_fetal_abnormality);
        bi.setCallback(this);
        this.setTitle(getResources().getString(R.string.fetalheading));

    }



    public void BtnEnd() {
        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
        AppMain.endActivity(this, this);
    }

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();
               if (AppMain.sf == 1) {
                    startActivity(new Intent(this, HealthSurveyScoringActivity.class));
                } else if (AppMain.aq == 1) {
                    startActivity(new Intent(this, DataCollectionActivity.class));
                } else {
                    Intent endSec = new Intent(this, EndingActivity.class);
                    endSec.putExtra("check", true);
                    startActivity(endSec);
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.fet01, bi.fet01a, getString(R.string.fet01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet02, bi.fet02a, getString(R.string.fet02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet03, bi.fet03a, getString(R.string.fet03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet04, bi.fet04a, getString(R.string.fet04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet05, bi.fet05a, getString(R.string.fet05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet06, bi.fet06a, getString(R.string.fet06))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet07, bi.fet07a, getString(R.string.fet07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet08, bi.fet08a, getString(R.string.fet08))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet09, bi.fet09a, getString(R.string.fet09))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet10, bi.fet10a, getString(R.string.fet10))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet11, bi.fet11a, getString(R.string.fet11))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet12, bi.fet12a, getString(R.string.fet12))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet13, bi.fet13a, getString(R.string.fet13))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet14, bi.fet14a, getString(R.string.fet14))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet15, bi.fet15a, getString(R.string.fet15))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.fet16, bi.fet16a,bi.fet16ax, getString(R.string.fet16))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.fet17, getString(R.string.fet17))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.fet18, getString(R.string.fet18))) {
            return false;
        }


        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();
        JSONObject fetal = new JSONObject();
        fetal.put("fet01",bi.fet01a.isChecked() ? "1" : bi.fet01b.isChecked() ? "2":"0");
        fetal.put("fet02",bi.fet02a.isChecked() ? "1" : bi.fet02b.isChecked() ? "2":"0");
        fetal.put("fet03",bi.fet03a.isChecked() ? "1" : bi.fet03b.isChecked() ? "2":"0");
        fetal.put("fet04",bi.fet04a.isChecked() ? "1" : bi.fet04b.isChecked() ? "2":"0");
        fetal.put("fet05",bi.fet05a.isChecked() ? "1" : bi.fet05b.isChecked() ? "2":"0");
        fetal.put("fet06",bi.fet06a.isChecked() ? "1" : bi.fet06b.isChecked() ? "2":"0");
        fetal.put("fet07",bi.fet07a.isChecked() ? "1" : bi.fet07b.isChecked() ? "2":"0");
        fetal.put("fet08",bi.fet08a.isChecked() ? "1" : bi.fet08b.isChecked() ? "2":"0");
        fetal.put("fet09",bi.fet09a.isChecked() ? "1" : bi.fet09b.isChecked() ? "2":"0");
        fetal.put("fet10",bi.fet10a.isChecked() ? "1" : bi.fet10b.isChecked() ? "2":"0");
        fetal.put("fet11",bi.fet11a.isChecked() ? "1" : bi.fet11b.isChecked() ? "2":"0");
        fetal.put("fet12",bi.fet12a.isChecked() ? "1" : bi.fet12b.isChecked() ? "2":"0");
        fetal.put("fet13",bi.fet13a.isChecked() ? "1" : bi.fet13b.isChecked() ? "2":"0");
        fetal.put("fet14",bi.fet14a.isChecked() ? "1" : bi.fet14b.isChecked() ? "2":"0");
        fetal.put("fet15",bi.fet15a.isChecked() ? "1" : bi.fet15b.isChecked() ? "2":"0");
        fetal.put("fet16",bi.fet16a.isChecked() ? "1" : bi.fet16b.isChecked() ? "2":"0");
        fetal.put("fet16x",bi.fet16ax.getText().toString());
        fetal.put("fet17",bi.fet17.getText().toString());

        AppMain.fc.setSfetal(String.valueOf(fetal));
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);
        int updcount = db.updateSFETAL();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}
