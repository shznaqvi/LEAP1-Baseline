package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;

import static android.content.ContentValues.TAG;

public class SectionAActivity extends Activity {

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.sitenumber)
    EditText sitenumber;
    @BindView(R.id.studyID)
    EditText studyID;
    @BindView(R.id.b01)
    EditText b01;
    @BindView(R.id.b02)
    EditText b02;
    @BindView(R.id.b03)
    EditText b03;
    @BindView(R.id.b04)
    EditText b04;
    @BindView(R.id.b05)
    RadioGroup b05;
    @BindView(R.id.b0501)
    RadioButton b0501;
    @BindView(R.id.b0502)
    RadioButton b0502;
    @BindView(R.id.b06)
    EditText b06;
    @BindView(R.id.b07)
    EditText b07;
    @BindView(R.id.b0801)
    EditText b0801;
    @BindView(R.id.b0802)
    EditText b0802;
    @BindView(R.id.b0803)
    EditText b0803;
    @BindView(R.id.b09)
    EditText b09;
    @BindView(R.id.b10)
    RadioGroup b10;
    @BindView(R.id.b1001)
    RadioButton b1001;
    @BindView(R.id.b1002)
    RadioButton b1002;
    @BindView(R.id.b1003)
    RadioButton b1003;
    @BindView(R.id.b1004)
    RadioButton b1004;
    @BindView(R.id.b1005)
    RadioButton b1005;
    @BindView(R.id.b1006)
    RadioButton b1006;
    @BindView(R.id.b1007)
    RadioButton b1007;
    @BindView(R.id.b1008)
    RadioButton b1008;
    @BindView(R.id.b1009)
    RadioButton b1009;
    @BindView(R.id.b1010)
    RadioButton b1010;
    @BindView(R.id.b1011)
    RadioButton b1011;
    @BindView(R.id.b1012)
    RadioButton b1012;
    @BindView(R.id.b1013)
    RadioButton b1013;
    @BindView(R.id.b1014)
    RadioButton b1014;
    @BindView(R.id.b1015)
    RadioButton b1015;
    @BindView(R.id.b1016)
    RadioButton b1016;
    @BindView(R.id.b1017)
    RadioButton b1017;
    @BindView(R.id.b1018)
    RadioButton b1018;
    @BindView(R.id.b1088)
    RadioButton b1088;
    @BindView(R.id.b1088x)
    EditText b1088x;
    @BindView(R.id.b11)
    RadioGroup b11;
    @BindView(R.id.b1101)
    RadioButton b1101;
    @BindView(R.id.b1102)
    RadioButton b1102;
    @BindView(R.id.b1103)
    RadioButton b1103;
    @BindView(R.id.b1104)
    RadioButton b1104;
    @BindView(R.id.b1188)
    RadioButton b1188;
    @BindView(R.id.b1188x)
    EditText b1188x;
    @BindView(R.id.b12)
    RadioGroup b12;
    @BindView(R.id.b1201)
    RadioButton b1201;
    @BindView(R.id.b1202)
    RadioButton b1202;
    @BindView(R.id.b1203)
    RadioButton b1203;
    @BindView(R.id.b1204)
    RadioButton b1204;
    @BindView(R.id.b1205)
    RadioButton b1205;
    @BindView(R.id.b1288)
    RadioButton b1288;
    @BindView(R.id.b1288x)
    EditText b1288x;
    @BindView(R.id.b13)
    EditText b13;
    @BindView(R.id.b14)
    RadioGroup b14;
    @BindView(R.id.b1401)
    RadioButton b1401;
    @BindView(R.id.b1402)
    RadioButton b1402;
    @BindView(R.id.b1403)
    RadioButton b1403;
    @BindView(R.id.b1488)
    RadioButton b1488;
    @BindView(R.id.b1488x)
    EditText b1488x;
    @BindView(R.id.b15)
    DatePicker b15;
    @BindView(R.id.b16)
    EditText b16;
    @BindView(R.id.b17)
    EditText b17;
    @BindView(R.id.b18)
    DatePicker b18;
    @BindView(R.id.b19)
    EditText b19;
    @BindView(R.id.b20)
    EditText b20;
    @BindView(R.id.b2201)
    RadioGroup b2201;
    @BindView(R.id.b220101)
    RadioButton b220101;
    @BindView(R.id.b220102)
    RadioButton b220102;
    @BindView(R.id.fldGrp23)
    LinearLayout fldGrp23;
    @BindView(R.id.b2301)
    CheckBox b2301;
    @BindView(R.id.b2302)
    CheckBox b2302;
    @BindView(R.id.b2303)
    CheckBox b2303;
    @BindView(R.id.b2304)
    CheckBox b2304;
    @BindView(R.id.b2305)
    CheckBox b2305;
    @BindView(R.id.b2306)
    CheckBox b2306;
    @BindView(R.id.b2307)
    CheckBox b2307;
    @BindView(R.id.b2308)
    CheckBox b2308;
    @BindView(R.id.b2309)
    CheckBox b2309;
    @BindView(R.id.b2310)
    CheckBox b2310;
    @BindView(R.id.b2311)
    CheckBox b2311;
    @BindView(R.id.b2312)
    CheckBox b2312;
    @BindView(R.id.b2313)
    CheckBox b2313;
    @BindView(R.id.b2314)
    CheckBox b2314;
    @BindView(R.id.b2315)
    CheckBox b2315;
    @BindView(R.id.b2316)
    CheckBox b2316;
    @BindView(R.id.b2288)
    RadioGroup b2288;
    @BindView(R.id.b228801)
    RadioButton b228801;
    @BindView(R.id.b228802)
    RadioButton b228802;
    @BindView(R.id.b228801r)
    EditText b228801r;
    @BindView(R.id.b2401)
    RadioGroup b2401;
    @BindView(R.id.b240101)
    RadioButton b240101;
    @BindView(R.id.b240102)
    RadioButton b240102;
    @BindView(R.id.b240102r)
    EditText b240102r;
    @BindView(R.id.b2402)
    RadioGroup b2402;
    @BindView(R.id.b240201)
    RadioButton b240201;
    @BindView(R.id.b240202)
    RadioButton b240202;
    @BindView(R.id.b240202r)
    EditText b240202r;
    @BindView(R.id.b2403)
    RadioGroup b2403;
    @BindView(R.id.b240301)
    RadioButton b240301;
    @BindView(R.id.b240302)
    RadioButton b240302;
    @BindView(R.id.b240302r)
    EditText b240302r;
    @BindView(R.id.b2501)
    RadioGroup b2501;
    @BindView(R.id.b250101)
    RadioButton b250101;
    @BindView(R.id.b250102)
    RadioButton b250102;
    @BindView(R.id.b250102r)
    EditText b250102r;
    @BindView(R.id.b2502)
    RadioGroup b2502;
    @BindView(R.id.b250201)
    RadioButton b250201;
    @BindView(R.id.b250202)
    RadioButton b250202;
    @BindView(R.id.b250202r)
    EditText b250202r;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);


        b2201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (b220101.isChecked()) {
                    fldGrp23.setVisibility(View.VISIBLE);

                } else {
                    fldGrp23.setVisibility(View.GONE);
                    b2301.setChecked(false);
                    b2302.setChecked(false);
                    b2303.setChecked(false);
                    b2304.setChecked(false);
                    b2305.setChecked(false);
                    b2306.setChecked(false);
                    b2307.setChecked(false);
                    b2308.setChecked(false);
                    b2309.setChecked(false);
                    b2310.setChecked(false);
                    b2311.setChecked(false);
                    b2312.setChecked(false);
                    b2313.setChecked(false);
                    b2314.setChecked(false);
                    b2315.setChecked(false);
                    b2316.setChecked(false);
                }
            }
        });

        // =================== Q10 Others ====================

        b1088.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b1088x.setVisibility(View.VISIBLE);
                } else {
                    b1088x.setVisibility(View.GONE);
                    b1088x.setText(null);
                }
            }
        });

        // =================== Q11 Others ====================

        b1188.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b1188x.setVisibility(View.VISIBLE);
                } else {
                    b1188x.setVisibility(View.GONE);
                    b1188x.setText(null);
                }
            }
        });

        // =================== Q12 Others ====================

        b1288.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b1288x.setVisibility(View.VISIBLE);
                } else {
                    b1288x.setVisibility(View.GONE);
                    b1288x.setText(null);
                }
            }
        });

        // =================== Q14 Others ====================

        b1488.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b1488x.setVisibility(View.VISIBLE);
                } else {
                    b1488x.setVisibility(View.GONE);
                    b1488x.setText(null);
                }
            }
        });

        // =================== Q22 others ====================

        b228801.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b228801r.setVisibility(View.VISIBLE);
                } else {
                    b228801r.setVisibility(View.GONE);
                    b228801r.setText(null);
                }
            }
        });

        // =================== Q2401 reason ====================

        b240102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b240102r.setVisibility(View.VISIBLE);
                } else {
                    b240102r.setVisibility(View.GONE);
                    b240102r.setText(null);
                }
            }
        });

        // =================== Q2402 reason ====================

        b240202.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b240202r.setVisibility(View.VISIBLE);
                } else {
                    b240202r.setVisibility(View.GONE);
                    b240202r.setText(null);
                }
            }
        });

        // =================== Q2403 reason ====================

        b240302.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b240302r.setVisibility(View.VISIBLE);
                } else {
                    b240302r.setVisibility(View.GONE);
                    b240302r.setText(null);
                }
            }
        });

        // =================== Q2501 reason ====================

        b250102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b250102r.setVisibility(View.VISIBLE);
                } else {
                    b250102r.setVisibility(View.GONE);
                    b250102r.setText(null);
                }
            }
        });

        // =================== Q2502 reason ====================

        b250202.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b250202r.setVisibility(View.VISIBLE);
                } else {
                    b250202r.setVisibility(View.GONE);
                    b250202r.setText(null);
                }
            }
        });

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
                startActivity(new Intent(this, SectionBActivity.class));
