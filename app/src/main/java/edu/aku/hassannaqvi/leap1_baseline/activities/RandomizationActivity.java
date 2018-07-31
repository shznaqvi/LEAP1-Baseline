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
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.contracts.MotherListContract;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1_baseline.validatorClass;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

import static android.content.ContentValues.TAG;
import static edu.aku.hassannaqvi.leap1_baseline.activities.InfoActivity.MOTHERMR_KEY;
import static edu.aku.hassannaqvi.leap1_baseline.activities.InfoActivity.MOTHERNAME_KEY;
import static edu.aku.hassannaqvi.leap1_baseline.core.AppMain.mlc;

public class RandomizationActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.r06)
    DatePickerInputEditText r06;
    @BindView(R.id.r07)
    EditText r07;
    @BindView(R.id.fldGrpr08)
    LinearLayout fldGrpr08;
    @BindView(R.id.txtr08)
    TextView txtr08;
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
    @BindView(R.id.mStudyID)
    EditText mStudyID;
    @BindView(R.id.r02)
    RadioGroup r02;
    @BindView(R.id.r0201)
    RadioButton r0201;
    @BindView(R.id.r0202)
    RadioButton r0202;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;
    @BindView(R.id.fldGrpeligibility)
    LinearLayout fldGrpeligibility;

    @BindViews({R.id.r07, R.id.r0901, R.id.r0902})
    List<EditText> listEditText;
int mrno = 0;
String mothername ="";

    @BindViews({R.id.r10, R.id.r11, R.id.r12})
    List<RadioGroup> ListRadioGroup;
    @BindViews({R.id.r1001, R.id.r1102, R.id.r1202})
    List<RadioButton> ListEligibilityRadio;
    TextWatcher myTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

/*
            if (!r07.getText().toString().isEmpty()) {

                if (Integer.valueOf(r07.getText().toString()) >= 70 && Integer.valueOf(r07.getText().toString()) <= 110) {
                    fldGrpr08.setVisibility(View.VISIBLE);
                } else if (Integer.valueOf(r07.getText().toString()) < 70 || Integer.valueOf(r07.getText().toString()) > 110) {
                    fldGrpr08.setVisibility(View.GONE);
                    r08.setText(null);
                }

                if (!r0901.getText().toString().isEmpty()) {
                    if (isEligible() && Integer.valueOf(r07.getText().toString()) >= 70
                            && Integer.valueOf(r07.getText().toString()) <= 115
                            && Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26) {
                        fldGrpeligibility.setVisibility(View.VISIBLE);
                    } else {
                        fldGrpeligibility.setVisibility(View.GONE);
                    }

                }   old range logic!!!

            }*/

// Below is the working with the new hb range.
            if (!r07.getText().toString().isEmpty()) {
                if (r07.getText().toString().matches("\\d+(\\.\\d+)*")) {
                    if (Double.valueOf(r07.getText().toString()) >= 7.0 && Double.valueOf(r07.getText().toString()) <= 11.5) {
                        fldGrpr08.setVisibility(View.VISIBLE);
                    } else if (Double.valueOf(r07.getText().toString()) < 7.0 || Double.valueOf(r07.getText().toString()) > 11.5) {
                        fldGrpr08.setVisibility(View.GONE);
                        r08.setText(null);
                    }

                    if (!r0901.getText().toString().isEmpty()) {
                        if (isEligible() && Double.valueOf(r07.getText().toString()) >= 7.0
                                && Double.valueOf(r07.getText().toString()) <= 11.5
                                && Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26) {
                            fldGrpeligibility.setVisibility(View.VISIBLE);
                        } else {
                            fldGrpeligibility.setVisibility(View.GONE);
                        }

                    }
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomization);
        ButterKnife.bind(this);

        String maxDate18Years = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((AppMain.MILLISECONDS_IN_18YEAR) + (AppMain.MILLISECONDS_IN_DAY)));
        r06.setManager(getSupportFragmentManager());
        r06.setMaxDate(maxDate18Years);

        for (RadioGroup rg : ListRadioGroup) {
            rg.setOnCheckedChangeListener(this);
        }

        r07.addTextChangedListener(myTextWatcher);
        r0901.addTextChangedListener(myTextWatcher);
