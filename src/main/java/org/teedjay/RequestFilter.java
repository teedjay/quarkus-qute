package org.teedjay;

import org.slf4j.MDC;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

@Provider
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MDC.clear();
        MDC.put("millis", "" + System.currentTimeMillis());
        MDC.put("uuid", UUID.randomUUID().toString());
        MDC.put("json-escape-test", "{ % ' \" }");
    }

}
