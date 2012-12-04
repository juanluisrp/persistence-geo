/*
 * StyleEntryDto.java
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
 * Authors:: Alejandro Díaz Torres (mailto:adiaz@emergya.com)
 */
package com.emergya.persistenceGeo.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Simple Dto object to wrap style entry property
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 */
public class StyleEntryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8302433520158118951L;
	
	protected String name;
	protected List<RuleEntryDto> rules;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the rules
	 */
	public List<RuleEntryDto> getRules() {
		return rules;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param rules the rules to set
	 */
	public void setRules(List<RuleEntryDto> rules) {
		this.rules = rules;
	}
}
