package com.wez.experimental;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public abstract class AbstractUploadClient<R> {

    public R upload(String jpgFilePath) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = buildRequest(jpgFilePath);
            try (CloseableHttpResponse response = client.execute(post)) {
                String content = EntityUtils.toString(response.getEntity());
                return new ObjectMapper().readerFor(getResponseClass()).readValue(content);
            } catch (Exception ex) {
                ex.printStackTrace();
                return getDefaultResponse();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return getDefaultResponse();
        }
    }

    protected abstract HttpPost buildRequest(String jpgFilePath);

    protected abstract Class<R> getResponseClass();

    protected abstract R getDefaultResponse();
}
