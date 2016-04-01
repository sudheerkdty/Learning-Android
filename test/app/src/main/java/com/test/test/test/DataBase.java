package com.test.test.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


/**
 * Created by nuventure on 17/2/16.
 */
public class DataBase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";

    public static final String TABLE_NAME = "User_Details";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_PHONE = "PHONE_NO";
    public static final String COLUMN_EMAIL = "EMAIL_ID";

    public DataBase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT,"
                + COLUMN_USER_NAME + " TEXT," + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_PHONE + " TEXT," + COLUMN_EMAIL+ " VARCHAR );";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void Add_User(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, user.getID());// Contact ID
        values.put(COLUMN_NAME, user.getName()); // Contact Name
        values.put(COLUMN_USER_NAME, user.getUserName()); //User Name
        values.put(COLUMN_PASSWORD, user.get_password()); //Password
        values.put(COLUMN_PHONE, user.getPhoneNumber()); // Contact Phone
        values.put(COLUMN_EMAIL, user.getEmail()); // Contact Email
        // Inserting Row
        db.insert(TABLE_NAME, null, values);

        db.close(); // Closing database connection
    }

    User getUser(int id){
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor1 = db.query(true, TABLE_NAME,
                new String[]{COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_USER_NAME,
                        COLUMN_PASSWORD,
                        COLUMN_PHONE,
                        COLUMN_EMAIL},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where "+COLUMN_ID +"= ?",new String[]{String.valueOf(id)});

        if (cursor != null)
            cursor.moveToFirst();
            User user = new User(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5));
        return user;


    }
    User getUserbyUsername(String usern){
        SQLiteDatabase db =this.getReadableDatabase();
        String query = "SELECT *  FROM " + TABLE_NAME + " WHERE " + COLUMN_USER_NAME + " = '" +usern  +"'";
        Cursor cursor = db.rawQuery(query,null);
        if (cursor != null)
            cursor.moveToFirst();
        User user = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5));
        return user;

    }
    public int getUserCount() {
        int count =0;
        String countQuery = "SELECT  * FROM " +" "+ TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery(countQuery, null);
            if (cursor != null && !cursor.isClosed()) {
                count = cursor.getCount();
                cursor.close();
            }
        }
        catch (CursorIndexOutOfBoundsException e){
            return 0;
        }

        return count;


    }
    String getpwd(String usrname){
        SQLiteDatabase db = this.getReadableDatabase();
        String password;
        String query = "SELECT *  FROM " + TABLE_NAME + " WHERE " + COLUMN_USER_NAME + " = '" +usrname  +"'";

        Cursor cursor = db.rawQuery(query,null);
        //Cursor cursor = db.rawQuery("SELECT password FROM " + TABLE_NAME + " WHERE " + COLUMN_USER_NAME + "= ?",new String[]{String.valueOf(usrname)},null);
        if (cursor != null)
            cursor.moveToFirst();
            password = cursor.getString(3);
        return password;
    }
    ArrayList getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor  cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        ArrayList list = new ArrayList();
        if (cursor .moveToFirst()) {

            while (cursor.isAfterLast() == false) {
                String id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));
                String pass = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                String username = cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL));

                list.add("ID : " + id);
                list.add("Name : " + name);
                list.add("Username : " + username);
                list.add("Password : " + pass);
                list.add("Phone No : " + phone);
                list.add("Email Id: " + email);
                cursor.moveToNext();
            }
        }
        return list;
    }
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, user.getID());// Contact ID
        values.put(COLUMN_NAME, user.getName()); // Contact Name
        values.put(COLUMN_USER_NAME, user.getUserName()); //User Name
        values.put(COLUMN_PASSWORD, user.get_password()); //Password
        values.put(COLUMN_PHONE, user.getPhoneNumber()); // Contact Phone
        values.put(COLUMN_EMAIL, user.getEmail()); // Contact Email

        // updating row
        return db.update(TABLE_NAME, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(user.getID()) });
    }
    public void deleteUser(User user ) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?",
                new String[]{String.valueOf(user.getID())});
        db.close();
    }
    boolean userExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String Query = "Select * from " + TABLE_NAME + " where " + COLUMN_USER_NAME + " = '" + username +"'";
        Cursor cursor = db.rawQuery(Query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
    void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }


}
