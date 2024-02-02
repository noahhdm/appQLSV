package lab.nhut.appqlsv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class clophoc extends Activity {

    //khai báo biến

    String lenh;

    private EditText ma, ten, si;

    private Button btluulophoc, bttrove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_cnlh);

        //lấy dữ liệu button
        btluulophoc = findViewById(R.id.bt_cnlh_luulophoc);
        bttrove = findViewById(R.id.bt_cnlh_trove);

        //sự kiện nút lưu lớp học
        btluulophoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //tham chiếu
                ma = findViewById(R.id.edit_cnlh_malop);
                ten = findViewById(R.id.edit_cnlh_tenlop);
                si = findViewById(R.id.edit_cnlh_siso);
                try{
                    KET_NOI_CSDL kn = new KET_NOI_CSDL(clophoc.this,"QLSV.sqlite",null,1);
                    lenh = "Insert into tblLop (malop, tenlop, siso)values('"+ma.getText().toString()+"','"+ten.getText().toString()+"','"+si.getText().toString()+"')";
                    kn.Ghi_bang(lenh);
                    Toast.makeText(clophoc.this, "Đã lưu thành công", Toast.LENGTH_SHORT).show();
                }
                catch (Exception loi){
                    Toast.makeText(clophoc.this, "Lỗi "+loi.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        //sự kiện nút trở lại
        bttrove.setOnClickListener(new View.OnClickListener() {

            //đi tới trang chức năng
            @Override
            public void onClick(View v) {
                Intent it = new Intent(clophoc.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}
