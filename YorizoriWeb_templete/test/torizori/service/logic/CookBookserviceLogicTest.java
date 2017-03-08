package torizori.service.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import yorizori.domain.Cookbook;
import yorizori.domain.Procedure;
import yorizori.domain.Recipe;
import yorizori.domain.User;
import yorizori.service.CookbookService;
import yorizori.service.logic.CookbookServiceLogic;

public class CookBookserviceLogicTest {
	
	private CookbookService service;
	
	@Before
	public void serUp(){
		service = new CookbookServiceLogic();
	}

	@Test
	public void testFindAllCookbooks() {
		
		
		
	}
//
//	@Test
//	public void testFindCookbook() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRegisterCookbook() {
//		Cookbook cookbook = new Cookbook();
//		
//		cookbook.setName("한식 요리책");
//		cookbook.setDescription("한식 요리의 바이블");
//		User user = new User();
//		user.setUserId("kimgisa");
//		user.setName("김기사");
//		cookbook.setAuthor(user);
//
//		cookbook = service.registerCookbook(cookbook);
//		
//		cookbook = service.findCookbook(cookbook.getId());
//		
//		assertEquals("한식 요리책", cookbook.getName());
//		assertEquals("한식 요리의 바이블", cookbook.getDescription());
//		assertEquals("김기사", cookbook.getAuthor().getName());
//	
//	}

//	@Test
//	public void testFindRecipeById() {
//		Recipe recipe = service.findRecipeById(1);
//		
//		assertEquals("맛있는 피자", recipe.getName());
//		
//	}
//
//	@Test
//	public void testRegisterRecipe() {
//		
//		Recipe recipe = new Recipe();
//		
//		recipe.setCookbook(new Cookbook(1));
//		recipe.setName("라볶이");
//		recipe.setLevel(1);
//		recipe.setTime(30);
//		recipe.setIngredients("떡");
//		
//		User writer = new User();
//		writer.setUserId("kimgisa");
//		writer.setName("김기사");
//		recipe.setWriter(writer);
//		
//		List<Procedure> p = new ArrayList<>();
//		p.add(new Procedure(1,"물을 끓인다."));
//		p.add(new Procedure(2, "떡을끓인다."));
//		recipe.setProcedures(p);
//		
//		
//		
//		recipe = service.registerRecipe(recipe);
//		recipe = service.findRecipeById(recipe.getId());
//		
//		assertEquals("떡볶이", recipe.getName());
//		
//	}

}
