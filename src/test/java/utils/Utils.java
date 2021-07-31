package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoes.csv")
public class Utils {

	WebDriverWait wait;
	WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void preecherCampoTexto(String idElement, String valor){
       driver.findElement(By.id(idElement)).sendKeys(valor);
    }
    
//    public void preencherDia(String day) {
//    	//Actions action = new Actions(driver);   
//      
//    	//driver.findElement(By.id(idElement)).sendKeys(Keys, valor);
//    }
//    
    public void maximizarTela() {
    	driver.manage().window().maximize();
    }
   

    public void clicarEmbotaoParaAcessar(String idElement){
    	 driver.findElement(By.id(idElement)).click();
    }

    public void preencherData(String dia, String mes, String ano) {
    	 new Select(this.driver.findElement(By.id("days"))).selectByValue(dia);
    	 new Select(this.driver.findElement(By.id("months"))).selectByValue(mes);
    	 new Select(this.driver.findElement(By.id("years"))).selectByValue(ano);
    }
    
    public void limparCampoTexto(String idElement) {
    	driver.findElement(By.id(idElement)).clear();
    }
    
    public void navegarParaURL(String URL) {
    	driver.navigate().to(URL);
    }

    public void voltarUmaTela(){
       driver.navigate().back();
    }

    public void recarregarATela(){
        driver.navigate().refresh();
    }
    
    public void fecharDriver() {
    	driver.close();
    	driver.quit();
    }

  
    public void limparCache(){
        driver.manage().deleteAllCookies();
    }

    
    public void esperarCarregarElemento(int segundos, String elementoQueDesejoEspera){
        wait = new WebDriverWait(this.driver, segundos);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementoQueDesejoEspera)));

    }
    
    public void scrollParaCima(String idElement) {
    	driver.findElement(By.id(idElement)).sendKeys(Keys.ARROW_UP);
    }
    
    

    public void esperarCarregarDriver(int segundos){
        driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }


    public void tirarFotoDaPaginaAtual() {
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         try {
			FileUtils.copyFile(scrFile, new File("C:\\MeusCasosDeTesteTreino\\Treinamento\\AutomacaoDesafio\\src\\test\\resources\\images\\image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }

    public boolean validandoTexto(String valor){
        return driver.getPageSource().contains(valor);
    }
    
    
    public void formularia(
    @Param(name = "email") String email, @Param(name = "nome") 
    String nome,  
    @Param(name = "sobrenome") String sobrenome,  
    @Param(name = "password") String password, 
    @Param(name = "dia") String dia, 
    @Param(name = "mes") String mes, 
    @Param(name = "ano") String ano, 
    @Param(name = "empresa") String empresa, 
    @Param(name = "endereco") String endereco,
    @Param(name = "cidade") String cidade,
    @Param(name = "estado") String estado,
    @Param(name = "cep") String cep,
    @Param(name = "telefone") String telefone,int quantidade) {
    	
    }

    
    
}

