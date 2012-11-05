/*
 * FoldersAdminServiceImpl.java
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

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emergya.persistenceGeo.dao.AbstractGenericDao;
import com.emergya.persistenceGeo.dao.AuthorityEntityDao;
import com.emergya.persistenceGeo.dao.FolderEntityDao;
import com.emergya.persistenceGeo.dao.GenericDAO;
import com.emergya.persistenceGeo.dao.LayerEntityDao;
import com.emergya.persistenceGeo.dao.UserEntityDao;
import com.emergya.persistenceGeo.dto.FolderDto;
import com.emergya.persistenceGeo.metaModel.AbstractFolderEntity;
import com.emergya.persistenceGeo.metaModel.Instancer;
import com.emergya.persistenceGeo.service.FoldersAdminService;

/**
 * FoldersAdminService transactional implementation based on daos uses
 * {@link AbstractGenericDao}
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 * 
 */
@Repository
@Transactional
public class FoldersAdminServiceImpl extends AbstractServiceImpl<FolderDto, AbstractFolderEntity>
		implements FoldersAdminService {

	@Resource
	private Instancer instancer;
	@Resource
	private FolderEntityDao folderDao;
	@Resource
	private LayerEntityDao layerDao;
	@Resource
	private UserEntityDao userDao;
	@Resource
	private AuthorityEntityDao authDao;
	
	public FoldersAdminServiceImpl(){
		super();
	}

	@Override
	@Cacheable("persistenceGeo")
	public FolderDto getRootFolder(Long idUser) {
		return entityToDto(folderDao.findRootByUser(idUser));
	}

	@Override
	@Cacheable("persistenceGeo")
	public FolderDto getRootGroupFolder(Long idGroup) {
		return entityToDto(folderDao.findRootByGroup(idGroup));
	}
	
	/**
	 * Saves a folder
	 * 
	 * @return saved folder
	 */
	public FolderDto saveFolder(FolderDto folder){
		AbstractFolderEntity entity = dtoToEntity(folder);
		return entityToDto(folderDao.makePersistent(entity));
	}

	protected FolderDto entityToDto(AbstractFolderEntity entity) {
		FolderDto dto = null;
		if(entity != null){
			dto = new FolderDto();
			dto.setEnabled(entity.getEnabled());
			dto.setIsChannel(entity.getIsChannel());
			dto.setUpdateDate(entity.getUpdateDate());
			dto.setCreateDate(entity.getCreateDate());
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			
			
			//Children
			List<AbstractFolderEntity> children = folderDao.getFolders(entity.getId());
			if(children != null){
				List<FolderDto> subFolders = new LinkedList<FolderDto>();
				for(AbstractFolderEntity child: children){
					//Recursive case
					subFolders.add(entityToDto(child));
				}
				dto.setFolderList(subFolders);
			}//else: base case
			
			//Parent
			if(entity.getParent() != null
					&& entity.getParent().getId() != null){
				dto.setIdParent(entity.getParent().getId());
			}

			//Auth
			if(entity.getAuthority() != null
					&& entity.getAuthority().getId() != null){
				dto.setIdAuth(entity.getAuthority().getId());
			}

			//User
			if(entity.getUser() != null
					&& entity.getUser().getId() != null){
				dto.setIdUser((Long) entity.getUser().getId());
			}
			
			//TODO: entity.setZoneList(zoneList);
		}
		return dto;
	}

	protected AbstractFolderEntity dtoToEntity(FolderDto dto) {
		AbstractFolderEntity entity = null;
		if(dto != null){
			if(dto.getId() != null){
				entity = folderDao.findById(dto.getId(), false);
			}else{
				entity = instancer.createFolder();
			}
			entity.setEnabled(dto.getEnabled());
			entity.setIsChannel(dto.getIsChannel());
			entity.setUpdateDate(dto.getUpdateDate());
			entity.setCreateDate(dto.getCreateDate());
			entity.setName(dto.getName());
			
			//TODO: Children if is necesary
			
			//Parent
			if (dto.getIdParent() != null) {
				AbstractFolderEntity parent = folderDao.findById(dto.getIdParent(), false);
				entity.setParent(parent);
			}
			
			//Auth & user
			if(dto.getIdAuth() != null){
				entity.setAuthority(authDao.findById(dto.getIdAuth(), false));
			}
			if(dto.getIdUser() != null){
				entity.setUser(userDao.findById(dto.getIdUser(), false));
			}
			
			//TODO: entity.setZoneList(zoneList);
		}
		return entity;
	}

	@Override
	protected GenericDAO<AbstractFolderEntity, Long> getDao() {
		return folderDao;
	}
}
