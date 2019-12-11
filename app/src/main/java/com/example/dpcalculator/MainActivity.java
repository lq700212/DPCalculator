package com.example.dpcalculator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;
    private EditText et_input_number;
    private TextView tv_output_number;
    private Button bt_px2dip;
    private Button bt_dip2px;
    private Button bt_px2sp;
    private Button bt_sp2px;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initData();
    }

    private void initUI() {
        et_input_number = (EditText) findViewById(R.id.et_input_number);
        tv_output_number = (TextView) findViewById(R.id.tv_output_number);
        bt_px2dip = (Button) findViewById(R.id.bt_px2dip);
        bt_dip2px = (Button) findViewById(R.id.bt_dip2px);
        bt_px2sp = (Button) findViewById(R.id.bt_px2sp);
        bt_sp2px = (Button) findViewById(R.id.bt_sp2px);
    }

    private void initData() {
        bt_px2dip.setOnClickListener(this);
        bt_dip2px.setOnClickListener(this);
        bt_px2sp.setOnClickListener(this);
        bt_sp2px.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(et_input_number.getText())){
            Toast.makeText(this, "请输入要转换的数值", Toast.LENGTH_SHORT).show();
            return;
        }
        float inputNumber = Float.parseFloat(et_input_number.getText().toString());
        int outputNumber = 0;
        switch (v.getId()) {
            case R.id.bt_px2dip:
                outputNumber = DisplayUtil.px2dip(MainActivity.this, inputNumber);
                break;
            case R.id.bt_dip2px:
                outputNumber = DisplayUtil.dip2px(MainActivity.this, inputNumber);
                break;
            case R.id.bt_px2sp:
                outputNumber = DisplayUtil.px2sp(MainActivity.this, inputNumber);
                break;
            case R.id.bt_sp2px:
                outputNumber = DisplayUtil.sp2px(MainActivity.this, inputNumber);
                break;
            default:
                break;
        }
        tv_output_number.setText("" + outputNumber);
    }
}
