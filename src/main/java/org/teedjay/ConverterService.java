package org.teedjay;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;

@ApplicationScoped
public class ConverterService {

    public String convertXmlToText(String xmlFileName, String xsltFileName) {
        String relativePathToResources = "../src/main/resources/";
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer(new StreamSource(relativePathToResources + xsltFileName));
            transformer.transform(new StreamSource(relativePathToResources + xmlFileName), new StreamResult(resultStream));
            return resultStream.toString();
        } catch (TransformerException ex) {
            return ex.getMessage();
        }
    }

}
