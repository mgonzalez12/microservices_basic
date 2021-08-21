package com.springboot.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private Long id;
	private String nombres;
	private Double precio;
	
	@Transient
	private Integer port;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -8068338434639790357L;
}
