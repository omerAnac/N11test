package com.example.n11test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Check {
    WebDriver _webDriver;
    By _emptyBasketChekBy ;
    By _chekItemNUmberBy ;

    public Check(WebDriver webDriverriver) {
        this._webDriver=webDriverriver;
    }

    //Girilen sayfanın doğruluğunu kontrol eden method
    void checkURL(String expectedUrl){
        String URL = _webDriver.getCurrentUrl();
        if(URL.contains(expectedUrl))
        {
            System.out.println("Landed in correct URL " +
                    "" + URL);

        }else
        {
            System.out.println("Landed in wrong URL");

        }
    }
    //sepetin boş olduğunu kontrol etme
    void chekBasket(By emptyBasketChekBy ){
        this._emptyBasketChekBy=emptyBasketChekBy;
        _webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        var emptyBasketCheck=_webDriver.findElement(emptyBasketChekBy);
        if(!emptyBasketCheck.getText().isEmpty()) System.out.println("Basket is empty");
        else System.out.println("Basket is not empty");
    }

    //ürün adetinin 2 olduğunun kotrolü
    void checkQuantity(By chekItemNUmberBy){
        this._chekItemNUmberBy=chekItemNUmberBy;
        var checkItemNumber=_webDriver.findElement(chekItemNUmberBy);
        if (checkItemNumber.getAttribute("value").equals("2")) System.out.println("Quantity of items in basket="+checkItemNumber);
        else System.out.println(checkItemNumber);
    }
    //fiyat karşılaştırılması
    void checkPrice(String price1,String price2){
        if (price1.equals(price2)) System.out.println("Both price is same");
        else System.out.println("Both price is not same!");
    }
}

