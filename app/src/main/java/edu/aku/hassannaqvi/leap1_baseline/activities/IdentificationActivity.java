package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.validation.Validator;

import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.contracts.FormsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.NutritionContract;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1_baseline.databinding.ActivityIdentificationBinding;
import edu.aku.hassannaqvi.leap1_baseline.validatorClass;

import static edu.aku.hassannaqvi.leap1_baseline.activities.MainActivity.ACTIVITY_TYPE_ID_KEY;
import static edu.aku.hassannaqvi.leap1_baseline.activities.MainActivity.ACTIVITY_TYPE_KEY;

public class IdentificationActivity extends AppCompatActivity {
ActivityIdentificationBinding bi;
    int length = 0;
    SharedPreferences sharedPref;
    String fup_type = "";
    int fup_typeID = AppMain.SELECTED_FUP_TYPE;
    static String MRNO_KEY = "mrno";
    static String STUDY_ID_KEY = "studyid";
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       bi = DataBindingUtil.setContentView(this,R.layout.activity_identification);
       bi.setCallback(this);
       db = new DatabaseHelper(this);
       setupView();
        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

    }

    private void setupView() {
        bi.mrno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                bi.mrno.setInputType(InputType.TYPE_CLASS_NUMBER);
                length = charSequence.toString().length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                if (!bi.mrno.getText().toString().isEmpty() && bi.mrno.getText().toString().length() == 3) {
                    if (bi.mrno.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        if (length < 4) {
                            bi.mrno.setText(bi.mrno.getText().toString() + "-");
                            bi.mrno.setSelection(bi.mrno.getText().length());
                        }

                    }
                }
                if (!bi.mrno.getText().toString().isEmpty() && bi.mrno.getText().toString().length() == 6) {
                    if (bi.mrno.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        if (length < 7) {
                            bi.mrno.setText(bi.mrno.getText().toString() + "-");
                            bi.mrno.setSelection(bi.mrno.getText().length());
                        }

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });


        Intent fupintent = getIntent();

        if (fupintent.hasExtra(ACTIVITY_TYPE_KEY) && fupintent.hasExtra(ACTIVITY_TYPE_ID_KEY)) {
            Bundle bundle = fupintent.getExtras();
            fup_type = bundle.getString(ACTIVITY_TYPE_KEY);
            fup_typeID = bundle.getInt(ACTIVITY_TYPE_ID_KEY);
        } else {
            // Do something else
            Toast.makeText(this, "Restart your app or contact your support team!", Toast.LENGTH_SHORT);

        }

    }

    public void btnCheckFup() {

        if (!bi.mrno.getText().toString().trim().isEmpty() && !bi.studyID.getText().toString().trim().isEmpty()) {
            clearError();
            if (AppMain.SELECTED_FUP_TYPE == AppMain.Fup30day){


            }else if(AppMain.SELECTED_FUP_TYPE == AppMain.Fupantenatal) {
                if (db.isMotherFound(bi.mrno.getText().toString(), bi.studyID.getText().toString())) {
                    clearError();
                    bi.btnNext.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(this, "Mother Not Found!", Toast.LENGTH_SHORT).show();
                    setError("Mother Not Found!");
                    bi.btnNext.setVisibility(View.GONE);
                }
            }
        } else {
            Toast.makeText(this, "Please Enter correct MrNo and Study ID", Toast.LENGTH_SHORT).show();
            setError("Please Enter correct MrNo and Study ID");
            bi.btnNext.setVisibility(View.GONE);
        }
    }

    private void setError(String msg) {
        bi.errwindow.setVisibility(View.VISIBLE);
        bi.errwindow.setText(msg);
    }

    private void clearError() {
        bi.errwindow.setVisibility(View.GONE);
        bi.errwindow.setText(null);
    }


    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();
        AppMain.fc = new FormsContract();
        AppMain.fc.setTagID(sharedPref.getString("tagName", null));
        AppMain.fc.setDeviceID(AppMain.deviceId);
        AppMain.fc.setUserName(AppMain.username);
        AppMain.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        AppMain.fc.setFormType(AppMain.formType);
        AppMain.fc.setSfuptype(String.valueOf(AppMain.SELECTED_FUP_TYPE));
        AppMain.fc.setSiteNum(String.valueOf(AppMain.site));
        AppMain.fc.setMrNum(bi.mrno.getText().toString());
        AppMain.fc.setmStudyID(bi.studyID.getText().toString());
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addForm(AppMain.fc);
        AppMain.fc.setID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            AppMain.fc.setUID(
                    (AppMain.fc.getDeviceID() + AppMain.fc.getID()));
            db.updateFormID();
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }
        return true;

    }


    private boolean ValidateForm() {
        if (!validatorClass.EmptyTextBox(this,bi.mrno,getString(R.string.mrno))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this,bi.studyID,getString(R.string.studyID))) {
            return false;
        }
        return true;
    }
    public void BtnContinue() {

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                final Intent iA = new Intent(getApplicationContext(), FollowupActivity.class);
                iA.putExtra(ACTIVITY_TYPE_KEY, fup_type);
                iA.putExtra(ACTIVITY_TYPE_ID_KEY, fup_typeID);
                iA.putExtra(MRNO_KEY,bi.mrno.getText().toString());
                iA.putExtra(STUDY_ID_KEY,bi.studyID.getText().toString());
                startActivity(iA);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }


}
