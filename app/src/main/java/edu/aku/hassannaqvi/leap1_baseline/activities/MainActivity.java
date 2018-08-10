package edu.aku.hassannaqvi.leap1_baseline.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.leap1_baseline.NetworkUtils;
import edu.aku.hassannaqvi.leap1_baseline.R;
import edu.aku.hassannaqvi.leap1_baseline.contracts.FetalContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.FormsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.HFacilitiesContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.LHWsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.NutritionContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.SurveyContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.TehsilsContract;
import edu.aku.hassannaqvi.leap1_baseline.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;
import edu.aku.hassannaqvi.leap1_baseline.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1_baseline.getclasses.GetHFacilities;
import edu.aku.hassannaqvi.leap1_baseline.getclasses.GetLHWs;
import edu.aku.hassannaqvi.leap1_baseline.getclasses.GetMotherList;
import edu.aku.hassannaqvi.leap1_baseline.getclasses.GetTehsil;
import edu.aku.hassannaqvi.leap1_baseline.getclasses.GetUCs;
import edu.aku.hassannaqvi.leap1_baseline.getclasses.GetUsers;
import edu.aku.hassannaqvi.leap1_baseline.getclasses.GetVillages;
import edu.aku.hassannaqvi.leap1_baseline.syncclasses.SyncAllData;
import edu.aku.hassannaqvi.leap1_baseline.syncclasses.SyncForms;
import edu.aku.hassannaqvi.leap1_baseline.syncclasses.SyncNutrition;
import edu.aku.hassannaqvi.leap1_baseline.validatorClass;

import static edu.aku.hassannaqvi.leap1_baseline.core.AppMain.Fup30day;
import static edu.aku.hassannaqvi.leap1_baseline.core.AppMain.Fupantenatal;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getSimpleName();
    public List<String> lhwName;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    @BindView(R.id.adminsec)
    LinearLayout adminsec;
    @BindView(R.id.recordSummary)
    TextView recordSummary;
    @BindView(R.id.clusterNo)
    EditText clusterNo;
    @BindView(R.id.MN01)
    Spinner mN01;
    @BindView(R.id.MN02)
    Spinner mN02;
    @BindView(R.id.MN03)
    Spinner mN03;
    Map<String, String> tehsils, lhws;
    DatabaseHelper db;
    List<String> hfCodes;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    AlertDialog.Builder builder;
    String m_Text = "";
    String mStudyIdText = "";
    String mrnoText = "";
    private String rSumText = "";
    static String ACTIVITY_TYPE_KEY = "fuptype";
    static String ACTIVITY_TYPE_ID_KEY = "fuptypeId";
    int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // Reset working variables
        AppMain.mnb1 = "Test";
        AppMain.chCount = 0;
        AppMain.chTotal = 0;

        if (AppMain.admin) {
            adminsec.setVisibility(View.VISIBLE);
        } else {
            adminsec.setVisibility(View.GONE);
        }

