package com.lingaro.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    private static final Logger LOG = Logger.getGlobal();

    @GetMapping(value = "/", produces = MimeTypeUtils.TEXT_HTML_VALUE)
    public Object info() {
        LOG.info("got info request");
        String propInfo = System.getProperties().entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .sorted()
                .collect(Collectors.joining("\n"));
        return "<html>" +
                "<head><title>SpringApp</title></head>" +
                "<body>" +
                "   <h1>Spring App Status Page</h1>" +
                "   <h2>System Properties</h2>" +
                "   <pre style='" +
                        "border:solid 1px lightgray; " +
                        "font-size:smaller; " +
                        "width: 60%;" +
                        "height:600px;" +
                        "overflow:scroll; " +
                        "background: lightgreen'>" +
                propInfo +
                "   </pre>" +
                "</body>" +
                "</html>";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
