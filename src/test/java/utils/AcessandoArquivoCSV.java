package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class AcessandoArquivoCSV {
	//

	String CSVPATH = "C:\\MeusCasosDeTesteTreino\\Treinamento\\AutomacaoDesafio\\src\\test\\resources\\csv\\informacoes.csv";
	private CSVReader csvReader;
	private String[] csvCell;
	private Utils utils;
	private String email;
	private String nome;
	private String sobrenome;
	private String password;
	private String dia;
	private String mes;
	private String ano;
	private String nomeEmpresa;
	private String endereço;
	private String estado;
	private String cidade;
	private String pais;
	private String zipCode;
	private String telefone;

	public AcessandoArquivoCSV(WebDriver driver) {
		try {
			this.utils = new Utils(driver);
			csvReader = new CSVReader(new FileReader(CSVPATH));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// email, nome, sobrenome, password, dia, mes, ano, empresa, endereco, cidade,
	// estado, cep, telefone

	public void preenchedorDeFormulario() {
		try {
			while ((csvCell = this.csvReader.readNext()) != null) {
				email = csvCell[0];
				nome = csvCell[1];
				sobrenome = csvCell[2];
				password = csvCell[3];
				dia = csvCell[4];
				mes = csvCell[5];
				ano = csvCell[6];
				nomeEmpresa = csvCell[7];
				endereço = csvCell[8];
				cidade = csvCell[9];
				estado = csvCell[10];
				zipCode = csvCell[11];
				telefone = csvCell[12];
				utils.clicarEmbotaoParaAcessar("id_gender2");
				utils.preecherCampoTexto("customer_firstname", this.nome);
				
				utils.preecherCampoTexto("customer_lastname", this.sobrenome);
				
				utils.preecherCampoTexto("passwd", this.password);
				
				utils.preencherData(dia, mes, ano);
				
				utils.preecherCampoTexto("company", this.nomeEmpresa);
				
				utils.preecherCampoTexto("address1", this.endereço);
				
				utils.preecherCampoTexto("city", this.cidade);
				
				utils.preecherCampoTexto("id_state", this.estado);
				
				utils.preecherCampoTexto("postcode", this.zipCode);
				
				utils.preecherCampoTexto("phone_mobile", this.telefone);
				
				utils.scrollParaCima("customer_firstname");
				utils.limparCampoTexto("customer_firstname");
				utils.limparCampoTexto("customer_lastname");
				utils.limparCampoTexto("passwd");
				utils.limparCampoTexto("company");
				utils.limparCampoTexto("address1");
				utils.limparCampoTexto("phone_mobile");
				utils.limparCampoTexto("postcode");
			}
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCsvCell(String[] csvCell) {
		this.csvCell = csvCell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