//        Tag Working

        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        editor = sharedPref.edit();

        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Tag Name");

        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                if (!m_Text.equals("")) {
                    editor.putString("tagName", m_Text);
                    editor.commit();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        if (sharedPref.getString("tagName", null) == "" || sharedPref.getString("tagName", null) == null) {
            builder.show();
        }

//        End Tag


        db = new DatabaseHelper(this);
        //Collection<FormsContract> todaysForms = new ArrayList<>();

        //todaysForms = db.getTodayForms();

        rSumText += "TODAY'S RECORDS SUMMARY\r\n";
        rSumText += "=======================";
        rSumText += "\r\n\r\n";
        //rSumText += "Total Forms Today: " + todaysForms.size();
        rSumText += "\r\n";
        rSumText += "    Forms List: \r\n";
        String iStatus = "";
//        for (FormsContract fc : todaysForms) {
//
//            switch (fc.getiStatus()) {
//                case "1":
//                    iStatus = "Complete";
//                    break;
//                case "2":
//                    iStatus = "House Locked";
//                    break;
//                case "3":
//                    iStatus = "Refused";
//                    break;
//                case "4":
//                    iStatus = "Refused";
//                    break;
//            }
//
//            rSumText += fc.getLhwCode() + " " + fc.getHouseHold() + " " + iStatus;
//            rSumText += "\r\n";
//
//        }

        rSumText += "--------------------------------------------------\r\n";
        if (AppMain.admin) {
            adminsec.setVisibility(View.VISIBLE);
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Update: " + syncPref.getString("LastUpdate", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Synced(DB): " + syncPref.getString("LastSyncDB", "Never Synced");
            rSumText += "\r\n";
        }
        recordSummary.setText(rSumText);

        //        Sync Spinners

        AppMain.fc = null;

        // Spinner Drop down elements
        /*tehsils = new HashMap<>();
        final List<String> Tname = new ArrayList<>();
        Collection<TehsilsContract> Tc = db.getAllTehsil();
        Log.d(TAG, "onCreate: " + Tc.size());
        for (TehsilsContract hf : Tc) {
            tehsils.put(hf.getTehsil_name(), hf.getTehsil_code());
            Tname.add(hf.getTehsil_name());
        }

        mN01.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Tname));

        final List<String> hfCodes = new ArrayList<>();

        mN01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Spinner Drop down elements
                List<String> hfNames = new ArrayList<>();

                AppMain.tehsilCode = tehsils.get(Tname.get(position));

                Collection<HFacilitiesContract> hfc = db.getAllHFacilitiesByTehsil(AppMain.tehsilCode);
                Log.d(TAG, "onCreate: " + hfc.size());
                for (HFacilitiesContract hf : hfc) {
                    hfNames.add(hf.gethFacilityName());
                    hfCodes.add(hf.gethFacilityCode());
                }

                // attaching data adapter to spinner
                mN02.setAdapter(new ArrayAdapter<>(getBaseContext(),
                        android.R.layout.simple_spinner_dropdown_item, hfNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
        mN02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AppMain.hfCode = hfCodes.get(position);

                lhwName = new ArrayList<String>();
                lhws = new HashMap<String, String>();
                Collection<LHWsContract> lhwc = db.getAllLhwsByHf(hfCodes.get(position));
                for (LHWsContract lhw : lhwc) {
                    lhws.put("" + (lhw.getLHWName() + " (" + lhw.getLHWCode() + ")"), lhw.getLHWCode());
                    lhwName.add(lhw.getLHWName() + " (" + lhw.getLHWCode() + ")");
                }
                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(getBaseContext(),
                        android.R.layout.simple_spinner_dropdown_item, lhwName);

                psuAdapter
                        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mN03.setAdapter(psuAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mN03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                AppMain.lhwCode = lhws.get(lhwName.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void openForm(View v) {
        if (sharedPref.getString("tagName", null) != "" && sharedPref.getString("tagName", null) != null) {
            Intent oF = new Intent(MainActivity.this, InfoActivity.class);
            startActivity(oF);
        } else {

            builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Tag Name");

            final EditText input = new EditText(MainActivity.this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    m_Text = input.getText().toString();
                    if (!m_Text.equals("")) {
                        editor.putString("tagName", m_Text);
                        editor.commit();

                        if (mN01.getSelectedItem() != null) {
                            Intent oF = new Intent(MainActivity.this, InfoActivity.class);
                            startActivity(oF);
                        } else {
                            Toast.makeText(MainActivity.this, "First Download Data", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }

    }

    public void openantinatal(View v) {
//        studyIdPrompt(" Antenatal Visit (Monthly Follow Up) ", Fupantenatal);
        AppMain.formType = String.valueOf(AppMain.TYPE_FUP);
        AppMain.SELECTED_FUP_TYPE = Fupantenatal;
        openIdentificationActivity(" Antenatal Visit (Monthly Follow Up) ", Fupantenatal);

    }

    private void openIdentificationActivity(String fuptitle, int fuptype) {
        startActivity(new Intent(MainActivity.this, IdentificationActivity.class).putExtra(ACTIVITY_TYPE_KEY,fuptitle).putExtra(ACTIVITY_TYPE_ID_KEY,fuptype));
    }

    private void studyIdPrompt(String fup_type, final int fup_typeID) {
        final Intent iA = new Intent(getApplicationContext(), FollowupActivity.class);
        iA.putExtra(ACTIVITY_TYPE_KEY, fup_type);
        iA.putExtra(ACTIVITY_TYPE_ID_KEY, fup_typeID);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mother Study ID");
        View viewInflated = LayoutInflater.from(this).inflate(R.layout.text_input_mstudyid, (ViewGroup) findViewById(R.id.activity_main), false);

        final EditText input = (EditText) viewInflated.findViewById(R.id.input);
        final EditText inputmrno = (EditText) viewInflated.findViewById(R.id.inputmrno);
        inputmrno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                inputmrno.setInputType(InputType.TYPE_CLASS_NUMBER);
                length = charSequence.toString().length();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

//                clearFields();


                if (!inputmrno.getText().toString().isEmpty() && inputmrno.getText().toString().length() == 3) {
                    if (inputmrno.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        if (length < 4) {
                            inputmrno.setText(inputmrno.getText().toString() + "-");
                            inputmrno.setSelection(inputmrno.getText().length());
                            //binding.nh108.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                        }

                    }
                }
                if (!inputmrno.getText().toString().isEmpty() && inputmrno.getText().toString().length() == 6) {
                    if (inputmrno.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        if (length < 7) {
                            inputmrno.setText(inputmrno.getText().toString() + "-");
                            inputmrno.setSelection(inputmrno.getText().length());
                            //binding.nh108.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                        }

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.search_go, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                mStudyIdText = input.getText().toString();
                mrnoText = inputmrno.getText().toString();
                if (mStudyIdText.isEmpty() ) {
                    if (!validatorClass.EmptyTextBox(getApplicationContext(), input, "Please enter study id")) {
                        return;
                    }
                    if (!validatorClass.EmptyTextBox(getApplicationContext(),inputmrno,"Please enter MR no")){
                        return;
                    }
                } else {
                    insertFup(mStudyIdText,mrnoText,fup_typeID);
                    dialog.dismiss();
                    startActivity(iA);
                }
            }

            private void insertFup(String mstudyId, String mrno, int fupID) {
                AppMain.fc = new FormsContract();
                AppMain.fc.setTagID(sharedPref.getString("tagName", null));
                AppMain.fc.setDeviceID(AppMain.deviceId);
                AppMain.fc.setUserName(AppMain.username);
                AppMain.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
                AppMain.fc.setFormType(AppMain.formType);
                AppMain.fc.setSfuptype(String.valueOf(fupID));
                AppMain.fc.setSiteNum(String.valueOf(AppMain.site));
                AppMain.fc.setMrNum(mrno);
                AppMain.fc.setmStudyID(mstudyId);
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void open30day(View v) {
//        studyIdPrompt(" 30 Day Visit (Follow Up)", Fup30day);
        AppMain.SELECTED_FUP_TYPE = Fup30day;
        AppMain.formType = String.valueOf(AppMain.TYPE_FUP);
        openIdentificationActivity(" 30 Day Visit (Follow Up)", Fup30day);
    }

    public void openA(View v) {
        Intent iA = new Intent(this, RandomizationActivity.class);
        startActivity(iA);
    }

    public void openB(View v) {
        Intent iB = new Intent(this, BaselineActvity.class);
        startActivity(iB);
    }

    public void openC(View v) {
        Intent iC = new Intent(this, HealthSurveyScoringActivity.class);
        startActivity(iC);
    }

    public void openD(View v) {
        Intent iD = new Intent(this, DataCollectionActivity.class);
        startActivity(iD);
    }

    public void openE(View v) {
       /* Intent iD = new Intent(this, SectionEActivity.class);
        startActivity(iD);*/
    }

    public void openF(View v) {
       /* Intent iD = new Intent(this, SectionFActivity.class);
        startActivity(iD);*/
    }

   /* public void openIM(View v) {
        Intent iIM = new Intent(this, SectionIMActivity.class);
        startActivity(iIM);
    }*/

    public void openG(View v) {
       /* Intent iG = new Intent(this, SectionGActivity.class);
        startActivity(iG);*/
    }

    public void openEnd(View v) {
        Intent iEnd = new Intent(this, EndingActivity.class);
        startActivity(iEnd);
    }

    public void openDB(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }

    /*public void CheckCluster(View v) {
        Intent cluster_list = new Intent(getApplicationContext(), FormsList.class);
        cluster_list.putExtra("clusterno", clusterNo.getText().toString());
        startActivity(cluster_list);

    }*/
    public void syncServer(View view) {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            /*
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            new SyncForms(this).execute();
            Toast.makeText(getApplicationContext(), "Syncing Nutritions", Toast.LENGTH_SHORT).show();
            new SyncNutrition(this).execute();
            */
            // TODO : Syncing Baseline Form to server
            Toast.makeText(getApplicationContext(), "Syncing Baseline Form", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Baseline",
                    "updateForms",
                    FormsContract.class,
                    NetworkUtils.buildUrl(FormsContract.formsTable.URI.replace(".php", "bl.php")),
                    db.getUnsyncedForms(AppMain.TYPE_BASELINE), this.findViewById(R.id.syncStatus)
            ).execute();
            // TODO : Syncing 30 day Fup Form to server
            Toast.makeText(getApplicationContext(), "Syncing 30 Day Followup", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "30Day",
                    "updateForms",
                    FormsContract.class,
                    NetworkUtils.buildUrl(FormsContract.formsTable.URI.replace(".php", "30day.php")),
                    db.getUnsyncedFups(AppMain.TYPE_FUP,AppMain.Fup30day), this.findViewById(R.id.syncStatus)
            ).execute();
            // TODO : Syncing Antenatal Fup Form to server
            Toast.makeText(getApplicationContext(), "Syncing Antenatal Followup", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Antenatal",
                    "updateForms",
                    FormsContract.class,
                    NetworkUtils.buildUrl(FormsContract.formsTable.URI.replace(".php", "antenatal.php")),
                    db.getUnsyncedFups(AppMain.TYPE_FUP,AppMain.Fupantenatal), this.findViewById(R.id.syncStatus)
            ).execute();
            // TODO : Syncing Survey Form to server
            Toast.makeText(getApplicationContext(), "Syncing Survey Forms", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Survey",
                    "updateSurvey",
                    SurveyContract.class,
                    NetworkUtils.buildUrl(SurveyContract.SurveyTable._URL),
                    db.getUnsyncedSurvey(), this.findViewById(R.id.syncStatus)
            ).execute();
            // TODO : Syncing Nutrition Form to server
            Toast.makeText(getApplicationContext(), "Syncing Nutrition Forms", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Nutrition",
                    "updateNutrition",
                    NutritionContract.class,
                    NetworkUtils.buildUrl(NutritionContract.NutritionTable._URL),
                    db.getUnsyncedNutrition(), this.findViewById(R.id.syncStatus)
            ).execute();
            // TODO : Syncing Fetal Form to server
            Toast.makeText(getApplicationContext(), "Syncing Fetal Forms", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Fetal",
                    "updateFetal",
                    FetalContract.class,
                    NetworkUtils.buildUrl(FetalContract.FetalTable._URL),
                    db.getUnsyncedFetal(), this.findViewById(R.id.syncStatus)
            ).execute();


            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastSyncServer", dtToday);

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    public void syncDevice(View view) {
        if (isNetworkAvailable()) {

            syncData sync = new syncData(this);
            sync.execute();

        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public class syncData extends AsyncTask<String, String, String> {

        private Context mContext;

        public syncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {

                    GetMotherList ml = new GetMotherList(mContext);
                    Toast.makeText(mContext, "Syncing mother list", Toast.LENGTH_SHORT).show();
                    ml.execute();
                    GetUsers us = new GetUsers(mContext);
                    Toast.makeText(mContext, "Syncing Users", Toast.LENGTH_SHORT).show();
                    us.execute();
                    /*
                    GetTehsil gt = new GetTehsil(mContext);
                    Toast.makeText(mContext, "Syncing Tehsils", Toast.LENGTH_SHORT).show();
                    gt.execute();

                    GetVillages gv = new GetVillages(mContext);
                    Toast.makeText(mContext, "Syncing Villages", Toast.LENGTH_SHORT).show();
                    gv.execute();

                    GetUCs gu = new GetUCs(mContext);
                    Toast.makeText(mContext, "Syncing Ucs", Toast.LENGTH_SHORT).show();
                    gu.execute();

                    GetHFacilities gh = new GetHFacilities(mContext);
                    Toast.makeText(mContext, "Syncing Health Facilities", Toast.LENGTH_SHORT).show();
                    gh.execute();

                    GetLHWs gp = new GetLHWs(mContext);
                    Toast.makeText(mContext, "Syncing LHWs", Toast.LENGTH_SHORT).show();
                    gp.execute();
*/

                    SharedPreferences syncPref = getSharedPreferences("SyncInfo(DOWN)", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = syncPref.edit();

                    editor.putString("LastSyncDevice", dtToday);

                    editor.apply();
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    //        Sync Spinners

                    AppMain.fc = null;

                    // Spinner Drop down elements
                    tehsils = new HashMap<>();
                    final List<String> Tname = new ArrayList<>();
                    Collection<TehsilsContract> Tc = db.getAllTehsil();
                    Log.d(TAG, "onCreate: " + Tc.size());
                    for (TehsilsContract hf : Tc) {
                        tehsils.put(hf.getTehsil_name(), hf.getTehsil_code());
                        Tname.add(hf.getTehsil_name());
                    }

                    mN01.setAdapter(new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_dropdown_item, Tname));

                    mN01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            // Spinner Drop down elements
                            List<String> hfNames = new ArrayList<>();

                            hfCodes = new ArrayList<>();

                            AppMain.tehsilCode = tehsils.get(Tname.get(position));

                            Collection<HFacilitiesContract> hfc = db.getAllHFacilitiesByTehsil(AppMain.tehsilCode);
                            Log.d(TAG, "onCreate: " + hfc.size());
                            for (HFacilitiesContract hf : hfc) {
                                hfNames.add(hf.gethFacilityName());
                                hfCodes.add(hf.gethFacilityCode());
                            }

                            // attaching data adapter to spinner
                            mN02.setAdapter(new ArrayAdapter<>(getBaseContext(),
                                    android.R.layout.simple_spinner_dropdown_item, hfNames));

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    mN02.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            AppMain.hfCode = hfCodes.get(position);

                            lhwName = new ArrayList<String>();
                            lhws = new HashMap<String, String>();
                            Collection<LHWsContract> lhwc = db.getAllLhwsByHf(hfCodes.get(position));
                            for (LHWsContract lhw : lhwc) {
                                lhws.put("" + (lhw.getLHWName() + " (" + lhw.getLHWCode() + ")"), lhw.getLHWCode());
                                lhwName.add(lhw.getLHWName() + " (" + lhw.getLHWCode() + ")");
                            }
                            ArrayAdapter<String> psuAdapter = new ArrayAdapter<String>(MainActivity.this,
                                    android.R.layout.simple_spinner_item, lhwName);

                            psuAdapter
                                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            mN03.setAdapter(psuAdapter);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    mN03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            AppMain.lhwCode = lhws.get(lhwName.get(position));
                /*Collection<LHWsContract> lhwc = db.getAllLhwsByHf(AppMain.hh01txt);
                for (LHWsContract l : lhwc) {
                    Log.d(TAG, "onItemSelected: " + l.getLHWCode() + " -" + AppMain.hh02txt);

                    if (l.getLHWCode().equals(AppMain.hh02txt)) {
                        Log.d(TAG, "onItemSelected: " + l.getLHWName());
                        String[] psuNameS = l.getLHWName().toString().split("\\|");
                        districtN.setText(psuNameS[0]);
                        Log.d(TAG, "onItemSelected: " + psuNameS[0]);
                        ucN.setText(psuNameS[1]);
                        Log.d(TAG, "onItemSelected: " + psuNameS[1]);
                        psuN.setText(psuNameS[2]);
                        Log.d(TAG, "onItemSelected: " + psuNameS[2]);

                    }
                }*/
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
            }, 1200);
        }
    }
}
