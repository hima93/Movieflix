package io.egen.app.entity;
import javax.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Writer {


	
	@Id
	   private String id;
	   private String name;
	    	    public Writer() {
			id = UUID.randomUUID().toString();
		}
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
				@Override
				public String toString() {
					return "Writer [id=" + id + ", name=" + name + "]";
				}
			
				



	
}
