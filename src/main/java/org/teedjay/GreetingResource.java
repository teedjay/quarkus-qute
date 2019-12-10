package org.teedjay;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    Logger logger;

    @Inject
    ConverterService converterService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        logger.info("running the '{}' service", "hello");
        return converterService.convertXmlToText("xml/authors.xml", "xslt/author-info.xslt");
    }

}