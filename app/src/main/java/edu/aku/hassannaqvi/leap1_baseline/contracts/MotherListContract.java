package edu.aku.hassannaqvi.leap1_baseline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class MotherListContract {
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String mrno = "";
    private String studyid = "";
    private String mothername = "";

    public MotherListContract() {
    }

    public MotherListContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID= jsonObject.getString(MotherListTable.COLUMN__ID);
        this._UID= jsonObject.getString(MotherListTable.COLUMN__UID);
        this._UUID= jsonObject.getString(MotherListTable.COLUMN__UUID);
        this.mrno= jsonObject.getString(MotherListTable.COLUMN_MRNO);
        this.studyid= jsonObject.getString(MotherListTable.COLUMN_STUDYID);
        this.mothername= jsonObject.getString(MotherListTable.COLUMN_MOTHERNAME);

        return this;
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

    public String getmrno() {
        return mrno;
    }

    public void setmrno(String mrno) {
        this.mrno = mrno;
    }

    public String getstudyid() {
        return studyid;
    }

    public void setstudyid(String studyid) {
        this.studyid = studyid;
    }

    public String getmothername() {
        return mothername;
    }

    public void setmothername(String mothername) {
        this.mothername = mothername;
    }

    public MotherListContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(MotherListTable.COLUMN__ID));
        this._UID = cursor.getString(cursor.getColumnIndex(MotherListTable.COLUMN__UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(MotherListTable.COLUMN__UUID));
        this.mrno = cursor.getString(cursor.getColumnIndex(MotherListTable.COLUMN_MRNO));
        this.studyid = cursor.getString(cursor.getColumnIndex(MotherListTable.COLUMN_STUDYID));
        this.mothername = cursor.getString(cursor.getColumnIndex(MotherListTable.COLUMN_MOTHERNAME));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(MotherListTable.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(MotherListTable.COLUMN__UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(MotherListTable.COLUMN__UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(MotherListTable.COLUMN_MRNO, this.mrno == null ? JSONObject.NULL : this.mrno);
        json.put(MotherListTable.COLUMN_STUDYID, this.studyid == null ? JSONObject.NULL : this.studyid);
        json.put(MotherListTable.COLUMN_MOTHERNAME, this.mothername == null ? JSONObject.NULL : this.mothername);


        return json;
    }


    public static abstract class MotherListTable implements BaseColumns {

        public static final String TABLE_NAME = "motherlist";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN__UID = "_uid";
        public static final String COLUMN__UUID = "_uuid";
        public static final String COLUMN_MRNO = "mrno";
        public static final String COLUMN_STUDYID = "studyid";
        public static final String COLUMN_MOTHERNAME = "mothername";



        public static String _URL = "motherlist.php";

    }

}
