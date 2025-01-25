package com.bezkoder.springjwt.models;

import java.sql.Date;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserRoleDTO {
	
	    private Long id;
	    private String username;
	    private String email;
	    private String password;
	    private String etat;
	    private String ville;
	    private String pays;
	  private String age;
	  private String prenom;
	  private String nom;
	  private Date datenaiss;
	  private String Genre;
	  private String numtele;
	  private String numwhats;
	  private String stat_matrim;
	  private String nbr_enf;
	  private String prof_act;
	  private String sect_act;
	  private String Emp_act;
	  private String autoris_consent;
	  private String PreferComm;
	  private String NbrPays;
	  private String photo;
	  private String prefer_communi;
	  private String nbr_pays_expat;
	  private String expat_depui;
	  private String expat_avec;
	  private String question1;
	  private String question2;
	  private String question3;
	  
	  private Set<UserLangueDTO> userLangues;
	    private Set<UserReseauSociauxDTO> userReseauSociaux;
	    private Set<String> userPreferCommuni;
	    private Set<String> paysVisiters;
	    private Set<String> centreInterets;
	    private Set<String> serviceRecherches;
	    private Set<String> marquesPreferees;
	    
	
	    
	    
	    
	    
	public String getExpat_avec() {
			return expat_avec;
		}
		public void setExpat_avec(String expat_avec) {
			this.expat_avec = expat_avec;
		}
	public Set<UserLangueDTO> getUserLangues() {
			return userLangues;
		}
		public void setUserLangues(Set<UserLangueDTO> userLangues) {
			this.userLangues = userLangues;
		}
		public Set<UserReseauSociauxDTO> getUserReseauSociaux() {
			return userReseauSociaux;
		}
		public void setUserReseauSociaux(Set<UserReseauSociauxDTO> userReseauSociaux) {
			this.userReseauSociaux = userReseauSociaux;
		}
		public Set<String> getUserPreferCommuni() {
			return userPreferCommuni;
		}
		public void setUserPreferCommuni(Set<String> userPreferCommuni) {
			this.userPreferCommuni = userPreferCommuni;
		}
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Set<String> getPaysVisiters() {
			return paysVisiters;
		}
		public void setPaysVisiters(Set<String> paysVisiters) {
			this.paysVisiters = paysVisiters;
		}
		public Set<String> getCentreInterets() {
			return centreInterets;
		}
		public void setCentreInterets(Set<String> centreInterets) {
			this.centreInterets = centreInterets;
		}
		public Set<String> getServiceRecherches() {
			return serviceRecherches;
		}
		public void setServiceRecherches(Set<String> serviceRecherches) {
			this.serviceRecherches = serviceRecherches;
		}
		public Set<String> getMarquesPreferees() {
			return marquesPreferees;
		}
		public void setMarquesPreferees(Set<String> marquesPreferees) {
			this.marquesPreferees = marquesPreferees;
		}
	public String getPrefer_communi() {
			return prefer_communi;
		}
		public void setPrefer_communi(String prefer_communi) {
			this.prefer_communi = prefer_communi;
		}
		public String getNbr_pays_expat() {
			return nbr_pays_expat;
		}
		public void setNbr_pays_expat(String nbr_pays_expat) {
			this.nbr_pays_expat = nbr_pays_expat;
		}
		public String getExpat_depui() {
			return expat_depui;
		}
		public void setExpat_depui(String expat_depui) {
			this.expat_depui = expat_depui;
		}
		public String getQuestion1() {
			return question1;
		}
		public void setQuestion1(String question1) {
			this.question1 = question1;
		}
		public String getQuestion2() {
			return question2;
		}
		public void setQuestion2(String question2) {
			this.question2 = question2;
		}
		public String getQuestion3() {
			return question3;
		}
		public void setQuestion3(String question3) {
			this.question3 = question3;
		}
	

		public String getAutoris_consent() {
			return autoris_consent;
		}
		public void setAutoris_consent(String autoris_consent) {
			this.autoris_consent = autoris_consent;
		}
		public String getPreferComm() {
			return PreferComm;
		}
		public void setPreferComm(String preferComm) {
			PreferComm = preferComm;
		}
		public String getNbrPays() {
			return NbrPays;
		}
		public void setNbrPays(String nbrPays) {
			NbrPays = nbrPays;
		}

	public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEtat() {
			return etat;
		}
		public void setEtat(String etat) {
			this.etat = etat;
		}
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public String getPays() {
			return pays;
		}
		public void setPays(String pays) {
			this.pays = pays;
		}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getNumtele() {
		return numtele;
	}
	public void setNumtele(String numtele) {
		this.numtele = numtele;
	}
	public String getNumwhats() {
		return numwhats;
	}
	public void setNumwhats(String numwhats) {
		this.numwhats = numwhats;
	}
	public String getStat_matrim() {
		return stat_matrim;
	}
	public void setStat_matrim(String stat_matrim) {
		this.stat_matrim = stat_matrim;
	}
	public String getNbr_enf() {
		return nbr_enf;
	}
	public void setNbr_enf(String nbr_enf) {
		this.nbr_enf = nbr_enf;
	}
	public String getProf_act() {
		return prof_act;
	}
	public void setProf_act(String prof_act) {
		this.prof_act = prof_act;
	}
	public String getSect_act() {
		return sect_act;
	}
	public void setSect_act(String sect_act) {
		this.sect_act = sect_act;
	}
	public String getEmp_act() {
		return Emp_act;
	}
	public void setEmp_act(String emp_act) {
		Emp_act = emp_act;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}



	  

}
