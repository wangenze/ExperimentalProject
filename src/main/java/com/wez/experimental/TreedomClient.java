package com.wez.experimental;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class TreedomClient extends AbstractUploadClient<TreedomUploadResponse> {

    private static final String UPLOAD_URL = "https://dv.treedom.cn/v1/device/upload";
    private static final String UPLOADS_URL = "https://dv.treedom.cn/v1/device/uploads";

    public TreedomUploadsResponse uploads(String... jpgFilePaths) {
        Validate.isTrue(ArrayUtils.getLength(jpgFilePaths) == 4);
        HttpPost post = buildUploadsRequest(jpgFilePaths);
        return postRequest(post, TreedomUploadsResponse.class, TreedomUploadsResponse::new);
    }

    private HttpPost buildUploadsRequest(String... jpgFilePaths) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        for (String jpgFilePath : jpgFilePaths) {
            File file = new File(jpgFilePath);
            builder.addBinaryBody("file", file, ContentType.IMAGE_JPEG, file.getName());
        }
        HttpEntity multipart = builder.build();
        HttpPost post = new HttpPost(UPLOADS_URL);
        post.setEntity(multipart);
        return post;
    }

    @Override
    protected HttpPost buildRequest(String jpgFilePath) {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        File file = new File(jpgFilePath);
        builder.addBinaryBody("file", file, ContentType.IMAGE_JPEG, file.getName());
        HttpEntity multipart = builder.build();
        HttpPost post = new HttpPost(UPLOAD_URL);
        post.setEntity(multipart);
        return post;
    }

    @Override
    protected Class<TreedomUploadResponse> getResponseClass() {
        return TreedomUploadResponse.class;
    }

    @Override
    protected TreedomUploadResponse getDefaultResponse() {
        return new TreedomUploadResponse();
    }
}
