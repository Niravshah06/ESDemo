package com.myeample.es.all;

public interface MenuItemService {
	MenuItem save(MenuItem article);

	MenuItem findOne(String id);

    Iterable<MenuItem> findAll();

}