package edu.aku.hassannaqvi.leap1_baseline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import edu.aku.hassannaqvi.leap1_baseline.core.AppMain;

/**
 * Created by hassan.naqvi on 10/25/2016.
 */

public class FormsContract {

    private String projectName = "LEAP1 - Baseline";
    private String appVer = AppMain.versionName + "." + AppMain.versionCode;
    private String userName = "";
    private String ID = "";
    private String UID = "";
    private String formDate = ""; // Date
    private String formType = "";
    private String iStatus = ""; // Form Status
    private String tagId = "";
    private String sInfo = "";
    private String sRandomization = "";
    private String sBaseline = "";
    private String sSF = "";
    private String sAQ = "";
    private String studyID = "";
    private String MstudyID = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsTime = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String synced = "";
    private String synced_date = "";

    public FormsContract() {
    }

    public FormsContract sync(JSONObject jsonObject) throws JSONException {
        this.projectName = jsonObject.getString(singleForm.COLUMN_PROJECT_NAME);
        this.ID = jsonObject.getString(singleForm.COLUMN_ID);
        this.UID = jsonObject.getString(singleForm.COLUMN_UID);
        this.formDate = jsonObject.getString(singleForm.COLUMN_FORMDATE);
        this.iStatus = jsonObject.getString(singleForm.COLUMN_ISTATUS);
        this.userName = jsonObject.getString(singleForm.COLUMN_NAME_USERNAME);
        this.tagId = jsonObject.getString(singleForm.COLUMN_DEVICETAGID);
        this.appVer = jsonObject.getString(singleForm.COLUMN_APPVER);
        this.studyID = jsonObject.getString(singleForm.COLUMN_STUDYID);
        this.MstudyID = jsonObject.getString(singleForm.COLUMN_MSTUDYID);
        this.formType = jsonObject.getString(singleForm.COLUMN_FORMTYPE);
        this.sInfo = jsonObject.getString(singleForm.COLUMN_INFO);
        this.sRandomization = jsonObject.getString(singleForm.COLUMN_RANDOMIZATION);
        this.sBaseline = jsonObject.getString(singleForm.COLUMN_BASELINE);
        this.sSF = jsonObject.getString(singleForm.COLUMN_SF);
        this.sAQ = jsonObject.getString(singleForm.COLUMN_AQ);
        this.gpsLat = jsonObject.getString(singleForm.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(singleForm.COLUMN_GPSLNG);
        this.gpsTime = jsonObject.getString(singleForm.COLUMN_GPSTIME);
        this.gpsAcc = jsonObject.getString(singleForm.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(singleForm.COLUMN_DEVICEID);
        this.synced = jsonObject.getString(singleForm.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(singleForm.COLUMN_SYNCED_DATE);


        return this;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }

    public String getsRandomization() {
        return sRandomization;
    }

    public void setsRandomization(String sRandomization) {
        this.sRandomization = sRandomization;
    }

    public String getsBaseline() {
        return sBaseline;
    }

    public void setsBaseline(String sBaseline) {
        this.sBaseline = sBaseline;
    }

    public String getsSF() {
        return sSF;
    }

    public void setsSF(String sSF) {
        this.sSF = sSF;
    }

    public String getsAQ() {
        return sAQ;
    }

    public void setsAQ(String sAQ) {
        this.sAQ = sAQ;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getAppVer() {

        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
    }

    public String getMstudyID() {
        return MstudyID;
    }

    public void setMstudyID(String mstudyID) {
        MstudyID = mstudyID;
    }

    public String getTagId() {

        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }


    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }


    public String getStudyID() {
        return studyID;
    }

    public void setStudyID(String studyID) {
        this.studyID = studyID;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
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

    public FormsContract hydrate(Cursor cursor) {
        this.projectName = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_PROJECT_NAME));
        this.ID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_FORMDATE));
        this.iStatus = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_ISTATUS));
        this.userName = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_NAME_USERNAME));
        this.tagId = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_DEVICETAGID));
        this.appVer = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_APPVER));
        this.studyID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_STUDYID));
        this.MstudyID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_MSTUDYID));
        this.formType = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_FORMTYPE));


        this.sInfo = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_INFO));
        this.sRandomization = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_RANDOMIZATION));
        this.sBaseline = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_BASELINE));
        this.sSF = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SF));
        this.sAQ = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_AQ));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSLNG));
        this.gpsTime = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSTIME));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_DEVICEID));
        this.synced = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(singleForm.COLUMN_SYNCED_DATE));


        return this;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(singleForm.COLUMN_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(singleForm.COLUMN_ID, this.ID == null ? JSONObject.NULL : this.ID);
        json.put(singleForm.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(singleForm.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(singleForm.COLUMN_ISTATUS, this.iStatus == null ? JSONObject.NULL : this.iStatus);
        json.put(singleForm.COLUMN_NAME_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
        json.put(singleForm.COLUMN_DEVICETAGID, this.tagId == null ? JSONObject.NULL : this.tagId);
        json.put(singleForm.COLUMN_STUDYID, this.studyID == null ? JSONObject.NULL : this.studyID);
        json.put(singleForm.COLUMN_MSTUDYID, this.MstudyID == null ? JSONObject.NULL : this.MstudyID);
        json.put(singleForm.COLUMN_APPVER, this.appVer == null ? JSONObject.NULL : this.appVer);
        json.put(singleForm.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);
        json.put(singleForm.COLUMN_INFO, this.sInfo == null ? JSONObject.NULL : this.sInfo);
        json.put(singleForm.COLUMN_RANDOMIZATION, this.sRandomization == null ? JSONObject.NULL : this.sRandomization);
        json.put(singleForm.COLUMN_BASELINE, this.sBaseline == null ? JSONObject.NULL : this.sBaseline);
        json.put(singleForm.COLUMN_SF, this.sSF == null ? JSONObject.NULL : this.sSF);
        json.put(singleForm.COLUMN_AQ, this.sAQ == null ? JSONObject.NULL : this.sAQ);
        json.put(singleForm.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(singleForm.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(singleForm.COLUMN_GPSTIME, this.gpsTime == null ? JSONObject.NULL : this.gpsTime);
        json.put(singleForm.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(singleForm.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(singleForm.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(singleForm.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);

        return json;
    }

    public JSONObject jsonMerge(JSONObject o1, JSONObject o2) throws JSONException {

        JSONObject jm = new JSONObject();

        //I assume that your two JSONObjects are o1 and o2
        JSONObject mergedObj = new JSONObject();

        Iterator i1 = o1.keys();
        Iterator i2 = o2.keys();
        String tmp_key;
        while (i1.hasNext()) {
            tmp_key = (String) i1.next();
            mergedObj.put(tmp_key, o1.get(tmp_key));
        }
        while (i2.hasNext()) {
            tmp_key = (String) i2.next();
            mergedObj.put(tmp_key, o2.get(tmp_key));
        }

        return mergedObj;
    }

    public static abstract class singleForm implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String URI = "/syncblforms.php";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectname";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_FORMTYPE = "formtype";
        public static final String COLUMN_INFO = "sinfo";
        public static final String COLUMN_RANDOMIZATION = "srandomization";
        public static final String COLUMN_BASELINE = "sbaseline";
        public static final String COLUMN_SF = "ssf";
        public static final String COLUMN_AQ = "saq";
        public static final String COLUMN_STUDYID = "studyID";
        public static final String COLUMN_MSTUDYID = "mstudyID";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSTIME = "gpstime";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagId";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVER = "appver";

    }
}


