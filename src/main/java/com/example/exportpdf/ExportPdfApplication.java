package com.example.exportpdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class ExportPdfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExportPdfApplication.class, args);
    }

}
