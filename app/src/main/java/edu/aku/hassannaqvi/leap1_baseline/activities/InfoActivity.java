package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.contracts.FormsContract;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;

public class InfoActivity extends Activity {
    private static final String TAG = InfoActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.sitenumber)
    EditText sitenumber;
    @BindView(R.id.mrnumber)
    EditText mrnumber;
    @BindView(R.id.r01)
    EditText r01;
    @BindView(R.id.r03)
    EditText r03;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.r04)
    EditText r04;
    @BindView(R.id.r0501)
    EditText r0501;
    @BindView(R.id.r0502)
    EditText r0502;
    @BindView(R.id.r0503)
    EditText r0503;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);
        sitenumber.setText(String.valueOf(AppMain.site));
        /*String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        r13.setManager(getSupportFragmentManager());
        r13.setMaxDate(dateToday);*/

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


                startActivity(new Intent(this, RandomizationActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
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
                Intent endSec = new Intent(this, MainActivity.class);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(AppMain.fc);

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

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        AppMain.fc = new FormsContract();

        AppMain.fc.setTagID(sharedPref.getString("tagName", null));
        AppMain.fc.setDeviceID(AppMain.deviceId);
        AppMain.fc.setUserName(AppMain.username);
        AppMain.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        AppMain.fc.setFormType(AppMain.formType);
        AppMain.fc.setSiteNum(sitenumber.getText().toString());
        AppMain.fc.setMrNum(mrnumber.getText().toString());

        AppMain.fc.setParticipantName(r01.getText().toString());

        JSONObject sa = new JSONObject();

        sa.put("r03", r03.getText().toString());
        sa.put("r04", r04.getText().toString());
        sa.put("r0501", r0501.getText().toString());
        sa.put("r0502", r0502.getText().toString());
        sa.put("r0503", r0503.getText().toString());
        setGPS();
        AppMain.fc.setsInfo(String.valueOf(sa));
        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }


    public boolean ValidateForm() {

        if (sitenumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.siteNumber), Toast.LENGTH_SHORT).show();
            sitenumber.setError("This data is Required!");
            sitenumber.requestFocus();
            Log.i(TAG, "sitenumber: This Data is Required!");
            return false;
        } else {
            sitenumber.setError(null);
        }


        if (mrnumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.mrnumber), Toast.LENGTH_SHORT).show();
            mrnumber.setError("This data is required");
            Log.d(TAG, "mrnumber: This data is required ");
            mrnumber.requestFocus();
            return false;
        } else {
            mrnumber.setError(null);
        }



        /*if (r13.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.r13), Toast.LENGTH_SHORT).show();
            r13.setError("This data is required");
            Log.i(TAG, "r13: This data is required ");
            return false;
        } else {
            r13.setError(null);
        }*/

        /*if (hospitalID.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.b03), Toast.LENGTH_SHORT).show();
            hospitalID.setError("This data is required");
            Log.i(TAG, "hospitalID: This data is required ");
            return false;
        } else {
            hospitalID.setError(null);
        }*/

        if (r01.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.r01), Toast.LENGTH_SHORT).show();
            r01.setError("This data is required");
            Log.i(TAG, "r01: This data is required");
            r01.requestFocus();
            return false;
        } else {
            r01.setError(null);
        }


        if (r03.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.r03), Toast.LENGTH_SHORT).show();
            r03.setError("This data is required");
            Log.i(TAG, "r03: this data is required");
            r03.requestFocus();
            return false;
        } else {
            r03.setError(null);
        }

        if (r04.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.r04), Toast.LENGTH_SHORT).show();
            r04.setError("This data is required");
            Log.i(TAG, "r04: this data is required ");
            r04.requestFocus();
            return false;
        } else {
            r04.setError(null);
        }

        if (r0501.getText().toString().isEmpty() && r0502.getText().toString().isEmpty() && r0503.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR (Empty)" + getString(R.string.r0501), Toast.LENGTH_SHORT).show();
            r0501.setError("this data is required");
            Log.i(TAG, "r0501: This data is required ");
            r0501.requestFocus();
            return false;
        } else {
            r0501.setError(null);
        }

        return true;
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

//        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            AppMain.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            AppMain.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            AppMain.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            //AppMain.fc.setG(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }


}
