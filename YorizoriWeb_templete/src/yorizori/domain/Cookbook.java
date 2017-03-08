package yorizori.domain;

import java.io.Serializable;
import java.util.List;

public class Cookbook implements Serializable {

    /** */
    private static final long serialVersionUID = 6588043859841295L;
    
    private int id;
    private String name;
    private String description;
    private List<Recipe> recipes;
    private User author;
    
    //--------------------------------------------------------------------------
    
    public Cookbook() {
        //
    }
    
    public Cookbook(int id) {
        // 
        this.id = id;
    }
    
    //--------------------------------------------------------------------------
    
    public Recipe findRecipeByName(String recipeName) {
        //
        if (recipes != null) {
            for (Recipe recipe : recipes) {
                if (recipeName.equals(recipe.getName())) {
                    return recipe;
                }
            }
        }
        return null;
    }
    
    //--------------------------------------------------------------------------

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
}
