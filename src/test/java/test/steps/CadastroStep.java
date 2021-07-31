package test.steps;


import io.cucumber.java.BeforeStep;
import io.cucumber.java.pt.Dado;
import pages.CadastroDeUsuario;
import pages.iniciatorBrowser;

public class CadastroStep {
	iniciatorBrowser iniciar;
	CadastroDeUsuario passosCadastro;
	
	@BeforeStep
	public void setup() {
		iniciar = new iniciatorBrowser();
		this.passosCadastro = new CadastroDeUsuario(this.iniciar.getDriver());
		this.iniciar.getDriver().manage().window().maximize();
		
	}

	@Dado("o usuario que acessa a plataforma e faz o cadastro")
	public void o_usuario_que_acessa_a_plataforma_e_faz_o_cadastro() {
		this.passosCadastro.acessarFormulario();
		//this.passosCadastro.preencherFormularioComCSV();
		this.passosCadastro.preencherFormularioComJSON(6);
			
	}
	
	
	
	
//	@After
//	public void fecharTudo() {
//		this.passosCadastro.fecharDriver();
//	}
	

}
