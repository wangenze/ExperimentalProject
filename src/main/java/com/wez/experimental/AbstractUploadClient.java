package com.wez.experimental;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class AbstractUploadClient<R> {

    public R upload(String jpgFilePath) {
        HttpPost post = buildRequest(jpgFilePath);
        return postRequest(post, getResponseClass(), this::getDefaultResponse);
    }

    protected <T> T postRequest(HttpPost post, Class<T> responseClass,
                                Supplier<T> defaultResponseSupplier) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = client.execute(post)) {
                String content = EntityUtils.toString(response.getEntity());
                return new ObjectMapper().readerFor(responseClass).readValue(content);
            } catch (Exception ex) {
                ex.printStackTrace();
                return defaultResponseSupplier.get();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return defaultResponseSupplier.get();
        }
    }

    protected abstract HttpPost buildRequest(String jpgFilePath);

    protected abstract Class<R> getResponseClass();

    protected abstract R getDefaultResponse();
}
