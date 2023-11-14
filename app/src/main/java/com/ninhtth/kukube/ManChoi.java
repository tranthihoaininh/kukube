package com.ninhtth.kukube;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ManChoi extends AppCompatActivity {
    TextView txvTime, txvDiem, txvScore;
    Button btnRestart;
    GridView gdvMau;
    RandomColor randomColor=new RandomColor();
    ArrayList arr;
    int diem, soO, kiemtradiem;
    Dialog outGameDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_man_choi);
        anhXa();
        caiDatGridView();
        setDuLieu();
        setSuKienClick();
    }
    private void anhXa(){
        gdvMau = (GridView) findViewById(R.id.gdvMau);
        txvDiem=(TextView) findViewById(R.id.txvDiem);
        txvTime=(TextView) findViewById(R.id.txvTime);
        diem=0;
        outGameDialog = new Dialog(this);
        outGameDialog.setContentView(R.layout.layout_outgame);
        btnRestart = outGameDialog.findViewById(R.id.btnRestart);
        txvScore = outGameDialog.findViewById(R.id.txvScore);

        // Set a click listener for the restart button
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart the game
                restartGame();
                // Dismiss the outgame dialog
                outGameDialog.dismiss();
            }
        });
    }
    private void caiDatGridView(){
        if(diem<10){
            gdvMau.setNumColumns(2);
            soO=4;
        }else {
            gdvMau.setNumColumns(diem/10+2);
            soO=(diem/10+2)*(diem/10+2);
        }
    }
    private void setDuLieu(){
        arr=new ArrayList(randomColor.taoBangMau(soO));
        Adapter adapter=new Adapter(ManChoi.this, R.layout.layout_man_choi,arr);
        gdvMau.setAdapter(adapter);
        txvDiem.setText(Integer.toString(diem));
    }
    private void setSuKienClick(){
        gdvMau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==randomColor.dapAn && kiemtradiem==0){
                    caiDatGridView();
                    tm.start();
                    diem++;
                    setDuLieu();
                }
            }
        });
    }

    CountDownTimer tm=new CountDownTimer(4000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            txvTime.setText(millisUntilFinished/1000 + "");
        }

        @Override
        public void onFinish() {
            kiemtradiem=1;
            txvTime.setText("0");
            showOutGameDialog();
        }
    }.start();

    private void showOutGameDialog() {
        txvScore.setText("Score: " + diem); // Set the score text
        outGameDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        outGameDialog.show();
    }

    private void restartGame() {
        // Reset variables and start a new game
        diem = 0;
        kiemtradiem = 0;
        caiDatGridView();
        setDuLieu();
        tm.start();
    }
}