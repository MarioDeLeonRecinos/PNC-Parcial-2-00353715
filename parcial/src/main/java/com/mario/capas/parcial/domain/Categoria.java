package com.mario.capas.parcial.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public",name = "cat_categoria")
public class Categoria {
	
	@Id
	@Column(name = "c_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer c_categoria;

	@Size(max = 50, message = "no puede exceder 50 caracteres")
	@NotBlank(message = "El campo nombre categoría no puede estar vacío")
	@Column(name = "s_categoria")
	private String s_categoria;

	public Categoria() {
		super();
	}
	
	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getS_categoria() {
		return s_categoria;
	}

	public void setS_categoria(String s_categoria) {
		this.s_categoria = s_categoria;
	}
	
}
