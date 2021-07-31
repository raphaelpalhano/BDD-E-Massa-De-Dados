package pages;

import static org.junit.Assert.fail;

import org.apache.commons.lang3.Functions.FailableBiConsumer;
import org.openqa.selenium.WebDriver;

import utils.AcessandoArquivoCSV;
import utils.JsonReader;
import utils.Utils;

public class CadastroDeUsuario {
	private AcessandoArquivoCSV baseDeDadosCSV;
	private Utils utils;
	private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	private JsonReader readerJson;
	
	
	public CadastroDeUsuario(WebDriver driver) {
		this.baseDeDadosCSV = new AcessandoArquivoCSV(driver);
		this.readerJson = new JsonReader();
		this.utils = new Utils(driver);
	}

	public void acessarFormulario() {
		utils.navegarParaURL(URL);
		utils.preecherCampoTexto("email_create", "raphael1angel@gmail.com");
		utils.clicarEmbotaoParaAcessar("SubmitCreate");
	}
	
	
	
	
	public void preencherFormularioComCSV() {
		baseDeDadosCSV.preenchedorDeFormulario();
		utils.tirarFotoDaPaginaAtual();
//		utils.clicarEmbotaoParaAcessar("id_gender2");
//		utils.preecherCampoTexto("customer_firstname", this.baseDeDadosCSV.getNome());
//		utils.preecherCampoTexto("customer_lastname", this.baseDeDadosCSV.getSobrenome());
//		utils.preecherCampoTexto("passwd", this.baseDeDadosCSV.getPassword());
//		utils.preecherCampoTexto("days", this.baseDeDadosCSV.getDia());
//		utils.preecherCampoTexto("months", this.baseDeDadosCSV.getMes());
//		utils.preecherCampoTexto("years", this.baseDeDadosCSV.getAno());
//		utils.preecherCampoTexto("company", this.baseDeDadosCSV.getNomeEmpresa());
//		utils.preecherCampoTexto("address1", this.baseDeDadosCSV.getEndereço());
//		utils.preecherCampoTexto("city", this.baseDeDadosCSV.getCidade());
//		utils.preecherCampoTexto("id_state", this.baseDeDadosCSV.getEstado());
//		utils.preecherCampoTexto("postcode", this.baseDeDadosCSV.getZipCode());
//		utils.preecherCampoTexto("phone_mobile", this.baseDeDadosCSV.getTelefone());
			

	}
	
	public void preencherFormularioComJSON(int quantidade) {
		for(int i = 0; i < quantidade; i++) {
			
			try {
				utils.clicarEmbotaoParaAcessar("id_gender2");
				utils.preecherCampoTexto("customer_firstname", readerJson.nome.get(i));
				utils.preecherCampoTexto("customer_lastname",readerJson.sobrenome.get(i));
				utils.preecherCampoTexto("passwd", readerJson.password.get(i));
				utils.preecherCampoTexto("days", readerJson.dia.get(i));
				utils.preecherCampoTexto("months", readerJson.mes.get(i));
				utils.preecherCampoTexto("years", readerJson.ano.get(i));
				utils.preecherCampoTexto("company", readerJson.empresa.get(i));
				utils.preecherCampoTexto("address1", readerJson.endereco.get(i));
				utils.preecherCampoTexto("city", readerJson.cidade.get(i));
				utils.preecherCampoTexto("id_state", readerJson.estado.get(i));
				utils.preecherCampoTexto("postcode", readerJson.cep.get(i));
				utils.preecherCampoTexto("phone_mobile", readerJson.telefone.get(i));
				
				utils.scrollParaCima("customer_firstname");
				utils.limparCampoTexto("customer_firstname");
				utils.limparCampoTexto("customer_lastname");
				utils.limparCampoTexto("passwd");
				utils.limparCampoTexto("company");
				utils.limparCampoTexto("address1");
				utils.limparCampoTexto("phone_mobile");
				utils.limparCampoTexto("postcode");	
				
				}catch(IndexOutOfBoundsException e) {
					fail("Valor do parametro maior que a lista");
					
				}
			}
	}
	
	public void fecharDriver() {
		utils.fecharDriver();
	}
	
}
