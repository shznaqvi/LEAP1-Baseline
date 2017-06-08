package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
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
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

import static android.content.ContentValues.TAG;

public class SectionAActivity extends AppCompatActivity {

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
    @BindView(R.id.b1077)
    RadioButton b1077;
    @BindView(R.id.b1088)
    RadioButton b1088;
    @BindView(R.id.b1088x)
    EditText b1088x;
    @BindView(R.id.b11)
    EditText b11;
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
    @BindView(R.id.b1206)
    RadioButton b1206;
    @BindView(R.id.b1207)
    RadioButton b1207;
    @BindView(R.id.b1208)
    RadioButton b1208;
    @BindView(R.id.b1209)
    RadioButton b1209;
    @BindView(R.id.b1210)
    RadioButton b1210;
    @BindView(R.id.b1211)
    RadioButton b1211;
    @BindView(R.id.b1212)
    RadioButton b1212;
    @BindView(R.id.b1213)
    RadioButton b1213;
    @BindView(R.id.b1214)
    RadioButton b1214;
    @BindView(R.id.b1215)
    RadioButton b1215;
    @BindView(R.id.b1216)
    RadioButton b1216;
    @BindView(R.id.b1217)
    RadioButton b1217;
    @BindView(R.id.b1277)
    RadioButton b1277;
    @BindView(R.id.b1288)
    RadioButton b1288;
    @BindView(R.id.b1288x)
    EditText b1288x;
    @BindView(R.id.b13)
    RadioGroup b13;
    @BindView(R.id.b1301)
    RadioButton b1301;
    @BindView(R.id.b1302)
    RadioButton b1302;
    @BindView(R.id.b1303)
    RadioButton b1303;
    @BindView(R.id.b1304)
    RadioButton b1304;
    @BindView(R.id.b1388)
    RadioButton b1388;
    @BindView(R.id.b1388x)
    EditText b1388x;
    @BindView(R.id.b14)
    RadioGroup b14;
    @BindView(R.id.b1401)
    RadioButton b1401;
    @BindView(R.id.b1402)
    RadioButton b1402;
    @BindView(R.id.b1403)
    RadioButton b1403;
    @BindView(R.id.b1404)
    RadioButton b1404;
    @BindView(R.id.b1405)
    RadioButton b1405;
    @BindView(R.id.b1488)
    RadioButton b1488;
    @BindView(R.id.b1488x)
    EditText b1488x;
    @BindView(R.id.b15)
    EditText b15;
    @BindView(R.id.b16)
    RadioGroup b16;
    @BindView(R.id.b1601)
    RadioButton b1601;
    @BindView(R.id.b1602)
    RadioButton b1602;
    @BindView(R.id.b1603)
    RadioButton b1603;
    @BindView(R.id.b1688)
    RadioButton b1688;
    @BindView(R.id.b1688x)
    EditText b1688x;
    @BindView(R.id.b17)
    DatePickerInputEditText b17;
    @BindView(R.id.b18)
    EditText b18;
    @BindView(R.id.b19)
    EditText b19;
    @BindView(R.id.b20)
    DatePickerInputEditText b20;
    @BindView(R.id.b21)
    EditText b21;
    @BindView(R.id.b22)
    EditText b22;
    @BindView(R.id.b23)
    RadioGroup b23;
    @BindView(R.id.b2301)
    RadioButton b2301;
    @BindView(R.id.b2302)
    RadioButton b2302;
    @BindView(R.id.fldGrp23)
    LinearLayout fldGrp23;
    @BindView(R.id.b23t1)
    RadioGroup b23t1;
    @BindView(R.id.b23t101)
    RadioButton b23t101;
    @BindView(R.id.b23t102)
    RadioButton b23t102;
    @BindView(R.id.b23t2)
    RadioGroup b23t2;
    @BindView(R.id.b23t201)
    RadioButton b23t201;
    @BindView(R.id.b23t202)
    RadioButton b23t202;
    @BindView(R.id.b2401)
    RadioGroup b2401;
    @BindView(R.id.b240101)
    RadioButton b240101;
    @BindView(R.id.b240102)
    RadioButton b240102;
    @BindView(R.id.fldGrp25)
    LinearLayout fldGrp25;
    @BindView(R.id.b2501)
    CheckBox b2501;
    @BindView(R.id.b2502)
    CheckBox b2502;
    @BindView(R.id.b2503)
    CheckBox b2503;
    @BindView(R.id.b2504)
    CheckBox b2504;
    @BindView(R.id.b2505)
    CheckBox b2505;
    @BindView(R.id.b2506)
    CheckBox b2506;
    @BindView(R.id.b2507)
    CheckBox b2507;
    @BindView(R.id.b2508)
    CheckBox b2508;
    @BindView(R.id.b2509)
    CheckBox b2509;
    @BindView(R.id.b2510)
    CheckBox b2510;
    @BindView(R.id.b2511)
    CheckBox b2511;
    @BindView(R.id.b2512)
    CheckBox b2512;
    @BindView(R.id.b2513)
    CheckBox b2513;
    @BindView(R.id.b2514)
    CheckBox b2514;
    @BindView(R.id.b2515)
    CheckBox b2515;
    @BindView(R.id.b2516)
    CheckBox b2516;
    @BindView(R.id.b2488)
    RadioGroup b2488;
    @BindView(R.id.b248801)
    RadioButton b248801;
    @BindView(R.id.b248802)
    RadioButton b248802;
    @BindView(R.id.b248801r)
    EditText b248801r;
    @BindView(R.id.b2601)
    RadioGroup b2601;
    @BindView(R.id.b260101)
    RadioButton b260101;
    @BindView(R.id.b260102)
    RadioButton b260102;
    @BindView(R.id.b260102r)
    EditText b260102r;
    @BindView(R.id.b2602)
    RadioGroup b2602;
    @BindView(R.id.b260201)
    RadioButton b260201;
    @BindView(R.id.b260202)
    RadioButton b260202;
    @BindView(R.id.b260202r)
    EditText b260202r;
    @BindView(R.id.b2603)
    RadioGroup b2603;
    @BindView(R.id.b260301)
    RadioButton b260301;
    @BindView(R.id.b260302)
    RadioButton b260302;
    @BindView(R.id.b260302r)
    EditText b260302r;
    @BindView(R.id.b2701)
    RadioGroup b2701;
    @BindView(R.id.b270101)
    RadioButton b270101;
    @BindView(R.id.b270102)
    RadioButton b270102;
    @BindView(R.id.b270102r)
    EditText b270102r;
    @BindView(R.id.b2702)
    RadioGroup b2702;
    @BindView(R.id.b270201)
    RadioButton b270201;
    @BindView(R.id.b270202)
    RadioButton b270202;
    @BindView(R.id.b270202r)
    EditText b270202r;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);
        String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        String maxDate43Weeks = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() + (AppMain.MILLISECONDS_IN_43_WEEKS));


        b17.setManager(getSupportFragmentManager());
        b20.setManager(getSupportFragmentManager());
        b17.setMaxDate(dateToday);
        b20.setMinDate(dateToday);
        b20.setMaxDate(maxDate43Weeks);

        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b17.onFocusChange(v, true);
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b20.onFocusChange(v, true);
            }
        });



        b2401.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (b240101.isChecked()) {
                    fldGrp25.setVisibility(View.VISIBLE);

                } else {
                    fldGrp25.setVisibility(View.GONE);
                    b2501.setChecked(false);
                    b2502.setChecked(false);
                    b2503.setChecked(false);
                    b2504.setChecked(false);
                    b2505.setChecked(false);
                    b2506.setChecked(false);
                    b2507.setChecked(false);
                    b2508.setChecked(false);
                    b2509.setChecked(false);
                    b2510.setChecked(false);
                    b2511.setChecked(false);
                    b2512.setChecked(false);
                    b2513.setChecked(false);
                    b2514.setChecked(false);
                    b2515.setChecked(false);
                    b2516.setChecked(false);
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

        // =================== Q13 Others ====================

        b1388.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b1388x.setVisibility(View.VISIBLE);
                } else {
                    b1388x.setVisibility(View.GONE);
                    b1388x.setText(null);
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

        // =================== Q16 Others ====================

        b1688.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b1688x.setVisibility(View.VISIBLE);
                } else {
                    b1688x.setVisibility(View.GONE);
                    b1688x.setText(null);
                }
            }
        });

        // =================== Q24 others ====================

        b248801.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b248801r.setVisibility(View.VISIBLE);
                } else {
                    b248801r.setVisibility(View.GONE);
                    b248801r.setText(null);
                }
            }
        });

        // =================== Q2601 reason ====================

        b260102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b260102r.setVisibility(View.VISIBLE);
                } else {
                    b260102r.setVisibility(View.GONE);
                    b260102r.setText(null);
                }
            }
        });

        // =================== Q2602 reason ====================

        b260202.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b260202r.setVisibility(View.VISIBLE);
                } else {
                    b260202r.setVisibility(View.GONE);
                    b260202r.setText(null);
                }
            }
        });

        // =================== Q2603 reason ====================

        b260302.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b260302r.setVisibility(View.VISIBLE);
                } else {
                    b260302r.setVisibility(View.GONE);
                    b260302r.setText(null);
                }
            }
        });

        // =================== Q2701 reason ====================

        b270102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b270102r.setVisibility(View.VISIBLE);
                } else {
                    b270102r.setVisibility(View.GONE);
                    b270102r.setText(null);
                }
            }
        });

        // =================== Q2702 reason ====================

        b270202.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b270202r.setVisibility(View.VISIBLE);
                } else {
                    b270202r.setVisibility(View.GONE);
                    b270202r.setText(null);
                }
            }
        });

        b23.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (b2301.isChecked()) {
                    fldGrp23.setVisibility(View.VISIBLE);
                } else {
                    fldGrp23.setVisibility(View.GONE);
                    b23t1.clearCheck();
                    b23t2.clearCheck();
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
        sa.put("b10", b1001.isChecked() ? "1" : b1002.isChecked() ? "2" : b1003.isChecked() ? "3" : b1004.isChecked() ? "4"
                : b1005.isChecked() ? "5" : b1006.isChecked() ? "6" : b1007.isChecked() ? "7" : b1008.isChecked() ? "8"
                : b1009.isChecked() ? "9" : b1010.isChecked() ? "10" : b1011.isChecked() ? "11" : b1012.isChecked() ? "12"
                : b1013.isChecked() ? "13" : b1014.isChecked() ? "14" : b1015.isChecked() ? "15" : b1016.isChecked() ? "16"
                : b1017.isChecked() ? "17" : b1077.isChecked() ? "77" : b1088.isChecked() ? "88" : "0");

        sa.put("b11", b11.getText().toString());
        sa.put("b12", b1201.isChecked() ? "1" : b1202.isChecked() ? "2" : b1203.isChecked() ? "3" : b1204.isChecked() ? "4"
                : b1205.isChecked() ? "5" : b1206.isChecked() ? "6" : b1207.isChecked() ? "7" : b1208.isChecked() ? "8"
                : b1209.isChecked() ? "9" : b1210.isChecked() ? "10" : b1211.isChecked() ? "11" : b1212.isChecked() ? "12"
                : b1213.isChecked() ? "13" : b1214.isChecked() ? "14" : b1215.isChecked() ? "15" : b1216.isChecked() ? "16"
                : b1217.isChecked() ? "17" : b1277.isChecked() ? "77" : b1288.isChecked() ? "88" : "0");


        sa.put("b13", b1301.isChecked() ? "1" : b1302.isChecked() ? "2" : b1303.isChecked() ? "3" : b1304.isChecked() ? "4"
                : b1388.isChecked() ? "88" : "0");
        sa.put("b14", b1401.isChecked() ? "1" : b1402.isChecked() ? "2" : b1403.isChecked() ? "3" : b1404.isChecked() ? "4"
                : b1405.isChecked() ? "5" : b1488.isChecked() ? "88" : "0");
        sa.put("b15", b15.getText().toString());
        sa.put("b16", b1601.isChecked() ? "1" : b1602.isChecked() ? "2" : b1603.isChecked() ? "3"
                : b1688.isChecked() ? "88" : "0");
        sa.put("b17", b17.getText().toString());
        sa.put("b18", b18.getText().toString());
        sa.put("b19", b19.getText().toString());
        sa.put("b20", b20.getText().toString());
        sa.put("b21", b21.getText().toString());
        sa.put("b22", b22.getText().toString());
        sa.put("b23", b2301.isChecked() ? "1" : b2302.isChecked() ? "2" : "0");
        sa.put("b23t1", b23t101.isChecked() ? "1" : b23t102.isChecked() ? "2" : "0");
        sa.put("b23t2", b23t201.isChecked() ? "1" : b23t202.isChecked() ? "2" : "0");
        sa.put("b2401", b240101.isChecked() ? "1" : b240102.isChecked() ? "2" : "0");
        sa.put("b2488", b248801.isChecked() ? "1" : b248802.isChecked() ? "2" : "0");
        sa.put("b248801x", b248801r.getText().toString());
        sa.put("b2501", b2501.isChecked() ? "1" : "0");
        sa.put("b2502", b2502.isChecked() ? "2" : "0");
        sa.put("b2503", b2503.isChecked() ? "3" : "0");
        sa.put("b2504", b2504.isChecked() ? "4" : "0");
        sa.put("b2505", b2505.isChecked() ? "5" : "0");
        sa.put("b2506", b2506.isChecked() ? "6" : "0");
        sa.put("b2507", b2507.isChecked() ? "7" : "0");
        sa.put("b2508", b2508.isChecked() ? "8" : "0");
        sa.put("b2509", b2509.isChecked() ? "9" : "0");
        sa.put("b2510", b2510.isChecked() ? "10" : "0");
        sa.put("b2511", b2511.isChecked() ? "11" : "0");
        sa.put("b2512", b2512.isChecked() ? "12" : "0");
        sa.put("b2513", b2513.isChecked() ? "13" : "0");
        sa.put("b2514", b2514.isChecked() ? "14" : "0");
        sa.put("b2515", b2515.isChecked() ? "15" : "0");
        sa.put("b2516", b2516.isChecked() ? "16" : "0");
        sa.put("b2601", b260101.isChecked() ? "1" : b260102.isChecked() ? "2" : "0");
        sa.put("b260102r", b260102r.getText().toString());
        sa.put("b2602", b260201.isChecked() ? "1" : b260202.isChecked() ? "2" : "0");
        sa.put("b260202r", b260202r.getText().toString());
        sa.put("b2603", b260301.isChecked() ? "1" : b260302.isChecked() ? "2" : "0");
        sa.put("b260302r", b260302r.getText().toString());
        sa.put("b2701", b270101.isChecked() ? "1" : b270102.isChecked() ? "2" : "0");
        sa.put("b270102r", b270102r.getText().toString());
        sa.put("b2702", b270201.isChecked() ? "1" : b270202.isChecked() ? "2" : "0");
        sa.put("b250202r", b270202r.getText().toString());

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
        if (Integer.valueOf(studyID.getText().toString()) == 0) {
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

        if (Integer.valueOf(b01.getText().toString()) == 0) {
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

        //==================== b09 ====================
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

        //=================== b10 ==============
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

        //==================== b11 ====================
        if (b11.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b11), Toast.LENGTH_SHORT).show();
            b11.setError("This data is Required!");
            Log.i(TAG, "b11: This Data is Required!");
            return false;
        } else {
            b11.setError(null);
        }

        //============== Check on Education=============
        if ((Integer.valueOf(b11.getText().toString()) < 0)
                || (Integer.valueOf(b11.getText().toString()) > 16)) {
            Toast.makeText(this, "ERROR(Invalid) " + getString(R.string.b11), Toast.LENGTH_LONG).show();
            b11.setError("Range is 1-16");
            Log.i(TAG, "b11: Range is 1-16");
            return false;
        } else {
            b11.setError(null);
        }

        //=================== b12 ==============
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

        //=================== b13 ==============
        if (b13.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b13), Toast.LENGTH_SHORT).show();
            b1388.setError("This data is Required!");
            Log.i(TAG, "b13: This Data is Required!");
            return false;
        } else {
            b1388.setError(null);
        }

        //=================== b13 Others ==============
        if (b1388.isChecked() && b1388x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b13) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b1388x.setError("This data is Required!");
            Log.i(TAG, "b1388x: This Data is Required!");
            return false;
        } else {
            b1388x.setError(null);
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

        // =================== b15 ====================
        if (b15.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b15), Toast.LENGTH_SHORT).show();
            b15.setError("This data is required");
            Log.d(TAG, " b15 : This data is required ");
            return false;
        } else {
            b15.setError(null);
        }

        if (Integer.valueOf(b15.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b15), Toast.LENGTH_SHORT).show();
            b15.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "b15: Invalid data is 0");
            return false;
        } else {
            b15.setError(null);
        }
        //=================== b16==============
        if (b16.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b16), Toast.LENGTH_SHORT).show();
            b1688.setError("This data is Required!");
            Log.i(TAG, "b16: This Data is Required!");
            return false;
        } else {
            b1688.setError(null);
        }

        //=================== b16 Others ==============
        if (b1688.isChecked() && b1688x.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b16) + " - " + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b1688x.setError("This data is Required!");
            Log.i(TAG, "b1688x: This Data is Required!");
            return false;
        } else {
            b1688x.setError(null);
        }

        // =================== b18 ====================
        if (b17.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.b17), Toast.LENGTH_SHORT).show();
            b17.setError("This data is Required!");
            Log.i(TAG, "b17: This data is Required!");
            return false;
        } else {
            b17.setError(null);
        }

        // =================== b18 ====================
        if (b18.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.b18), Toast.LENGTH_SHORT).show();
            b18.setError("This data is Required!");
            Log.i(TAG, "b18: This data is Required!");
            return false;
        } else {
            b18.setError(null);
        }
        if (Double.parseDouble(b18.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b18), Toast.LENGTH_SHORT).show();
            b18.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "b18: Invalid data is 0");
            return false;
        } else {
            b18.setError(null);
        }
        if (Double.parseDouble(b18.getText().toString()) < 30.0 || Double.parseDouble(b18.getText().toString()) > 150.0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b18), Toast.LENGTH_SHORT).show();
            b18.setError("Invalid: Range is 30.0 - 150.0 ");
            Log.i(TAG, "b18: Invalid Range is 30.0 - 150.0 kg");
            return false;
        } else {
            b18.setError(null);
        }

        // =================== b19 ====================
        if (b19.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.b19), Toast.LENGTH_SHORT).show();
            b19.setError("This data is Required!");
            Log.i(TAG, "b19: This data is Required!");
            return false;
        } else {
            b19.setError(null);
        }
        if (Double.parseDouble(b19.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b19), Toast.LENGTH_SHORT).show();
            b19.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "b19: Invalid data is 0");
            return false;
        } else {
            b19.setError(null);
        }
        if (Double.parseDouble(b19.getText().toString()) < 137 || Double.parseDouble(b19.getText().toString()) > 160) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.b19), Toast.LENGTH_SHORT).show();
            b19.setError("Invalid: Range is 137-160 cm");
            Log.i(TAG, "b19: Invalid Range is 137-160 cm");
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

        //==================== b21====================
        if (b21.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b21), Toast.LENGTH_SHORT).show();
            b21.setError("This data is Required!");
            Log.i(TAG, "b21: This Data is Required!");
            return false;
        } else {
            b21.setError(null);
        }

        //==================== b22====================
        if (b22.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b22), Toast.LENGTH_SHORT).show();
            b22.setError("This data is Required!");
            Log.i(TAG, "b22: This Data is Required!");
            return false;
        } else {
            b22.setError(null);
        }

        //=================b23================
        if (b23.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b23), Toast.LENGTH_SHORT).show();
            b2302.setError("This data is Required!");
            Log.i(TAG, "b23: This Data is Required!");
            return false;
        } else {
            b2302.setError(null);
        }

        if (b2301.isChecked()) {
            if (b23t1.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2301), Toast.LENGTH_SHORT).show();
                b23t102.setError("This data is Required!");
                Log.i(TAG, "b23t1: This Data is Required!");
                return false;
            } else {
                b23t102.setError(null);
            }

            if (b23t2.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2302), Toast.LENGTH_SHORT).show();
                b23t202.setError("This data is Required!");
                Log.i(TAG, "b23t2: This Data is Required!");
                return false;
            } else {
                b23t202.setError(null);
            }
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

        if (b240101.isChecked()) {
            // ====================== b23 ===================
            if (!(b2501.isChecked() || b2502.isChecked() || b2503.isChecked() || b2504.isChecked()
                    || b2505.isChecked() || b2506.isChecked() || b2507.isChecked() || b2508.isChecked() || b2509.isChecked() || b2510.isChecked() || b2511.isChecked()
                    || b2512.isChecked() || b2513.isChecked() || b2514.isChecked() || b2515.isChecked() || b2516.isChecked())) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.b25), Toast.LENGTH_LONG).show();
                b2516.setError("This data is Required!");    // Set Error on last check box
                Log.i(TAG, "b2516: This data is Required!");
                return false;
            } else {
                b2516.setError(null);
            }
        }

        //=================== b2488==============
        if (b2488.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.other), Toast.LENGTH_SHORT).show();
            b248802.setError("This data is Required!");
            Log.i(TAG, "b2488: This Data is Required!");
            return false;
        } else {
            b248802.setError(null);
        }

        //=================== b22other ==============
        if (b248801.isChecked() && b248801r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.other) + " - " + getString(R.string.b248801r), Toast.LENGTH_SHORT).show();
            b248801r.setError("This data is Required!");
            Log.i(TAG, "b2403r: This Data is Required!");
            return false;
        } else {
            b248801r.setError(null);
        }


        //=================== b2601==============
        if (b2601.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2601), Toast.LENGTH_SHORT).show();
            b260102.setError("This data is Required!");
            Log.i(TAG, "b2601: This Data is Required!");
            return false;
        } else {
            b260102.setError(null);
        }

        //=================== b2601 reason ==============
        if (b260102.isChecked() && b260102r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2601) + " - " + getString(R.string.b26r), Toast.LENGTH_SHORT).show();
            b260102r.setError("This data is Required!");
            Log.i(TAG, "b2601r: This Data is Required!");
            return false;
        } else {
            b260102r.setError(null);
        }

        //=================== b2602==============
        if (b2602.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2602), Toast.LENGTH_SHORT).show();
            b260202.setError("This data is Required!");
            Log.i(TAG, "b2602: This Data is Required!");
            return false;
        } else {
            b260202.setError(null);
        }

        //=================== b2602 reason ==============
        if (b260202.isChecked() && b260202r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2602) + " - " + getString(R.string.b26r), Toast.LENGTH_SHORT).show();
            b260202r.setError("This data is Required!");
            Log.i(TAG, "b2602r: This Data is Required!");
            return false;
        } else {
            b260202r.setError(null);
        }

        //=================== b2603==============
        if (b2603.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2603), Toast.LENGTH_SHORT).show();
            b260302.setError("This data is Required!");
            Log.i(TAG, "b2603: This Data is Required!");
            return false;
        } else {
            b260302.setError(null);
        }

        //=================== b2603 reason ==============
        if (b260302.isChecked() && b260302r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2603) + " - " + getString(R.string.b26r), Toast.LENGTH_SHORT).show();
            b260302r.setError("This data is Required!");
            Log.i(TAG, "b2603r: This Data is Required!");
            return false;
        } else {
            b260302r.setError(null);
        }

        //=================== b2701==============
        if (b2701.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2701), Toast.LENGTH_SHORT).show();
            b270102.setError("This data is Required!");
            Log.i(TAG, "b2701: This Data is Required!");
            return false;
        } else {
            b270102.setError(null);
        }

        //=================== b2701 reason ==============
        if (b270102.isChecked() && b270102r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2701) + " - " + getString(R.string.b27r), Toast.LENGTH_SHORT).show();
            b270102r.setError("This data is Required!");
            Log.i(TAG, "b2701r: This Data is Required!");
            return false;
        } else {
            b270102r.setError(null);
        }

        //=================== b2702==============
        if (b2702.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2702), Toast.LENGTH_SHORT).show();
            b270202.setError("This data is Required!");
            Log.i(TAG, "b2702: This Data is Required!");
            return false;
        } else {
            b270202.setError(null);
        }

        //=================== b2702 reason ==============
        if (b270202.isChecked() && b270202r.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.b2702) + " - " + getString(R.string.b27r), Toast.LENGTH_SHORT).show();
            b270202r.setError("This data is Required!");
            Log.i(TAG, "b2702r: This Data is Required!");
            return false;
        } else {
            b270202r.setError(null);
        }

        return true;

    }


}
