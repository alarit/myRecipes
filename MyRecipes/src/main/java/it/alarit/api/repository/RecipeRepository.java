package it.alarit.api.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.alarit.api.model.Recipe;

@Repository
public interface RecipeRepository extends GenericRepository<Recipe, Long>{

	public List<Recipe> findByNameContainingIgnoreCase(@Param("name") String name);
	
	public List<Recipe> findByDescriptionContainingIgnoreCase(@Param("description") String description);
	
}
