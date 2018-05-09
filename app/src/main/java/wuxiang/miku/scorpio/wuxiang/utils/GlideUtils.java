package wuxiang.miku.scorpio.wuxiang.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.net.URL;

import wuxiang.miku.scorpio.wuxiang.R;


public class GlideUtils {

//    public static void loadImage(Context context, String url, int errorImg, ImageView imageView) {
//        Glide.with(context)
//                .load(url)
//                .error(errorImg)
//                .placeholder(R.drawable.icon_default)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .dontAnimate()
//                .into(imageView);
//    }
//
//    public static void loadImage(Context context, String url, ImageView imageView) {
//        Glide.with(context)
//                .load(url)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .dontAnimate()
//                .into(imageView);
//    }
//

    public static void loadImage(Context context, int drawable, ImageView imageView) {
        Glide.with(context)
                .load(drawable)
                .into(imageView);
    }

    public static void loadImage(Context context, String drawable, ImageView imageView) {
        Glide.with(context)
                .load(drawable)
                .into(imageView);
    }

    public static void clearPicCache(Context context) {
        final Glide glide = Glide.get(context);
        new Thread(new Runnable() {
            @Override
            public void run() {
                glide.clearDiskCache();
            }
        }).start();
    }
}
