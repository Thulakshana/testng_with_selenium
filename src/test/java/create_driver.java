
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class create_driver {
    WebDriver driver;
    @BeforeClass
    public void initial_test(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");
    }

    @Test (priority = 1)
    public void test_one() throws InterruptedException {
        WebElement link=driver.findElement(By.linkText("Test Login Page"));
        link.click();
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "test_one")
    public void test_001() throws InterruptedException {
        WebElement username_textbox=driver.findElement(By.name("username"));
        username_textbox.sendKeys("student");
        WebElement password_textbox=driver.findElement(By.name("password"));
        password_textbox.sendKeys("Password123");
        Thread.sleep(3000);
        WebElement btn=driver.findElement(By.xpath("//button[@id='submit']"));
        btn.click();
        Thread.sleep(3000);

        String actual_url=driver.getCurrentUrl();
        if(actual_url.equals("https://practicetestautomation.com/logged-in-successfully/")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
    }

    @Test(dependsOnMethods = "test_001")
    public void navigate(){
        driver.navigate().back();
        String url=driver.getCurrentUrl();
        if(url.equals("https://practicetestautomation.com/practice-test-login/")){
            System.out.println("back ok");
        }else{
            System.out.println("not back");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }






}
