package edu.aku.hassannaqvi.leap1_baseline.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.leap1_baseline.contracts.FetalContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.FetalContract.FetalTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.FormsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.FormsContract.formsTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.HFacilitiesContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.HFacilitiesContract.HFacilityTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.LHWsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.LHWsContract.LHWTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.MotherListContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.MotherListContract.MotherListTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.NutritionContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.NutritionContract.NutritionTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.PSUsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.PSUsContract.singleChild;
import edu.aku.hassannaqvi.leap1_baseline.contracts.SourceNGOContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.SourceNGOContract.SourceTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.SurveyContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.SurveyContract.SurveyTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.TehsilsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.TehsilsContract.TehsilTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.UCsContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.UCsContract.UcTable;
import edu.aku.hassannaqvi.leap1_baseline.contracts.UsersContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.UsersContract.singleUser;
import edu.aku.hassannaqvi.leap1_baseline.contracts.VillagesContract;
import edu.aku.hassannaqvi.leap1_baseline.contracts.VillagesContract.VillageTable;

/**
 * Created by hassan.naqvi on 10/29/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + singleUser.TABLE_NAME + "("
            + singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUser.ROW_USERNAME + " TEXT,"
            + singleUser.ROW_PASSWORD + " TEXT );";
    public static final String DATABASE_NAME = "leap1bl.db";
    public static final String DB_NAME = "leap1bl_copy.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + formsTable.TABLE_NAME + "("
            + formsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            formsTable.COLUMN_PROJECTNAME + " TEXT," +
            formsTable.COLUMN_UID + " TEXT," +
            formsTable.COLUMN_USERNAME + " TEXT," +
            formsTable.COLUMN_FORMDATE + " TEXT," +
            formsTable.COLUMN_FORMTYPE + " TEXT," +
            formsTable.COLUMN_ISTATUS + " TEXT," +
            formsTable.COLUMN_SITENUM + " TEXT," +
            formsTable.COLUMN_MRNUM + " TEXT," +
            formsTable.COLUMN_MSTUDYID + " TEXT," +
            formsTable.COLUMN_PARTICIPANT_NAME + " TEXT," +
            formsTable.COLUMN_SINFO + " TEXT," +
            formsTable.COLUMN_SRANDOMIZATION + " TEXT," +
            formsTable.COLUMN_SBASELINE + " TEXT," +
            formsTable.COLUMN_SFUP + " TEXT," +
            formsTable.COLUMN_SFUP_TYPE + " TEXT," +
            formsTable.COLUMN_DEVICEID + " TEXT," +
            formsTable.COLUMN_TAGID + " TEXT," +
            formsTable.COLUMN_GPSLAT + " TEXT," +
            formsTable.COLUMN_GPSLNG + " TEXT," +
            formsTable.COLUMN_GPSTIME + " TEXT," +
            formsTable.COLUMN_GPSACC + " TEXT," +
            formsTable.COLUMN_SYNCED + " TEXT," +
            formsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
    final String SQL_CREATE_NUTRITION = "CREATE TABLE " + NutritionTable.TABLE_NAME + " (" +
            NutritionTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            NutritionTable.COLUMN_PROJECTNAME + " TEXT," +
            NutritionTable.COLUMN_UID + " TEXT," +
            NutritionTable.COLUMN_UUID + " TEXT," +
            NutritionTable.COLUMN_FORMDATE + " TEXT," +
            NutritionTable.COLUMN_SITENUM + " TEXT," +
            NutritionTable.COLUMN_MRNUM + " TEXT," +
            NutritionTable.COLUMN_MSTUDYID + " TEXT," +
            NutritionTable.COLUMN_DEVICEID + " TEXT," +
            NutritionTable.COLUMN_DEVICETAGID + " TEXT," +
            NutritionTable.COLUMN_USER + " TEXT," +
            NutritionTable.COLUMN_APP_VER + " TEXT," +
            NutritionTable.COLUMN_LFITEM + " TEXT," +
            NutritionTable.COLUMN_SYNCED + " TEXT," +
            NutritionTable.COLUMN_SYNCEDDATE + " TEXT" +
            ");";
    final String SQL_CREATE_MOTHERlIST = "CREATE TABLE " + MotherListTable.TABLE_NAME + " (" +
            MotherListTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MotherListTable.COLUMN__UID + " TEXT,"+
            MotherListTable.COLUMN__UUID + " TEXT,"+
            MotherListTable.COLUMN_MRNO + " TEXT,"+
            MotherListTable.COLUMN_STUDYID + " TEXT,"+
            MotherListTable.COLUMN_MOTHERNAME + " TEXT"+
            ");";
    final String SQL_CREATE_SURVEY = "CREATE TABLE " + SurveyTable.TABLE_NAME + " (" +
            SurveyTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SurveyTable.COLUMN__UID  + " TEXT,"+
            SurveyTable.COLUMN__UUID + " TEXT,"+
            SurveyTable.COLUMN_FORMDATE + " TEXT,"+
            SurveyTable.COLUMN_FORMTYPE + " TEXT,"+
            SurveyTable.COLUMN_FUPTYPE + " TEXT,"+
            SurveyTable.COLUMN_USER + " TEXT,"+
            SurveyTable.COLUMN_SITENUM + " TEXT,"+
            SurveyTable.COLUMN_MRNUM + " TEXT,"+
            SurveyTable.COLUMN_MSTUDYID + " TEXT,"+
            SurveyTable.COLUMN_SF + " TEXT,"+
            SurveyTable.COLUMN_AQ + " TEXT,"+
            SurveyTable.COLUMN_DEVICEID  + " TEXT,"+
            SurveyTable.COLUMN_DEVICETAGID  + " TEXT,"+
            SurveyTable.COLUMN_SYNCED  + " TEXT,"+
            SurveyTable.COLUMN_SYNCED_DATE  + " TEXT,"+
            SurveyTable.COLUMN_APPVERSION + " TEXT"+
            ");";
    private static final String SQL_CREATE_FETAL = "CREATE TABLE "
            +FetalTable.TABLE_NAME + "("
            +FetalTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FetalTable.COLUMN_PROJECTNAME + " TEXT,"
            + FetalTable.COLUMN__UID + " TEXT," +
            FetalTable.COLUMN__UUID + " TEXT," +
            FetalTable.COLUMN_USER + " TEXT," +
            FetalTable.COLUMN_STUDYID + " TEXT," +
            FetalTable.COLUMN_MRNO + " TEXT," +
            FetalTable.COLUMN_SITE + " TEXT," +
            FetalTable.COLUMN_FORMDATE + " TEXT," +
            FetalTable.COLUMN_FORMTYPE + " TEXT," +
            FetalTable.COLUMN_FUPTYPE + " TEXT," +
            FetalTable.COLUMN_FETAB + " TEXT," +
            FetalTable.COLUMN_DEVICEID + " TEXT," +
            FetalTable.COLUMN_DEVICETAGID + " TEXT," +
            FetalTable.COLUMN_SYNCED + " TEXT," +
            FetalTable.COLUMN_APP_VERSION + " TEXT," +
            FetalTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";
    private static final String SQL_DELETE_FORMS = "DROP TABLE IF EXISTS " + formsTable.TABLE_NAME;
    private static final String SQL_DELETE_USERS = "DROP TABLE IF EXISTS " + singleUser.TABLE_NAME;
    private static final String SQL_DELETE_NUTRITION = "DROP TABLE IF EXISTS " + NutritionTable.TABLE_NAME;
    private static final String SQL_DELETE_MOTHERLIST = "DROP TABLE IF EXISTS " + MotherListTable.TABLE_NAME;

    private static final String SQL_DELETE_FETAL ="DROP TABLE IF EXISTS " + FetalTable.TABLE_NAME;
    private static final String SQL_DELETE_SURVEY ="DROP TABLE IF EXISTS " + SurveyTable.TABLE_NAME;
    private static final String SQL_DELETE_PSUS = "DROP TABLE IF EXISTS " + singleChild.TABLE_NAME;
    public static String DB_FORM_ID;
    public static String DB_IMS_ID;

    final String SQL_CREATE_H_FACILIY_TABLE = "CREATE TABLE " + HFacilityTable.TABLE_NAME + " (" +
            HFacilityTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            HFacilityTable.COLUMN_HFACILITY_CODE + " TEXT, " +
            HFacilityTable.COLUMN_TEHSIL_CODE + " TEXT, " +
            HFacilityTable.COLUMN_HFACILITY_NAME + " TEXT " +
            ");";


    private final String TAG = "DatabaseHelper";
    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_H_FACILIY_TABLE);
        db.execSQL(SQL_CREATE_NUTRITION);
        db.execSQL(SQL_CREATE_SURVEY);
        db.execSQL(SQL_CREATE_FETAL);
        db.execSQL(SQL_CREATE_MOTHERlIST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_NUTRITION);
        db.execSQL(SQL_DELETE_MOTHERLIST);
        db.execSQL(SQL_DELETE_SURVEY);
        db.execSQL(SQL_DELETE_FETAL);
        db.execSQL(HFacilityTable.TABLE_NAME);
        onCreate(db);
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_PROJECTNAME, fc.getProjectName());
        values.put(formsTable.COLUMN_UID, fc.getUID());
        values.put(formsTable.COLUMN_USERNAME, fc.getUserName());
        values.put(formsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(formsTable.COLUMN_FORMTYPE, fc.getFormType());
        values.put(formsTable.COLUMN_ISTATUS, fc.getiStatus());
        values.put(formsTable.COLUMN_SITENUM, fc.getSiteNum());
        values.put(formsTable.COLUMN_MRNUM, fc.getMrNum());
        values.put(formsTable.COLUMN_MSTUDYID, fc.getmStudyID());
        values.put(formsTable.COLUMN_PARTICIPANT_NAME, fc.getParticipantName());
        values.put(formsTable.COLUMN_SINFO, fc.getsInfo());
        values.put(formsTable.COLUMN_SRANDOMIZATION, fc.getsRandomization());
        values.put(formsTable.COLUMN_SBASELINE, fc.getsBaseline());
        values.put(formsTable.COLUMN_SFUP, fc.getSfup());
        values.put(formsTable.COLUMN_SFUP_TYPE, fc.getSfuptype());
        values.put(formsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(formsTable.COLUMN_TAGID, fc.getTagID());
        values.put(formsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(formsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(formsTable.COLUMN_GPSTIME, fc.getGpsTime());
        values.put(formsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(formsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(formsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                formsTable.TABLE_NAME,
                formsTable.COLUMN_NAME_NULLABLE,
                values);
        DB_FORM_ID = String.valueOf(newRowId);
        return newRowId;
    }
    public Long addFetal(FetalContract fet) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FetalTable.COLUMN_PROJECTNAME, fet.getProjectName());
        values.put(FetalTable.COLUMN__UID, fet.get_UID());
        values.put(FetalTable.COLUMN__UUID, fet.get_UUID());
        values.put(FetalTable.COLUMN_USER, fet.getUser());
        values.put(FetalTable.COLUMN_STUDYID, fet.getstudyid());
        values.put(FetalTable.COLUMN_MRNO, fet.getmrno());
        values.put(FetalTable.COLUMN_SITE, fet.getsite());
        values.put(FetalTable.COLUMN_FORMDATE, fet.getFormDate());
        values.put(FetalTable.COLUMN_FORMTYPE, fet.getFormType());
        values.put(FetalTable.COLUMN_FUPTYPE, fet.getfupType());
        values.put(FetalTable.COLUMN_FETAB, fet.getfetab());
        values.put(FetalTable.COLUMN_DEVICEID, fet.getDeviceID());
        values.put(FetalTable.COLUMN_DEVICETAGID, fet.getDevicetagID());
        values.put(FetalTable.COLUMN_SYNCED, fet.getSynced());
        values.put(FetalTable.COLUMN_SYNCED_DATE, fet.getSynced_date());
        values.put(FetalTable.COLUMN_APP_VERSION, fet.getApp_version());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FetalTable.TABLE_NAME,
                FetalTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }
    public Long addSurvey(SurveyContract sc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SurveyTable.COLUMN__UID, sc.get_UID());
        values.put(SurveyTable.COLUMN__UUID, sc.get_UUID());
        values.put(SurveyTable.COLUMN_FORMDATE, sc.getformDate());
        values.put(SurveyTable.COLUMN_FORMTYPE, sc.getformType());
        values.put(SurveyTable.COLUMN_FUPTYPE, sc.getfupType());
        values.put(SurveyTable.COLUMN_USER, sc.getuser());
        values.put(SurveyTable.COLUMN_SITENUM, sc.getsiteNum());
        values.put(SurveyTable.COLUMN_MRNUM, sc.getmrNum());
        values.put(SurveyTable.COLUMN_MSTUDYID, sc.getmStudyID());
        values.put(SurveyTable.COLUMN_SF, sc.getsf());
        values.put(SurveyTable.COLUMN_AQ, sc.getaq());
        values.put(SurveyTable.COLUMN_DEVICEID, sc.getdeviceID());
        values.put(SurveyTable.COLUMN_DEVICETAGID, sc.getdevicetagID());
        values.put(SurveyTable.COLUMN_SYNCED, sc.getsynced());
        values.put(SurveyTable.COLUMN_SYNCED_DATE, sc.getsynced_date());
        values.put(SurveyTable.COLUMN_APPVERSION, sc.getappVersion());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                SurveyTable.TABLE_NAME,
                SurveyTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addMotherList(MotherListContract mlc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MotherListTable.COLUMN__UID, mlc.get_UID());
        values.put(MotherListTable.COLUMN__UUID, mlc.get_UUID());
        values.put(MotherListTable.COLUMN_MRNO, mlc.getmrno());
        values.put(MotherListTable.COLUMN_STUDYID, mlc.getstudyid());
        values.put(MotherListTable.COLUMN_MOTHERNAME, mlc.getmothername());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MotherListTable.TABLE_NAME,
                MotherListTable.COLUMN_NAME_NULLABLE,
                values);
        DB_FORM_ID = String.valueOf(newRowId);
        return newRowId;
    }

    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_UID, AppMain.fc.getUID());

// Which row to update, based on the ID
        String selection = formsTable.COLUMN_ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(formsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
    public int updateMotherListID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MotherListTable.COLUMN__UID, AppMain.mlc.get_UID());

// Which row to update, based on the ID
        String selection = MotherListTable.COLUMN__ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(AppMain.mlc.get_ID())};

        int count = db.update(MotherListTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateFetalID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FetalTable.COLUMN__UID, AppMain.fet.get_UID());

// Which row to update, based on the ID
        String selection = FetalTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fet.get_ID())};

        int count = db.update(FetalTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
    public int updateSurveyID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(SurveyTable.COLUMN__UID, AppMain.sur.get_UID());

// Which row to update, based on the ID
        String selection = SurveyTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.sur.get_ID())};

        int count = db.update(SurveyTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateNutritionID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(NutritionTable.COLUMN_UID, AppMain.nc.get_UID());

// Which row to update, based on the ID
        String selection = NutritionTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.nc.get_ID())};

        int count = db.update(NutritionTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public void updateForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_SYNCED, true);
        values.put(formsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = formsTable.COLUMN_ID + " LIKE ?";
        String[] whereArgs = {id};

        int count = db.update(
                formsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }
    public void updateSyncedFetal(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FetalTable.COLUMN_SYNCED, true);
        values.put(FetalTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FetalTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FetalTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateNutrition(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(NutritionTable.COLUMN_SYNCED, true);
        values.put(NutritionTable.COLUMN_SYNCEDDATE, new Date().toString());

// Which row to update, based on the title
        String where = NutritionTable.COLUMN__ID + " LIKE ?";
        String[] whereArgs = {id};

        int count = db.update(
                NutritionTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public Long addNutrition(NutritionContract mc, int type) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(NutritionTable.COLUMN_LFITEM, mc.getlfitem());

        values.put(NutritionTable.COLUMN_PROJECTNAME, mc.getProjectName());
        values.put(NutritionTable.COLUMN_UID, mc.get_UID());
        values.put(NutritionTable.COLUMN_UUID, mc.get_UUID());
        values.put(NutritionTable.COLUMN_FORMDATE, mc.getFormDate());
        values.put(NutritionTable.COLUMN_SITENUM, mc.getSiteNum());
        values.put(NutritionTable.COLUMN_MRNUM, mc.getMrNum());
        values.put(NutritionTable.COLUMN_MSTUDYID, mc.getmStudyID());
        values.put(NutritionTable.COLUMN_DEVICEID, mc.getDeviceId());
        values.put(NutritionTable.COLUMN_DEVICETAGID, mc.getDevicetagID());
        values.put(NutritionTable.COLUMN_USER, mc.getUser());
        values.put(NutritionTable.COLUMN_APP_VER, mc.getApp_ver());
        values.put(NutritionTable.COLUMN_SYNCED, mc.getSynced());
        values.put(NutritionTable.COLUMN_SYNCEDDATE, mc.getSyncedDate());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;

        newRowId = db.insert(
                NutritionTable.TABLE_NAME,
                NutritionTable.COLUMN_NAME_NULLABLE,
                values);


        return newRowId;
    }

    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                formsTable.COLUMN_ID,
                formsTable.COLUMN_UID,
                formsTable.COLUMN_USERNAME,
                formsTable.COLUMN_FORMDATE,
                formsTable.COLUMN_FORMTYPE,
                formsTable.COLUMN_ISTATUS,
                formsTable.COLUMN_SITENUM,
                formsTable.COLUMN_MRNUM,
                formsTable.COLUMN_MSTUDYID,
                formsTable.COLUMN_PARTICIPANT_NAME,
                formsTable.COLUMN_SINFO,
                formsTable.COLUMN_SRANDOMIZATION,
                formsTable.COLUMN_SBASELINE,
                formsTable.COLUMN_SFUP,
                formsTable.COLUMN_SFUP_TYPE,
                formsTable.COLUMN_DEVICEID,
                formsTable.COLUMN_TAGID,
                formsTable.COLUMN_GPSLAT,
                formsTable.COLUMN_GPSLNG,
                formsTable.COLUMN_GPSTIME,
                formsTable.COLUMN_GPSACC,
                formsTable.COLUMN_SYNCED,
                formsTable.COLUMN_SYNCED_DATE,
                formsTable.COLUMN_APPVER

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                formsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    formsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }
    public Collection<SurveyContract> getAllSurvey() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SurveyTable.COLUMN__ID,
                SurveyTable.COLUMN__UID,
                SurveyTable.COLUMN__UUID,
                SurveyTable.COLUMN_FORMDATE,
                SurveyTable.COLUMN_FORMTYPE,
                SurveyTable.COLUMN_FUPTYPE,
                SurveyTable.COLUMN_USER,
                SurveyTable.COLUMN_SITENUM,
                SurveyTable.COLUMN_MRNUM,
                SurveyTable.COLUMN_MSTUDYID,
                SurveyTable.COLUMN_SF,
                SurveyTable.COLUMN_AQ,
                SurveyTable.COLUMN_DEVICEID,
                SurveyTable.COLUMN_DEVICETAGID,
                SurveyTable.COLUMN_SYNCED,
                SurveyTable.COLUMN_SYNCED_DATE,
                SurveyTable.COLUMN_APPVERSION,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                SurveyTable.COLUMN__ID + " ASC";

        Collection<SurveyContract> allFC = new ArrayList<SurveyContract>();
        try {
            c = db.query(
                    SurveyTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                SurveyContract fc = new SurveyContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {

                formsTable.COLUMN_ID,
                formsTable.COLUMN_UID,
                formsTable.COLUMN_USERNAME,
                formsTable.COLUMN_FORMDATE,
                formsTable.COLUMN_FORMTYPE,
                formsTable.COLUMN_ISTATUS,
                formsTable.COLUMN_SITENUM,
                formsTable.COLUMN_MRNUM,
                formsTable.COLUMN_MSTUDYID,
                formsTable.COLUMN_PARTICIPANT_NAME,
                formsTable.COLUMN_SINFO,
                formsTable.COLUMN_SRANDOMIZATION,
                formsTable.COLUMN_SBASELINE,
                formsTable.COLUMN_SFUP,
                formsTable.COLUMN_SFUP_TYPE,
                formsTable.COLUMN_DEVICEID,
                formsTable.COLUMN_TAGID,
                formsTable.COLUMN_GPSLAT,
                formsTable.COLUMN_GPSLNG,
                formsTable.COLUMN_GPSTIME,
                formsTable.COLUMN_GPSACC,
                formsTable.COLUMN_SYNCED,
                formsTable.COLUMN_SYNCED_DATE,
                formsTable.COLUMN_APPVER
        };
        String whereClause = formsTable.COLUMN_SYNCED + " is null OR " + formsTable.COLUMN_SYNCED + " = ''";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                formsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    formsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }
    public Collection<SurveyContract> getUnsyncedSurvey() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {

                SurveyTable.COLUMN__ID,
                SurveyTable.COLUMN__UID,
                SurveyTable.COLUMN__UUID,
                SurveyTable.COLUMN_FORMDATE,
                SurveyTable.COLUMN_FORMTYPE,
                SurveyTable.COLUMN_FUPTYPE,
                SurveyTable.COLUMN_USER,
                SurveyTable.COLUMN_SITENUM,
                SurveyTable.COLUMN_MRNUM,
                SurveyTable.COLUMN_MSTUDYID,
                SurveyTable.COLUMN_SF,
                SurveyTable.COLUMN_AQ,
                SurveyTable.COLUMN_DEVICEID,
                SurveyTable.COLUMN_DEVICETAGID,
                SurveyTable.COLUMN_SYNCED,
                SurveyTable.COLUMN_SYNCED_DATE,
                SurveyTable.COLUMN_APPVERSION,
        };
        String whereClause = SurveyTable.COLUMN_SYNCED + " is null OR " + SurveyTable.COLUMN_SYNCED + " = ''";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                SurveyTable.COLUMN__ID + " ASC";

        Collection<SurveyContract> allFC = new ArrayList<SurveyContract>();
        try {
            c = db.query(
                    SurveyTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                SurveyContract fc = new SurveyContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }
    public Collection<FetalContract> getUnsyncedFetal() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {

                FetalTable.COLUMN_ID,
                FetalTable.COLUMN__UID,
                FetalTable.COLUMN__UUID,
                FetalTable.COLUMN_USER,
                FetalTable.COLUMN_STUDYID,
                FetalTable.COLUMN_MRNO,
                FetalTable.COLUMN_SITE,
                FetalTable.COLUMN_FORMDATE,
                FetalTable.COLUMN_FORMTYPE,
                FetalTable.COLUMN_FUPTYPE,
                FetalTable.COLUMN_FETAB,
                FetalTable.COLUMN_DEVICEID,
                FetalTable.COLUMN_DEVICETAGID,
                FetalTable.COLUMN_SYNCED,
                FetalTable.COLUMN_SYNCED_DATE,
                FetalTable.COLUMN_APP_VERSION

        };
       /* String whereClause = FormsTable.COLUMN_SYNCED + " is null OR " + FormsTable.COLUMN_SYNCED + " = '' AND "
                + FormsTable.COLUMN_FORMTYPE + " =?";*/
        String whereClause = FetalTable.COLUMN_SYNCED + " is null OR " + FetalTable.COLUMN_SYNCED + "='' AND " + FetalTable.COLUMN_FORMTYPE + " =?";
        String[] whereArgs = new String[]{"2"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FetalTable.COLUMN_ID + " ASC";

        Collection<FetalContract> allFC = new ArrayList<FetalContract>();
        try {
            c = db.query(
                    FetalTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FetalContract fc = new FetalContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<NutritionContract> getUnsyncedNutrition() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                NutritionTable.COLUMN__ID,
                NutritionTable.COLUMN_UID,
                NutritionTable.COLUMN_UUID,
                NutritionTable.COLUMN_FORMDATE,
                NutritionTable.COLUMN_DEVICEID,
                NutritionTable.COLUMN_DEVICETAGID,
                NutritionTable.COLUMN_USER,
                NutritionTable.COLUMN_MRNUM,
                NutritionTable.COLUMN_MSTUDYID,
                NutritionTable.COLUMN_SITENUM,
                NutritionTable.COLUMN_APP_VER,
                NutritionTable.COLUMN_LFITEM,
                NutritionTable.COLUMN_SYNCED,
                NutritionTable.COLUMN_SYNCEDDATE,

        };
        String whereClause = NutritionTable.COLUMN_SYNCED + " is null OR " + NutritionTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                NutritionTable.COLUMN__ID + " ASC";

        Collection<NutritionContract> allFC = new ArrayList<NutritionContract>();
        try {
            c = db.query(
                    NutritionTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                NutritionContract fc = new NutritionContract();
                allFC.add(fc.Hydrate(c, 0));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormsContract> getTodayForms() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                formsTable.COLUMN_ID
        };

        String whereClause = formsTable.COLUMN_FORMDATE + " LIKE ?";
        String[] whereArgs = {spDateT};
        String groupBy = null;
        String having = null;

        String orderBy =
                formsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> formList = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    formsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                formList.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }


        // return contact list
        return formList;
    }

    public int updateSInfo() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_SINFO, AppMain.fc.getsInfo());
        values.put(formsTable.COLUMN_UID, AppMain.fc.getUID());


