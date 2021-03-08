package br.com.marcia.base64.utils;

import org.apache.tika.Tika;

public class MimeTypeUtils {

    public static final String MIME_TYPE_IMAGE_JPEG = "image/jpeg";

    public static final String MIME_TYPE_IMAGE_PNG = "image/png";

    public static final String MIME_TYPE_APPLICATION_PDF = "application/pdf";

    public static String getMimeType(byte[] bytes) {
        return new Tika().detect(bytes);
    }
}