Intent intent = getIntent();

        if (intent.hasExtra(MOTHERNAME_KEY) && intent.hasExtra(MOTHERMR_KEY)) {
            Bundle bundle = intent.getExtras();
            mothername = bundle.getString(MOTHERNAME_KEY);
            mrno = bundle.getInt(MOTHERMR_KEY);
        } else {

            // Do something else
            Toast.makeText(this, "Restart your app or contact your support team!", Toast.LENGTH_SHORT);

        }

        /*r07.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!r07.getText().toString().isEmpty()) {
                    if (Integer.valueOf(r07.getText().toString()) >= 70 && Integer.valueOf(r07.getText().toString()) <= 110) {
                        fldGrpr08.setVisibility(View.VISIBLE);
                    } else if (Integer.valueOf(r07.getText().toString()) < 70 || Integer.valueOf(r07.getText().toString()) > 110) {
                        fldGrpr08.setVisibility(View.GONE);
                        r08.setText(null);
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

*/
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
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

/*
                if (isEligible() && (Integer.valueOf(r07.getText().toString()) >= 70
                        && Integer.valueOf(r07.getText().toString()) <= 115)
                        && (Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26)) {
                    Intent EndingActivity = new Intent(this, BaselineActvity.class);
                    startActivity(EndingActivity);
                } else {
                    Intent endSec = new Intent(this, EndingActivity.class);
                    endSec.putExtra("check", true);
                    startActivity(endSec);
                }
                old implementation with integer hb range
                */

// below is the implementation with the new hb range with decimal
                if (isEligible() && (Double.valueOf(r07.getText().toString()) >= 7.0
                        && Double.valueOf(r07.getText().toString()) <= 11.5)
                        && (Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26)) {

                    if ((Double.valueOf(r07.getText().toString()) >= 11.0 && Double.valueOf(r07.getText().toString()) <= 11.5) && Double.valueOf(r08.getText().toString()) < 15.0) {
                        Intent EndingActivity = new Intent(this, BaselineActvity.class);
                        startActivity(EndingActivity);
                    } else {
                        Intent endSec = new Intent(this, EndingActivity.class);
                        endSec.putExtra("check", true);
                        startActivity(endSec);
                    }

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
                endSec.putExtra("complete", false);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/

        AppMain.endActivity(this, this);


    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSRandomization();
        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            long id = db.addMotherList(mlc);
            if (updcount != 0) {
                AppMain.mlc.set_ID(String.valueOf(id));

                AppMain.mlc.set_UID(
                        (AppMain.fc.getDeviceID() + AppMain.mlc.get_ID()));
                db.updateMotherListID();
            }else {
                Toast.makeText(this, "Mother List not updated... ERROR!", Toast.LENGTH_SHORT).show();
            }
       return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();
        AppMain.fc.setmStudyID(mStudyID.getText().toString());
        JSONObject sa = new JSONObject();

        sa.put("studyID", mStudyID.getText().toString());
        sa.put("r02", r0201.isChecked() ? "A" : r0202.isChecked() ? "B" : "0");
        sa.put("r06", r06.getText().toString());
        sa.put("r07", r07.getText().toString());
        sa.put("r08", r08.getText().toString());
        sa.put("r0901", r0901.getText().toString());
        sa.put("r0902", r0902.getText().toString());
        sa.put("r10", r1001.isChecked() ? "1" : r1002.isChecked() ? "2" : "0");
        sa.put("r11", r1101.isChecked() ? "1" : r1102.isChecked() ? "2" : "0");
        sa.put("r12", r1201.isChecked() ? "1" : r1202.isChecked() ? "2" : "0");


        AppMain.fc.setsRandomization(String.valueOf(sa));
        AppMain.mlc = new MotherListContract();
        AppMain.mlc.set_UUID(AppMain.fc.getUID());
        AppMain.mlc.setmrno(String.valueOf(mrno));
        AppMain.mlc.setstudyid(mStudyID.getText().toString());
        AppMain.mlc.setmothername(mothername);
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    public boolean ValidateForm() {


        // =================== Q6====================
        if (r06.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r06), Toast.LENGTH_SHORT).show();
            r06.setError("This data is required");
            Log.d(TAG, " r06 :empty ");
            r06.requestFocus();
            return false;
        } else {
            r06.setError(null);
        }
        // =================== Q7 ====================
        if (!validatorClass.EmptyTextBox(this, r07, getString(R.string.r07))) {
            return false;
        }
        if (!r07.getText().toString().matches("\\d+(\\.\\d+)*")) {
            Toast.makeText(this, "Please enter correct decimal value!", Toast.LENGTH_SHORT).show();
            r07.requestFocus();
            r07.setError("Please enter correct decimal value!");
            return false;
        } else {
            r07.clearFocus();
            r07.setError(null);
            if (!validatorClass.RangeTextBox(this, r07, 4.0, 18.0, getString(R.string.r07), " g/L")) {
                return false;
            }

        }
        /*
        if ((Integer.valueOf(r07.getText().toString().isEmpty() ? "0" : r07.getText().toString()) < 40)
                || (Integer.valueOf(r07.getText().toString().isEmpty() ? "0" : r07.getText().toString()) > 180)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.r07), Toast.LENGTH_LONG).show();
            r07.setError("Range is 40 g/L - 180 g/L ");
            Log.d(TAG, "r07: Range is 40 g/L - 180 g/L days");
            r07.requestFocus();
            return false;
        } else {
            r07.setError(null);
        }
*/

