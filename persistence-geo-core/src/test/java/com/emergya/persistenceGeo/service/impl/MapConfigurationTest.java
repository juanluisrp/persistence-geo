/* 
 * CreateLayersTest.java Copyright (C) 2012 This file is part of Proyecto persistenceGeo
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
package com.emergya.persistenceGeo.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

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

import com.emergya.persistenceGeo.dto.MapConfigurationDto;
import com.emergya.persistenceGeo.service.MapConfigurationAdminService;


/**
 * Test para LayerAdminService
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:modelContext.xml"})
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public class MapConfigurationTest{

	private static final Log LOG = LogFactory.getLog(MapConfigurationTest.class);

	@Resource
	protected Properties testProperties;
	
	protected static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");
	
	@Resource
	private MapConfigurationAdminService mapConfigurationService;

	protected static final String PR_1_LAYER_NAME = "tmpLayer";
	protected static final String PR_1_LAYER_DATA = "target/classes/test-classes/ficheros/Barcelona_4326.kml";

	
	@Test
	public void testCreateMapConfiguration(){
		try{
			MapConfigurationDto dto = new MapConfigurationDto();
			dto.setPDFServer("");
			dto.setUploadServletURL("uploadServlet");
			dto.setDownloadServletURL("download/");
			dto.setDefaultUserLogo("http://www.emergya.es/logo.jpg");
			dto.setDefaultWMSServer("http://sigescat.pise.interior.intranet/ows/wms?");
			dto.setOpenLayersProxyHost("proxy?url=");
			dto.setDefaultIdioma("cat");
			dto.setNumZoomLevels("16");
			dto.setDisplayProjection("true");
			dto.setProjection("EPSG:23031");
			dto.setBbox("162100,4407000,546560,4848000");
			dto.setInitalBbox("162100,4407000,546560,4848000");
			dto.setMaxScale("50000000");
			dto.setMinScale("100");
			dto.setResolutions("350,200,120,100,50,25,10,5,2,1,0.5,0.16000000000000000333");
			dto.setMaxResolution("360");
			dto.setVersion("4.1(r928)");
			dto.setMinResolution("10");
			dto = (MapConfigurationDto) mapConfigurationService.create(dto);
			Assert.assertNotNull(dto);
		}catch (Exception e) {
			LOG.error(e);
			Assert.fail();
		}
	}

	@Test
	public void testUpdateMapConfiguration(){
		try{
			MapConfigurationDto mcDto = mapConfigurationService.loadConfiguration();
			mapConfigurationService.updateMapConfiguration((Long) mcDto.getId(), "3", "3", "3");
			mcDto = mapConfigurationService.loadConfiguration();
			Assert.assertNotNull(mcDto);
			Assert.assertEquals("3" ,mcDto.getBbox());
			Assert.assertEquals("3" ,mcDto.getResolutions());
			Assert.assertEquals("3" ,mcDto.getProjection());
		}catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			Assert.fail();
		}
		
		
	}
	
}
