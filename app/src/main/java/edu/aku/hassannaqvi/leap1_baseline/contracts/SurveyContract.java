package edu.aku.hassannaqvi.leap1_baseline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class SurveyContract {

    private final String projectName = "LEAP 1";
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String formDate = "";
    private String formType = "";
    private String fupType = "";
    private String user = "";
    private String siteNum = "";
    private String mrNum = "";
    private String mStudyID = "";
    private String sf = "";
    private String aq = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appVersion = "";

    public SurveyContract() {
    }

    public String getprojectName() {
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

    public String getformDate() {
        return formDate;
    }

    public void setformDate(String formDate) {
        this.formDate = formDate;
    }

    public String getformType() {
        return formType;
    }

    public void setformType(String formType) {
        this.formType = formType;
    }

    public String getfupType() {
        return fupType;
    }

    public void setfupType(String fupType) {
        this.fupType = fupType;
    }

    public String getuser() {
        return user;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public String getsiteNum() {
        return siteNum;
    }

    public void setsiteNum(String siteNum) {
        this.siteNum = siteNum;
    }

    public String getmrNum() {
        return mrNum;
    }

    public void setmrNum(String mrNum) {
        this.mrNum = mrNum;
    }

    public String getmStudyID() {
        return mStudyID;
    }

    public void setmStudyID(String mStudyID) {
        this.mStudyID = mStudyID;
    }

    public String getsf() {
        return sf;
    }

    public void setsf(String sf) {
        this.sf = sf;
    }

    public String getaq() {
        return aq;
    }

    public void setaq(String aq) {
        this.aq = aq;
    }

    public String getdeviceID() {
        return deviceID;
    }

    public void setdeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getdevicetagID() {
        return devicetagID;
    }

    public void setdevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getsynced() {
        return synced;
    }

    public void setsynced(String synced) {
        this.synced = synced;
    }

    public String getsynced_date() {
        return synced_date;
    }

    public void setsynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getappVersion() {
        return appVersion;
    }

    public void setappVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public SurveyContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(SurveyTable.COLUMN__ID );
        this._UID = jsonObject.getString(SurveyTable.COLUMN__UID );
        this._UUID= jsonObject.getString(SurveyTable.COLUMN__UUID);
        this.formDate= jsonObject.getString(SurveyTable.COLUMN_FORMDATE);
        this.formType= jsonObject.getString(SurveyTable.COLUMN_FORMTYPE);
        this.fupType= jsonObject.getString(SurveyTable.COLUMN_FUPTYPE);
        this.user= jsonObject.getString(SurveyTable.COLUMN_USER);
        this.siteNum= jsonObject.getString(SurveyTable.COLUMN_SITENUM);
        this.mrNum= jsonObject.getString(SurveyTable.COLUMN_MRNUM);
        this.mStudyID= jsonObject.getString(SurveyTable.COLUMN_MSTUDYID);
        this.sf= jsonObject.getString(SurveyTable.COLUMN_SF);
        this.aq= jsonObject.getString(SurveyTable.COLUMN_AQ);
        this.deviceID = jsonObject.getString(SurveyTable.COLUMN_DEVICEID );
        this.devicetagID = jsonObject.getString(SurveyTable.COLUMN_DEVICETAGID );
        this.synced = jsonObject.getString(SurveyTable.COLUMN_SYNCED );
        this.synced_date = jsonObject.getString(SurveyTable.COLUMN_SYNCED_DATE );
        this.appVersion= jsonObject.getString(SurveyTable.COLUMN_APPVERSION);

        return this;

    }

    public SurveyContract Hydrate(Cursor cursor) {

        this._ID  = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN__ID ));
        this._UID  = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN__UID ));
        this._UUID = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN__UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_FORMDATE));
        this.formType = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_FORMTYPE));
        this.fupType = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_FUPTYPE));
        this.user = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_USER));
        this.siteNum = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_SITENUM));
        this.mrNum = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_MRNUM));
        this.mStudyID = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_MSTUDYID));
        this.sf = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_SF));
        this.aq = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_AQ));
        this.deviceID  = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_DEVICEID ));
        this.devicetagID  = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_DEVICETAGID ));
        this.synced  = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_SYNCED ));
        this.synced_date  = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_SYNCED_DATE ));
        this.appVersion = cursor.getString(cursor.getColumnIndex(SurveyTable.COLUMN_APPVERSION));


        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(SurveyTable.COLUMN__ID , this._ID  == null ? JSONObject.NULL : this._ID );
        json.put(SurveyTable.COLUMN__UID , this._UID  == null ? JSONObject.NULL : this._UID );
        json.put(SurveyTable.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SurveyTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SurveyTable.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);
        json.put(SurveyTable.COLUMN_FUPTYPE, this.fupType == null ? JSONObject.NULL : this.fupType);
        json.put(SurveyTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(SurveyTable.COLUMN_SITENUM, this.siteNum == null ? JSONObject.NULL : this.siteNum);
        json.put(SurveyTable.COLUMN_MRNUM, this.mrNum == null ? JSONObject.NULL : this.mrNum);
        json.put(SurveyTable.COLUMN_MSTUDYID, this.mStudyID == null ? JSONObject.NULL : this.mStudyID);
        if (!this.sf.equals("")) {
            json.put(SurveyTable.COLUMN_SF, this.sf.equals("") ? JSONObject.NULL :  new JSONObject(this.sf));
        }
        if (!this.aq.equals("")) {
            json.put(SurveyTable.COLUMN_AQ, this.aq.equals("") ? JSONObject.NULL : new JSONObject(this.aq));
        }
        json.put(SurveyTable.COLUMN_DEVICEID , this.deviceID  == null ? JSONObject.NULL : this.deviceID );
        json.put(SurveyTable.COLUMN_DEVICETAGID , this.devicetagID  == null ? JSONObject.NULL : this.devicetagID );
        json.put(SurveyTable.COLUMN_SYNCED , this.synced  == null ? JSONObject.NULL : this.synced );
        json.put(SurveyTable.COLUMN_SYNCED_DATE , this.synced_date  == null ? JSONObject.NULL : this.synced_date );
        json.put(SurveyTable.COLUMN_APPVERSION, this.appVersion == null ? JSONObject.NULL : this.appVersion);
        return json;
    }

    public static abstract class SurveyTable implements BaseColumns {

        public static final String TABLE_NAME = "survey";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN__ID  = "_id";
        public static final String COLUMN__UID  = "_uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_FORMTYPE = "formtype";
        public static final String COLUMN_FUPTYPE = "fuptype";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SITENUM = "sitenum";
        public static final String COLUMN_MRNUM = "mrnum";
        public static final String COLUMN_MSTUDYID = "mstudyid";
        public static final String COLUMN_SF = "sf";
        public static final String COLUMN_AQ = "aq";
        public static final String COLUMN_DEVICEID  = "deviceid";
        public static final String COLUMN_DEVICETAGID  = "devicetagid";
        public static final String COLUMN_SYNCED  = "synced";
        public static final String COLUMN_SYNCED_DATE  = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";



        public static String _URL = "survey.php";
    }
}
