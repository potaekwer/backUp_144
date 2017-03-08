package yorizori.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable {

    /** */
    private static final long serialVersionUID = -2521738904047850755L;

    private int id;
    private String name;
    private int time;
    private int level;
    private String ingredients;
    private List<Procedure> procedures;
    private ImageFile recipeImage;
    private User writer;
    
    private Cookbook cookbook;
    
    //--------------------------------------------------------------------------

    public void addProcedure(Procedure procedure) {
        if (procedures == null) {
            procedures = new ArrayList<Procedure>();
        }
        procedures.add(procedure);
    }
    
    
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
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public List<Procedure> getProcedures() {
        return procedures;
    }
    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }
    public ImageFile getRecipeImage() {
        return recipeImage;
    }
    public void setRecipeImage(ImageFile recipeImage) {
        this.recipeImage = recipeImage;
    }
    public User getWriter() {
        return writer;
    }
    public void setWriter(User writer) {
        this.writer = writer;
    }
    public Cookbook getCookbook() {
        return cookbook;
    }
    public void setCookbook(Cookbook cookbook) {
        this.cookbook = cookbook;
    }

}
