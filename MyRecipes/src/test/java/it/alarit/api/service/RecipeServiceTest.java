package it.alarit.api.service;

import org.junit.Before;
import org.junit.Test;

import it.alarit.api.exception.NoElementsException;

public class RecipeServiceTest {

	private RecipeService recipeService;
	
	@Test(expected=NoElementsException.class)
	public void saveNullTest() throws Exception{
		recipeService.save(null);
	}
	
	@Before
	public void init(){
		recipeService = new RecipeService();
	}
}
