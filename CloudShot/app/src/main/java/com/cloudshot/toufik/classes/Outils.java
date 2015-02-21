package com.cloudshot.toufik.classes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.microsoft.azure.storage.core.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Toufik on 14/02/2015.
 */
public class Outils {

    public static String encodeImage(byte[] imageByteArray) {
       return Base64.encode(imageByteArray);
    }

    public static byte[] decodePicture(String imageDataString) {
        return Base64.decode(imageDataString);
    }

    public static Bitmap decodeFile(File f){
        try {
            //Decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

            //The new size we want to scale to
            final int REQUIRED_SIZE=70;

            //Find the correct scale value. It should be the power of 2.
            int scale=1;
            while(o.outWidth/scale/2>=REQUIRED_SIZE && o.outHeight/scale/2>=REQUIRED_SIZE)
                scale*=2;

            //Decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize=scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {}
        return null;
    }
}
