package com.wez.experimental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacePlusPlusResponse {

    private String request_id;
    private List<HumanBody> humanbodies;
    private String image_id;
    private Integer time_used;
    private String error_message;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HumanBody {
        private Float confidence;
        private HumanBodyRectangle humanbody_rectangle;
        private Attributes attributes;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HumanBodyRectangle {
        private Integer width;
        private Integer top;
        private Integer height;
        private Integer left;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Attributes {
        private Gender gender;
        private UpperBodyCloth upper_body_cloth;
        private LowerBodyCloth lower_body_cloth;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Gender {
        private Float male;
        private Float female;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpperBodyCloth {
        private String upper_body_cloth_color;
        private ColorRGB upper_body_cloth_color_rgb;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LowerBodyCloth {
        private String lower_body_cloth_color;
        private ColorRGB lower_body_cloth_color_rgb;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ColorRGB {
        private Integer r;
        private Integer g;
        private Integer b;
    }
}
