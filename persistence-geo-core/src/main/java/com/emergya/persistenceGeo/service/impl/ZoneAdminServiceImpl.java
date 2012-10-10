/*
 * UserAdminServiceImpl.java
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
package com.emergya.persistenceGeo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emergya.persistenceGeo.dao.AbstractGenericDao;
import com.emergya.persistenceGeo.dao.GenericDAO;
import com.emergya.persistenceGeo.dao.ZoneEntityDao;
import com.emergya.persistenceGeo.dto.ZoneDto;
import com.emergya.persistenceGeo.metaModel.AbstractZoneEntity;
import com.emergya.persistenceGeo.metaModel.Instancer;
import com.emergya.persistenceGeo.service.ZoneAdminService;

/**
 * Implementacion transacional de ZoneAdminService basada en el uso de daos
 * {@link AbstractGenericDao}
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 * 
 */
@Repository
@Transactional
public class ZoneAdminServiceImpl extends AbstractServiceImpl<ZoneDto, AbstractZoneEntity> implements ZoneAdminService {
	
	@Resource
	private ZoneEntityDao zoneDao;
	
	@Resource
	private Instancer instancer;

	@Override
	protected GenericDAO<AbstractZoneEntity, Long> getDao() {
		return zoneDao;
	}

	@Override
	protected ZoneDto entityToDto(AbstractZoneEntity entity) {
		ZoneDto dto = null;
		if(entity != null){
			dto = new ZoneDto();
			dto.setCreateDate(entity.getCreateDate());
			dto.setCode(entity.getCode());
			dto.setExtension(entity.getExtension());
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setType(entity.getType());
			dto.setUpdateDate(entity.getUpdateDate());
		}
		return dto;
	}

	@Override
	protected AbstractZoneEntity dtoToEntity(ZoneDto dto) {
		AbstractZoneEntity entity = null;
		if(dto != null){
			if(dto.getId()!= null){
				zoneDao.findById(dto.getId(), false);
			}else{
				entity = instancer.createZone();
			}
			entity.setCreateDate(dto.getCreateDate());
			entity.setCode(dto.getCode());
			entity.setExtension(dto.getExtension());
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setType(dto.getType());
			entity.setUpdateDate(dto.getUpdateDate());
		}
		return entity;
	}
	
}