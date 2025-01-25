package com.bezkoder.springjwt.models;

import java.util.List;
import java.util.Set;

public class BlogDTO {
	
	
	private String title;
    private String content;
    private Long blogCategorieId;
    private Set<Long> blogScategorieIds;  // Liste des IDs de BlogSCategorie
    private String pays;
    private String image;
    private List<BlogTagDTO> tags;
    
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getBlogCategorieId() {
		return blogCategorieId;
	}
	public void setBlogCategorieId(Long blogCategorieId) {
		this.blogCategorieId = blogCategorieId;
	}
	public Set<Long> getBlogScategorieIds() {
		return blogScategorieIds;
	}
	public void setBlogScategorieIds(Set<Long> blogScategorieIds) {
		this.blogScategorieIds = blogScategorieIds;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<BlogTagDTO> getTags() {
		return tags;
	}
	public void setTags(List<BlogTagDTO> tags) {
		this.tags = tags;
	}
	
	
	
	
	
	
	
	
	/*public BlogDTO(String title, String content, Long blogCategorieId) {
		super();
		this.title = title;
		this.content = content;
		this.blogCategorieId = blogCategorieId;
	}*/
	
    
    // Getters et setters

	
    
}