*/
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
                Intent endSec = new Intent(this, EndingActivity.class);
                endSec.putExtra("complete", false);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

      /*  long updcount = db.addForm(AppMain.fc);

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


  /*  public void setGPS() {
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
//            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            AppMain.fc.setGpsTime(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }*/

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();

      /*  AppMain.VillageName = cravillage.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        AppMain.fc = new FormsContract();

        AppMain.fc.setUserName(AppMain.username);
        AppMain.fc.setDeviceID(deviceId);
        AppMain.fc.setHhDT(dtToday);
        AppMain.fc.setTehsil(AppMain.tehsilCode);
        AppMain.fc.sethFacility(AppMain.hfCode);
        AppMain.fc.setLhwCode(AppMain.lhwCode);
        AppMain.fc.setUccode(getAllUCs.get(crauc.getSelectedItem().toString()));
        AppMain.fc.setVillagename(AppMain.VillageName);
        AppMain.fc.setChildId(cra03.getText().toString());
        AppMain.fc.setTagId(sharedPref.getString("tagName", ""));
*/
        JSONObject sa = new JSONObject();

        sa.put("sitenumber", sitenumber.getText().toString());
        sa.put("studyID", studyID.getText().toString());
        sa.put("b01", b01.getText().toString());
        sa.put("b02", b02.getText().toString());
        sa.put("b03", b03.getText().toString());
        sa.put("b04", b04.getText().toString());
        sa.put("b05", b0501.isChecked() ? "1" : b0502.isChecked() ? "2" : "0");
        sa.put("b06", b06.getText().toString());
        sa.put("b07", b07.getText().toString());
        sa.put("b0801", b0801.getText().toString());
        sa.put("b0802", b0802.getText().toString());
        sa.put("b0803", b0803.getText().toString());
        sa.put("b09", b09.getText().toString());
        sa.put("b10", b1001.isChecked() ? "1" : b1002.isChecked() ? "2" : b1003.isChecked() ? "3" : b1004.isChecked() ? "4" : b1005.isChecked() ? "5" : b1006.isChecked() ? "6" : b1007.isChecked() ? "7" : b1008.isChecked() ? "8" : b1009.isChecked() ? "9" : b1010.isChecked() ? "10" : b1011.isChecked() ? "11" : b1012.isChecked() ? "12" : b1013.isChecked() ? "13" : b1014.isChecked() ? "14" : b1015.isChecked() ? "15" : b1016.isChecked() ? "16" : b1017.isChecked() ? "17" : b1018.isChecked() ? "18" : b1088.isChecked() ? "88" : "0");
        sa.put("b11", b1101.isChecked() ? "1" : b1102.isChecked() ? "2" : b1103.isChecked() ? "3" : b1104.isChecked() ? "4" : b1188.isChecked() ? "88" : "0");
        sa.put("b12", b1201.isChecked() ? "1" : b1202.isChecked() ? "2" : b1203.isChecked() ? "3" : b1204.isChecked() ? "4" : b1205.isChecked() ? "5" : b1288.isChecked() ? "88" : "0");
        sa.put("b13", b13.getText().toString());
        sa.put("b14", b1401.isChecked() ? "1" : b1402.isChecked() ? "2" : b1403.isChecked() ? "3" : b1188.isChecked() ? "88" : "0");
        sa.put("b16", b16.getText().toString());
        sa.put("b17", b17.getText().toString());
        sa.put("b18", new SimpleDateFormat("dd-MM-yyyy").format(b18.getCalendarView().getDate()));
        sa.put("b19", b19.getText().toString());
        sa.put("b20", b20.getText().toString());
        sa.put("b2201", b220101.isChecked() ? "1" : b220102.isChecked() ? "2" : "0");
        sa.put("b2288", b228801.isChecked() ? "1" : b228802.isChecked() ? "2" : "0");
        sa.put("b228801x", b228801r.getText().toString());
        sa.put("b2301", b2301.isChecked() ? "1" : "0");
        sa.put("b2302", b2302.isChecked() ? "1" : "0");
        sa.put("b2303", b2303.isChecked() ? "1" : "0");
        sa.put("b2304", b2304.isChecked() ? "1" : "0");
        sa.put("b2305", b2305.isChecked() ? "1" : "0");
        sa.put("b2306", b2306.isChecked() ? "1" : "0");
        sa.put("b2307", b2307.isChecked() ? "1" : "0");
        sa.put("b2308", b2308.isChecked() ? "1" : "0");
        sa.put("b2309", b2309.isChecked() ? "1" : "0");
        sa.put("b2310", b2310.isChecked() ? "1" : "0");
        sa.put("b2311", b2311.isChecked() ? "1" : "0");
        sa.put("b2312", b2312.isChecked() ? "1" : "0");
        sa.put("b2313", b2313.isChecked() ? "1" : "0");
        sa.put("b2314", b2314.isChecked() ? "1" : "0");
        sa.put("b2315", b2315.isChecked() ? "1" : "0");
        sa.put("b2316", b2316.isChecked() ? "1" : "0");
        sa.put("b2401", b240101.isChecked() ? "1" : b240102.isChecked() ? "2" : "0");
        sa.put("b240102r", b240102r.getText().toString());
        sa.put("b2402", b240201.isChecked() ? "1" : b240202.isChecked() ? "2" : "0");
        sa.put("b240202r", b240202r.getText().toString());
        sa.put("b2403", b240301.isChecked() ? "1" : b240302.isChecked() ? "2" : "0");
        sa.put("b240302r", b240302r.getText().toString());
        sa.put("b2501", b250101.isChecked() ? "1" : b250102.isChecked() ? "2" : "0");
        sa.put("b250102r", b250102r.getText().toString());
        sa.put("b2502", b250201.isChecked() ? "1" : b250202.isChecked() ? "2" : "0");
        sa.put("b250202r", b250202r.getText().toString());

        // setGPS();

        //  AppMain.fc.setsA(String.valueOf(sa));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    public boolean ValidateForm() {

        // =================== studyID ====================
        if (studyID.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.studyID), Toast.LENGTH_SHORT).show();
            studyID.setError("This data is required");
            Log.d(TAG, " studyID :empty ");
            return false;
        } else {
            studyID.setError(null);
        }
        if (Double.parseDouble(studyID.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.studyID), Toast.LENGTH_SHORT).show();
            studyID.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "studyID: Invalid data is 0");
            return false;
        } else {
            studyID.setError(null);
        }

        // =================== b01 ====================
        if (b01.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b01), Toast.LENGTH_SHORT).show();
            b01.setError("This data is required");
            Log.d(TAG, " b01 :empty ");
            return false;
        } else {
            b01.setError(null);
        }

        if (Double.parseDouble(b01.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b01), Toast.LENGTH_SHORT).show();
            b01.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "b01: Invalid data is 0");
            return false;
        } else {
            b01.setError(null);
        }

        // =================== b06 ====================
        if (b06.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b06), Toast.LENGTH_SHORT).show();
            b06.setError("This data is required");
            Log.d(TAG, "b06: empty");
            return false;
        } else {
            b06.setError(null);
        }

        //==================== b09====================
        if (b09.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b09), Toast.LENGTH_SHORT).show();
            b09.setError("This data is Required!");
            Log.i(TAG, "b09: This Data is Required!");
            return false;
        } else {
            b09.setError(null);
        }

        //============== Check on Education=============
        if ((Integer.valueOf(b09.getText().toString()) < 0)
                || (Integer.valueOf(b09.getText().toString()) > 16)) {
            Toast.makeText(this, "ERROR(Invalid) " + getString(R.string.b09), Toast.LENGTH_LONG).show();
            b09.setError("Range is 1-16");
            Log.i(TAG, "b09: Range is 1-16");
            return false;
        } else {
            b09.setError(null);
        }

        //=================== b10==============
        if (b10.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b10), Toast.LENGTH_SHORT).show();
            b1088.setError("This data is Required!");
            Log.i(TAG, "b10: This Data is Required!");
            return false;
        } else {
            b1088.setError(null);
        }

        //=================== b10 Others ==============
        if (b1088.isChecked() && b1088x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b10) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b1088x.setError("This data is Required!");
            Log.i(TAG, "b1088x: This Data is Required!");
            return false;
        } else {
            b1088x.setError(null);
        }

        //=================== b11==============
        if (b11.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b11), Toast.LENGTH_SHORT).show();
            b1188.setError("This data is Required!");
            Log.i(TAG, "b11: This Data is Required!");
            return false;
        } else {
            b1188.setError(null);
        }

        //=================== b11 Others ==============
        if (b1188.isChecked() && b1188x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b11) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b1188x.setError("This data is Required!");
            Log.i(TAG, "b1188x: This Data is Required!");
            return false;
        } else {
            b1188x.setError(null);
        }

        //=================== b12==============
        if (b12.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b12), Toast.LENGTH_SHORT).show();
            b1288.setError("This data is Required!");
            Log.i(TAG, "b12: This Data is Required!");
            return false;
        } else {
            b1288.setError(null);
        }

        //=================== b12 Others ==============
        if (b1288.isChecked() && b1288x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b12) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b1288x.setError("This data is Required!");
            Log.i(TAG, "b1288x: This Data is Required!");
            return false;
        } else {
            b1288x.setError(null);
        }

        // =================== b13 ====================
        if (b13.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b13), Toast.LENGTH_SHORT).show();
            b13.setError("This data is required");
            Log.d(TAG, " b13 :empty ");
            return false;
        } else {
            b13.setError(null);
        }

        if (Double.parseDouble(b13.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b13), Toast.LENGTH_SHORT).show();
            b13.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "b13: Invalid data is 0");
            return false;
        } else {
            b13.setError(null);
        }
        //=================== b14==============
        if (b14.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b14), Toast.LENGTH_SHORT).show();
            b1488.setError("This data is Required!");
            Log.i(TAG, "b14: This Data is Required!");
            return false;
        } else {
            b1488.setError(null);
        }

        //=================== b14 Others ==============
        if (b1488.isChecked() && b1488x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b14) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b1488x.setError("This data is Required!");
            Log.i(TAG, "b1488x: This Data is Required!");
            return false;
        } else {
            b1488x.setError(null);
        }

        // =================== b16 ====================
        if (b16.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.b16), Toast.LENGTH_SHORT).show();
            b16.setError("This data is Required!");
            Log.i(TAG, "b16: This data is Required!");
            return false;
        } else {
            b16.setError(null);
        }
        if (Double.parseDouble(b16.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b16), Toast.LENGTH_SHORT).show();
            b16.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "b16: Invalid data is 0");
            return false;
        } else {
            b16.setError(null);
        }
        if (Double.parseDouble(b16.getText().toString()) < 30 || Double.parseDouble(b16.getText().toString()) > 150) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b16), Toast.LENGTH_SHORT).show();
            b16.setError("Invalid: Range is 30-150 ");
            Log.i(TAG, "b16: Invalid Range is 30-150 kg");
            return false;
        } else {
            b16.setError(null);
        }

        // =================== b17 ====================
        if (b17.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.b17), Toast.LENGTH_SHORT).show();
            b17.setError("This data is Required!");
            Log.i(TAG, "b17: This data is Required!");
            return false;
        } else {
            b17.setError(null);
        }
        if (Double.parseDouble(b17.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b17), Toast.LENGTH_SHORT).show();
            b17.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "b17: Invalid data is 0");
            return false;
        } else {
            b17.setError(null);
        }
        if (Double.parseDouble(b17.getText().toString()) < 137 || Double.parseDouble(b17.getText().toString()) > 160) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b17), Toast.LENGTH_SHORT).show();
            b17.setError("Invalid: Range is 137-160 cm");
            Log.i(TAG, "b17: Invalid Range is 137-160 cm");
            return false;
        } else {
            b17.setError(null);
        }

        //==================== b19====================
        if (b19.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b19), Toast.LENGTH_SHORT).show();
            b19.setError("This data is Required!");
            Log.i(TAG, "b19: This Data is Required!");
            return false;
        } else {
            b19.setError(null);
        }

        //==================== b20====================
        if (b20.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b20), Toast.LENGTH_SHORT).show();
            b20.setError("This data is Required!");
            Log.i(TAG, "b20: This Data is Required!");
            return false;
        } else {
            b20.setError(null);
        }

        //=================== b2201==============
        if (b2201.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2201), Toast.LENGTH_SHORT).show();
            b220102.setError("This data is Required!");
            Log.i(TAG, "b2201: This Data is Required!");
            return false;
        } else {
            b220102.setError(null);
        }

        if (b220101.isChecked()) {
            // ====================== b23 ===================
            if (!(b2301.isChecked() || b2302.isChecked() || b2303.isChecked() || b2304.isChecked()
                    || b2305.isChecked() || b2306.isChecked() || b2307.isChecked() || b2308.isChecked() || b2309.isChecked() || b2310.isChecked() || b2311.isChecked()
                    || b2312.isChecked() || b2313.isChecked() || b2314.isChecked() || b2315.isChecked() || b2316.isChecked())) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.b23), Toast.LENGTH_LONG).show();
                b2316.setError("This data is Required!");    // Set Error on last check box
                Log.i(TAG, "b2316: This data is Required!");
                return false;
            } else {
                b2316.setError(null);
            }
        }

        //=================== b2288==============
        if (b2288.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b228802.setError("This data is Required!");
            Log.i(TAG, "b2288: This Data is Required!");
            return false;
        } else {
            b228802.setError(null);
        }

        //=================== b22other ==============
        if (b228801.isChecked() && b228801r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.other) + " - " + getString(R.string.b228801r), Toast.LENGTH_SHORT).show();
            b228801r.setError("This data is Required!");
            Log.i(TAG, "b2403r: This Data is Required!");
            return false;
        } else {
            b228801r.setError(null);
        }


        //=================== b2401==============
        if (b2401.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2401), Toast.LENGTH_SHORT).show();
            b240102.setError("This data is Required!");
            Log.i(TAG, "b2401: This Data is Required!");
            return false;
        } else {
            b240102.setError(null);
        }

        //=================== b2401 reason ==============
        if (b240102.isChecked() && b240102r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2401) + " - " + getString(R.string.b24r), Toast.LENGTH_SHORT).show();
            b240102r.setError("This data is Required!");
            Log.i(TAG, "b2401r: This Data is Required!");
            return false;
        } else {
            b240102r.setError(null);
        }

        //=================== b2402==============
        if (b2402.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2402), Toast.LENGTH_SHORT).show();
            b240202.setError("This data is Required!");
            Log.i(TAG, "b2402: This Data is Required!");
            return false;
        } else {
            b240202.setError(null);
        }

        //=================== b2402 reason ==============
        if (b240202.isChecked() && b240202r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2402) + " - " + getString(R.string.b24r), Toast.LENGTH_SHORT).show();
            b240202r.setError("This data is Required!");
            Log.i(TAG, "b2402r: This Data is Required!");
            return false;
        } else {
            b240202r.setError(null);
        }

        //=================== b2403==============
        if (b2403.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2403), Toast.LENGTH_SHORT).show();
            b240302.setError("This data is Required!");
            Log.i(TAG, "b2403: This Data is Required!");
            return false;
        } else {
            b240302.setError(null);
        }

        //=================== b2403 reason ==============
        if (b240302.isChecked() && b240302r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2403) + " - " + getString(R.string.b24r), Toast.LENGTH_SHORT).show();
            b240302r.setError("This data is Required!");
            Log.i(TAG, "b2403r: This Data is Required!");
            return false;
        } else {
            b240302r.setError(null);
        }

        //=================== b2501==============
        if (b2501.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2501), Toast.LENGTH_SHORT).show();
            b250102.setError("This data is Required!");
            Log.i(TAG, "b2501: This Data is Required!");
            return false;
        } else {
            b250102.setError(null);
        }

        //=================== b2501 reason ==============
        if (b250102.isChecked() && b250102r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2501) + " - " + getString(R.string.b25r), Toast.LENGTH_SHORT).show();
            b250102r.setError("This data is Required!");
            Log.i(TAG, "b2501r: This Data is Required!");
            return false;
        } else {
            b250102r.setError(null);
        }

        //=================== b2502==============
        if (b2502.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2502), Toast.LENGTH_SHORT).show();
            b250202.setError("This data is Required!");
            Log.i(TAG, "b2502: This Data is Required!");
            return false;
        } else {
            b250202.setError(null);
        }

        //=================== b2502 reason ==============
        if (b250202.isChecked() && b250202r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2502) + " - " + getString(R.string.b25r), Toast.LENGTH_SHORT).show();
            b250202r.setError("This data is Required!");
            Log.i(TAG, "b2502r: This Data is Required!");
            return false;
        } else {
            b250202r.setError(null);
        }








        return true;

    }


}
