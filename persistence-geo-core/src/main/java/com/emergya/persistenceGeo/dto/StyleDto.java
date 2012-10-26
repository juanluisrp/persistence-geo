/*
 * StyleDto.java
 * 
 * Copyright (C) 2012
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
package com.emergya.persistenceGeo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Style data transfer object
 * 
 * @author <a href="mailto:marcos@emergya.com">marcos</a>
 *
 */
public class StyleDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3685102608026529663L;
	
	private Long id;
	
	private String name;
	private Date createDate;
	private Date updateDate;
	
	private Map<RuleDto, Map<String, String>> rules;
	private Long layerId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return the layerId
	 */
	public Long getLayerId() {
		return layerId;
	}
	/**
	 * @param layerId the layerId to set
	 */
	public void setLayerId(Long layerId) {
		this.layerId = layerId;
	}
	/**
	 * @return the rules
	 */
	public Map<RuleDto, Map<String, String>> getRules() {
		return rules;
	}
	/**
	 * @param rules the rules to set
	 */
	public void setRules(Map<RuleDto, Map<String, String>> rules) {
		this.rules = rules;
	}

}