// Which row to update, based on the ID
        String selection = formsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(formsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateSBaseLine() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_SBASELINE, AppMain.fc.getsBaseline());
        values.put(formsTable.COLUMN_MSTUDYID, AppMain.fc.getmStudyID());


// Which row to update, based on the ID
        String selection = formsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(formsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSRandomization() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_SRANDOMIZATION, AppMain.fc.getsRandomization());

// Which row to update, based on the ID
        String selection = formsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(formsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
    public int updateFETAB() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FetalTable.COLUMN_FETAB, AppMain.fet.getfetab());

// Which row to update, based on the ID
        String selection = FetalTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fet.get_ID())};

        int count = db.update(FetalTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
    public int updateSF() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(SurveyTable.COLUMN_SF, AppMain.sur.getsf());
        // Which row to update, based on the ID
        String selection = SurveyTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.sur.get_ID())};

        int count = db.update(SurveyTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSAQ() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(SurveyTable.COLUMN_AQ, AppMain.sur.getaq());

// Which row to update, based on the ID
        String selection = SurveyTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.sur.get_ID())};

        int count = db.update(SurveyTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
    public int updateSFUP() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_SFUP, AppMain.fc.getSfup());

// Which row to update, based on the ID
        String selection = formsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(formsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateStudyID() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_MSTUDYID, AppMain.fc.getmStudyID());


        // Which row to update, based on the ID
        String selection = formsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(formsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateEnd() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(formsTable.COLUMN_ISTATUS, AppMain.fc.getiStatus());


        // Which row to update, based on the ID
        String selection = formsTable.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(AppMain.fc.getID())};

        int count = db.update(formsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public void addUser(UsersContract userscontract) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(singleUser.ROW_USERNAME, userscontract.getUserName());
            values.put(singleUser.ROW_PASSWORD, userscontract.getPassword());
            db.insert(singleUser.TABLE_NAME, null, values);
            db.close();

        } catch (Exception e) {
        }
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");


                ContentValues values = new ContentValues();

                values.put(singleUser.ROW_USERNAME, userName);
                values.put(singleUser.ROW_PASSWORD, password);
                db.insert(singleUser.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }
    public void syncMotherList(JSONArray motherlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MotherListTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = motherlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectch = jsonArray.getJSONObject(i);

                MotherListContract mlc = new MotherListContract();
                mlc.Sync(jsonObjectch);
                ContentValues values = new ContentValues();
//                values.put(MotherListTable.COLUMN__ID, mlc.get_ID());
                values.put(MotherListTable.COLUMN__UID, mlc.get_UID());
                values.put(MotherListTable.COLUMN__UUID, mlc.get_UUID());
                values.put(MotherListTable.COLUMN_MRNO, mlc.getmrno());
                values.put(MotherListTable.COLUMN_STUDYID, mlc.getstudyid());
                values.put(MotherListTable.COLUMN_MOTHERNAME, mlc.getmothername());

                db.insert(MotherListTable.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
            Log.d(TAG, "sync motherlist(e): " + e);
        } finally {
            db.close();
        }
    }


    public ArrayList<UsersContract> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UsersContract> userList = null;
        try {
            userList = new ArrayList<UsersContract>();
            String QUERY = "SELECT * FROM " + singleUser.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    UsersContract user = new UsersContract();
                    user.setId(cursor.getInt(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + singleUser.TABLE_NAME + " WHERE " + singleUser.ROW_USERNAME + "=? AND " + singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public Collection<HFacilitiesContract> getAllHFacilitiesByTehsil(String tehsil_code) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                HFacilityTable._ID,
                HFacilityTable.COLUMN_HFACILITY_CODE,
                HFacilityTable.COLUMN_HFACILITY_NAME,
                HFacilityTable.COLUMN_TEHSIL_CODE,
        };

        String whereClause = HFacilityTable.COLUMN_TEHSIL_CODE + " = ?";
        String[] whereArgs = {tehsil_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                HFacilityTable._ID + " ASC";

        Collection<HFacilitiesContract> allHFC = new ArrayList<>();
        try {
            c = db.query(
                    HFacilityTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HFacilitiesContract hfc = new HFacilitiesContract();
                allHFC.add(hfc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allHFC;
    }

    public Collection<UCsContract> getAllUCsByTehsil(String tehsil_code) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UcTable._ID,
                UcTable.COLUMN_UC_NAME,
                UcTable.COLUMN_UC_CODE,
                UcTable.COLUMN_TEHSIL_CODE,
        };

        String whereClause = UcTable.COLUMN_TEHSIL_CODE + " = ?";
        String[] whereArgs = {tehsil_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                UcTable._ID + " ASC";

        Collection<UCsContract> allUCsC = new ArrayList<>();
        try {
            c = db.query(
                    UcTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );

            UCsContract uc1 = new UCsContract();
            allUCsC.add(uc1.setDefaultVal("", "..."));

            while (c.moveToNext()) {
                UCsContract ucsc = new UCsContract();
                allUCsC.add(ucsc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allUCsC;
    }

    public Collection<VillagesContract> getAllVillagesByUc(String uc_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VillageTable._ID,
                VillageTable.COLUMN_VILLAGE_CODE,
                VillageTable.COLUMN_VILLAGE_NAME,
                VillageTable.COLUMN_UC_CODE
        };

        String whereClause = VillageTable.COLUMN_UC_CODE + " = ?";
        String[] whereArgs = {uc_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                VillageTable.COLUMN_VILLAGE_CODE + " ASC";

        Collection<VillagesContract> allPC = new ArrayList<VillagesContract>();
        try {
            c = db.query(
                    VillageTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );

            VillagesContract uc1 = new VillagesContract();
            allPC.add(uc1.setDefaultVal("", "..."));

            while (c.moveToNext()) {
                VillagesContract pc = new VillagesContract();
                allPC.add(pc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC;
    }

    public Collection<LHWsContract> getAllLhwsByHf(String hf_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                LHWTable._ID,
                LHWTable.COLUMN_LHW_CODE,
                LHWTable.COLUMN_LHW_NAME,
                LHWTable.COLUMN_HF_CODE,
                LHWTable.COLUMN_AREA_TYPE,
                LHWTable.COLUMN_STATUS
        };

        String whereClause = LHWTable.COLUMN_HF_CODE + " = ?";
        String[] whereArgs = {hf_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                LHWTable.COLUMN_LHW_CODE + " ASC";

        Collection<LHWsContract> allLhwC = new ArrayList<LHWsContract>();
        try {
            c = db.query(
                    LHWTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                LHWsContract lhwc = new LHWsContract();
                allLhwC.add(lhwc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allLhwC;
    }


    public Collection<TehsilsContract> getAllTehsil() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TehsilTable._ID,
                TehsilTable.COLUMN_TEHSIL_CODE,
                TehsilTable.COLUMN_TEHSIL_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                TehsilTable._ID + " ASC";

        Collection<TehsilsContract> allDC = new ArrayList<TehsilsContract>();
        try {
            c = db.query(
                    TehsilTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                TehsilsContract dc = new TehsilsContract();
                allDC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public Collection<VillagesContract> getAllVillage() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VillageTable._ID,
                VillageTable.COLUMN_VILLAGE_CODE,
                VillageTable.COLUMN_VILLAGE_NAME,
                VillageTable.COLUMN_UC_CODE
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                VillageTable._ID + " ASC";

        Collection<VillagesContract> allDC = new ArrayList<VillagesContract>();
        try {
            c = db.query(
                    VillageTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                VillagesContract vc = new VillagesContract();
                allDC.add(vc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public void syncChild(JSONArray childlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PSUsContract.singleChild.TABLE_NAME, null, null);
        Log.d(TAG, "PSU table deleted!");
        try {
            JSONArray jsonArray = childlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String LUID = jsonObjectUser.getString("UID");
                String psu = jsonObjectUser.getString("hh02");
                String hh03 = jsonObjectUser.getString("hh03");
                String hh07 = jsonObjectUser.getString("hh07");
                String child_name = jsonObjectUser.getString("child_name");


                ContentValues values = new ContentValues();

                values.put(singleChild.COLUMN_LUID, LUID);
                values.put(singleChild.COLUMN_HH03, hh03);
                values.put(singleChild.COLUMN_HH07, hh07);
                values.put(singleChild.COLUMN_HH, hh03 + "-" + hh07);
                values.put(singleChild.COLUMN_PSU, psu);
                values.put(singleChild.COLUMN_CHILD_NAME, child_name);

                db.insert(singleChild.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }


    public void syncUc(JSONArray ucList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UcTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = ucList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUc = jsonArray.getJSONObject(i);

                UCsContract dc = new UCsContract();
                dc.sync(jsonObjectUc);

                ContentValues values = new ContentValues();

                values.put(UcTable.COLUMN_UC_CODE, dc.getUcCode());
                values.put(UcTable.COLUMN_UC_NAME, dc.getUcName());
                values.put(UcTable.COLUMN_TEHSIL_CODE, dc.getTehsilCode());

                db.insert(UcTable.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            Log.e(TAG, "syncUc: " + e.toString());
        }
    }

    public void syncSources(JSONArray ucList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SourceTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = ucList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUc = jsonArray.getJSONObject(i);

                SourceNGOContract dc = new SourceNGOContract();
                dc.sync(jsonObjectUc);

                ContentValues values = new ContentValues();

                values.put(SourceTable.COLUMN_SOURCE_CODE, dc.getSourceCode());
                values.put(SourceTable.COLUMN_SOURCE_NAME, dc.getSourceName());

                db.insert(SourceTable.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            Log.e(TAG, "syncUc: " + e.toString());
        }
    }


    public void syncTehsil(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TehsilTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectTehsil = jsonArray.getJSONObject(i);

                TehsilsContract pc = new TehsilsContract();
                pc.sync(jsonObjectTehsil);

                ContentValues values = new ContentValues();

                values.put(TehsilTable.COLUMN_TEHSIL_CODE, pc.getTehsil_code());
                values.put(TehsilTable.COLUMN_TEHSIL_NAME, pc.getTehsil_name());

                db.insert(TehsilTable.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncHFacility(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(HFacilityTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectHFacility = jsonArray.getJSONObject(i);

                HFacilitiesContract hc = new HFacilitiesContract();
                hc.sync(jsonObjectHFacility);

                ContentValues values = new ContentValues();

                values.put(HFacilityTable.COLUMN_HFACILITY_CODE, hc.gethFacilityCode());
                values.put(HFacilityTable.COLUMN_HFACILITY_NAME, hc.gethFacilityName());
                values.put(HFacilityTable.COLUMN_TEHSIL_CODE, hc.getTehsilCode());

                db.insert(HFacilityTable.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }


    public void syncVillages(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VillageTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectVillage = jsonArray.getJSONObject(i);

                VillagesContract vc = new VillagesContract();
                vc.sync(jsonObjectVillage);

                ContentValues values = new ContentValues();

                values.put(VillageTable.COLUMN_VILLAGE_CODE, vc.getVillageCode());
                values.put(VillageTable.COLUMN_VILLAGE_NAME, vc.getVillageName());
                values.put(VillageTable.COLUMN_UC_CODE, vc.getUcCode());

                db.insert(VillageTable.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncLHW(JSONArray lcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LHWsContract.LHWTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = lcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectLHW = jsonArray.getJSONObject(i);

                LHWsContract lc = new LHWsContract();
                lc.sync(jsonObjectLHW);

                ContentValues values = new ContentValues();

                values.put(LHWTable.COLUMN_LHW_CODE, lc.getLHWCode());
                values.put(LHWTable.COLUMN_LHW_NAME, lc.getLHWName());
                values.put(LHWTable.COLUMN_AREA_TYPE, lc.getAreaType());
                values.put(LHWTable.COLUMN_HF_CODE, lc.getHfCode());
                values.put(LHWTable.COLUMN_STATUS, lc.getStatus());

                db.insert(LHWTable.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }


    public ArrayList<PSUsContract> getAllChildren() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<PSUsContract> childList = null;
        try {
            childList = new ArrayList<PSUsContract>();
            String QUERY = "SELECT * FROM " + singleChild.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    PSUsContract child = new PSUsContract(cursor);

                    childList.add(child);

                }
            }
            db.close();
        } catch (Exception e) {
        }
        return childList;
    }

    public String getChildByHH(String hh, String psu) {
        SQLiteDatabase db = this.getReadableDatabase();
        PSUsContract child = null;
        try {
            String QUERY = "SELECT * FROM " + singleChild.TABLE_NAME
                    + " where " + singleChild.COLUMN_HH + " = '" + hh.toUpperCase().replaceFirst("^0+(?!$)", "") + "' and " + singleChild.COLUMN_PSU + " = '" + psu + "' Limit 1";
            Cursor cursor = db.rawQuery(QUERY, null);
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    child = new PSUsContract(cursor);
                    return child.getChild_name();

                }
            } else {
                return "No Child Found";
            }
            db.close();
        } catch (Exception e) {
        }
        return "No Child Found";
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"mesage"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }
    public boolean isMotherFound(String mrno, String studyid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int count = 0;
        try {
            String query = "SELECT * FROM " + MotherListTable.TABLE_NAME + " WHERE " + MotherListTable.COLUMN_MRNO + " = ? AND " + MotherListTable.COLUMN_STUDYID + " =? ";
            cursor = db.rawQuery(
                    query,
                    new String[]{String.valueOf(mrno), String.valueOf(studyid)}
            );

            count = cursor.getCount();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return count > 0;
    }
    public boolean checkMotherDublicate(String studyid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        int count = 0;
        try {
            String query = "SELECT * FROM " + MotherListTable.TABLE_NAME + " WHERE " + MotherListTable.COLUMN_STUDYID + " =? ";
            cursor = db.rawQuery(
                    query,
                    new String[]{String.valueOf(studyid)}
            );

            count = cursor.getCount();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return count > 0;
    }

}