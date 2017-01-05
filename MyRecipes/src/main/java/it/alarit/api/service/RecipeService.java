package it.alarit.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.alarit.api.model.Recipe;
import it.alarit.api.repository.RecipeRepository;

@Service
public class RecipeService{
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	public Recipe findById(final Long id){
		return recipeRepository.findOneById(id);
	}
	
	public List<Recipe> find(final String word, final Long filter){
		return (filter == 0L?findByName(word):findByDescription(word));
	}
	
	public Recipe save(final Recipe r) throws Exception{
		if(r == null) throw new NullPointerException();
		return recipeRepository.save(r);
	}
	
	public void delete(final Long id) throws Exception{
		if(id == null) throw new NullPointerException();
		Recipe r = findById(id);
		
		if(r == null) throw new NullPointerException();
		recipeRepository.delete(r);
	}
	
	private List<Recipe> findByName(final String name){
		return recipeRepository.findByNameContainingIgnoreCase(name);
	}
	
	private List<Recipe> findByDescription(final String description){
		return recipeRepository.findByDescriptionContainingIgnoreCase(description);
	}

}
