package com.moliyacentre.topcamouflageskinsmcpe.utils;


public class BaseURL {
    public static final String HTTPS_skin = "https://imagetobase64.net/camouflage/skin/";
    public static final String HTTPS_thumbnail = "https://imagetobase64.net/camouflage/thumbnail/";

    public static String createThumbnailPath(String str) {
        return String.format("%s%s.png", HTTPS_thumbnail, str);
    }

    public static String createSkinPath(String str) {
        return String.format("%s%s.png", HTTPS_skin, str);
    }
}
