package com.example.maciejpolitowski.colordialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.xdty.preference.colorpicker.ColorPickerDialog;
import org.xdty.preference.colorpicker.ColorPickerSwatch;

public class MainActivity extends AppCompatActivity {


    private int mSelectedColor;
    private int[] mColors;
    private int[] aaa;
    private ColorPickerDialog dialog;
    TextView textView;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSelectedColor = ContextCompat.getColor(this, R.color.flamingo);

        textView = (TextView) findViewById(R.id.textViewMoj);
        button1 = (Button) findViewById(R.id.button1);


        mColors = getResources().getIntArray(R.array.rainbow2);


        dialog = ColorPickerDialog.newInstance(R.string.color_picker_default_title,
                mColors,
                mSelectedColor,
                5, // Number of columns
                ColorPickerDialog.SIZE_SMALL);

        dialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener() {

            @Override
            public void onColorSelected(int color) {
                mSelectedColor = color;
                textView.setTextColor(mSelectedColor);

            }

        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show(getFragmentManager(), "color_dialog_test");
            }
        });






    }
}
