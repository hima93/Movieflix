package io.egen.app.entity;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Genre {
	
	@Id
	   private String id;
	   private String type;
	    	    public Genre() {
			id = UUID.randomUUID().toString();
		}
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				public String getType() {
					return type;
				}
				public void setType(String type) {
					this.type = type;
				}
				@Override
				public String toString() {
					return "Genre [id=" + id + ", type=" + type + "]";
				}




	
}
