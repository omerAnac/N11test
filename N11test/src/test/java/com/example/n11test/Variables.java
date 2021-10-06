package com.example.n11test;

import org.openqa.selenium.By;

public class Variables {

    //---Variables---
    public String mainPage="https://www.n11.com/";
    public String expectedMainMage="https://www.n11.com/";
    public String expectedLoginpage="https://www.n11.com/giris-yap";
    public String expected2Page="https://www.n11.com/arama?q=Bilgisayar&pg=2";
    public String n11Mail="omeranac12@gmail.com"; // lütfen N11 hesap mailinizi giriniz
    public String n11psw="on8021995"; //lütfen N11 hesap şifrenizi giriniz

    //----Paths----
    public By buttonSignBy = By.className("btnSignIn");
    public By mailBy=By.id("email");
    public By pswBy=By.id("password");
    public By loginBy=By.id("loginButton");
    public By searchBoxBy=By.id("searchData");
    public By searchBtnBy=By.className("searchBtn");
    public By secandPageBy=By.xpath(".//*[@class='pagination']/a[2]");
    public By rndItemBy=By.xpath(".//*[@class='listView ']//ul//li[3]//div[1]//div[1]//a[1]");
    public By itemPriceBy=By.xpath(".//*[@class='newPrice']/ins[1]");
    public By addBasketBy=By.xpath(".//div[contains(@class,'proDetailArea')]//a[@title='Sepete Ekle']/span");
    public By basketBy=By.xpath(".//*[@class='myBasketHolder']");
    public By itemBasketPriceBy=By.xpath(".//*[@class='priceArea']//span");
    public By itemNumberIncreaseBy=By.xpath(".//*[@class='spinnerFieldContainer']//span[1]");
    public By chekItemNUmberBy=By.xpath(".//*[@class='quantity']");
    public By deleteItemBy=By.xpath(".//*[@class='prodAction']//span[1]");
    public By emptyBasketChekBy=By.xpath(".//*[@class='cartEmptyText']//h2");
    public By addedBasketPopUpBy=By.xpath(".//*[@class='myBasketList otherListTemplate']");
}
