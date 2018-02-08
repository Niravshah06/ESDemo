package com.myeample.es.all;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "rest", type = "manuItem")
public class MenuItem {
 
    @Id
    private String id;
     
    private String title;
     
  

	public MenuItem(String string) {
		// TODO Auto-generated constructor stub
		this.title=string;
		this.id=String.valueOf(string.length());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

     
    // standard getters and setters
}