//        if (Integer.valueOf(r07.getText().toString()) >= 70 && Integer.valueOf(r07.getText().toString()) <= 110) {
        if (Double.valueOf(r07.getText().toString()) >= 7.0 && Double.valueOf(r07.getText().toString()) <= 11.5) {
            // =================== Q8 ====================
          /*  if (r08.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r08), Toast.LENGTH_SHORT).show();
                r08.setError("This data is required");
                Log.d(TAG, " r08 :empty ");
                r08.requestFocus();
                return false;
            } else {
                r08.setError(null);
            }

            if (Integer.valueOf(r08.getText().toString()) < 0 || Integer.valueOf(r08.getText().toString()) > 20) {
                Toast.makeText(this, "ERROR: " + getString(R.string.r08), Toast.LENGTH_LONG).show();
                r08.setError("Range is 0 - 20 ug/L");
                Log.d(TAG, "r08: Range is 0 - 20 ug/L");
                r08.requestFocus();
                return false;
            } else {
                r08.setError(null);
            }
            */
            if (!validatorClass.EmptyTextBox(this, r08, getString(R.string.r08))) {
                return false;
            }
            if (!r08.getText().toString().matches("\\d+(\\.\\d+)*")) {
                Toast.makeText(this, "Please enter correct decimal value!", Toast.LENGTH_SHORT).show();
                r08.requestFocus();
                r08.setError("Please enter correct decimal value!");
                return false;
            } else {
                r08.clearFocus();
                r08.setError(null);
                if (!validatorClass.RangeTextBox(this, r08, 0.0, 20.0, getString(R.string.r08), " ng/mL")) {
                    return false;
                }

            }

        }


        // =================== Q9 ====================
        if (r0901.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r09) + getString(R.string.r0901), Toast.LENGTH_SHORT).show();
            r0901.setError("This data is required");
            Log.d(TAG, "r0901 :empty  ");
            r0901.requestFocus();
            return false;
        } else {
            r0901.setError(null);
        }

        if (Integer.valueOf(r0901.getText().toString()) < 4 || Integer.valueOf(r0901.getText().toString()) > 40) {
            Toast.makeText(this, "ERROR: " + getString(R.string.r09) + getString(R.string.r0901), Toast.LENGTH_LONG).show();
            r0901.setError("Range is 4-40 weeks");
            Log.d(TAG, "r0901: Range is 4-40 weeks");
            r0901.requestFocus();
            return false;
        } else {
            r0901.setError(null);
        }


        if (r0902.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r09) + getString(R.string.r0902), Toast.LENGTH_SHORT).show();
            r0902.setError("This data is required");
            Log.d(TAG, "r0902 :empty  ");
            r0902.requestFocus();
            return false;
        } else {
            r0902.setError(null);
        }

        if ((Integer.valueOf(r0902.getText().toString()) < 0) || (Integer.valueOf(r0902.getText().toString()) > 6)) {
            Toast.makeText(this, "ERROR: " + getString(R.string.r09) + getString(R.string.r0902), Toast.LENGTH_LONG).show();
            r0902.setError("Range is 0-6 days");
            Log.d(TAG, "r0902: Range is 0-6 days");
            r0902.requestFocus();
            return false;
        } else {
            r0902.setError(null);
        }


        // =================== Q10 ====================
        if (r10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r10), Toast.LENGTH_SHORT).show();
            r1002.setError("This Data is required");
            Log.d(TAG, " r10 : not selected ");
            r1002.setFocusable(true);
            r1002.setFocusableInTouchMode(true);
            r1002.requestFocus();
            return false;
        } else {
            r1002.setError(null);
        }

        // =================== Q11 ====================
        if (r11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r11), Toast.LENGTH_SHORT).show();
            r1102.setError("This Data is required");
            Log.d(TAG, " r11 : not selected ");
            r1102.setFocusable(true);
            r1102.setFocusableInTouchMode(true);
            r1102.requestFocus();
            return false;
        } else {
            r1102.setError(null);
        }

        // =================== Q12 ====================
        if (r12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r12), Toast.LENGTH_SHORT).show();
            r1202.setError("This Data is required");
            Log.d(TAG, " r12 : not selected ");
            r1202.setFocusable(true);
            r1202.setFocusableInTouchMode(true);
            r1202.requestFocus();
            return false;
        } else {
            r1202.setError(null);
        }

        // =================== Q16 ====================
        if (r16.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.r16), Toast.LENGTH_SHORT).show();
            r16.setError("This data is required");
            Log.d(TAG, " r16 :empty ");
            r16.requestFocus();
            return false;
        } else {
            r16.setError(null);
        }
