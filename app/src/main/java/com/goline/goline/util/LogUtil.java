package com.goline.goline.util;

import android.content.Context;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Vinícius Lindemberg on 22/05/17.
 */

public class LogUtil {

    public static void writeLog(Context context, String msg){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime dateTime = DateTime.now();
        String dateTimeString = dateTime.toString(dateTimeFormatter);
        msg = "\n"  + dateTimeString + ": " + msg;
        File file = FileUtil.getFileInternalStorage(context, "appcbr_log.txt");
        if(file.exists()){
            try {
                OutputStream outputStream = FileUtil.getFileOutputStreamInternalStorage(context, "appcbr_log.txt", Context.MODE_APPEND);
                IOUtil.writeString(outputStream, msg);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            IOUtil.writeString(file, msg);
        }
    }

    public static String readLog(Context context){
        String log = "";
        File file = FileUtil.getFileInternalStorage(context, "appcbr_log.txt");
        if(file.exists()){
            try {
                InputStream inputStream = FileUtil.getFileInputStreamInternalStorage(context, "appcbr_log.txt");
                log = IOUtil.readString(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return log;
    }

}
