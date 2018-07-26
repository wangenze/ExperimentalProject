package com.wez.experimental;

import org.junit.Ignore;

public class TreedomClientTest {

    @Ignore
    public void upload() {
        TreedomResponse response = new TreedomClient().upload("/Users/enzewang/Downloads/endurance.jpg");
        System.out.println(response);
    }
}