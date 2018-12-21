import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import static org.junit.Assert.assertEquals;
public class GoogleTest
{

    private String SearchValue;
    private String CheckAssertions;
    private WebDriver driver = new ChromeDriver();

    @Before
    public void PreConditions()
    {
        SearchValue="bike";
    }

    @Test
    public void TestMethod()
    {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(SearchValue.toLowerCase());
        driver.findElement(By.cssSelector("div.jsb input[type=\"submit\"]:nth-child(1)")).click();
        List<WebElement> allSearch = driver.findElements(By.cssSelector("div.rc"));

        for(int i=0; i < allSearch.size(); i++)
        {
            CheckAssertions =  allSearch.get(i).getText().toLowerCase();
            assertEquals(true,CheckAssertions.contains(SearchValue.toLowerCase()));
        }

    }

    @After
    public void PostConditions()
    {
        driver.quit();
    }
}
