package com.bezkoder.springjwt.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class UserRole extends User  {
	
	
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
	  private String photo;
      private String nbr_pays_expat;
	  private String expat_depui;
	  private String raison_expat;
	  private String expat_avec;
	  private String prefer_communi;
	  private String question1;
	  private String question2;
	  private String question3;
	  
	  
	  
	  
	 
	  

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private Set<UserLangue> userLangues;    
	    

	    

	    @ManyToMany
	    @JoinTable(
	        name = "user_centre_interet",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "centre_interet_id")
	    )
	    private Set<CentreInteret> centreInterets = new HashSet<>();
	    
	    
	    @ManyToMany
	    @JoinTable(
	        name = "user_pays_visiter",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "pays_visiter_id")
	    )
	    private Set<PaysVisiter> paysVisiters = new HashSet<>();


	    @ManyToMany
	    @JoinTable(
	        name = "user_Services_Recherche_Sur_Platform",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "Services_Recherche_Sur_Platform_id")
	    )
	    private Set<RecherchePlatform> servicesRechercheSurPlatform = new HashSet<>();

	    @ManyToMany
	    @JoinTable(
	        name = "user_marques_preferees",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "marques_preferees_id")
	    )
	    private Set<MarquesPreferees> marquesPreferees = new HashSet<>();    
	    
	    @OneToMany(mappedBy = "user", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
	    @JsonManagedReference(value = "user-userPreferCommuni")
	    private Set<UserPreferCommuni> userPreferCommuni;
	  
		  public String getExpat_avec() {
				return expat_avec;
			}
			public void setExpat_avec(String expat_avec) {
				this.expat_avec = expat_avec;
			}
			
	public String getNbr_enf() {
		return nbr_enf;
	}
	public void setNbr_enf(String nbr_enf) {
		this.nbr_enf = nbr_enf;
	}
	public String getStat_matrim() {
		return stat_matrim;
	}
	public void setStat_matrim(String stat_matrim) {
		this.stat_matrim = stat_matrim;
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
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getRaison_expat() {
		return raison_expat;
	}
	public void setRaison_expat(String raison_expat) {
		this.raison_expat = raison_expat;
	}
	public String getPrefer_communi() {
		return prefer_communi;
	}
	public void setPrefer_communi(String prefer_communi) {
		this.prefer_communi = prefer_communi;
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
	
	public Set<UserLangue> getUserLangues() {
		return userLangues;
	}
	public void setUserLangues(Set<UserLangue> userLangues) {
		this.userLangues = userLangues;
	}

	public Set<CentreInteret> getCentreInterets() {
		return centreInterets;
	}
	public void setCentreInterets(Set<CentreInteret> centreInterets) {
		this.centreInterets = centreInterets;
	}
	public Set<RecherchePlatform> getServicesRechercheSurPlatform() {
		return servicesRechercheSurPlatform;
	}
	public void setServicesRechercheSurPlatform(Set<RecherchePlatform> servicesRechercheSurPlatform) {
		this.servicesRechercheSurPlatform = servicesRechercheSurPlatform;
	}
	public Set<MarquesPreferees> getMarquesPreferees() {
		return marquesPreferees;
	}
	public void setMarquesPreferees(Set<MarquesPreferees> marquesPreferees) {
		this.marquesPreferees = marquesPreferees;
	}
	public Set<UserPreferCommuni> getUserPreferCommuni() {
		return userPreferCommuni;
	}
	public void setUserPreferCommuni(Set<UserPreferCommuni> userPreferCommuni) {
		this.userPreferCommuni = userPreferCommuni;
	}
	
	public String getAutoris_consent() {
		return autoris_consent;
	}
	public void setAutoris_consent(String autoris_consent) {
		this.autoris_consent = autoris_consent;
	}
	
	
	public Set<PaysVisiter> getPaysVisiters() {
		return paysVisiters;
	}
	public void setPaysVisiters(Set<PaysVisiter> paysVisiters) {
		this.paysVisiters = paysVisiters;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(String age, String prenom, String nom, Date datenaiss, String genre, String numtele,
			String numwhats, String stat_matrim, String nbr_enf, String prof_act, String sect_act, String emp_act,
			String autoris_consent, String photo, String nbr_pays_expat, String expat_depui, String raison_expat,
			String prefer_communi, String question1, String question2, String question3, String expat_avec,
			Set<UserLangue> userLangues, Set<CentreInteret> centreInterets, Set<PaysVisiter> paysVisiters,
			Set<RecherchePlatform> servicesRechercheSurPlatform, Set<MarquesPreferees> marquesPreferees,
			Set<UserPreferCommuni> userPreferCommuni) {
		super();
		this.age = age;
		this.prenom = prenom;
		this.nom = nom;
		this.datenaiss = datenaiss;
		Genre = genre;
		this.numtele = numtele;
		this.numwhats = numwhats;
		this.stat_matrim = stat_matrim;
		this.nbr_enf = nbr_enf;
		this.prof_act = prof_act;
		this.sect_act = sect_act;
		Emp_act = emp_act;
		this.autoris_consent = autoris_consent;
		this.photo = photo;
		this.nbr_pays_expat = nbr_pays_expat;
		this.expat_depui = expat_depui;
		this.raison_expat = raison_expat;
		this.prefer_communi = prefer_communi;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.expat_avec = expat_avec;
		this.userLangues = userLangues;
		this.centreInterets = centreInterets;
		this.paysVisiters = paysVisiters;
		this.servicesRechercheSurPlatform = servicesRechercheSurPlatform;
		this.marquesPreferees = marquesPreferees;
		this.userPreferCommuni = userPreferCommuni;
	}
	
	
}