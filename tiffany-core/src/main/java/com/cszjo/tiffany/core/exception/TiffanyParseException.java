package com.cszjo.tiffany.core.exception;

import com.cszjo.tiffany.core.compress.Compress;

/**
 * Created by hansiming on 2017/10/23.
 */
public class TiffanyParseException extends TiffanyAbstractException {

    private static final String nullOrEmptyMessage = "The element '%s' attribute '%s'" +
            " can`t be null or empty!";

    public TiffanyParseException(String message) {
        super(message);
    }

    @Deprecated
    public static TiffanyParseException parseNullOrEmpty (String element, String attr) {
        String message = String.format(nullOrEmptyMessage, element, attr);
        return new TiffanyParseException(message);
    }
}
