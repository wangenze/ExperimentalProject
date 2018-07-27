package com.wez.experimental;

import org.junit.Ignore;

public class FacePlusPlusClientTest {

    @Ignore
    public void upload() {
        FacePlusPlusResponse response = new FacePlusPlusClient().upload("/Users/enzewang/Downloads/human.jpg");
        System.out.println(response);
    }
}