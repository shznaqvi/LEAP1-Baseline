package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.leap1_baseline.ClearClass;
import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.contracts.MotherListContract;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1_baseline.databinding.ActivityEndOfTreatmentBinding;
import edu.aku.hassannaqvi.leap1_baseline.validatorClass;

import static edu.aku.hassannaqvi.leap1_baseline.activities.IdentificationActivity.MRNO_KEY;
import static edu.aku.hassannaqvi.leap1_baseline.activities.IdentificationActivity.STUDY_ID_KEY;
import static edu.aku.hassannaqvi.leap1_baseline.core.AppMain.mlc;

public class EndOfTreatmentActivity extends AppCompatActivity {

    ActivityEndOfTreatmentBinding bi;
    String mrno,studyid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_end_of_treatment);
        bi.setCallback(this);

        bi.eot01a.setManager(getSupportFragmentManager());
        bi.eot0401b.setManager(getSupportFragmentManager());
        bi.eot0405a.setManager(getSupportFragmentManager());


        setupViews();


    }

    private void setupViews() {


        Intent motherintent = getIntent();

        if (motherintent.hasExtra(MRNO_KEY) && motherintent.hasExtra(STUDY_ID_KEY)) {
            Bundle bundle = motherintent.getExtras();
            mrno = bundle.getString(MRNO_KEY);
            studyid = bundle.getString(STUDY_ID_KEY);
        } else {
            // Do something else
            Toast.makeText(this, "Restart your app or contact your support team!", Toast.LENGTH_SHORT);

        }

        bi.eot0404.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if (checked) {
                    bi.fldgrpeot0404.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldgrpeot0404, true);
                } else {
                    bi.fldgrpeot0404.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldgrpeot0404, false);
                }

            }
        });
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);
        int updcount = db.updateEOT();

        if (updcount == 1) {
           db.updateFormUUID();
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


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
                Intent endSec = new Intent(this, EndingActivity.class);
                endSec.putExtra("check", true);
                startActivity(endSec);


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    public boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.eot01a, getString(R.string.eot01))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.eot02, bi.eot02a, getString(R.string.eot02))) {

            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.eot03a, getString(R.string.eot03))) {

            return false;
        }

        if (!bi.eot03a.getText().toString().contains(".")) {
            Toast.makeText(this, "Please enter correct decimal value!", Toast.LENGTH_SHORT).show();
            bi.eot03a.requestFocus();
            bi.eot03a.setError("Please enter correct decimal value!");
            return false;
        } else {
            bi.eot03a.clearFocus();
            bi.eot03a.setError(null);
            if (!validatorClass.RangeTextBox(this, bi.eot03a, 4.0, 18.0, getString(R.string.b21hb), " g/dL")) {
                return false;
            }
        }

        if (!validatorClass.EmptyCheckBox(this, bi.fldgrpeot04, bi.eot04a, getString(R.string.eot04))) {
            return false;
        }

        if (bi.eot04a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.eot0401a, getString(R.string.eot0401a))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.eot0401b, getString(R.string.eot0401b))) {
                return false;
            }
        }
        if (bi.eot0402.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.eot0402a, getString(R.string.eot0402))) {
                return false;
            }
        }

        if (bi.eot0403.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.eot0403a, getString(R.string.eot0403))) {
                return false;
            }
        }

        if (bi.eot0404.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.eot0404a, bi.eot040401a, getString(R.string.eot0404))) {
                return false;
            }

        }

        if (bi.eot0405.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.eot0405a, getString(R.string.eot0405))) {
                return false;
            }
        }

        if (bi.eot0406.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.eot0406a, getString(R.string.eot0406))) {
                return false;
            }
        }


        return true;

    }

    public void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();

        JSONObject eot = new JSONObject();

        eot.put("eot01", bi.eot01a.getText().toString());
        eot.put("eot02", bi.eot02a.isChecked() ? "1" : bi.eot02b.isChecked() ? "2" : "0");
        eot.put("eot03", bi.eot03a.getText().toString());
        eot.put("eot0401", bi.eot04a.isChecked() ? "1" : "0");
        eot.put("eot0401a", bi.eot0401a.getText().toString());
        eot.put("eot0401b", bi.eot0401b.getText().toString());
        eot.put("eot0402", bi.eot0402.isChecked() ? bi.eot0402a.getText().toString() : "0");
        eot.put("eot0403", bi.eot0403.isChecked() ? bi.eot0403a.getText().toString() : "0");
        eot.put("eot0404", bi.eot0404.isChecked() ? (bi.eot040401a.isChecked() ? "1" : bi.eot040401b.isChecked() ? "2" : "0") : "0");
        eot.put("eot0405", bi.eot0405.isChecked() ? bi.eot0405a.getText().toString() : "0");
        eot.put("eot0406", bi.eot0406.isChecked() ? bi.eot0406a.getText().toString() : "0");

        AppMain.fc.setseot(String.valueOf(eot));
        DatabaseHelper db = new DatabaseHelper(this);
        MotherListContract mlc = db.getMotherUUID(mrno,studyid);
        AppMain.fc.setUUID(mlc.get_UID());
    }

    public void BtnEnd() {

        Toast.makeText(this, "Not Processing This Section", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
        AppMain.endActivity(this, this);


    }
}
