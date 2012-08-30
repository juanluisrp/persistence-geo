/*
 * AuthorityEntity.java
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
 * Authors:: Alejandro Díaz Torres (mailto:adiaz@emergya.com)
 */
package com.emergya.persistenceGeo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity that represents the users group
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 * @author <a href="mailto:marcos@emergya.com">marcos</a>
 *
 */
@Entity
@Table(name = "authority")
public class AuthorityEntity extends AbstractEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6293606419664405344L;
	
	private Long id;
    private String authority;
    
    private Date createDate;
    private Date updateDate;
    
    private List<UserEntity> people;
    private AuthorityTypeEntity authType;
    private LayerEntity layer;
    private PrivateLayerEntity privateLayer;
    private ZoneEntity zone;

    public AuthorityEntity() {
    }

    public AuthorityEntity(String authString) {
        authority = authString;
    }

    @Column(name = "authority", nullable = false)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @OneToMany(mappedBy = "authority")
    public List<UserEntity> getPeople() {
        return people;
    }

    public void setPeople(List<UserEntity> people) {
        this.people = people;
    }

    @Column(name = "createDate")
	public Date getCreateDate() {
		return createDate;
	}

	public void setcreateDate(Date createDate) {
		this.createDate = createDate;
	}

    @Column(name = "updateDate")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@ManyToOne
    @JoinColumn(name = "id")
	public AuthorityTypeEntity getAuthType() {
		return authType;
	}

	public void setAuthType(AuthorityTypeEntity authType) {
		this.authType = authType;
	}

	@ManyToOne
    @JoinColumn(name = "id")
	public LayerEntity getLayer() {
		return layer;
	}

	public void setLayer(LayerEntity layer) {
		this.layer = layer;
	}

	@ManyToOne
    @JoinColumn(name = "id")
	public PrivateLayerEntity getPrivateLayer() {
		return privateLayer;
	}

	public void setPrivateLayer(PrivateLayerEntity privateLayer) {
		this.privateLayer = privateLayer;
	}

	@ManyToOne
    @JoinColumn(name = "id")
	public ZoneEntity getZone() {
		return zone;
	}

	public void setZone(ZoneEntity zone) {
		this.zone = zone;
	}

}