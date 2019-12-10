# quarkus-xslt
Testing plain XSLT from Quarkus

## Start dev mode
```
mvn clean quarkus:dev
```

## Some bonus features
- testing new json log format feature from Quarkus 1.1.0.CR1 +
- using a CDI producer to make SLF4J Logger injectable
- rigging the MDC with various values in ContainerRequestFilter