/*
        if (isEligible() && Integer.valueOf(r07.getText().toString()) >= 70
                && Integer.valueOf(r07.getText().toString()) <= 115
                && Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26) {
            if (mStudyID.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR (Empty)" + getString(R.string.studyID), Toast.LENGTH_SHORT).show();
                mStudyID.setError("This data is required");
                Log.i(TAG, "studyNumber: This data is required");
                mStudyID.requestFocus();
                return false;
            } else {
                mStudyID.setError(null);
            }
*/

        if (isEligible() && Double.valueOf(r07.getText().toString()) >= 7.0
                && Double.valueOf(r07.getText().toString()) <= 11.5
                && Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26) {
            if (mStudyID.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR (Empty)" + getString(R.string.studyID), Toast.LENGTH_SHORT).show();
                mStudyID.setError("This data is required");
                Log.i(TAG, "studyNumber: This data is required");
                mStudyID.requestFocus();
                return false;
            } else {
                mStudyID.setError(null);
            }

            if (r02.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR (Empty)" + getString(R.string.r02), Toast.LENGTH_SHORT).show();
                r0201.setError("This data is required");
                Log.i(TAG, "r02: This data is required ");
                r0201.setFocusable(true);
                r0201.setFocusableInTouchMode(true);
                r0201.requestFocus();
                return false;
            } else {
                r0201.setError(null);
            }
        }


        return true;
    }

    public boolean isEligible() {

        int i = 0;
        for (RadioButton rg : ListEligibilityRadio) {
            if (rg.isChecked()) {
                i++;
            }

        }


        // Show answer here
        return i == ListEligibilityRadio.size();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
/*
        if (isEligible() && ((Integer.valueOf(r07.getText().toString()) >= 70
                && Integer.valueOf(r07.getText().toString()) <= 115)
                && (Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26))) {
            fldGrpeligibility.setVisibility(View.VISIBLE);
        } else {
            fldGrpeligibility.setVisibility(View.GONE);
            mStudyID.setText(null);
            r02.clearCheck();
        }
        */
        if (!r07.getText().toString().isEmpty() && !r0901.getText().toString().isEmpty()) {
            if (r07.getText().toString().matches("\\d+(\\.\\d+)*")) {
                if (isEligible() && ((Double.valueOf(r07.getText().toString()) >= 7.0
                        && Double.valueOf(r07.getText().toString()) <= 11.5)
                        && (Integer.valueOf(r0901.getText().toString()) > 12 && Integer.valueOf(r0901.getText().toString()) <= 26))) {
                    fldGrpeligibility.setVisibility(View.VISIBLE);
                } else {
                    fldGrpeligibility.setVisibility(View.GONE);
                    mStudyID.setText(null);
                    r02.clearCheck();
                }
            }
        }


    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }


}


