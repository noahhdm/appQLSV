package lab.nhut.appqlsv;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import lab.nhut.appqlsv.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String lenh;
    private Button bttaoCSDL, bttaolop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_chucnang);

        //code nút TẠO CƠ SỞ DỮ LIỆU
        bttaoCSDL = findViewById(R.id.bt_chucnang_tcsdl);
        bttaoCSDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KET_NOI_CSDL kn = new KET_NOI_CSDL(MainActivity.this, "QLSV.sqlite", null,1);

                //Tạo bảng tblLop trong QLSV
                lenh = "CREATE TABLE IF NOT EXISTS tblLop(malop text primary key, tenlop text, siso Interger)";

                kn.Ghi_bang(lenh);//tạo bảng tpllop
                lenh = "CREATE TABLE IF NOT EXISTS tplsinhvien (mssv text Primary key, hoten text, ngaysinh date, diachi text, dienthoai text, malop text)";
                kn.Ghi_bang(lenh);//tạo bảng tplsinhvien
                Toast.makeText(MainActivity.this, "Tạo CSDL thành công", Toast.LENGTH_LONG).show();
            }
        });

        //code nút nhập lớp học
        bttaolop = findViewById(R.id.bt_chucnang_nhaplh);
        bttaolop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, clophoc.class);
                startActivity(it);
            }
        });

    }


}