package com.ninhtth.kukube;

import java.util.ArrayList;
import java.util.Random;

public class RandomColor {
    static int dapAn;
    Random random=new Random();
    String string[]=new String[]{"#d7d720", "#fefe00", "#20d720", "#00fe00", "#20d7d7","#00ffff", "#2020d7", "#2f2fff", "#d80707", "#ff4242"};
    public ArrayList<String> taoBangMau(int n){
        int x,y;
        ArrayList<String> a=new ArrayList<>();
        x=random.nextInt(n);//0 -> n-1
        dapAn=x;
        y=random.nextInt(string.length);
        if(y%2==1){
            y--;
        }
        for (int i = 0; i<n; i++){
            if (i==x){
                a.add(string[y]);
            }else {
                a.add(string[y+1]);
            }
        }
        return a;
    }
}
