package it.alarit.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.alarit.api.model.Recipe;
import it.alarit.api.service.GenericService;
import it.alarit.api.service.RecipeService;

@RestController
@RequestMapping("recipe")
public class RecipeController extends AbstractApiController{
	
	@Autowired 
	GenericService genericService;
	@Autowired 
	RecipeService recipeService;
	
	@GetMapping(value = "/{id}")
	public Recipe findById(@PathVariable final Long id) throws Exception{
		return recipeService.findById(id);
	}
	
	@PostMapping
	public Recipe save(final Recipe r) throws Exception{
		return recipeService.save(r);
	}
	
	@PutMapping(value = "/{recipe}")
	public Recipe update(final Recipe recipe) throws Exception{
		return recipeService.save(recipe);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable final Long id) throws Exception{
		recipeService.delete(id);
	}

	/*Autocomplete*/
	@GetMapping
	public List<Recipe> findByNameLike(@RequestParam final String word, @RequestParam final Long filter){
		return recipeService.find(word,filter);
	}

}
