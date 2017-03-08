package yorizori.store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import yorizori.common.util.JdbcUtils;
import yorizori.domain.Cookbook;
import yorizori.domain.ImageFile;
import yorizori.domain.Procedure;
import yorizori.domain.Recipe;
import yorizori.store.RecipeStore;

public class RecipeStoreLogic implements RecipeStore{
	private DataSource dataSource;
	public RecipeStoreLogic(DataSource datasource) {
		this.dataSource = datasource;
	}
	@Override
	public int create(Recipe recipe) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int generatedId = -1;
		try {
			conn = dataSource.getConnection();
			String[] cols = {"recipe_id"};
			pstmt = conn.prepareStatement("insert into recipe"
					+ "(recipe_id, book_id, recipe_name, recipe_time, f_level,ingredients, img_cont_type,img_file_name,writer_id, writer_name)"
					+ " values(recipe_seq.nextval,?,?,?,?,?,?,?,?,?)",cols );
			
			pstmt.setInt(1, recipe.getCookbook().getId());	
			pstmt.setString(2, recipe.getName());
			pstmt.setInt(3, recipe.getTime());
			pstmt.setInt(4, recipe.getLevel());
			pstmt.setString(5, recipe.getIngredients());
			ImageFile rimage = recipe.getRecipeImage();
			if(rimage != null){
				pstmt.setString(6, recipe.getRecipeImage().getContentType());
				pstmt.setString(7, recipe.getRecipeImage().getFileName());
			}else{
				pstmt.setString(6, "");
				pstmt.setString(7, "");
			}
		
			pstmt.setString(8, recipe.getWriter().getUserId());
			pstmt.setString(9, recipe.getWriter().getName());
			
			pstmt.executeUpdate();
			
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				generatedId = (int)rs.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.closeQuietly(conn,pstmt,rs);
		}
		return generatedId;
	}
	@Override
	public List<Recipe> retrieveAll(int cookbookId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Recipe> list = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select recipe_id, book_id, recipe_name, recipe_time, f_level,ingredients, img_cont_type,img_file_name,writer_id, writer_name"
					+ " from recipe where book_id = ?");
			pstmt.setInt(1, cookbookId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(convertToDomain(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeQuietly(conn,rs,pstmt);
		}
		return list;
	}

	@Override
	public Recipe retrieve(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Recipe recipe = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select recipe_id, book_id, recipe_name, recipe_time, f_level, ingredients, img_cont_type,img_file_name,writer_id, writer_name"
					+ " from recipe where recipe_id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				recipe = convertToDomain(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeQuietly(conn,rs,pstmt);
		}
		return recipe;
	}

	@Override
	public void createProcedure(int recipeId, Procedure procedure) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("insert into recipe_procedure (recipe_id, seq_num, procedure)"
					+ "values(?,?,?)");
			pstmt.setInt(1, recipeId);
			pstmt.setInt(2, procedure.getSequence());
			pstmt.setString(3, procedure.getProcedure());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeQuietly(conn,pstmt);
		}
	}

	@Override
	public List<Procedure> retrieveProcedures(int recipeId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Procedure> list  = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("select seq_num, procedure from recipe_procedure"
					+ " where recipe_id = ?"
					+ "order by seq_num asc");
			pstmt.setInt(1, recipeId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Procedure(rs.getInt("seq_num"), rs.getString("procedure")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.closeQuietly(conn,rs,pstmt);
		}
		return list;
	}
	private Recipe convertToDomain(ResultSet rs) throws SQLException{
		Recipe recipe = new Recipe();
		recipe.setCookbook(new Cookbook(rs.getInt("book_id")));
		recipe.setId(rs.getInt("recipe_id"));
		recipe.setName(rs.getString("recipe_name"));
		recipe.setTime(rs.getInt("recipe_time"));
		recipe.setLevel(rs.getInt("f_level"));
		recipe.setIngredients(rs.getString("ingredients"));
		String contentType = rs.getString("img_cont_type");
		String fileName = rs.getString("img_file_name");
		if(contentType !=null && contentType.length() > 0 && fileName != null && fileName.length() >0){
			ImageFile rImage = new ImageFile();
			rImage.setContentType(contentType);
			rImage.setFileName(fileName);
			recipe.setRecipeImage(rImage);
		}
		return recipe;
	}
	
	
	

}
