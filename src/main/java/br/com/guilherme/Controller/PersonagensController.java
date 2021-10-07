package br.com.guilherme.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.guilherme.Service.PersonagensService;
import br.com.guilherme.model.Personagens;

@RestController
@RequestMapping("/presonagens")

public class PersonagensController {
	
	@Autowired
	private PersonagensService personagensSevice;
	
	@GetMapping
	public List<Personagens> findAll(){
		return personagensSevice.findAll();
	}
	
	@GetMapping("/{nome}")
	public Personagens findOne(@PathVariable String nome) {
		return personagensSevice.findOne(nome);
	}
	
	@PostMapping
	public Map<String, String> inset(@RequestBody Personagens personagens){
		return personagensSevice.inset(personagens);
	}
	
	@PutMapping
	public Map<String, String> edit(@RequestBody Personagens personagens){
		return personagensSevice.edit(personagens);
	}
	
	@DeleteMapping
	public Map<String, String> remove(String nome){
		return personagensSevice.remove(nome);
	}
}
