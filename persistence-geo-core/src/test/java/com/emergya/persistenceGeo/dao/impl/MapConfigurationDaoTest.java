/* 
 * MapConfigurationDaoTest.java Copyright (C) 2012 This file is part of Proyecto persistenceGeo
 * 
 * This software is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * As a special exception, if you link this library with other files to
 * produce an executable, this library does not by itself cause the
 * resulting executable to be covered by the GNU General Public License.
 * This exception does not however invalidate any other reasons why the
 * executable file might be covered by the GNU General Public License.
 * 
 * Authors:: Alejandro Díaz Torres (mailto:adiaz@emergya.com)
 */
package com.emergya.persistenceGeo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.emergya.persistenceGeo.dao.MapConfigurationEntityDao;
import com.emergya.persistenceGeo.metaModel.AbstractMapConfigurationEntity;
import com.emergya.persistenceGeo.metaModel.Instancer;
import com.emergya.persistenceGeo.model.MapConfigurationEntity;

/**
 * Test for MapConfigurationDao and init map configuration
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:modelContext.xml" })
@TransactionConfiguration(defaultRollback = false, transactionManager = "transactionManager")
@Transactional
public class MapConfigurationDaoTest {

	private static final Log LOG = LogFactory
			.getLog(MapConfigurationDaoTest.class);

	@Resource
	private MapConfigurationEntityDao mapConfigDao;

	@Resource
	private Instancer instancer;

	@Test
	public void testCreateMapConfigurationIfNotExist() {
		try {
			AbstractMapConfigurationEntity entity = createMapConfiguration();
			Assert.assertNotNull(entity);
			Assert.assertNotNull(entity.getId());
		} catch (Exception e) {
			LOG.error(e);
			Assert.fail();
		}
	}

	/**
	 * Create a mapConfiguration with default values if is not found
	 * 
	 * @return mapConfiguration created
	 */
	private AbstractMapConfigurationEntity createMapConfiguration() {
		try {
			List<AbstractMapConfigurationEntity> all = mapConfigDao.findAll();
			AbstractMapConfigurationEntity entity = null;
			if (all == null || all.size() < 1) {
				entity = instancer.createMapConfiguration();
				entity.setPDFServer("");
				entity.setUploadServletURL("uploadServlet");
				entity.setDownloadServletURL("download/");
				entity.setDefaultUserLogo("http://www.emergya.es/logo.jpg");
				entity.setDefaultWMSServer("http://sigescat.pise.interior.intranet/ows/wms?");
				entity.setOpenLayersProxyHost("proxy?url=");
				entity.setDefaultIdioma("cat");
				entity.setNumZoomLevels("16");
				entity.setDisplayProjection("true");
				entity.setProjection("EPSG:23031");
				entity.setBbox("162100,4407000,546560,4848000");
				entity.setInitalBbox("162100,4407000,546560,4848000");
				entity.setMaxScale("50000000");
				entity.setMinScale("100");
				entity.setResolutions("350,200,120,100,50,25,10,5,2,1,0.5,0.16000000000000000333");
				entity.setMaxResolution("360");
				entity.setVersion("4.1(r928)");
				entity.setMinResolution("10");
				entity = (MapConfigurationEntity) mapConfigDao
						.makePersistent(entity);
			} else {
				entity = all.get(0);
			}

			return entity;
		} catch (Exception e) {
			LOG.error(e);
			Assert.fail();
		}
		return null;
	}

}
