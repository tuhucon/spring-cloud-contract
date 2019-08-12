package com.example.springcloudcontract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MatchController {

    @Autowired
    ImageProcessingService imageService;

    @Autowired
    TextProcessingService textService;

    @GetMapping("/match")
    public Map<String, Integer> match() throws IOException {
        ImageProcessingInterface.MatchingRequest imageMatchingRequest = new ImageProcessingInterface.MatchingRequest();
        imageMatchingRequest.pids = Arrays.asList("adki46", "adki47", "bhckh500");
        imageMatchingRequest.values = Arrays.asList(
                new ImageProcessingInterface.MatchingRequest.ValueItem("main", "/x/y/image1.jpg"),
                new ImageProcessingInterface.MatchingRequest.ValueItem("thumb_1", "/x/y/image2.jpg")
                );
        ImageProcessingInterface.MatchingResponse imageMatchingResponse = imageService.match(imageMatchingRequest);

        TextProcessingInterface.MatchingRequest textMatchingRequest = new TextProcessingInterface.MatchingRequest();
        textMatchingRequest.pids = Arrays.asList("adki46", "adki47", "bhckh500");
        textMatchingRequest.values = Arrays.asList(
                new TextProcessingInterface.MatchingRequest.ValueItem("name", "text content here"),
                new TextProcessingInterface.MatchingRequest.ValueItem("description", "text content here")
                );
        TextProcessingInterface.MatchingResponse textMatchingResponse = textService.match(textMatchingRequest);

        Map<String, Integer> result = new HashMap<>();
        result.put("count", textMatchingResponse.pids.size() + imageMatchingResponse.pids.size());
        return result;
    }

}
