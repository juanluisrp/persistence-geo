/*
 * AbstractRuleEntity.java
 * 
 * Copyright (C) 2011
 * 
 * This file is part of Proyecto persistenceGeo
 * 
 * This software is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General public abstract License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version.
 * 
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General public abstract License for more
 * details.
 * 
 * You should have received a copy of the GNU General public abstract License along with
 * this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * As a special exception, if you link this library with other files to produce
 * an executable, this library does not by itself cause the resulting executable
 * to be covered by the GNU General public abstract License. This exception does not
 * however invalidate any other reasons why the executable file might be covered
 * by the GNU General public abstract License.
 * 
 * Authors:: Moisés Arcos Santiago (mailto:marcos@emergya.com)
 */
package com.emergya.persistenceGeo.metaModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Entidad de regla
 * 
 * @author <a href="mailto:marcos@emergya.com">marcos</a>
 *
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractRuleEntity extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6186512869484565458L;

	protected Long id;
	
	protected String symbolizer;
	protected String filter;
	protected Date createDate;
	protected Date updateDate;
	protected List properties;

	public AbstractRuleEntity(){
		
	}

	/**
	 * @return the symbolizer
	 */
	public abstract String getSymbolizer();

	/**
	 * @return the filter
	 */
	public abstract String getFilter();

	/**
	 * @return the createDate
	 */
	public abstract Date getCreateDate();

	/**
	 * @return the updateDate
	 */
	public abstract Date getUpdateDate();
	
	/**
	 * @return the properties
	 */
	public abstract List getProperties();

	/**
	 * @param id the id to set
	 */
	public void setId(Serializable id) {
		this.id = (Long) id;
	}

	/**
	 * @param symbolizer the symbolizer to set
	 */
	public void setSymbolizer(String symbolizer) {
		this.symbolizer = symbolizer;
	}

	/**
	 * @param filter the filter to set
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List properties) {
		this.properties = properties;
	}
}
