package org.teedjay;

import io.quarkus.qute.Template;
import no.difi.begrep.sdp.schema_v10.Kvittering;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

@ApplicationScoped
public class TemplateService {

    @Inject
    Logger logger;

    @Inject
    Template response;

    @Inject
    ConfigData config;

    public String createFromSingleSource() {
        return response.data("config", config).render();
    }

    public String createFromMultipleSources() {
        Kvittering receipt = fetchReceipt("xml/kvittering.xml");
        return response.data("config", config).data("receipt", receipt).render();
    }

    private Kvittering fetchReceipt(String filename) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Kvittering.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream stream = getClass().getClassLoader().getResourceAsStream(filename);
            return (Kvittering) unmarshaller.unmarshal(stream);
        } catch (Exception ex) {
            logger.error("Unable to read receipt file {}", filename, ex);
            return null;
        }
    }

}
