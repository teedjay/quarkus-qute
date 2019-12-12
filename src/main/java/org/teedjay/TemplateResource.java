package org.teedjay;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/template")
public class TemplateResource {

    @Inject
    Logger logger;

    @Inject
    TemplateService templateService;

    @GET
    @Path("single")
    @Produces(MediaType.TEXT_HTML)
    public String withSingleInput() {
        logger.info("using single input templating");
        return templateService.createFromSingleSource();
    }

    @GET
    @Path("multiple")
    @Produces(MediaType.TEXT_HTML)
    public String withMultipleInputs() {
        logger.info("using multiple input templating");
        return templateService.createFromMultipleSources();
    }

}