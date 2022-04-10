package com.example.contactbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_contacts_list";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "tbl_contacts_list";

    private static final String ID_COL = "contact_id";
    private static final String NAME_COL = "name";
    private static final String PHONE_COL = "phone";
    private static final String EMAIL_COL = "email";
    private static final String STATUS_COL = "status";

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + STATUS_COL + " INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void addNewContact(String name, String phone, String email) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(NAME_COL, name);
        values.put(PHONE_COL, phone);
        values.put(EMAIL_COL, email);
        values.put(STATUS_COL, 1);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public ArrayList<ContactModal> readContact() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        ArrayList<ContactModal> contactModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                contactModalArrayList.add(new ContactModal(
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return contactModalArrayList;
    }
    public List<String>  read_for_AutoTextView() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        List<String> readAllModel = new ArrayList<String>();

        if (cursorCourses.moveToFirst()) {
            do {
                readAllModel.add(new String(cursorCourses.getString(1)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return readAllModel;
    }
}
