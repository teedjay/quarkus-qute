package org.teedjay;

import io.quarkus.qute.TemplateExtension;

public class QuteTestingExtension {

    @TemplateExtension
    public static boolean wasNull(String input, String message) {
        System.out.println("wasNull got object '" + input.getClass().toString() + "'");
        return input == null;
    }

}
