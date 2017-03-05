package com.jiajiguo12gmail.labtwo;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Jiaji Guo on 2017/3/2.
 */

public class MyCsvFileReader {

    Context context;
    public MyCsvFileReader(Context applicationContext) {
        this.context = applicationContext;
    }

    //public ArrayList<String[]> readCsvFile(int fileresource) {
    public ArrayList<String[]> readCsvFile(int fileresource) {
        ArrayList<String[]> games = new ArrayList<>();
        InputStream fin = null;
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            fin = context.getResources().openRawResource(fileresource);
            isr = new InputStreamReader(fin);
            reader = new BufferedReader(isr);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] teamInfo = line.split(",");
                games.add(teamInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fin != null)
                    fin.close();
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
        return games;
    }
}