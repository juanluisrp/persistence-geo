/*
 * AuthorityTypeEntity.java
 * 
 * Copyright (C) 2011
 * 
 * This file is part of Proyecto persistenceGeo
 * 
 * This software is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * As a special exception, if you link this library with other files to produce
 * an executable, this library does not by itself cause the resulting executable
 * to be covered by the GNU General Public License. This exception does not
 * however invalidate any other reasons why the executable file might be covered
 * by the GNU General Public License.
 * 
 * Authors:: Moisés Arcos Santiago (mailto:marcos@emergya.com)
 */
package com.emergya.persistenceGeo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entidad de tipo de grupos de usuario
 * 
 * @author <a href="mailto:marcos@emergya.com">marcos</a>
 *
 */
public class AuthorityTypeEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355239823795963260L;
	
	private Long auth_type_id;
	private String auth_type;
	
	private String name;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	
	private List<AuthorityEntity> authList;
	private List<PermissionEntity> permissionList;
	
	public AuthorityTypeEntity(){
		
	}
	
	public AuthorityTypeEntity(String auth_type_str){
		auth_type = auth_type_str;
	}

	@Column(name = "auth_type", nullable = false)
	public String getAuth_type() {
		return auth_type;
	}

	public void setAuth_type(String auth_type) {
		this.auth_type = auth_type;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "fechaCreacion")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "fechaActualizacion")
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Id
    @Column(name = "auth_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return auth_type_id;
	}

	public void setId(Serializable id) {
		auth_type_id = (Long) id;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "authList")
	public List<AuthorityEntity> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthorityEntity> authList) {
		this.authList = authList;
	}

	@ManyToMany(targetEntity = PermissionEntity.class,
	cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "permission_by_authType",
	joinColumns =
	@JoinColumn(name = "auth_type_id"),
	inverseJoinColumns =
	@JoinColumn(name = "permission_id"))
	public List<PermissionEntity> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<PermissionEntity> permissionList) {
		this.permissionList = permissionList;
	}

}
