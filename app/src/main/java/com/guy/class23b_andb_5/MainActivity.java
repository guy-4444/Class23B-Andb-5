package com.guy.class23b_andb_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private MaterialButton main_BTN_export;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_BTN_export = findViewById(R.id.main_BTN_export);
        main_BTN_export.setOnClickListener(v -> export());

    }

    private void export() {
        ArrayList<Shift> shifts = DataManager.generateMockData();


        File folder = new File(getFilesDir() + File.separator + "MyFiles" + File.separator + "CSVs");
        boolean success = false;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }

        String fileName = "tableof_shifts";
        File file = new File(folder.getPath() + File.separator + fileName + ".csv");


        PrintWriter writer = null;

        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            // https://en.wikipedia.org/wiki/Byte_order_mark
            // https://stackoverflow.com/a/4192897/7147289
            os.write(239);
            os.write(187);
            os.write(191);

            writer = new PrintWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));

            String HEADER = "Key,Workplace,StartTime,EndTime,Salary,Comments";
            writer.print(HEADER);

            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.setLength(0);
            for (Shift shift : shifts) {
                stringBuilder.append("\n");
                stringBuilder.append("\"" + shift.getKey() + "\"" + ",");
                stringBuilder.append("\"" + shift.getWorkplace() + "\"" + ",");
                stringBuilder.append("\"" + new SimpleDateFormat("dd/MM/yy HH:mm", Locale.US).format(shift.getStartTime()) + "\"" + ",");
                stringBuilder.append("\"" + new SimpleDateFormat("dd/MM/yy HH:mm", Locale.US).format(shift.getEndTime()) + "\"" + ",");
                stringBuilder.append("\"" + String.format(Locale.US, "%.03f", shift.getSalary()) + "\"" + ",");
                stringBuilder.append("\"" + shift.getComments() + "\"" + ",");
            }
            writer.print(stringBuilder.toString());

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //MyUtils.sendAttachedMail(this, file.getAbsolutePath(), "\nSent from our application.");
        MyUtils.sendAttachedMail(this, file.getAbsolutePath());

    }
}