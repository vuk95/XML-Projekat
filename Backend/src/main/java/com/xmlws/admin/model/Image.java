package com.xmlws.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class Image {
	
	
	@Column(name = "image_id")
    private Integer id;
	
	@Lob
    private Byte[] slika;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Byte[] getSlika() {
		return slika;
	}

	public void setSlika(Byte[] slika) {
		this.slika = slika;
	}
}
