package com.bezkoder.springjwt.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProRole extends User {

    private String nomentreprise;
    private String secteuractivite;
    
    @Lob
    private String descriptionentre;
    private String rue;
    private String codepostal;
    private String liengooglemap;
    private String numtel;
    private String numwhats;
    private String facebook;
    private String instag;
    private String linkedin;
    private String twitter;
    private String tiktok;
    private String autre;
    private String premierparrain;
    private String secondparrain;
    private String commentperso;
    private String location;
    private String categorie;
    private String photo;
    private Double latitude;
    private Double longitude;
    private String typeEntreprise;
    private String Referencement;
	private String num_siret;
	private String num_tva;
	private String certif_accred;
	private String site_web;
	private String moy_payem;
	private String livrai_dispo;
	private String frai_livrais;
	private String condit_livrai;
	private String interet_compag_mark;
	private String budg_pub_mensuel;
	private String servic_spec_expat;
	private String accept_platf;
	private String prenom_pers_cont;
	private String nom_pers_cont;
	private String foncti_pers_cont;
	private String email_pers_cont;
	private String num_tel_pers_cont;
	private String num_what_pers_cont;
	

	@OneToMany(mappedBy = "proRole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Rating> ratings;

	/*@OneToMany(mappedBy = "proRole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
	private Set<Deal> deals;*/
	
	@OneToMany(mappedBy = "proRole")
    @JsonIgnore  // Ignorer la collection de Deal pour éviter les boucles
    private List<Deal> deals;

	@OneToMany(mappedBy = "proRole", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
	private Set<Produit> produits;
	
	
    @ManyToMany
    @JoinTable(
        name = "proRole_Tags",
        joinColumns = @JoinColumn(name = "proRole_id"),
        inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    private Set<Tags> tags = new HashSet<>();
    
    
   // @OneToMany(mappedBy = "proRole",  cascade = CascadeType.ALL, orphanRemoval = true)
   /* @OneToMany(mappedBy = "proRole", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<UserCompagnSouhait> userTypeCompagnSouhait = new HashSet<>();*/
    
    @ManyToMany(cascade = CascadeType.ALL) // Cette ligne permet de propager les modifications
    @JoinTable(
        name = "proRole_CompagnSouhait",
        joinColumns = @JoinColumn(name = "proRole_id"),
        inverseJoinColumns = @JoinColumn(name = "compagnSouhait_id")
    )
    private Set<UserCompagnSouhait> userCompagnSouhait = new HashSet<>();
    
    
    
    @OneToMany(mappedBy = "proRole", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<OpeningHours> openingHours = new HashSet<>();  // Utilisation de Set<OpeningHours>

    @OneToMany(mappedBy = "proRole", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UserImage> images = new ArrayList<>();
    

    @ManyToMany(cascade = CascadeType.ALL) // Cette ligne permet de propager les modifications
    @JoinTable(
        name = "proRole_MoyenPayement",
        joinColumns = @JoinColumn(name = "proRole_id"),
        inverseJoinColumns = @JoinColumn(name = "moyenPayement_id")
    )
    private Set<MoyenPayement> moyenPayement = new HashSet<>();

	public Set<Tags> getTags() {
		return tags;
	}

	public void setTags(Set<Tags> tags) {
		this.tags = tags;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	
	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

	// Constructors
    public ProRole() {
        super();
    }


    


	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

	public String getNum_siret() {
		return num_siret;
	}

	public void setNum_siret(String num_siret) {
		this.num_siret = num_siret;
	}

	public String getNum_tva() {
		return num_tva;
	}

	public void setNum_tva(String num_tva) {
		this.num_tva = num_tva;
	}

	public String getCertif_accred() {
		return certif_accred;
	}

	public void setCertif_accred(String certif_accred) {
		this.certif_accred = certif_accred;
	}

	public String getSite_web() {
		return site_web;
	}

	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}

	public String getMoy_payem() {
		return moy_payem;
	}

	public void setMoy_payem(String moy_payem) {
		this.moy_payem = moy_payem;
	}

	public String getLivrai_dispo() {
		return livrai_dispo;
	}

	public void setLivrai_dispo(String livrai_dispo) {
		this.livrai_dispo = livrai_dispo;
	}

	public String getFrai_livrais() {
		return frai_livrais;
	}

	public void setFrai_livrais(String frai_livrais) {
		this.frai_livrais = frai_livrais;
	}

	public String getCondit_livrai() {
		return condit_livrai;
	}

	public void setCondit_livrai(String condit_livrai) {
		this.condit_livrai = condit_livrai;
	}

	public String getInteret_compag_mark() {
		return interet_compag_mark;
	}

	public void setInteret_compag_mark(String interet_compag_mark) {
		this.interet_compag_mark = interet_compag_mark;
	}

	public String getBudg_pub_mensuel() {
		return budg_pub_mensuel;
	}

	public void setBudg_pub_mensuel(String budg_pub_mensuel) {
		this.budg_pub_mensuel = budg_pub_mensuel;
	}

	public String getServic_spec_expat() {
		return servic_spec_expat;
	}

	public void setServic_spec_expat(String servic_spec_expat) {
		this.servic_spec_expat = servic_spec_expat;
	}

	public String getAccept_platf() {
		return accept_platf;
	}

	public void setAccept_platf(String accept_platf) {
		this.accept_platf = accept_platf;
	}

	public String getPrenom_pers_cont() {
		return prenom_pers_cont;
	}

	public void setPrenom_pers_cont(String prenom_pers_cont) {
		this.prenom_pers_cont = prenom_pers_cont;
	}

	public String getNom_pers_cont() {
		return nom_pers_cont;
	}

	public void setNom_pers_cont(String nom_pers_cont) {
		this.nom_pers_cont = nom_pers_cont;
	}

	public String getFoncti_pers_cont() {
		return foncti_pers_cont;
	}

	public void setFoncti_pers_cont(String foncti_pers_cont) {
		this.foncti_pers_cont = foncti_pers_cont;
	}

	public String getEmail_pers_cont() {
		return email_pers_cont;
	}

	public void setEmail_pers_cont(String email_pers_cont) {
		this.email_pers_cont = email_pers_cont;
	}

	public String getNum_tel_pers_cont() {
		return num_tel_pers_cont;
	}

	public void setNum_tel_pers_cont(String num_tel_pers_cont) {
		this.num_tel_pers_cont = num_tel_pers_cont;
	}

	public String getNum_what_pers_cont() {
		return num_what_pers_cont;
	}

	public void setNum_what_pers_cont(String num_what_pers_cont) {
		this.num_what_pers_cont = num_what_pers_cont;
	}

	public String getNomentreprise() {
		return nomentreprise;
	}

	public void setNomentreprise(String nomentreprise) {
		this.nomentreprise = nomentreprise;
	}

	public String getSecteuractivite() {
		return secteuractivite;
	}

	public void setSecteuractivite(String secteuractivite) {
		this.secteuractivite = secteuractivite;
	}

	public String getDescriptionentre() {
		return descriptionentre;
	}

	public void setDescriptionentre(String descriptionentre) {
		this.descriptionentre = descriptionentre;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getLiengooglemap() {
		return liengooglemap;
	}

	public void setLiengooglemap(String liengooglemap) {
		this.liengooglemap = liengooglemap;
	}

	public String getNumtel() {
		return numtel;
	}

	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}

	public String getNumwhats() {
		return numwhats;
	}

	public void setNumwhats(String numwhats) {
		this.numwhats = numwhats;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstag() {
		return instag;
	}

	public void setInstag(String instag) {
		this.instag = instag;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getAutre() {
		return autre;
	}

	public void setAutre(String autre) {
		this.autre = autre;
	}


	public String getPremierparrain() {
		return premierparrain;
	}

	public void setPremierparrain(String premierparrain) {
		this.premierparrain = premierparrain;
	}

	public String getSecondparrain() {
		return secondparrain;
	}

	public void setSecondparrain(String secondparrain) {
		this.secondparrain = secondparrain;
	}

	public String getCommentperso() {
		return commentperso;
	}

	public void setCommentperso(String commentperso) {
		this.commentperso = commentperso;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getTiktok() {
		return tiktok;
	}

	public void setTiktok(String tiktok) {
		this.tiktok = tiktok;
	}

	public String getTypeEntreprise() {
		return typeEntreprise;
	}

	public void setTypeEntreprise(String typeEntreprise) {
		this.typeEntreprise = typeEntreprise;
	}

	public String getReferencement() {
		return Referencement;
	}

	public void setReferencement(String referencement) {
		Referencement = referencement;
	}

	
	
	

	public Set<OpeningHours> getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(Set<OpeningHours> openingHours) {
		this.openingHours = openingHours;
	}

	

	

	public Set<UserCompagnSouhait> getUserCompagnSouhait() {
		return userCompagnSouhait;
	}

	public void setUserCompagnSouhait(Set<UserCompagnSouhait> userCompagnSouhait) {
		this.userCompagnSouhait = userCompagnSouhait;
	}

	public List<UserImage> getImages() {
		return images;
	}

	public void setImages(List<UserImage> images) {
		this.images = images;
	}


	public Set<MoyenPayement> getMoyenPayement() {
		return moyenPayement;
	}

	public void setMoyenPayement(Set<MoyenPayement> moyenPayement) {
		this.moyenPayement = moyenPayement;
	}



	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public ProRole(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String etat, String ville, String pays, Set<Role> roles,
			Set<UserReseauSociaux> userReseauSocieaux) {
		super(id, username, email, password, etat, ville, pays, roles, userReseauSocieaux);
		// TODO Auto-generated constructor stub
	}

	public ProRole(String nomentreprise, String secteuractivite, String descriptionentre, String rue, String codepostal,
			String liengooglemap, String numtel, String numwhats, String facebook, String instag, String linkedin,
			String twitter, String tiktok, String autre, String premierparrain, String secondparrain,
			String commentperso, String location, String categorie, String photo, Double latitude, Double longitude,
			String typeEntreprise, String referencement, String num_siret, String num_tva, String certif_accred,
			String site_web, String moy_payem, String livrai_dispo, String frai_livrais, String condit_livrai,
			String interet_compag_mark, String budg_pub_mensuel, String servic_spec_expat, String accept_platf,
			String prenom_pers_cont, String nom_pers_cont, String foncti_pers_cont, String email_pers_cont,
			String num_tel_pers_cont, String num_what_pers_cont, Set<Rating> ratings, List<Deal> deals,
			Set<Produit> produits, Set<Tags> tags, Set<UserCompagnSouhait> userCompagnSouhait,
			Set<OpeningHours> openingHours, List<UserImage> images, Set<MoyenPayement> moyenPayement) {
		super();
		this.nomentreprise = nomentreprise;
		this.secteuractivite = secteuractivite;
		this.descriptionentre = descriptionentre;
		this.rue = rue;
		this.codepostal = codepostal;
		this.liengooglemap = liengooglemap;
		this.numtel = numtel;
		this.numwhats = numwhats;
		this.facebook = facebook;
		this.instag = instag;
		this.linkedin = linkedin;
		this.twitter = twitter;
		this.tiktok = tiktok;
		this.autre = autre;
		this.premierparrain = premierparrain;
		this.secondparrain = secondparrain;
		this.commentperso = commentperso;
		this.location = location;
		this.categorie = categorie;
		this.photo = photo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.typeEntreprise = typeEntreprise;
		Referencement = referencement;
		this.num_siret = num_siret;
		this.num_tva = num_tva;
		this.certif_accred = certif_accred;
		this.site_web = site_web;
		this.moy_payem = moy_payem;
		this.livrai_dispo = livrai_dispo;
		this.frai_livrais = frai_livrais;
		this.condit_livrai = condit_livrai;
		this.interet_compag_mark = interet_compag_mark;
		this.budg_pub_mensuel = budg_pub_mensuel;
		this.servic_spec_expat = servic_spec_expat;
		this.accept_platf = accept_platf;
		this.prenom_pers_cont = prenom_pers_cont;
		this.nom_pers_cont = nom_pers_cont;
		this.foncti_pers_cont = foncti_pers_cont;
		this.email_pers_cont = email_pers_cont;
		this.num_tel_pers_cont = num_tel_pers_cont;
		this.num_what_pers_cont = num_what_pers_cont;
		this.ratings = ratings;
		this.deals = deals;
		this.produits = produits;
		this.tags = tags;
		this.userCompagnSouhait = userCompagnSouhait;
		this.openingHours = openingHours;
		this.images = images;
		this.moyenPayement = moyenPayement;
	}

	

	
	
	
	
	
	
	
}
