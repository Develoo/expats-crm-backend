package com.bezkoder.springjwt.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Entity
public class Role {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	   @Enumerated(EnumType.STRING)
	    @Column(length = 20)
	    private ERole name;

	    @ManyToMany(mappedBy = "roles")
	    @JsonIgnore
	    private Set<User> users;

	    public Role() {}

	    public Role(ERole name) {
	        this.name = name;
	    }
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public ERole getName() {
			return name;
		}

		public void setName(ERole name) {
			this.name = name;
		}

		public Set<User> getUsers() {
			return users;
		}

		public void setUsers(Set<User> users) {
			this.users = users;
		}

		public Role(Long id, ERole name, Set<User> users) {
			super();
			this.id = id;
			this.name = name;
			this.users = users;
		}
	    
}