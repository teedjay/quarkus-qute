package org.teedjay;

import io.quarkus.qute.TemplateExtension;

public class TemplateExtensionReverse {

    @TemplateExtension
    public static String reverseString(String input) {
        return new StringBuffer(input).reverse().toString();
    }

}
