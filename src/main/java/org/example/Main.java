package org.example;

import com.sofnium.beans.Santtium;
import com.sofnium.beans.SearchParameter;
import com.sofnium.beans.WebCtrl;
import com.sofnium.enumerators.By;
import com.sofnium.enumerators.KeyEvent;
import com.sofnium.enumerators.KeyToPress;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        SearchParameter byTitle = new SearchParameter(By.TAGNAME, "h2");
        SearchParameter byBtnHome = new SearchParameter(By.ID, "home");
        SearchParameter byBtnCatalog = new SearchParameter(By.ID, "video");
        SearchParameter byTitles = new SearchParameter(By.XPATH, "//*[@id=\"root\"]/div[3]/h2");


        Santtium santtium = new Santtium("hp57I", "34407912-3969-4fab-acc3-f7a9351e33e0");
        santtium.start();

        santtium.refreshPage();
        staticWait(3000);

        WebCtrl title = santtium.searchWebCtrl(byTitle);
        title.flash();

        String screenshotByDevice = santtium.takeScreenshotFromDevice("1KH3K");
        System.out.println(screenshotByDevice);

        WebCtrl btnHome = santtium.searchWebCtrl(byBtnHome);
        btnHome.flash();

        WebCtrl btnCatalog = santtium.searchWebCtrl(byBtnCatalog);
        btnCatalog.flash();

        String screenshot = santtium.takeScreenShot("document.getElementsByClassName(\"container center\")[0]");

        santtium.keyPress(new KeyToPress(KeyEvent.Down, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Enter, "keyup"));

        staticWait(1000);

        List<WebCtrl> titles = santtium.searchWebCtrls(byTitles);
        titles.get(0).flash();

        santtium.keyPress(new KeyToPress(KeyEvent.Right, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Right, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Right, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Down, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Enter, "keyup"));
        staticWait(8000);
        santtium.keyPress(new KeyToPress(KeyEvent.Space, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Right, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Enter, "keyup"));
        staticWait(8000);
        santtium.keyPress(new KeyToPress(KeyEvent.Space, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Left, "keydown"));
        santtium.keyPress(new KeyToPress(KeyEvent.Enter, "keyup"));
        staticWait(8000);
        santtium.keyPress(new KeyToPress(KeyEvent.Backspace, "keydown"));

        santtium.stop();
    }

    private static void staticWait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}