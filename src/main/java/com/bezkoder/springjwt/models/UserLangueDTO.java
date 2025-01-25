package com.bezkoder.springjwt.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserLangueDTO {
	
	
	    private Long id;
	    private String langueNom;
	    private long user_id;
	    private String nv_comp;
		public String getLangueNom() {
			return langueNom;
		}
		public void setLangueNom(String langueNom) {
			this.langueNom = langueNom;
		}
		public long getUser_id() {
			return user_id;
		}
		public void setUser_id(long user_id) {
			this.user_id = user_id;
		}
		public String getNv_comp() {
			return nv_comp;
		}
		public void setNv_comp(String nv_comp) {
			this.nv_comp = nv_comp;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		


}
