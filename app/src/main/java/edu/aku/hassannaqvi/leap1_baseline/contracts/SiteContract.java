package edu.aku.hassannaqvi.leap1_baseline.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class SiteContract {
    int id;
    String sitenum;
    String sitename;


    public SiteContract sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getInt(TehsilsContract.TehsilTable.COLUMN_TEHSIL_CODE);
        this.sitenum = jsonObject.getString(TehsilsContract.TehsilTable.COLUMN_TEHSIL_NAME);
        this.sitename = jsonObject.getString(TehsilsContract.TehsilTable.COLUMN_TEHSIL_NAME);

        return this;
    }

    public SiteContract hydrate(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex(TehsilsContract.TehsilTable.COLUMN_TEHSIL_CODE));
        this.sitenum = cursor.getString(cursor.getColumnIndex(TehsilsContract.TehsilTable.COLUMN_TEHSIL_NAME));
        this.sitename = cursor.getString(cursor.getColumnIndex(TehsilsContract.TehsilTable.COLUMN_TEHSIL_NAME));

        return this;
    }

    public abstract class SiteTable implements BaseColumns {
        public static final String TABLE_NAME = "site";
        public static final String URI = "/getsite.php";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";

        public static final String _ID = "_ID";
        public static final String COLUMN_SITE_NUM = "sitenum";
        public static final String COLUMN_SITE_NAME = "sitename";

    }
}
