package org.teedjay;

import io.quarkus.qute.Template;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/qutetesting")
public class QuteTestingResource {

    @Inject
    Template jsonTemplate;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String testing() {
        QuteTestingData testdata = new QuteTestingData();
        return jsonTemplate.data("data", testdata).render();
    }

}
