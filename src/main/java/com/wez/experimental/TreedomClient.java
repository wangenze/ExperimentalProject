package com.wez.experimental;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class TreedomClient {

    private static final String UPLOAD_URL = "https://dv.treedom.cn/v1/device/upload";

    public TreedomResponse upload(String jpgFilePath) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(UPLOAD_URL);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("file", new File(jpgFilePath), ContentType.IMAGE_JPEG, "file.jpg");
            HttpEntity multipart = builder.build();
            post.setEntity(multipart);
            try (CloseableHttpResponse response = client.execute(post)) {
                String content = EntityUtils.toString(response.getEntity());
                return new ObjectMapper().readerFor(TreedomResponse.class).readValue(content);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new TreedomResponse();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new TreedomResponse();
        }
    }
}
