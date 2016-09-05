package com.chan.mm.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by chan on 2016/9/2.
 */
public class ImgSamplingUtils {

    public static Bitmap DoubleSampling(Bitmap source, double scale) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        source.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(byteArray,0, byteArray.length,options);
        int height = options.outHeight;
        int width = options.outWidth;
        options.inSampleSize = 2;

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(byteArray,0, byteArray.length,options);
    }
}
//默认大小

class Cache{
    public static final int IMAGE_MAX_HEIGH=854;
    public static final int IMAGE_MAX_WIDTH=480;
}