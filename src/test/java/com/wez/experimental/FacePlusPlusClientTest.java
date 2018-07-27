package com.wez.experimental;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class FacePlusPlusClientTest {

    @Test
    public void upload() {
        FacePlusPlusResponse response = new FacePlusPlusClient().upload("/Users/enzewang/Downloads/human.jpg");
        System.out.println(response);
    }
}