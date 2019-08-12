package com.example.springcloudcontract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "image-processing-service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageProcessingConfiguration {
    @NotEmpty
    String hostname;

    @NotNull
    Integer port;
}
