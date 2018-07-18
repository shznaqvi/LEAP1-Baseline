package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.contracts.NutritionContract;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1_baseline.databinding.ActivityMddwBinding;
import edu.aku.hassannaqvi.leap1_baseline.validatorClass;

public class MDDWActivity extends AppCompatActivity {
    ActivityMddwBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_mddw);
        bi.setCallback(this);
        this.setTitle(getResources().getString(R.string.mddw));
        settingTimeToEat();
        setListners();


    }
    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

    private void setListners() {
        bi.nw501none.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501a.setChecked(false);
                    bi.nw501b.setChecked(false);
                    bi.nw501c.setChecked(false);
                    bi.nw501d.setChecked(false);
                    bi.nw501e.setChecked(false);
                    bi.nw501f.setChecked(false);
                    bi.nw501g.setChecked(false);
                    bi.nw501h.setChecked(false);
                    bi.nw501i.setChecked(false);
                    bi.nw501j.setChecked(false);

                    bi.nw501a.setEnabled(false);
                    bi.nw501b.setEnabled(false);
                    bi.nw501c.setEnabled(false);
                    bi.nw501d.setEnabled(false);
                    bi.nw501e.setEnabled(false);
                    bi.nw501f.setEnabled(false);
                    bi.nw501g.setEnabled(false);
                    bi.nw501h.setEnabled(false);
                    bi.nw501i.setEnabled(false);
                    bi.nw501j.setEnabled(false);
                } else {
                    bi.nw501a.setEnabled(true);
                    bi.nw501b.setEnabled(true);
                    bi.nw501c.setEnabled(true);
                    bi.nw501d.setEnabled(true);
                    bi.nw501e.setEnabled(true);
                    bi.nw501f.setEnabled(true);
                    bi.nw501g.setEnabled(true);
                    bi.nw501h.setEnabled(true);
                    bi.nw501i.setEnabled(true);
                    bi.nw501j.setEnabled(true);

                }

            }
        });


        bi.nw501a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

        bi.nw501j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw501none.setChecked(false);
                    bi.nw501none.setEnabled(false);
                } else {
                    bi.nw501none.setEnabled(true);
                }
            }
        });

    }


    private void settingTimeToEat() {
        if (AppMain.nuCount == 1) {
            bi.nw501.setText(R.string._1);
        } else if (AppMain.nuCount == 2) {
            bi.nw501.setText(R.string._2);
        } else if (AppMain.nuCount == 3) {
            bi.nw501.setText(R.string._3);
        } else if (AppMain.nuCount == 4) {
            bi.nw501.setText(R.string._4);
        } else if (AppMain.nuCount == 5) {
            bi.nw501.setText(R.string._5);
        } else if (AppMain.nuCount == 6) {
            bi.nw501.setText(R.string._6);
        } else if (AppMain.nuCount == 7) {
            bi.nw501.setText(R.string._7);
        }
    }

    public void BtnContinue() {

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                if (AppMain.nuCount == 7) {
                    AppMain.nuCount = 1; // resetting counter
                    startActivity(new Intent(this, EndingActivity.class)
                           .putExtra("check", true));

                } else {
                    AppMain.nuCount++;
                    startActivityForResult(new Intent(this, MDDWActivity.class), 1);
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private void SaveDraft() throws JSONException {
        //Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        AppMain.nc = new NutritionContract();
        AppMain.nc.setDevicetagID(AppMain.fc.getTagID());
        AppMain.nc.setFormDate(AppMain.fc.getFormDate());
        AppMain.nc.setUser(AppMain.fc.getUserName());
        AppMain.nc.setDeviceId(AppMain.fc.getDeviceID());
        AppMain.nc.setApp_ver(AppMain.fc.getAppVer());
        AppMain.nc.set_UUID(AppMain.fc.getUID());
        JSONObject lfitem = new JSONObject();


        lfitem.put("tpsno", String.valueOf(AppMain.nuCount));

        lfitem.put("lfa", bi.nw501a.isChecked() ? "1"
                : "2");
        lfitem.put("lfb", bi.nw501b.isChecked() ? "1"
                : "2");
        lfitem.put("lfc", bi.nw501c.isChecked() ? "1"
                : "2");
        lfitem.put("lfd", bi.nw501d.isChecked() ? "1"
                : "2");
        lfitem.put("lfe", bi.nw501e.isChecked() ? "1"
                : "2");
        lfitem.put("lff", bi.nw501f.isChecked() ? "1"
                : "2");
        lfitem.put("lfg", bi.nw501g.isChecked() ? "1"
                : "2");
        lfitem.put("lfh", bi.nw501h.isChecked() ? "1"
                : "2");
        lfitem.put("lfi", bi.nw501i.isChecked() ? "1"
                : "2");
        lfitem.put("lfj", bi.nw501j.isChecked() ? "1"
                : "2");
        lfitem.put("lfnone", bi.nw501none.isChecked() ? "1"
                : "2");


        AppMain.nc.setlfitem(String.valueOf(lfitem));

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

            Long updcount = db.addNutrition(AppMain.nc, 1);
        AppMain.nc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            AppMain.nc.set_UID(
                    (AppMain.nc.getDeviceId() + AppMain.nc.get_ID()));
            db.updateNutritionID();

        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }
        return true;

    }

    public void BtnEnd() {

        AppMain.endActivity(this, this);
    }

    private boolean ValidateForm() {

        return validatorClass.EmptyCheckBox(this, bi.fldGrpnw501check, bi.nw501a, getString(R.string.nw501a));

    }
}
