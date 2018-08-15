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
    private String UUID = "";
    private String formDate = ""; // Date
    private String formType = "";
    private String iStatus = ""; // Form Status
    private String siteNum = "";
    private String mrNum = "";
    private String mStudyID = "";
    private String enrolmentdt = "";
    private String participantName = "";
    private String sInfo = "";
    private String sRandomization = "";
    private String sBaseline = "";
    private String sfup = "";
    private String sfuptype = "";
    private String isel = "";
    private String seot = "";
    private String deviceID = "";
    private String tagID = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsTime = "";
    private String gpsAcc = "";
    private String synced = "";
    private String synced_date = "";

    public FormsContract() {
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getAppVer() {
        return appVer;
    }

    public void setAppVer(String appVer) {
        this.appVer = appVer;
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

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum;
    }

    public String getMrNum() {
        return mrNum;
    }

    public void setMrNum(String mrNum) {
        this.mrNum = mrNum;
    }

    public String getmStudyID() {
        return mStudyID;
    }

    public void setmStudyID(String mStudyID) {
        this.mStudyID = mStudyID;
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

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getTagID() {
        return tagID;
    }

    public void setTagID(String tagID) {
        this.tagID = tagID;
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

    public String getenrolmentdt() {
        return enrolmentdt;
    }

    public void setenrolmentdt(String enrolmentdt) {
        this.enrolmentdt = enrolmentdt;
    }

    public String getSfup() {
        return sfup;
    }

    public void setSfup(String sfup) {
        this.sfup = sfup;
    }

    public String getSfuptype() {
        return sfuptype;
    }

    public void setSfuptype(String sfuptype) {
        this.sfuptype = sfuptype;
    }

    public String getisel() {
        return isel;
    }

    public void setisel(String isel) {
        this.isel = isel;
    }

    public String getseot() {
        return seot;
    }

    public void setseot(String seot) {
        this.seot = seot;
    }

    public FormsContract sync(JSONObject jsonObject) throws JSONException {

        this.ID = jsonObject.getString(formsTable.COLUMN_ID);
        this.UID = jsonObject.getString(formsTable.COLUMN_UID);
        this.UUID = jsonObject.getString(formsTable.COLUMN_UUID);
        this.userName = jsonObject.getString(formsTable.COLUMN_USERNAME);
        this.formDate = jsonObject.getString(formsTable.COLUMN_FORMDATE);
        this.formType = jsonObject.getString(formsTable.COLUMN_FORMTYPE);
        this.iStatus = jsonObject.getString(formsTable.COLUMN_ISTATUS);
        this.siteNum = jsonObject.getString(formsTable.COLUMN_SITENUM);
        this.mrNum = jsonObject.getString(formsTable.COLUMN_MRNUM);
        this.mStudyID = jsonObject.getString(formsTable.COLUMN_MSTUDYID);
        this.enrolmentdt = jsonObject.getString(formsTable.COLUMN_ENROLDATE);
        this.participantName = jsonObject.getString(formsTable.COLUMN_PARTICIPANT_NAME);
        this.sInfo = jsonObject.getString(formsTable.COLUMN_SINFO);
        this.sRandomization = jsonObject.getString(formsTable.COLUMN_SRANDOMIZATION);
        this.sBaseline = jsonObject.getString(formsTable.COLUMN_SBASELINE);
        this.sfup = jsonObject.getString(formsTable.COLUMN_SFUP);
        this.sfuptype = jsonObject.getString(formsTable.COLUMN_SFUP_TYPE);
        this.isel = jsonObject.getString(formsTable.COLUMN_ISEl);
        this.seot = jsonObject.getString(formsTable.COLUMN_SEOT);
        this.deviceID = jsonObject.getString(formsTable.COLUMN_DEVICEID);
        this.tagID = jsonObject.getString(formsTable.COLUMN_TAGID);
        this.gpsLat = jsonObject.getString(formsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(formsTable.COLUMN_GPSLNG);
        this.gpsTime = jsonObject.getString(formsTable.COLUMN_GPSTIME);
        this.gpsAcc = jsonObject.getString(formsTable.COLUMN_GPSACC);
        this.synced = jsonObject.getString(formsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(formsTable.COLUMN_SYNCED_DATE);


        return this;
    }

    public FormsContract hydrate(Cursor cursor) {

        this.ID = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_UID));
        this.UUID = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_UUID));
        this.userName = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_USERNAME));
        this.formDate = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_FORMDATE));
        this.formType = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_FORMTYPE));
        this.iStatus = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_ISTATUS));
        this.siteNum = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SITENUM));
        this.mrNum = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_MRNUM));
        this.mStudyID = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_MSTUDYID));
        this.enrolmentdt = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_ENROLDATE));
        this.participantName = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_PARTICIPANT_NAME));
        this.sInfo = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SINFO));
        this.sRandomization = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SRANDOMIZATION));
        this.sBaseline = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SBASELINE));
        this.sfup = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SFUP));
        this.sfuptype = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SFUP_TYPE));
        this.seot = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SEOT));
        this.isel = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_ISEl));
        this.deviceID = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_DEVICEID));
        this.tagID = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_TAGID));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_GPSLNG));
        this.gpsTime = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_GPSTIME));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_GPSACC));
        this.synced = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(formsTable.COLUMN_SYNCED_DATE));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(formsTable.COLUMN_ID, this.ID == null ? JSONObject.NULL : this.ID);
        json.put(formsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(formsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(formsTable.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(formsTable.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(formsTable.COLUMN_UUID, this.UUID == null ? JSONObject.NULL : this.UUID);
        json.put(formsTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
        json.put(formsTable.COLUMN_FORMTYPE, this.formType == null ? JSONObject.NULL : this.formType);
        json.put(formsTable.COLUMN_ISTATUS, this.iStatus == null ? JSONObject.NULL : this.iStatus);
        json.put(formsTable.COLUMN_SITENUM, this.siteNum == null ? JSONObject.NULL : this.siteNum);
        json.put(formsTable.COLUMN_MRNUM, this.mrNum == null ? JSONObject.NULL : this.mrNum);
        json.put(formsTable.COLUMN_MSTUDYID, this.mStudyID == null ? JSONObject.NULL : this.mStudyID);
        json.put(formsTable.COLUMN_ENROLDATE, this.enrolmentdt == null ? JSONObject.NULL : this.enrolmentdt);
        json.put(formsTable.COLUMN_PARTICIPANT_NAME, this.participantName == null ? JSONObject.NULL : this.participantName);
        if (!this.sInfo.equals("")) {

            json.put(formsTable.COLUMN_SINFO, this.sInfo.equals("") ? JSONObject.NULL : new JSONObject(this.sInfo));
        }
        if (!this.sRandomization.equals("")) {

            json.put(formsTable.COLUMN_SRANDOMIZATION, this.sRandomization.equals("") ? JSONObject.NULL : new JSONObject(this.sRandomization));
        }
        if (!this.sBaseline.equals("")) {

            json.put(formsTable.COLUMN_SBASELINE, this.sBaseline.equals("") ? JSONObject.NULL : new JSONObject(this.sBaseline));
        }
        if (!this.sfup.equals("")) {

            json.put(formsTable.COLUMN_SFUP, this.sfup.equals("") ? JSONObject.NULL : new JSONObject(this.sfup));
        }
        if (!this.seot.equals("")) {
            json.put(formsTable.COLUMN_SEOT, this.seot.equals("") ? JSONObject.NULL : new JSONObject(this.seot));
        }
        if (!this.isel.equals("")) {
            json.put(formsTable.COLUMN_ISEl, this.isel.equals("") ? JSONObject.NULL : this.isel);
        }
        json.put(formsTable.COLUMN_SFUP_TYPE, this.sfuptype == null ? JSONObject.NULL : this.sfuptype);
        json.put(formsTable.COLUMN_TAGID, this.tagID == null ? JSONObject.NULL : this.tagID);
        json.put(formsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(formsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(formsTable.COLUMN_GPSTIME, this.gpsTime == null ? JSONObject.NULL : this.gpsTime);
        json.put(formsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(formsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(formsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(formsTable.COLUMN_APPVER, this.appVer == null ? JSONObject.NULL : this.appVer);

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

    public static abstract class formsTable implements BaseColumns
    {

        public static final String TABLE_NAME = "forms";
        public static final String URI = "forms.php";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_FORMTYPE = "formtype";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_SITENUM = "sitenum";
        public static final String COLUMN_MRNUM = "mrnum";
        public static final String COLUMN_MSTUDYID = "mstudyid";
        public static final String COLUMN_ENROLDATE = "enrolmentdt";
        public static final String COLUMN_PARTICIPANT_NAME = "participantname";
        public static final String COLUMN_SINFO = "sinfo";
        public static final String COLUMN_SRANDOMIZATION = "srandomization";
        public static final String COLUMN_SBASELINE = "sbaseline";
        public static final String COLUMN_SFUP = "sfup";
        public static final String COLUMN_ISEl = "isel";
        public static final String COLUMN_SEOT = "seot";
        public static final String COLUMN_SFUP_TYPE = "sfuptype";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_TAGID = "tagid";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSTIME = "gpstime";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVER = "appver";

    }
}


