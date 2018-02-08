package com.myeample.es.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    
    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public MenuItem save(MenuItem article) {
        return menuItemRepository.save(article);
    }

    @Override
    public MenuItem findOne(String id) {
        return menuItemRepository.findOne(id);
    }

    @Override
    public Iterable<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    

    
}