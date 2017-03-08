package yorizori.store;

import java.util.List;

import yorizori.domain.Procedure;
import yorizori.domain.Recipe;


public interface RecipeStore {
    
    int create(Recipe recipe);
    List<Recipe> retrieveAll(int cookbookId);
    Recipe retrieve(int id);
    void createProcedure(int recipeId, Procedure procedure);
    List<Procedure> retrieveProcedures(int recipeId);
}
