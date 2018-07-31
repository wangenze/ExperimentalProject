package com.wez.experimental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreedomUploadResponse {
    private Long code;
    private ResponseData data;
    private String msg;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseData {
        private String url;
        private String hash;
    }
}
