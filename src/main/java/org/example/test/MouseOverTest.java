package org.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MouseOverTest extends BaseTest{

        @Test
                public void mouseTest() {

            homePage.redirectToSection("Mouse Over");

            String titleBefore = mouseOverPage.getClickMeAttribute("title");
            mouseOverPage.hoverClickMeButton();
            String titleAfter = mouseOverPage.getClickMeAttribute("title");

            Assert.assertNotEquals(titleBefore, titleAfter);

            final int clickCount = 1;

            mouseOverPage.doubleClick(clickCount);

            int actualClickCount = Integer.valueOf(mouseOverPage.getClickCount());

            Assert.assertTrue(actualClickCount == clickCount * 2);

            System.out.println("test");


        }
    }
