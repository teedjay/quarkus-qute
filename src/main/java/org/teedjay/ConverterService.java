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
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            StreamSource fileStreamSource = new StreamSource(getClass().getClassLoader().getResourceAsStream(xmlFileName));
            StreamSource xsltStreamSource = new StreamSource(getClass().getClassLoader().getResourceAsStream(xsltFileName));
            transformer = transformerFactory.newTransformer(xsltStreamSource);
            transformer.transform(fileStreamSource, new StreamResult(resultStream));
            return resultStream.toString();
        } catch (TransformerException ex) {
            return ex.getMessage();
        }
    }

}
