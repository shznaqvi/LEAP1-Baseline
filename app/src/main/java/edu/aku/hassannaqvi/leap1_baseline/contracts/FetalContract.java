package edu.aku.hassannaqvi.leap1_baseline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class FetalContract {
    private final String projectName = "Leap1";
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String studyid = "";
    private String mrno = "";
    private String site = "";
    private String formType = "";
    private String fupType = "";
    private String fetab = ""; //fetal abnormality
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String app_version = "";

    public FetalContract() {
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getstudyid() {
        return studyid;
    }

    public void setstudyid(String studyid) {
        this.studyid = studyid;
    }

    public String getmrno() {
        return mrno;
    }

    public void setmrno(String mrno) {
        this.mrno = mrno;
    }

    public String getsite() {
        return site;
    }

    public void setsite(String site) {
        this.site = site;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getfupType() {
        return fupType;
    }

    public void setfupType(String fupType) {
        this.fupType = fupType;
    }

    public String getfetab() {
        return fetab;
    }

    public void setfetab(String fetab) {
        this.fetab = fetab;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public FetalContract Sync(JSONObject jsonObject) throws JSONException {


        this._ID = jsonObject.getString(FetalTable.COLUMN_ID);
        this._UID = jsonObject.getString(FetalTable.COLUMN__UID);
        this._UUID = jsonObject.getString(FetalTable.COLUMN__UUID);
        this.user = jsonObject.getString(FetalTable.COLUMN_USER);
        this.studyid = jsonObject.getString(FetalTable.COLUMN_STUDYID);
        this.mrno = jsonObject.getString(FetalTable.COLUMN_MRNO);
        this.site = jsonObject.getString(FetalTable.COLUMN_SITE);
        this.formDate = jsonObject.getString(FetalTable.COLUMN_FORMDATE);
        this.formType = jsonObject.getString(FetalTable.COLUMN_FORMTYPE);
        this.fupType = jsonObject.getString(FetalTable.COLUMN_FUPTYPE);
        this.fetab = jsonObject.getString(FetalTable.COLUMN_FETAB);
        this.deviceID = jsonObject.getString(FetalTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FetalTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FetalTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FetalTable.COLUMN_SYNCED_DATE);
        this.app_version = jsonObject.getString(FetalTable.COLUMN_APP_VERSION);


        return this;

    }

    public FetalContract Hydrate(Cursor cursor) {


        this._ID = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN__UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN__UUID));
        this.user = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_USER));
        this.studyid = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_STUDYID));
        this.mrno = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_MRNO));
        this.site= cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_SITE));
        this.formDate = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_FORMDATE));
        this.formType = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_FORMTYPE));
        this.fupType = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_FUPTYPE));
        this.fetab = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_FETAB));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_SYNCED_DATE));
        this.app_version = cursor.getString(cursor.getColumnIndex(FetalTable.COLUMN_APP_VERSION));


        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FetalTable.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(FetalTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FetalTable.COLUMN__UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FetalTable.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(FetalTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FetalTable.COLUMN_STUDYID, this.studyid == null ? JSONObject.NULL : this.studyid);
        json.put(FetalTable.COLUMN_MRNO, this.mrno == null ? JSONObject.NULL : this.mrno);
        json.put(FetalTable.COLUMN_SITE, this.site == null ? JSONObject.NULL : this.site);
        json.put(FetalTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FetalTable.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);
        json.put(FetalTable.COLUMN_FUPTYPE, this.fupType == null ? JSONObject.NULL : this.fupType);
        if (!this.fetab.equals("")) {
            json.put(FetalTable.COLUMN_FETAB, this.fetab == null ? JSONObject.NULL : new JSONObject(this.fetab));
        }

        json.put(FetalTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FetalTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FetalTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FetalTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(FetalTable.COLUMN_APP_VERSION, this.app_version == null ? JSONObject.NULL : this.app_version);

        return json;
    }

    public static abstract class FetalTable implements BaseColumns
    {

        public static final String TABLE_NAME = "fetal";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN__UID = "_uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_STUDYID = "studyid";
        public static final String COLUMN_MRNO = "mrno";
        public static final String COLUMN_SITE = "site";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_FORMTYPE = "formtype";
        public static final String COLUMN_FUPTYPE = "fuptype";
        public static final String COLUMN_FETAB = "fetab";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";

        public static final String COLUMN_APP_VERSION = "app_version";

        public static String _URL = "fetal.php";
    }

}
