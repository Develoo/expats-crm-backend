package com.bezkoder.springjwt.models;

import java.util.Set;

public class ProRoleDTO {

	
	
	private String username;
    private String email;
    private String password;
    private String etat;
    private String ville;
    private String pays;
	private String nomentreprise;
	private String secteuractivite;
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
	private String num_siret;
	private String num_tva;
	private String certif_accred;
	private String site_web;
	//private String moy_payem;
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
    private String typeEntreprise;
	private String photo;
	

	 
	
	
	private Set<UserReseauSociauxDTO> userReseauSociaux;
    private Set<UserCompagnSouhaitDTO> userCompagnSouhait;
	private Set<OpeningHoursDTO> openingHours;
	private Set<MoyenPayementDTO> moyenPayement;

	
	

	
	
	
	
	public Set<MoyenPayementDTO> getMoyenPayement() {
		return moyenPayement;
	}
	public void setMoyenPayement(Set<MoyenPayementDTO> moyenPayement) {
		this.moyenPayement = moyenPayement;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public Set<OpeningHoursDTO> getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(Set<OpeningHoursDTO> openingHours) {
		this.openingHours = openingHours;
	}
	public String getAccept_platf() {
		return accept_platf;
	}
	public void setAccept_platf(String accept_platf) {
		this.accept_platf = accept_platf;
	}
	public String getServic_spec_expat() {
		return servic_spec_expat;
	}
	public void setServic_spec_expat(String servic_spec_expat) {
		this.servic_spec_expat = servic_spec_expat;
	}


	public Set<UserCompagnSouhaitDTO> getUserCompagnSouhait() {
		return userCompagnSouhait;
	}
	public void setUserCompagnSouhait(Set<UserCompagnSouhaitDTO> userCompagnSouhait) {
		this.userCompagnSouhait = userCompagnSouhait;
	}
	public String getBudg_pub_mensuel() {
		return budg_pub_mensuel;
	}
	public void setBudg_pub_mensuel(String budg_pub_mensuel) {
		this.budg_pub_mensuel = budg_pub_mensuel;
	}
	public String getInteret_compag_mark() {
		return interet_compag_mark;
	}
	public void setInteret_compag_mark(String interet_compag_mark) {
		this.interet_compag_mark = interet_compag_mark;
	}
	public String getCondit_livrai() {
		return condit_livrai;
	}
	public void setCondit_livrai(String condit_livrai) {
		this.condit_livrai = condit_livrai;
	}
	public String getFrai_livrais() {
		return frai_livrais;
	}
	public void setFrai_livrais(String frai_livrais) {
		this.frai_livrais = frai_livrais;
	}
	public String getLivrai_dispo() {
		return livrai_dispo;
	}
	public void setLivrai_dispo(String livrai_dispo) {
		this.livrai_dispo = livrai_dispo;
	}
	
	/*public String getMoy_payem() {
		return moy_payem;
	}
	public void setMoy_payem(String moy_payem) {
		this.moy_payem = moy_payem;
	}*/
	
	public Set<UserReseauSociauxDTO> getUserReseauSociaux() {
		return userReseauSociaux;
	}
	public void setUserReseauSociaux(Set<UserReseauSociauxDTO> userReseauSociaux) {
		this.userReseauSociaux = userReseauSociaux;
	}
	public String getSite_web() {
		return site_web;
	}
	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}
	public String getCertif_accred() {
		return certif_accred;
	}
	public void setCertif_accred(String certif_accred) {
		this.certif_accred = certif_accred;
	}
	public String getNum_tva() {
		return num_tva;
	}
	public void setNum_tva(String num_tva) {
		this.num_tva = num_tva;
	}
	public String getNum_siret() {
		return num_siret;
	}
	public void setNum_siret(String num_siret) {
		this.num_siret = num_siret;
	}
	public String getSecteuractivite() {
		return secteuractivite;
	}
	public void setSecteuractivite(String secteuractivite) {
		this.secteuractivite = secteuractivite;
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
	public String getNomentreprise() {
		return nomentreprise;
	}
	public void setNomentreprise(String nomentreprise) {
		this.nomentreprise = nomentreprise;
	}
	
	/*public String getSecteuractivite() {
		return secteuractivite;
	}
	public void setSecteuractivite(String secteuractivite) {
		this.secteuractivite = secteuractivite;
	}*/
	
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
	
	
	
	
}
