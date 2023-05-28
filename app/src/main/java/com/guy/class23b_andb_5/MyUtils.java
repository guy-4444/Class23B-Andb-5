package com.guy.class23b_andb_5;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class MyUtils {

    public static void sendAttachedMail(Context context, String filePath) {
        Log.d("pttt", "sendAttachedMail");

        if (true) {
            //if (checkForPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) && checkForPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            String textToMail = "Attached File:\n";


            File file = new File(filePath);

            boolean success = false;
            if (!file.exists()) {
                success = file.mkdir();
            } else {
                success = true;
            }

            // Copy file to cache so the email can access it
            InputStream in = null;
            OutputStream out = null;
            File folder = new File(context.getCacheDir() + File.separator + "TempFiles");
            boolean success0 = true;
            if (!folder.exists()) {
                success0 = folder.mkdir();
            }
            File dst = new File(folder.getPath(), file.getName());

            try {
                in = new FileInputStream(file.getPath());
                out = new FileOutputStream(dst);

                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




            Uri csvUri = FileProvider.getUriForFile(context, context.getPackageName() + ".my.package.name.provider", dst);
            final Intent emailIntent1 = new Intent(Intent.ACTION_SEND);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                emailIntent1.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
            emailIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            emailIntent1.putExtra(Intent.EXTRA_STREAM, csvUri);
//            emailIntent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"guy@gmail.com"});
            emailIntent1.putExtra(Intent.EXTRA_SUBJECT, "[" + "My App" + "] - " + " Playlist File");
            emailIntent1.putExtra(Intent.EXTRA_TEXT, textToMail + "\n\n\nSent from My App");
            emailIntent1.putExtra(Intent.EXTRA_CC, new String[]{""});
            emailIntent1.setData(Uri.parse("mailto:")); // or just "mailto:" for blank
            emailIntent1.setType("text/html");
            context.startActivity(Intent.createChooser(emailIntent1, "Send email using"));
        } else {
            Toast.makeText(context, "Storage Permission Denied", Toast.LENGTH_LONG).show();
        }
    }

}