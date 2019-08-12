package com.example.springcloudcontract;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static com.example.springcloudcontract.TextProcessingInterface.MatchingRequest;
import static com.example.springcloudcontract.TextProcessingInterface.MatchingResponse;

@Service
public class TextProcessingService {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    TextProcessingConfiguration configuration;

    private TextProcessingInterface imageProcessingInterface;

    @PostConstruct
    void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.format("%s:%d", configuration.getHostname(), configuration.getPort()))
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
        imageProcessingInterface = retrofit.create(TextProcessingInterface.class);
    }

    public MatchingResponse match(MatchingRequest matchingRequest) throws IOException {
        return imageProcessingInterface.match(matchingRequest).execute().body();
    }
}
