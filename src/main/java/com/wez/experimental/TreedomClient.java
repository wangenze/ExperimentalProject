package com.wez.experimental;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.File;

public class TreedomClient extends AbstractUploadClient<TreedomResponse> {

    private static final String UPLOAD_URL = "https://dv.treedom.cn/v1/device/upload";

    @Override
    protected HttpPost buildRequest(String jpgFilePath) {
        HttpPost post = new HttpPost(UPLOAD_URL);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", new File(jpgFilePath), ContentType.IMAGE_JPEG, "file.jpg");
        HttpEntity multipart = builder.build();
        post.setEntity(multipart);
        return post;
    }

    @Override
    protected Class<TreedomResponse> getResponseClass() {
        return TreedomResponse.class;
    }

    @Override
    protected TreedomResponse getDefaultResponse() {
        return new TreedomResponse();
    }
}
