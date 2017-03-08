package yorizori.store;

public interface StoreFactory {
    
    CookbookStore getCookbookStore();
    RecipeStore getRecipeStore();
    UserStore getUserStore();
}
