package com.wez.experimental;

import org.junit.Ignore;

public class TreedomClientTest {

    @Ignore
    public void upload() {
        TreedomUploadResponse response = new TreedomClient().upload("/Users/enzewang/Downloads/1.jpg");
        System.out.println(response);
    }

    @Ignore
    public void uploads() {
        TreedomUploadsResponse response = new TreedomClient().uploads(
                "/Users/enzewang/Downloads/1.jpg",
                "/Users/enzewang/Downloads/1.jpg",
                "/Users/enzewang/Downloads/1.jpg",
                "/Users/enzewang/Downloads/1.jpg");
        System.out.println(response);
    }
}