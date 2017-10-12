package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

import static android.content.ContentValues.TAG;

public class RandomizationActivity extends AppCompatActivity
{

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    /*@BindView(R.id.sitenumber)
    EditText sitenumber;
    @BindView(R.id.mrnumber)
    EditText mrnumber;
    @BindView(R.id.r01)
    EditText r01;
    @BindView(R.id.r02)
    RadioGroup r02;
    @BindView(R.id.r0201)
    RadioButton r0201;
    @BindView(R.id.r0202)
    RadioButton r0202;
    @BindView(R.id.r03)
    EditText r03;
    @BindView(R.id.r04)
    EditText r04;
    @BindView(R.id.r0501)
    EditText r0501;
    @BindView(R.id.r0502)
    EditText r0502;
    @BindView(R.id.r0503)
    EditText r0503;*/
    @BindView(R.id.r06)
    DatePickerInputEditText r06;
    @BindView(R.id.r07)
    EditText r07;
    @BindView(R.id.r08)
    EditText r08;
    @BindView(R.id.r0901)
    EditText r0901;
    @BindView(R.id.r0902)
    EditText r0902;
    @BindView(R.id.r10)
    RadioGroup r10;
    @BindView(R.id.r1001)
    RadioButton r1001;
    @BindView(R.id.r1002)
    RadioButton r1002;
    @BindView(R.id.r11)
    RadioGroup r11;
    @BindView(R.id.r1101)
    RadioButton r1101;
    @BindView(R.id.r1102)
    RadioButton r1102;
    @BindView(R.id.r12)
    RadioGroup r12;
    @BindView(R.id.r1201)
    RadioButton r1201;
    @BindView(R.id.r1202)
    RadioButton r1202;
    @BindView(R.id.r16)
    EditText r16;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;
    @BindView(R.id.txtr08)
    TextView txtr08;
    @BindView(R.id.fldGrpr08)
    LinearLayout fldGrpr08;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomization);
        ButterKnife.bind(this);

        String maxDate18Years = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((AppMain.MILLISECONDS_IN_18YEAR) + (AppMain.MILLISECONDS_IN_DAY)));
        r06.setManager(getSupportFragmentManager());
        r06.setMaxDate(maxDate18Years);


        r07.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!r07.getText().toString().isEmpty()) {
                    if (Integer.valueOf(r07.getText().toString()) >= 110 && Integer.valueOf(r07.getText().toString()) < 115) {
                        fldGrpr08.setVisibility(View.VISIBLE);
                    } else if (Integer.valueOf(r07.getText().toString()) < 110) {
                        fldGrpr08.setVisibility(View.GONE);
                        r08.setText(null);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @OnClick(R.id.btnNext)
    void onBtnNextClick() {

        /*if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                Intent EndingActivity = new Intent(this, EndingActivity.class);
                startActivity(EndingActivity);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/

        startActivity(new Intent(this, BaselineActvity.class));

    }


    @OnClick(R.id.btnEnd)
    void onBtnEndClick() {
        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();

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
                endSec.putExtra("complete", false);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        /*DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(AppMain.fc);

        AppMain.fc.setID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            AppMain.fc.setUID(
                    (AppMain.fc.getDeviceID() + AppMain.fc.getID()));
            db.updateFormID();

        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }*/
        return true;
    }



    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();

        JSONObject sa = new JSONObject();


        sa.put("r06", r06.getText().toString());
        sa.put("r07", r07.getText().toString());
        sa.put("r08", r08.getText().toString());
        sa.put("r0901", r0901.getText().toString());
        sa.put("r0902", r0902.getText().toString());
        sa.put("r10", r1001.isChecked() ? "1" : r1002.isChecked() ? "2" : "0");
        sa.put("r11", r1101.isChecked() ? "1" : r1102.isChecked() ? "2" : "0");
        sa.put("r12", r1201.isChecked() ? "1" : r1202.isChecked() ? "2" : "0");

        AppMain.fc.setsA(String.valueOf(sa));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    public boolean ValidateForm() {


        // =================== Q6====================
        if (r06.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r06), Toast.LENGTH_SHORT).show();
            r06.setError("This data is required");
            Log.d(TAG, " r06 :empty ");
            return false;
        } else {
            r06.setError(null);
        }
        // =================== Q7 ====================
        if (r07.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r07), Toast.LENGTH_SHORT).show();
            r07.setError("This data is required");
            Log.d(TAG, " r07 :empty ");
            return false;
        } else {
            r07.setError(null);
        }

        if ((Integer.valueOf(r07.getText().toString().isEmpty() ? "0" : r07.getText().toString()) < 70)
                || (Integer.valueOf(r07.getText().toString().isEmpty() ? "0" : r07.getText().toString()) > 115)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.r07), Toast.LENGTH_LONG).show();
            r07.setError("Range is 70 g/L - 110 g/L ");
            Log.d(TAG, "r07: Range is 70 g/L - 110 g/L days");
            return false;
        } else {
            r07.setError(null);
        }


        if (Integer.valueOf(r07.getText().toString()) >= 110 && Integer.valueOf(r07.getText().toString()) < 115) {
            // =================== Q8 ====================
            if (r08.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r08), Toast.LENGTH_SHORT).show();
                r08.setError("This data is required");
                Log.d(TAG, " r08 :empty ");
                return false;
            } else {
                r08.setError(null);
            }

            if (Integer.valueOf(r08.getText().toString()) < 0 || Integer.valueOf(r08.getText().toString()) > 15) {
                Toast.makeText(this, "ERROR: " + getString(R.string.r08), Toast.LENGTH_LONG).show();
                r08.setError("Range is 0 - 15 ug/L");
                Log.d(TAG, "r08: Range is 0 - 15 ug/L");
                return false;
            } else {
                r08.setError(null);
            }
        }


        // =================== Q9 ====================
        if (r0901.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r09) + getString(R.string.r0901), Toast.LENGTH_SHORT).show();
            r0901.setError("This data is required");
            Log.d(TAG, "r0901 :empty  ");
            return false;
        } else {
            r0901.setError(null);
        }

        if ((Integer.valueOf(r0901.getText().toString()) < 12) || (Integer.valueOf(r0901.getText().toString()) > 26)) {
            if (Integer.valueOf(r0901.getText().toString()) == 0) {
                r0901.setError(null);
            } else {
                Toast.makeText(this, "ERROR: " + getString(R.string.r09) + getString(R.string.r0901), Toast.LENGTH_LONG).show();
                r0901.setError("Range is 12-26 weeks");
                Log.d(TAG, "r0901: Range is 12-26 weeks");
                return false;
            }
        }

        if (r0902.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r09) + getString(R.string.r0902), Toast.LENGTH_SHORT).show();
            r0902.setError("This data is required");
            Log.d(TAG, "r0902 :empty  ");
            return false;
        } else {
            r0902.setError(null);
        }

        if ((Integer.valueOf(r0902.getText().toString()) < 0) || (Integer.valueOf(r0902.getText().toString()) > 6)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.r09) + getString(R.string.r0902), Toast.LENGTH_LONG).show();
            r0902.setError("Range is 0-6 days");
            Log.d(TAG, "r0902: Range is 0-6 days");
            return false;
        } else {
            r0902.setError(null);
        }


        // =================== Q10 ====================
        if (r10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r10), Toast.LENGTH_SHORT).show();
            r1002.setError("This Data is required");
            Log.d(TAG, " r10 : not selected ");
            return false;
        } else {
            r1002.setError(null);
        }

        // =================== Q11 ====================
        if (r11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r11), Toast.LENGTH_SHORT).show();
            r1102.setError("This Data is required");
            Log.d(TAG, " r11 : not selected ");
            return false;
        } else {
            r1102.setError(null);
        }

        // =================== Q12 ====================
        if (r12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r12), Toast.LENGTH_SHORT).show();
            r1202.setError("This Data is required");
            Log.d(TAG, " r12 : not selected ");
            return false;
        } else {
            r1202.setError(null);
        }

        // =================== Q16 ====================
        if (r16.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r16), Toast.LENGTH_SHORT).show();
            r16.setError("This data is required");
            Log.d(TAG, " r16 :empty ");
            return false;
        } else {
            r16.setError(null);
        }


        return true;
    }


}
