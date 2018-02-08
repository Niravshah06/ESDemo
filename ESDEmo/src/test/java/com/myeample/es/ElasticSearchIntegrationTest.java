package com.myeample.es;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myeample.es.all.Config;
import com.myeample.es.all.MenuItem;
import com.myeample.es.all.MenuItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class ElasticSearchIntegrationTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private MenuItemService articleService;


    @Test
    public void before() {
       elasticsearchTemplate.deleteIndex(MenuItem.class);
        elasticsearchTemplate.createIndex(MenuItem.class);

        MenuItem article = new MenuItem("menu1");
      
        articleService.save(article);

        article = new MenuItem("menu111");

        
        articleService.save(article);

      
       Iterator<MenuItem> i= articleService.findAll().iterator();
       int j=0;
      while(i.hasNext())
    	 j++;
       assertEquals(2, j);

       
    }

   

   
  
   }
