/*
 * PrivateLayerEntity.java
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entidad de capa privada
 * 
 * @author <a href="mailto:marcos@emergya.com">marcos</a>
 *
 */
public class PrivateLayerEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8182484032046594841L;
	
	private Long privateLayer_id;
	private String privateLayer;
	
	private String name;
	private String type;
	private String server_resource;
	private Date fechaCreacion;
	private Date fechaActualizacion;
	
	private List<StyleEntity> styleList;
	private List<AuthorityEntity> authList;
	private List<UserEntity> userList;
	
	public PrivateLayerEntity(){
		
	}
	
	public PrivateLayerEntity(String privateLayerString){
		privateLayer = privateLayerString;
	}

	@Column(name = "privateLayer", nullable = false)
	public String getPrivateLayer() {
		return privateLayer;
	}

	public void setPrivateLayer(String privateLayer) {
		this.privateLayer = privateLayer;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "server_resource")
	public String getServer_resource() {
		return server_resource;
	}

	public void setServer_resource(String server_resource) {
		this.server_resource = server_resource;
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
    @Column(name = "privateLayer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return privateLayer_id;
	}

	public void setId(Serializable id) {
		privateLayer_id = (Long) id;
	}

	@ManyToMany(targetEntity = StyleEntity.class,
	cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "layerPrivate_with_style",
	joinColumns =
	@JoinColumn(name = "privateLayer_id"),
	inverseJoinColumns =
	@JoinColumn(name = "style_id"))
	public List<StyleEntity> getStyleList() {
		return styleList;
	}

	public void setStyleList(List<StyleEntity> styleList) {
		this.styleList = styleList;
	}

	@ManyToMany(targetEntity = AuthorityEntity.class,
	cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "pravateLayer_in_group",
	joinColumns =
	@JoinColumn(name = "privateLayer_id"),
	inverseJoinColumns =
	@JoinColumn(name = "auth_id"))
	public List<AuthorityEntity> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AuthorityEntity> authList) {
		this.authList = authList;
	}

	@ManyToMany(targetEntity = UserEntity.class,
	cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "privateLayer_by_users",
	joinColumns =
	@JoinColumn(name = "privateLayer_id"),
	inverseJoinColumns =
	@JoinColumn(name = "user_id"))
	public List<UserEntity> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEntity> userList) {
		this.userList = userList;
	}

}
