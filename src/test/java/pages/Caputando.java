package pages;

import java.util.Iterator;

import utils.JsonReader;


public class Caputando {
	public static void main(String[] args) {
		//AcessandoArquivoCSV dadosDoCSV = new AcessandoArquivoCSV();
		//System.out.println(dadosDoCSV.getAno());
		//System.out.println(dadosDoCSV.getTelefone());
		//System.out.println(dadosDoCSV.getZipCode());
		
		JsonReader reader = new JsonReader();
		
		for(int i = 0; i < 6; i++) {
			System.out.println( reader.telefone.get(i));
		}
		
		
	}
	
	
	
	
    	

}
