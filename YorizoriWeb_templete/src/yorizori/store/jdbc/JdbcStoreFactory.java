package yorizori.store.jdbc;

import javax.sql.DataSource;

import yorizori.store.CookbookStore;
import yorizori.store.RecipeStore;
import yorizori.store.StoreFactory;
import yorizori.store.UserStore;
import yorizori.store.logic.CookBookStoreLogic;
import yorizori.store.logic.RecipeStoreLogic;
import yorizori.store.logic.UserStoreLogic;

public class JdbcStoreFactory implements StoreFactory{
	
	
	private DataSource dataSource;
	
	public JdbcStoreFactory(){
		this.dataSource = DataSourceManager.getDataSource();
	}
	

	@Override
	public CookbookStore getCookbookStore() {
		return new CookBookStoreLogic(this.dataSource);
	}

	@Override
	public RecipeStore getRecipeStore() {
		return new RecipeStoreLogic(this.dataSource);
	}

	@Override
	public UserStore getUserStore() {
		return new UserStoreLogic(this.dataSource);
	}

	
	
	
	
	
	
	

}
