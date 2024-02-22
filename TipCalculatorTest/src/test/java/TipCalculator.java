import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class TipCalculator {
	public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\vijay\\eclipse-workspace\\MoviesAppTest\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qatipcalc.ccbp.tech/");
        WebElement billAmountEl = driver.findElement(By.cssSelector("input[id^='bill']"));
        billAmountEl.sendKeys("1000");
        WebElement percentgEl = driver.findElement(By.cssSelector("input[id^='percent']"));
        percentgEl.sendKeys("12");
        WebElement calculateBtn = driver.findElement(By.cssSelector("button[class*='calculate']"));
        calculateBtn.click();
        WebElement tipAmount = driver.findElement(By.cssSelector("p[id*='tip']"));
        String text = tipAmount.getText();
        String expected = "120.00";
        WebElement totalAmount = driver.findElement(By.cssSelector("p[id*='total']"));
        String actual = totalAmount.getText();
        String exptotal = "1120.00";
        if((text.equals(expected)&&(actual.equals(exptotal)))){
            System.out.println("Tip Calculated Correctly");
        }else{
            System.out.println("Tip Calculated Incorrectly");
        }
        percentgEl.clear();
        calculateBtn.click();
        WebElement errorEl = driver.findElement(By.cssSelector("p[id^='error']"));
        actual = errorEl.getText();
        expected = "Please Enter a Valid Input.";
        if(actual.equals(expected)){
            System.out.println("Error message displayed for no input");
        }else{
            System.out.println("Error message missing for no input");
        }
        percentgEl.sendKeys("10f");
        calculateBtn.click();
        actual = errorEl.getText();
        expected = "Please Enter a Valid Input.";
        if(actual.equals(expected)){
            System.out.println("Error message displayed for invalid input");
        }else{
            System.out.println("Error message missing for invalid input");
        }
        driver.quit();
    }

}
