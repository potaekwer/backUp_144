package yorizori.service.logic;

import java.util.List;

import yorizori.domain.Cookbook;
import yorizori.domain.Procedure;
import yorizori.domain.Recipe;
import yorizori.service.CookbookService;
import yorizori.store.CookbookStore;
import yorizori.store.RecipeStore;
import yorizori.store.StoreFactory;
import yorizori.store.StoreFactoryBuilder;

public class CookbookServiceLogic implements CookbookService{
	
	private CookbookStore cookbookStore;
	private RecipeStore recipeStore;
	
	public CookbookServiceLogic(){
		StoreFactory factory = StoreFactoryBuilder.createJdbcStoreFactory();
		cookbookStore = factory.getCookbookStore();
		recipeStore = factory.getRecipeStore();
	}
	@Override
	public List<Cookbook> findAllCookbooks() {
		return cookbookStore.retrieveAll();
	}
	@Override
	public Cookbook findCookbook(int cookbookId) {
		Cookbook cookbook = cookbookStore.retrieve(cookbookId);
		List<Recipe> recipes = recipeStore.retrieveAll(cookbookId);
		cookbook.setRecipes(recipes);
		return cookbook;
	}
	@Override
	public Cookbook registerCookbook(Cookbook cookbook) {
		int cookbookId =cookbookStore.create(cookbook);
		cookbook.setId(cookbookId);
		return cookbook;
	}
	@Override
	public Recipe findRecipeById(int recipeId) {
		
		Recipe recipe = recipeStore.retrieve(recipeId);
		if(recipe !=null){
			Cookbook cookbook = cookbookStore.retrieve(recipe.getCookbook().getId());
			recipe.setCookbook(cookbook);
//			조리절차
		}
		
		
		return recipe;
	}

	@Override
	public Recipe registerRecipe(Recipe recipe) {

		int recipeId = recipeStore.create(recipe);
		recipe.setId(recipeId);
		
		List<Procedure> list = recipe.getProcedures();
		
		if(list != null){
			for(Procedure p : list){
				recipeStore.createProcedure(recipe.getId(), p);
			}
		}
		
		return recipe;
	}

}
