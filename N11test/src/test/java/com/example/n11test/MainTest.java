package com.example.n11test;

import com.example.n11test.Check;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainTest extends Variables {
    //------Objects----
    private WebDriver driver;
    public Check check;



    @BeforeAll
    public static void setupDriver(){
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setup(){

         driver=new FirefoxDriver();
         driver.manage().window().maximize();
         check=new Check(driver);
    }

    @AfterEach
    void tearDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();
    }

    @Test
    void name() throws InterruptedException {
        //n11.com girer
        driver.get(mainPage);

        //giriş yap butununa tıklar
        var buttonSign= driver.findElement(buttonSignBy);
        check.checkURL(expectedMainMage);
        buttonSign.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //maili yazar
        var mailBox= driver.findElement(mailBy);
        mailBox.click();
        mailBox.sendKeys(n11Mail);

        //şifreyi yazar
        var pswBox = driver.findElement(pswBy);
        pswBox.click();
        pswBox.sendKeys(n11psw);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //hesaba giriş yapar
        driver.findElement(loginBy).click();

        //hesaba giriş kontrolu
        check.checkURL(expectedMainMage);//eğer n11.com urlsine giderse login işlemi başarılıdır

        //arama çubuğuna bilgisayar yazar ve arar
        var searchBox = driver.findElement(searchBoxBy);
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(searchBtnBy).click();

        //2. sayfaya gider
        driver.findElement(secandPageBy).click();
        check.checkURL(expected2Page);        //2. sayfanın açıldığını kontrol eder

        //2 saydan seçilen bir ürüne gider
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(rndItemBy).click();

        var itemPrice= driver.findElement(itemPriceBy);
        String itemPriceText= itemPrice.getText(); // ürünün fiyatı

        //sepete ekleme
        Thread.sleep(4000);
        WebElement SepeteEkle = driver.findElement(addBasketBy);
        SepeteEkle.click();

        var wait = new WebDriverWait(driver,30);
        var addedBasketPopUp = driver.findElement(addedBasketPopUpBy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addedBasketPopUp);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedBasketPopUpBy)); // sepete eklendi popup'ı çıkmasını bekler

        //sepete git
        driver.findElement(basketBy).click();
        var itemBasketPrice=driver.findElement(itemBasketPriceBy);
        String itemBasketPriceText=itemBasketPrice.getText();

        check.checkPrice(itemBasketPriceText,itemPriceText);  //fiyat karşılaştırılması


        //adet arttırımı
        var itemNumber=driver.findElement(itemNumberIncreaseBy);
        itemNumber.click();

        check.checkQuantity(chekItemNUmberBy); //ürün adet kontrolü

        //ürün silme
        var deleteItem=driver.findElement(deleteItemBy);
        deleteItem.click();

        check.chekBasket(emptyBasketChekBy); //sepetin boş olduğunu kontrol eder

    }

}
