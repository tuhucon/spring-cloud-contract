package com.example.springcloudcontract;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Url;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static com.example.springcloudcontract.ImageProcessingInterface.*;

@Service
public class ImageProcessingService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ImageProcessingConfiguration configuration;

    private ImageProcessingInterface imageProcessingInterface;

    @PostConstruct
    void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.format("%s:%d", configuration.getHostname(), configuration.getPort()))
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        imageProcessingInterface = retrofit.create(ImageProcessingInterface.class);
    }

    public MatchingResponse match(MatchingRequest matchingRequest) throws IOException {
        return imageProcessingInterface.match(matchingRequest).execute().body();
    }
}
