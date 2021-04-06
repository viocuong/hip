package com.example.hip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.hip.model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtName, txtPrice, txtQuantity;
    private Button btnAdd, btnDate;
    private RadioButton radioCon,radioHet;
    private Spinner spiner;
    private List<Product> mList = new ArrayList<>();
    private List<Integer> imgs= new ArrayList<>();
    private RecyclerView rcv;
    private String date;
    private ListProdAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        txtQuantity = findViewById(R.id.txtQuantity);
        btnAdd = findViewById(R.id.btnAdd);
        btnDate = findViewById(R.id.btnDate);
        radioCon = findViewById(R.id.radioConhang);
        radioHet = findViewById(R.id.radioHethang);
        spiner = findViewById(R.id.spiner);
        imgs.add(R.drawable.img1);
        imgs.add(R.drawable.img2);
        imgs.add(R.drawable.img3);
        spiner.setAdapter(new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item,imgs));
        rcv = findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        adapter = new ListProdAdapter(this,mList);
        rcv.setAdapter(adapter);
        btnDate.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:

                adapter.add(new Product(txtName.getText().toString(),(radioCon.isChecked())?true:false,Double.parseDouble(txtPrice.getText().toString()),date,Integer.parseInt(txtQuantity.getText().toString()),(int)spiner.getSelectedItem()));
                break;
            case R.id.btnDate:
                DatePickerDialog picker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date=dayOfMonth+"/"+month+"/"+year;
                    }
                },2021,4,1);
                picker.show();
                break;
        }
    }
}