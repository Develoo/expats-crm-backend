package com.bezkoder.springjwt.models;

import java.time.LocalTime;

public class OpeningHoursDTO {
	
	
	   private Long id;
	    private String dayOfWeek;
	    private LocalTime  openingTime; // Doit être de type String
	    private LocalTime  closingTime;
	    private String ferme;

	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFerme() {
			return ferme;
		}
		public void setFerme(String ferme) {
			this.ferme = ferme;
		}
		public String getDayOfWeek() {
			return dayOfWeek;
		}
		public void setDayOfWeek(String dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
		}
		public LocalTime getOpeningTime() {
			return openingTime;
		}
		public void setOpeningTime(LocalTime openingTime) {
			this.openingTime = openingTime;
		}
		public LocalTime getClosingTime() {
			return closingTime;
		}
		public void setClosingTime(LocalTime closingTime) {
			this.closingTime = closingTime;
		}
	
    
    
    
	
    
    

}
