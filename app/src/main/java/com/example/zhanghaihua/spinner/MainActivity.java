package com.example.zhanghaihua.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText text;

    CustomSinnper spinner;

    String[] strs = new String[] { "中国", "美国", "法国", "德国", "俄罗斯" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (CustomSinnper) findViewById(R.id.custom_sinnper);
//		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//
//		spinner.setDrawable(new BitmapDrawable(bitmap));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.select_dialog_item, strs);
        spinner.setAdapter(adapter);
        spinner.setOnItemSeletedListener(new CustomSinnper.OnItemSeletedListener() {

            @Override
            public void onItemSeleted(AdapterView<?> parent, View view,
                                      int position, long id) {
                Object obj = parent.getItemAtPosition(position);
//                Log.i("mainActivity onitemseleted", obj + "");
                Toast.makeText(MainActivity.this,obj.toString(),Toast.LENGTH_LONG).show();
            }
        });
        //

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            if(spinner.isShowPopup())
            {
                spinner.dismiss();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
