package org.teedjay;

import io.quarkus.qute.TemplateExtension;

public class TemplateExtensionFormat {

    @TemplateExtension
    public static String formatString(String input, String format) {
        if (format == null) format = "";
        return input + ":" + format + ":" + input;
    }

}
