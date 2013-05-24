/*
 * 
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
 * 
 */
package com.emergya.persistenceGeo.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emergya.persistenceGeo.dao.DBManagementDao;
import com.emergya.persistenceGeo.service.DBManagementService;

/**
 * Database access service
 * 
 * 
 * 
 */
@SuppressWarnings("unchecked")
@Repository
@Transactional
public class DBManagementServiceImpl implements DBManagementService{
	

	
	@Resource
	private DBManagementDao dbManagementDao;
	
	@Override
	public long getTableSize(String table_name) {
		return dbManagementDao.getTableSize(table_name);
	}


	@Override
	public String getTableSizeText(String table_name) {
		return dbManagementDao.getTableSizeText(table_name);
	}


	@Override
	public List<? extends Serializable> getAll() {
		return null;
	}


	@Override
	public List<? extends Serializable> getFromTo(Integer first, Integer last) {
		return null;
	}


	@Override
	public Long getResults() {
		return null;
	}


	@Override
	public Serializable getById(Long id) {
		return null;
	}


	@Override
	public Serializable create(Serializable dto) {
		return null;
	}


	@Override
	public Serializable update(Serializable dto) {
		return null;
	}


	@Override
	public void delete(Serializable dto) {
		
	}


}