package yorizori.service;

import java.util.List;

import yorizori.domain.Cookbook;
import yorizori.domain.Recipe;


public interface CookbookService {

    List<Cookbook> findAllCookbooks();
    Cookbook findCookbook(int cookbookId);
    
    Cookbook registerCookbook(Cookbook cookbook);
    
    Recipe findRecipeById(int recipeId);
    
    Recipe registerRecipe(Recipe recipe);
}
