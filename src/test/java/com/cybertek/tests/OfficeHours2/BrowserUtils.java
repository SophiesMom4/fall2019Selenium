package com.cybertek.tests.Office_Hours1;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /* we are going to write a method that :
    it takes a list of web elements
    and
    it returns a list of strings
     */

    public static List<String> getElementsText(List<WebElement> listEl) {
        //given a list web elements, extract the text of the element into new list of strings
        List<String> listSt = new ArrayList<>();
        for (WebElement element : listEl) {
            listSt.add(element.getText());
        }
        return listSt;
    }
}
