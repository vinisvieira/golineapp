package com.goline.goline.util;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by wolney on 18/04/17.
 */

public class FileUtil {

    // Obtém um objeto do tipo File que representa a localização de um arquivo no diretório privado da aplicação /data/data/pacote.do.aplicativo/
    public static File getFileInternalStorage(Context context, String fileName){
        File file = context.getFileStreamPath(fileName);
        return file;
    }

    // retorna um FileInputStrem para ler um arquivo no diretório privado da aplicação /data/data/pacote.do.aplicativo/
    public static FileInputStream getFileInputStreamInternalStorage(Context context, String fileName) throws FileNotFoundException {
        FileInputStream fileInputStream = context.openFileInput(fileName);
        return fileInputStream;
    }

    // retorna um FileOutputStream para escrever um arquivo no diretório privado da aplicação /data/data/pacote.do.aplicativo/
    public static FileOutputStream getFileOutputStreamInternalStorage(Context context, String fileName, int mode) throws FileNotFoundException {
        FileOutputStream fileOutputStream = context.openFileOutput(fileName, mode);
        return fileOutputStream;
    }

}
