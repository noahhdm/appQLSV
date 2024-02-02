package lab.nhut.appqlsv;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class KET_NOI_CSDL extends SQLiteOpenHelper {

    public KET_NOI_CSDL (@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    //tạo phương thức hàm đọc dữ liệu từ câu lệnh sql
    public Cursor Doc_bang(String lenh)//hàm dọc bảng trả về kết quả là con trỏ cursor
    {
        SQLiteDatabase csdl = getReadableDatabase();
        return csdl.rawQuery(lenh, null);//dọc dữ liệu theo câu lện sql
    }

    public void Ghi_bang(String lenh)
    {
        SQLiteDatabase csdl = getWritableDatabase();//ghi dữ liệu xuống Table
        csdl.execSQL(lenh);//thực thi lệnh
    }

    public void onCreate (SQLiteDatabase db) {

    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
