package com.wez.experimental;

import lombok.AllArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;

import java.io.File;

@AllArgsConstructor
public class FacePlusPlusClient extends AbstractUploadClient<FacePlusPlusResponse> {

    private static final String UPLOAD_URL = "https://api-cn.faceplusplus.com/humanbodypp/v1/detect";
    private static final String API_KEY = "jdf4Qhvt76H0S31fTv4j7_SX71Iyt0Jg";
    private static final String API_SECRET = "PHHlBNyqIqEvxseV77di6-UveP7HMNQq";
    private static final String ATTRIBUTES = "gender,upper_body_cloth,lower_body_cloth";

    private final String apiKey;
    private final String apiSecret;

    public FacePlusPlusClient() {
        this(API_KEY, API_SECRET);
    }

    @Override
    protected HttpPost buildRequest(String jpgFilePath) {
        HttpPost post = new HttpPost(UPLOAD_URL);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("api_key", new StringBody(apiKey, ContentType.MULTIPART_FORM_DATA));
        builder.addPart("api_secret", new StringBody(apiSecret, ContentType.MULTIPART_FORM_DATA));
        builder.addPart("return_attributes", new StringBody(ATTRIBUTES, ContentType.MULTIPART_FORM_DATA));
        builder.addBinaryBody("image_file", new File(jpgFilePath), ContentType.IMAGE_JPEG, "file.jpg");
        HttpEntity multipart = builder.build();
        post.setEntity(multipart);
        return post;
    }

    @Override
    protected Class<FacePlusPlusResponse> getResponseClass() {
        return FacePlusPlusResponse.class;
    }

    @Override
    protected FacePlusPlusResponse getDefaultResponse() {
        return new FacePlusPlusResponse();
    }
}
