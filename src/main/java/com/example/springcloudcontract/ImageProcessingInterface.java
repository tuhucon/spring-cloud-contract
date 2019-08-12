package com.example.springcloudcontract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface ImageProcessingInterface {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class MatchingResponse {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class MatchingItem {
            String oid;
            Float score;
        }
        List<MatchingItem> pids;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class MatchingRequest {
        @Data
        @NoArgsConstructor
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
