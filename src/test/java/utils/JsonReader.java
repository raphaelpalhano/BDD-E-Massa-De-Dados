package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReader {
	JSONParser jsonParser;
	JSONArray jsonArray;
	JSONObject readerFile;
	String filePath = "C:\\MeusCasosDeTesteTreino\\Treinamento\\AutomacaoDesafio\\src\\test\\resources\\json\\cadastro.json";
	public List<String> email = new ArrayList<>();
	public List<String> nome = new ArrayList<>();
	public List<String> sobrenome = new ArrayList<>();
	public List<String> password = new ArrayList<>();
	public List<String> dia = new ArrayList<>();
	public List<String> mes = new ArrayList<>();
	public List<String> ano = new ArrayList<>();
	public List<String> empresa = new ArrayList<>();
	public List<String> endereco = new ArrayList<>();
	public List<String> cidade = new ArrayList<>();
	public List<String> estado = new ArrayList<>();
	public List<String> cep = new ArrayList<>();
	public List<String> telefone = new ArrayList<>();

	
	public JsonReader() {
		try {
			jsonParser = new JSONParser();
			readerFile = (JSONObject) jsonParser.parse(new FileReader(filePath));
			this.lendoJSON();
			
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// email, nome, sobrenome, password, dia, mes, ano, empresa, endereco, cidade,
	// estado, cep, telefone
	
	public void lendoJSON() {
		
		
		this.jsonArray = (JSONArray) readerFile.get("usuarios");
       
        for(int i = 0; i < jsonArray.size(); i++) {
        	//System.out.println(listagem.get(i));
        	JSONObject innerObj = (JSONObject) jsonArray.get(i); //0, 1,2,3,4,5,6
        	email.add((String) innerObj.get("email"));
        	nome.add((String) innerObj.get("nome"));
        	sobrenome.add((String) innerObj.get("sobrenome"));
        	password.add((String) innerObj.get("password"));
        	dia.add((String) innerObj.get("dia"));
        	mes.add((String) innerObj.get("mes"));
        	ano.add((String) innerObj.get("ano"));
        	empresa.add((String) innerObj.get("empresa"));
        	endereco.add((String) innerObj.get("endereco"));
        	cidade.add((String) innerObj.get("cidade"));
        	estado.add((String) innerObj.get("estado"));
        	cep.add((String) innerObj.get("cep"));
        	telefone.add((String) innerObj.get("telefone"));

        }

           
     }
}
	

