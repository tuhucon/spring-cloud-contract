package com.example.springcloudcontract;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface ImageProcessingInterface {
    @Getter
    @Setter
    class MatchingResponse {
        @Getter
        @Setter
        public static class MatchingItem {
            String oid;
            Float score;
        }
        List<MatchingItem> pids;
    }

    @Getter
    @Setter
    class MatchingRequest {
        @Getter
        @Setter
        @AllArgsConstructor
        public static class ValueItem {
            String type;
            String path;
        }

        List<String> pids;
        List<ValueItem> values;
    }

    @POST("/v1/objects/match")
    Call<MatchingResponse> match(@Body MatchingRequest matchingRequest);
}
