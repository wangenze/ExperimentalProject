package com.wez.experimental;

import org.junit.Ignore;

public class FacePlusPlusClientTest {
    @Ignore
    public void upload() {
        FacePlusPlusResponse response = new FacePlusPlusClient().upload("/Users/enzewang/Downloads/human.jpg");
        if (response.getHumanbodies() != null) {
            System.out.println(response.getHumanbodies().size() + " human(s) identified");
            for (int i = 0; i < response.getHumanbodies().size(); i++) {
                FacePlusPlusResponse.HumanBody humanBody = response.getHumanbodies().get(i);
                System.out.println("Human " + (i + 1) + ":");
                System.out.println("\tConfidence: " + humanBody.getConfidence());
                FacePlusPlusResponse.Attributes attributes = humanBody.getAttributes();
                if (attributes != null) {
                    FacePlusPlusResponse.Gender gender = attributes.getGender();
                    String possibleGender = gender.getMale() > gender.getFemale() ? "Male" : "Female";
                    System.out.println("\tGender: " + possibleGender);
                    FacePlusPlusResponse.UpperBodyCloth upper_body_cloth = attributes.getUpper_body_cloth();
                    if (upper_body_cloth != null) {
                        System.out.println("\tUpper cloth color: " + upper_body_cloth.getUpper_body_cloth_color());
                    }
                    FacePlusPlusResponse.LowerBodyCloth lower_body_cloth = attributes.getLower_body_cloth();
                    if (lower_body_cloth != null) {
                        System.out.println("\tLower cloth color: " + lower_body_cloth.getLower_body_cloth_color());
                    }
                }
            }
        }
    }
}