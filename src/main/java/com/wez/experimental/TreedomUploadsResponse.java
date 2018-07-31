package com.wez.experimental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreedomUploadsResponse {
    private Long code;
    private String data;
    private String msg;
}
