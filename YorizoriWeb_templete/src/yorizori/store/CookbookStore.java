package yorizori.store;

import java.util.List;

import yorizori.domain.Cookbook;


public interface CookbookStore {
    
    int create(Cookbook cookbook);
    List<Cookbook> retrieveAll();
    Cookbook retrieve(int id);
}
