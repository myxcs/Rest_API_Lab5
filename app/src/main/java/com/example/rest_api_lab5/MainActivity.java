package com.example.rest_api_lab5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText edtMaSP, edtTenSP, edtMoTa;
    private TextView tvResult;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtMaSP = findViewById(R.id.edtMaSP);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtMoTa = findViewById(R.id.editTextText3);

        tvResult = findViewById(R.id.tvResult);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(v ->
                // insertData(edtMaSP, edtTenSP, edtMoTa, tvResult)
                // selectData()
               // deleteData(edtMaSP)
                updateData(edtMaSP, edtTenSP, edtMoTa, tvResult)
        );

    }

    private void insertData(EditText edtMaSP, EditText edtTenSP, EditText edtMoTa, TextView tvResult) {
        //b1 tao doi tuong chua du lieu
        SanPham sanPham = new SanPham(edtMaSP.getText().toString(), edtTenSP.getText().toString(), edtMoTa.getText().toString());

        //b2 tao doi tuong chua du lieu
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.112/000/rest_api_lab5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        //b3 goi ham insert
        InterfaceInsertSanPham interfaceInsertSanPham = retrofit.create(InterfaceInsertSanPham.class);
        //chuan bi ham
        Call<ServerResponseSanPham> call = interfaceInsertSanPham.insertSanPham(sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMoTa());

        //b4 thuc thi
        call.enqueue(new Callback<ServerResponseSanPham>() {
            @Override
            public void onResponse(Call<ServerResponseSanPham> call, Response<ServerResponseSanPham> response) {
                ServerResponseSanPham res = response.body();
                tvResult.setText(res.getMessage());


//                if (res.getSanPham() != null) {
//                    SanPham sanPham = res.getSanPham();
//                    edtMaSP.setText(sanPham.getMaSP());
//                    edtTenSP.setText(sanPham.getTenSP());
//                    edtMoTa.setText(sanPham.getMoTa());
//                }
            }
            @Override
            public void onFailure(Call<ServerResponseSanPham> call, Throwable t) {
                //xu ly loi
                tvResult.setText(t.getMessage());

            }

        });
    }

    private void deleteData(EditText edtMaSP) {

        //b2 tao doi tuong chua du lieu
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.112/000/rest_api_lab5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        InterfaceDelete interfaceDelete = retrofit.create(InterfaceDelete.class);
        //chuan bi ham
        Call<ServerResponseSanPham> call = interfaceDelete.deleteSanPham(edtMaSP.getText().toString());

        //b4 thuc thi
        call.enqueue(new Callback<ServerResponseSanPham>() {
            @Override
            public void onResponse(Call<ServerResponseSanPham> call, Response<ServerResponseSanPham> response) {
                ServerResponseSanPham res = response.body();
                tvResult.setText(res.getMessage());


//                if (res.getSanPham() != null) {
//                    SanPham sanPham = res.getSanPham();
//                    edtMaSP.setText(sanPham.getMaSP());
//                    edtTenSP.setText(sanPham.getTenSP());
//                    edtMoTa.setText(sanPham.getMoTa());
//                }
            }
            @Override
            public void onFailure(Call<ServerResponseSanPham> call, Throwable t) {
                //xu ly loi
                tvResult.setText(t.getMessage());

            }

        });
    }
    private void updateData(EditText edtMaSP, EditText edtTenSP, EditText edtMoTa, TextView tvResult) {
        //b1 tao doi tuong chua du lieu
        SanPham sanPham = new SanPham(edtMaSP.getText().toString(), edtTenSP.getText().toString(), edtMoTa.getText().toString());

        //b2 tao doi tuong chua du lieu
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.112/000/rest_api_lab5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        //b3 goi ham insert
        InterfaceUpdate interfaceUpdate = retrofit.create(InterfaceUpdate.class);
        //chuan bi ham
        Call<ServerResponseSanPham> call = interfaceUpdate.updateSanPham(sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getMoTa());


        //b4 thuc thi
        call.enqueue(new Callback<ServerResponseSanPham>() {
            @Override
            public void onResponse(Call<ServerResponseSanPham> call, Response<ServerResponseSanPham> response) {
                ServerResponseSanPham res = response.body();
                tvResult.setText(res.getMessage());


//                if (res.getSanPham() != null) {
//                    SanPham sanPham = res.getSanPham();
//                    edtMaSP.setText(sanPham.getMaSP());
//                    edtTenSP.setText(sanPham.getTenSP());
//                    edtMoTa.setText(sanPham.getMoTa());
//                }
            }
            @Override
            public void onFailure(Call<ServerResponseSanPham> call, Throwable t) {
                //xu ly loi
                tvResult.setText(t.getMessage());

            }

        });
    }

    String result = "";
    List<SanPham> ls;
    private void selectData() {
        //b1 tao doi tuong retrofit
        String MaSP = edtMaSP.getText().toString();
        result = "";
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.112/000/rest_api_lab5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        //2.goi ham select trong interface
        //2.1tao doi tuong
        InterfaceSelect interfaceSelect = retrofit.create(InterfaceSelect.class);

        //2.2 chuan bi
        Call<ServerResponseSelect> call = interfaceSelect.selectSanPham();

        //2.3 thuc thi
        call.enqueue(new Callback<ServerResponseSelect>() {
            @Override
            public void onResponse(Call<ServerResponseSelect> call, Response<ServerResponseSelect> response) {
                ServerResponseSelect res = response.body();
                //chuyen doi key sang dang lt
                ls = new ArrayList<>(Arrays.asList(res.getProducts()));
                //doc list
                for (SanPham sanPham : ls) {
                    result +="MaSP: "+sanPham.getMaSP()+"; TenSP: "+sanPham.getTenSP()+"; MoTa: "+sanPham.getMaSP()+"\n";
                }
                tvResult.setText(result);
            }
            @Override
            public void onFailure(Call<ServerResponseSelect> call, Throwable t) {
                //xu ly loi
                tvResult.setText(t.getMessage());


    }

});
    }

}

