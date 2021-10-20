package com.ilham.cpsat.base;

import com.ilham.cpsat.constants.ProjectConstants;
import com.ilham.cpsat.thread.ThreadLocalSEDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TestBase {
//    public static Properties prop;
//
//    public TestBase() {
//
//        try {
//            prop = new Properties();
////            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/configuration.properties");
//            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
//
//            prop.load(ip);
//        } catch (FileNotFoundException e) {//D:\SELENIUM\project-cp-practice
//            e.printStackTrace();
//        } catch (IOException e) { //config.properties
//            e.printStackTrace();
//        }
//    }

    public static void initialization() {
        String browserName = ProjectConstants.BROWSER_NAME;
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ThreadLocalSEDriver.setDriver(new ChromeDriver());
        } else if (browserName.equals("FF")) {
            WebDriverManager.firefoxdriver().setup();
            ThreadLocalSEDriver.setDriver(new FirefoxDriver());
        }
        ThreadLocalSEDriver.getDriver().manage().window().maximize();
        ThreadLocalSEDriver.getDriver().manage().deleteAllCookies();
        ThreadLocalSEDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
        // driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        ThreadLocalSEDriver.getDriver().get(ProjectConstants.URL);


    }


}



