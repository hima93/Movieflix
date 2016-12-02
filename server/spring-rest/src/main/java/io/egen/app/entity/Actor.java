package io.egen.app.entity;
import javax.persistence.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table
public class Actor {
	
	@Id
	   private String id;
	   	   private List<String> actor;
	    	    public Actor() {
			id = UUID.randomUUID().toString();
		}
				public String getId() {
					return id;
				}
				public void setId(String id) {
					this.id = id;
				}
				public List<String> getActor() {
					return actor;
				}
				public void setActor(List<String> actor) {
					this.actor = actor;
				}
				@Override
				public String toString() {
					return "Actor [id=" + id + ", actor=" + actor + "]";
				}
	    	    
	    	    

}
