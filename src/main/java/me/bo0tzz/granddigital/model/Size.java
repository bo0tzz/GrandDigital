package me.bo0tzz.granddigital.model;

public enum Size {

    SMALL("mdpi", "1x"),
    MEDIUM("hdpi", "2x"),
    LARGE("xhdpi", "3x");

    private final String androidName;
    private final String iosName;

    private static final String urlFormat = "/%s/%s/%s_%s.png";

    Size(String androidName, String iosName) {
        this.androidName = androidName;
        this.iosName = iosName;
    }

    public String urlFor(OS os, String image) {
        String sizeName;
        switch (os) {
            case IOS:
                sizeName = iosName;
                break;
            case ANDROID:
                sizeName = androidName;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + os);
        }
        return String.format(urlFormat, os, sizeName, image, sizeName);
    }

}
