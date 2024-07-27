package sixthsense.backend.util;

import javax.imageio.ImageIO;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

public final class Validator {

    private Validator() {}

    public static boolean isNullOrEmpty(Object value) {
        if (null == value) {
            return true;
        }

        if (value instanceof String) {
            return value.toString().trim().length() <= 0;
        }

        if (value instanceof Collection) {
            return ((Collection<?>) value).isEmpty();
        }

        if (value instanceof Map) {
            return ((Map<?, ?>) value).isEmpty();
        }

        if (value instanceof Enumeration) {
            return !((Enumeration<?>) value).hasMoreElements();
        }

        if (value instanceof Iterator) {
            return !((Iterator<?>) value).hasNext();
        }

        boolean arrayFlag = arrayIsNullOrEmpty(value);
        if (arrayFlag) {
            return true;
        }
        return false;
    }

    public static boolean isNotNullOrEmpty(Object value) {
        return !isNullOrEmpty(value);
    }

    private static boolean arrayIsNullOrEmpty(Object value) {
        if (value instanceof Object[]) {
            return ((Object[]) value).length == 0;
        }

        if (value instanceof int[]) {
            return ((int[]) value).length == 0;
        }

        if (value instanceof long[]) {
            return ((long[]) value).length == 0;
        }

        if (value instanceof float[]) {
            return ((float[]) value).length == 0;
        }

        if (value instanceof double[]) {
            return ((double[]) value).length == 0;
        }

        if (value instanceof char[]) {
            return ((char[]) value).length == 0;
        }

        if (value instanceof boolean[]) {
            return ((boolean[]) value).length == 0;
        }

        if (value instanceof byte[]) {
            return ((byte[]) value).length == 0;
        }

        if (value instanceof short[]) {
            return ((short[]) value).length == 0;
        }
        return false;
    }

    public static boolean isValidImage(InputStream is) {
        try {
            if (ImageIO.read(is) != null) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
