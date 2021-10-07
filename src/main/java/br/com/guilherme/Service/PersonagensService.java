package br.com.guilherme.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.guilherme.model.Personagens;

@Service
public class PersonagensService {
	private List<Personagens> listOfPersonagens = new ArrayList<Personagens>();
		
	public PersonagensService() {
		listOfPersonagens.add(new Personagens("Goku","kameramera","100000"));
		
		listOfPersonagens.add(new Personagens("Vegeta","Resplendor fina","900000"));
	}
	
	public List<Personagens> findAll(){
		return listOfPersonagens;
	}
	
	public Personagens findOne(String nome) {
		for(Personagens personagens : listOfPersonagens) {
			if(personagens.getNome().equalsIgnoreCase(nome)){
				return personagens;
			}
		}
		return null;
	}
	
	public Map<String, String> inset(Personagens personagens){
		Map<String, String> result = new HashMap<String, String>();
		boolean isSuccess = listOfPersonagens.add(personagens);
		if(isSuccess) {
			result.put("result", "Personagens cadrastrados com sucesso!!!");
		}else {
			result.put("result", "Não foi possível cadrastra os personagens");
		}
		return result;
	}
	
	public Map<String, String> edit(@RequestBody Personagens personagens){
		Map<String, String> result = new HashMap<String, String>();
		
		for(Personagens elemento : listOfPersonagens) {
			if(elemento.getNome().equalsIgnoreCase(personagens.getNome())){
				int index = listOfPersonagens.indexOf(personagens);
				listOfPersonagens.set(index, elemento);
				result.put("result", "Personagens editados com sucesso!!!");
				return result;
			}
		}
		        result.put("result","Não foi possível editar os personagens");
		        return result;
	}

	public Map<String, String> remove(String nome){
		Map<String, String> result = new HashMap<String, String>();
		boolean isSuccess = listOfPersonagens.removeIf((personagens)->personagens.getNome().equalsIgnoreCase(nome));
		if(isSuccess) {
			result.put("result", "Personagens removidos com sucesso");
			return result;
		}else {
			result.put("result", "Não foi possível remover os personagens");
			return result;
		}
}        
}