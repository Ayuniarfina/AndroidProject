package com.example.ayuniarfina.tangkiinformation;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    ImageViewTopCrop crop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer max = 10;

        myDB = new DatabaseHelper(this);
        Cursor isi = myDB.getListContents();
        int value_db = Integer.parseInt(isi.getString(2));
        int value = (value_db*100) / max;
        String value_view = Integer.toString(value);
        TextView fill_tank = (TextView) findViewById(R.id.fill);
        fill_tank.setText(value_view + "%");

//        final ImageView imageView = (ImageView) findViewById(R.id.tangkiIsi);
//        final Matrix matrix = imageView.getImageMatrix();
//        final float imageWidth = imageView.getDrawable().getIntrinsicWidth();
//        final int screenWidth = getResources().getDisplayMetrics().widthPixels;
//        final float scaleRatio = screenWidth / imageWidth;
//        matrix.postScale(scaleRatio, scaleRatio);
//        imageView.setImageMatrix(matrix);

        ImageView ivPeakOver=(ImageView) findViewById(R.id.tangkiBackground);

        Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.drawable.tangki2);
        int width=bmp.getWidth();
        int height=1000-(value*10);

        Bitmap resizedbitmap=Bitmap.createBitmap(bmp,0,0, width, height);
        ivPeakOver.setImageBitmap(resizedbitmap);

    }
}