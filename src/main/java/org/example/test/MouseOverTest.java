package org.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseOverTest extends BaseTest{

        @Test
                public void mouseTest() {

            homePage.redirectToSection("Mouse Over"); //навигация
            // на нужную страницу перед тестом

            String titleBefore = mouseOverPage.getClickMeAttribute("title"); //Берём значение атрибута
            // title у кнопки Click Me на странице MouseOverPage и Сохраняем его в переменную titleBefore
            //Нужен для сравнения до и после наведения мыши
            mouseOverPage.hoverClickMeButton();
            String titleAfter = mouseOverPage.getClickMeAttribute("title");
            //Снова читаем атрибут title после наведения мыши

            Assert.assertNotEquals(titleBefore, titleAfter);

            final int clickCount = 1;

            mouseOverPage.doubleClick(clickCount); //Метод doubleClick
            // выполняет двойной клик на нужном элементе. Передаём clickCount = 1 →
            // значит 2 клика (clickCount * 2)

            int actualClickCount = Integer.valueOf(mouseOverPage.getClickCount());
            //getClickCount() возвращает строку, поэтому оборачиваем в Integer.valueOf

            Assert.assertTrue(actualClickCount == clickCount * 2);

            System.out.println("test");


        }
    }
