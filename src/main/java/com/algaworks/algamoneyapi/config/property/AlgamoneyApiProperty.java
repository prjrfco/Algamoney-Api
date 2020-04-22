package com.algaworks.algamoneyapi.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "algamoney")
@Data
public class AlgamoneyApiProperty {

    private String originPermitida = "http://localhost:8000";

    private final Seguranca seguranca = new Seguranca();

    @Data
    public static class Seguranca {

        private boolean enableHtpps;

    }
}
