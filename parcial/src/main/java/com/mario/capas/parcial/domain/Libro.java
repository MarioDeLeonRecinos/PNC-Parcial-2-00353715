package com.mario.capas.parcial.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import net.bytebuddy.asm.Advice.This;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_libro")
	private Integer code;
	
	@Column(name = "s_titulo")
	@NotBlank(message = "El campo no puede estar vacío")
	@Size(max = 500,message = "El campo sobrepasa la cantidad de 500 caracteres")
	private String title;
	

	@NotBlank(message = "El campo no puede estar vacío")
	@Size(max = 150,message = "El campo sobrepasa la cantidad de 150 caracteres")
	@Column(name = "s_autor")
	private	String author;
	
	@ManyToOne
	@JoinColumn(name = "c_categoria")
	private Categoria c_categoria;
	
	@Column(name = "f_ingreso")
	private Date fecha;
	
	@Column(name = "b_estado")
	private Boolean b_estado;
	
	@NotBlank(message = "El campo no puede estar vacío")
	@Size(max = 150,message = "El campo sobrepasa la cantidad de 10 caracteres")
	@Column(name = "s_isbn")
	private String s_isbn;
	
	public Libro() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Categoria getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Categoria c_categoria) {
		this.c_categoria = c_categoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}
	
	public String getFechaDelegate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm aa");  
        String strDate = dateFormat.format(fecha);  
		return strDate;
	}
	
}
