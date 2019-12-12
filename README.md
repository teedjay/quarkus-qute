# quarkus-qute
Testing Qute templating from Quarkus

## Start dev mode
```
mvn clean quarkus:dev
```

## Testing
```
curl http://0.0.0.0:8080/template/single        <== one named input to the template
curl http://0.0.0.0:8080/template/multiple      <== using multiple named inputs to the template
```

## Some bonus features
- creating XML from multiple inputs
- using JAXB as input to template (simple alternative to XSLT)
