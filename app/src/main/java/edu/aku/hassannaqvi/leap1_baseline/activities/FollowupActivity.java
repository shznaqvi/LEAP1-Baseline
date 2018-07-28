package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1_baseline.databinding.ActivityFollowupBinding;
import edu.aku.hassannaqvi.leap1_baseline.validatorClass;

public class FollowupActivity extends AppCompatActivity {
    ActivityFollowupBinding bi;
    String fup_type;
    int fup_type_id;
    String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_followup);
        bi.setCallback(this);
        this.setTitle(getResources().getString(R.string.fuptitle));
        settingDateManager();
        Intent intent = getIntent();
        fup_type_id = intent.getIntExtra(MainActivity.ACTIVITY_TYPE_ID_KEY, AppMain.Fupdefault);
        if (fup_type_id != AppMain.Fupdefault) {
            fup_type = intent.getStringExtra(MainActivity.ACTIVITY_TYPE_KEY);
        } else {
            fup_type = "Follow Ups";
        }
        bi.fheading.setText(fup_type);

        if (fup_type_id == AppMain.Fupantenatal) {
            bi.fldGrp03.setVisibility(View.GONE);
            bi.fldGrp06.setVisibility(View.GONE);
        } else if (fup_type_id == AppMain.Fup30day) {
            bi.fldGrp03.setVisibility(View.VISIBLE);
            bi.fldGrp06.setVisibility(View.VISIBLE);
        }
    }

    private void settingDateManager() {
        bi.f01.setManager(getSupportFragmentManager());
        bi.f01.setMaxDate(dateToday);
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


                Intent secNext = new Intent(this, EndingActivity.class);
                secNext.putExtra("complete", true);
                startActivity(secNext);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {
        if (!validatorClass.EmptyTextBox(this, bi.f01, getString(R.string.f01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.f02w, getString(R.string.f02) + " " + getString(R.string.weeks))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.f02d, getString(R.string.f02) + " " + getString(R.string.days))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.f02w, 0, 42, getString(R.string.f02) + " " + getString(R.string.weeks), " weeks")) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.f02d, 0, 6, getString(R.string.f02) + " " + getString(R.string.days), " days")) {
            return false;
        }
        if (!validatorClass.checkMultipleZeros(this, getString(R.string.f02), bi.f02w, bi.f02d)) {
            return false;
        }
        if (fup_type_id == AppMain.Fup30day) {

            if (!validatorClass.EmptyTextBox(this, bi.f03hb, getString(R.string.f03) + " " + getString(R.string.f03hb))) {
                return false;
            }
            if (!bi.f03hb.getText().toString().matches("\\d+(\\.\\d+)*")) {
                Toast.makeText(this, "Please enter correct decimal value!", Toast.LENGTH_SHORT).show();
                bi.f03hb.requestFocus();
                bi.f03hb.setError("Please enter correct decimal value!");
                return false;
            } else {
                bi.f03hb.clearFocus();
                bi.f03hb.setError(null);
                if (!validatorClass.RangeTextBox(this, bi.f03hb, 4.0, 18.0, getString(R.string.b21hb), " g/L")) {
                    return false;
                }

            }

            if (!validatorClass.EmptyTextBox(this, bi.f03sf, getString(R.string.f03) + " " + getString(R.string.f03sf))) {
                return false;
            }
            if (!bi.f03sf.getText().toString().matches("\\d+(\\.\\d+)*")) {
                Toast.makeText(this, "Please enter correct decimal value!", Toast.LENGTH_SHORT).show();
                bi.f03sf.requestFocus();
                bi.f03sf.setError("Please enter correct decimal value!");
                return false;
            } else {
                bi.f03sf.clearFocus();
                bi.f03sf.setError(null);
                if (!validatorClass.RangeTextBox(this, bi.f03sf, 0.0, 20.0, getString(R.string.b21sf), " ng/mL")) {
                    return false;
                }
            }
            if (!validatorClass.EmptyTextBox(this, bi.f03crp, getString(R.string.f03) + " " + getString(R.string.f03crp))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.f03rbc, getString(R.string.f03) + " " + getString(R.string.f03rbc))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.f03tsi, getString(R.string.f03) + " " + getString(R.string.f03tsi))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.f04a, bi.f04a01, getString(R.string.f04a))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f04b, bi.f04b01, bi.f04bx, getString(R.string.f04b))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.f0501, getString(R.string.f05))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.f0502, getString(R.string.f05))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.f0501, 50, 150, getString(R.string.f05), " bp")) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.f0502, 50, 150, getString(R.string.f05), " bp")) {
            return false;
        }
        if (fup_type_id == AppMain.Fup30day) {

            if (!validatorClass.EmptyRadioButton(this, bi.f06sf, bi.f06sfb, bi.f06sfx, getString(R.string.f0601))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.f06aq, bi.f06aqb, bi.f06aqx, getString(R.string.f0602))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f07, bi.f07b, bi.f07x, getString(R.string.f07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0701, bi.f0701a, getString(R.string.f0701))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0702, bi.f0702a, getString(R.string.f0702))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0788, bi.f0788a,bi.f0788ax, getString(R.string.f0788))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0801, bi.f0801a, getString(R.string.f0801))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0802, bi.f0802a, getString(R.string.f0802))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0803, bi.f0803a, getString(R.string.f0803))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0804, bi.f0804a, getString(R.string.f0804))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0805, bi.f0805a, getString(R.string.f0805))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0806, bi.f0806a, getString(R.string.f0806))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0807, bi.f0807a, getString(R.string.f0807))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0808, bi.f0808a, getString(R.string.f0808))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0809, bi.f0809a,bi.f0809ax, getString(R.string.f0809))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0901, bi.f0901a, getString(R.string.f0901))) {
            return false;
        }
        if (bi.f0901a.isChecked()){
            if (!validatorClass.EmptyCheckBox(this,bi.fldGrpf0901check,bi.f0901sup88,bi.f0901sup88x,getString(R.string.f0901sup))){
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0902, bi.f0902a, getString(R.string.f0902))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0903, bi.f0903a, getString(R.string.f0903))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0904, bi.f0904a, getString(R.string.f0904))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0905, bi.f0905a, getString(R.string.f0905))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0906, bi.f0906a, getString(R.string.f0906))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0907, bi.f0907a, getString(R.string.f0907))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0908, bi.f0908a, getString(R.string.f0908))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0909, bi.f0909a, getString(R.string.f0909))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0910, bi.f0910a, getString(R.string.f0910))) {
            return false;
        }
        if (bi.f0910a.isChecked()){
            if (!validatorClass.EmptyRadioButton(this, bi.f0910op, bi.f0910op01, getString(R.string.f0910))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f0911, bi.f0911a,bi.f0911x, getString(R.string.f0911))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.f11, bi.f11a,bi.f11x, getString(R.string.f11))) {
            return false;
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();
        JSONObject fup = new JSONObject();
        fup.put("f01",bi.f01.getText().toString());
        fup.put("f02w",bi.f02w.getText().toString());
        fup.put("f02d",bi.f02d.getText().toString());
        fup.put("f03hb",bi.f03hb.getText().toString());
        fup.put("f03sf",bi.f03sf.getText().toString());
        fup.put("f03crp",bi.f03crp.getText().toString());
        fup.put("f03rbc",bi.f03rbc.getText().toString());
        fup.put("f03tsi",bi.f03tsi.getText().toString());
        fup.put("f04a",bi.f04a01.isChecked() ? "1" : bi.f04a02.isChecked() ? "2":"0");
        fup.put("f04b",bi.f04b01.isChecked() ? "1" : bi.f04b02.isChecked() ? "2":"0");
        fup.put("f04bx",bi.f04bx.getText().toString());
        fup.put("f05a",bi.f0501.getText().toString());
        fup.put("f05b",bi.f0502.getText().toString());
        fup.put("f06a",bi.f06sfa.isChecked() ? "1" : bi.f06sfb.isChecked() ? "2":"0");
        fup.put("f06ax",bi.f06sfx.getText().toString());
        fup.put("f06b",bi.f06aqa.isChecked() ? "1" : bi.f06aqb.isChecked() ? "2":"0");
        fup.put("f06bx",bi.f06aqx.getText().toString());
        fup.put("f07",bi.f07a.isChecked() ? "1" : bi.f07b.isChecked() ? "2":"0");
        fup.put("f07x",bi.f07x.getText().toString());
        fup.put("f0701",bi.f0701a.isChecked() ? "1" : bi.f0701b.isChecked() ? "2":"0");
        fup.put("f0702",bi.f0702a.isChecked() ? "1" : bi.f0702b.isChecked() ? "2":"0");
        fup.put("f0788",bi.f0788a.isChecked() ? "1" : bi.f0788b.isChecked() ? "2":"0");
        fup.put("f0788x",bi.f0788ax.getText().toString());
        fup.put("f0801",bi.f0801a.isChecked() ? "1" : bi.f0801b.isChecked() ? "2":"0");
        fup.put("f0802",bi.f0802a.isChecked() ? "1" : bi.f0802b.isChecked() ? "2":"0");
        fup.put("f0803",bi.f0803a.isChecked() ? "1" : bi.f0803b.isChecked() ? "2":"0");
        fup.put("f0804",bi.f0804a.isChecked() ? "1" : bi.f0804b.isChecked() ? "2":"0");
        fup.put("f0805",bi.f0805a.isChecked() ? "1" : bi.f0805b.isChecked() ? "2":"0");
        fup.put("f0806",bi.f0806a.isChecked() ? "1" : bi.f0806b.isChecked() ? "2":"0");
        fup.put("f0807",bi.f0807a.isChecked() ? "1" : bi.f0807b.isChecked() ? "2":"0");
        fup.put("f0808",bi.f0808a.isChecked() ? "1" : bi.f0808b.isChecked() ? "2":"0");
        fup.put("f0809",bi.f0809a.isChecked() ? "1" : bi.f0809b.isChecked() ? "2":"0");
        fup.put("f0809x",bi.f0809ax.getText().toString());
        fup.put("f0901",bi.f0901a.isChecked() ? "1" : bi.f0901b.isChecked() ? "2":"0");
        fup.put("f0901a",bi.f0901sup01.isChecked() ? "1":"0");
        fup.put("f0901b",bi.f0901sup02.isChecked() ? "1":"0");
        fup.put("f0901c",bi.f0901sup03.isChecked() ? "1":"0");
        fup.put("f0901d",bi.f0901sup04.isChecked() ? "1":"0");
        fup.put("f0901e",bi.f0901sup05.isChecked() ? "1":"0");
        fup.put("f0901f",bi.f0901sup06.isChecked() ? "1":"0");
        fup.put("f0901g",bi.f0901sup07.isChecked() ? "1":"0");
        fup.put("f0901h",bi.f0901sup08.isChecked() ? "1":"0");
        fup.put("f0901i",bi.f0901sup09.isChecked() ? "1":"0");
        fup.put("f0901j",bi.f0901sup10.isChecked() ? "1":"0");
        fup.put("f0901k",bi.f0901sup11.isChecked() ? "1":"0");
        fup.put("f0901l",bi.f0901sup12.isChecked() ? "1":"0");
        fup.put("f0901m",bi.f0901sup13.isChecked() ? "1":"0");
        fup.put("f0901n",bi.f0901sup14.isChecked() ? "1":"0");
        fup.put("f0901o",bi.f0901sup15.isChecked() ? "1":"0");
        fup.put("f0901p",bi.f0901sup16.isChecked() ? "1":"0");
        fup.put("f0901q",bi.f0901sup17.isChecked() ? "1":"0");
        fup.put("f0901r",bi.f0901sup18.isChecked() ? "1":"0");
        fup.put("f0901s",bi.f0901sup19.isChecked() ? "1":"0");
        fup.put("f090188",bi.f0901sup88.isChecked() ? "1":"0");
        fup.put("f090188x",bi.f0901sup88x.getText().toString());
        fup.put("f0902",bi.f0902a.isChecked() ? "1" : bi.f0902b.isChecked() ? "2":"0");
        fup.put("f0903",bi.f0903a.isChecked() ? "1" : bi.f0903b.isChecked() ? "2":"0");
        fup.put("f0904",bi.f0904a.isChecked() ? "1" : bi.f0904b.isChecked() ? "2":"0");
        fup.put("f0905",bi.f0905a.isChecked() ? "1" : bi.f0905b.isChecked() ? "2":"0");
        fup.put("f0906",bi.f0906a.isChecked() ? "1" : bi.f0906b.isChecked() ? "2":"0");
        fup.put("f0907",bi.f0907a.isChecked() ? "1" : bi.f0907b.isChecked() ? "2":"0");
        fup.put("f0908",bi.f0908a.isChecked() ? "1" : bi.f0908b.isChecked() ? "2":"0");
        fup.put("f0909",bi.f0909a.isChecked() ? "1" : bi.f0909b.isChecked() ? "2":"0");
        fup.put("f0910",bi.f0910a.isChecked() ? "1" : bi.f0910b.isChecked() ? "2":"0");
        fup.put("f0910op",bi.f0910op01.isChecked() ? "1" : bi.f0910op02.isChecked() ? "2": bi.f0910op03.isChecked() ? "3":"0");
        fup.put("f0911",bi.f0911a.isChecked() ? "1" : bi.f0911b.isChecked() ? "2":"0");
        fup.put("f0911x",bi.f0911x.getText().toString());
        fup.put("f11",bi.f11a.isChecked() ? "1" : bi.f11b.isChecked() ? "2":"0");
        fup.put("f11x",bi.f11x.getText().toString());

        AppMain.fc.setSfup(String.valueOf(fup));
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);
        int updcount = db.updateSFUP();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}
