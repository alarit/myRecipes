var recipeService = new function(){
	
	this.recipeUrl = '../api/recipe';
	
	this.findRecipeByFilter = function(word, filter){
		var data = {word: word, filter: filter};
		return $.get(this.recipeUrl, data).promise();
	}
	
	this.findRecipe = function(id, callback){
		$.get(this.recipeUrl +'/' + id)
		.done(function(recipe){
			callback(recipe);
		})
		.fail(function(e){
			displayMsg('Error ' + e);
		});
	}
	
	this.saveRecipe = function(recipe){
		$.post(this.recipeUrl, recipe)
		.done(function(recipe){
			displayMsg('Recipe saved');
		})
		.fail(function(e){
			displayMsg('Error ' + e);
		});
	}
};