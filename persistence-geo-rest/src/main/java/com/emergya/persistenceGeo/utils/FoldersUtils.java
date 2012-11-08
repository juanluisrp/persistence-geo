/*
 * FoldersUtils.java
 * 
 * Copyright (C) 2012
 * 
 * This file is part of persistenceGeo project
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
package com.emergya.persistenceGeo.utils;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.emergya.persistenceGeo.dto.FolderDto;

/**
 * Utils class to parse folder names
 * 
 * @author <a href="mailto:adiaz@emergya.com">adiaz</a>
 */
public class FoldersUtils {

	private static final String TREE_LEVEL = "-";
	
	/**
	 * Recursive tree build
	 * 
	 * @param folder parent at tree
	 * @param tree building
	 * @param style style to generate folder tree
	 * 
	 * @see FolderStyle
	 */
	public static void getFolderTree(FolderDto folder, List<FolderDto> tree, FolderStyle style, Boolean onlyNotEmpty) {
		getFolderTree(folder, tree, new String(), new Integer (0), style, onlyNotEmpty);
	}
	
	/**
	 * Recursive tree build
	 * 
	 * @param folder parent at tree
	 * @param tree building
	 * @param style style to generate folder tree
	 * 
	 * @see FolderStyle
	 */
	public static void getFolderTree(FolderDto folder, List<FolderDto> tree, String parent, FolderStyle style, Boolean onlyNotEmpty) {
		getFolderTree(folder, tree, parent, new Integer (0), style, onlyNotEmpty);
	}
	
	/**
	 * Recursive tree build
	 * 
	 * @param folder parent at tree
	 * @param tree building
	 * @param level level on tree
	 */
	public static void getFolderTree(FolderDto folder, List<FolderDto> tree, String parent, Integer level, FolderStyle style, Boolean canHaveLayers) {
		if(folder != null){
			String name = getFolderName(folder.getName(), parent, level, style);
			folder.setName(name);
			if(canHaveLayers == null){
				tree.add(folder);
			}else{
				if(canHaveLayers && 
						(folder.getIsChannel() 
							|| (folder.getFolderList() == null
								|| folder.getFolderList().isEmpty()))){
					// only can have layers folders without children
					tree.add(folder);
				}else if(!canHaveLayers && !folder.getIsChannel()){
					// only can have folders not layer channels (without children and without layers)
					tree.add(folder);
				}
			}
			if(folder.getFolderList() != null){
				String previus = parent;
				parent = name;
				level++;
				for(FolderDto subFolder: folder.getFolderList()){
					getFolderTree(subFolder, tree, parent, level, style, canHaveLayers);
				}
				level--;
				parent = previus;
			}
		}
	}

	public static String getFolderName(String name, String parent,
			Integer level, FolderStyle style) {
		if(FolderStyle.STRING.equals(style)){
			return getFolderNameString(name, parent);
		}else{
			return getFolderNameTree(name, parent, level);
		}
	}

	/**
	 * Build folder name on tree
	 * 
	 * @param name default name on tree
	 * @param parent
	 * 
	 * @return tree folder '' 
	 */
	public static String getFolderName(String name, String parent, FolderStyle style) {
		return getFolderName(name, parent, new Integer(0), style);
	}
	
	/**
	 * Build folder name on tree
	 * 
	 * @param name default name on tree
	 * @param parent
	 * 
	 * @return tree folder '' 
	 */
	private static String getFolderNameTree(String name, String parent, Integer level) {
		String result = name;
		for(int i = 0; i < level; i++){
			result = TREE_LEVEL + result;
		}
		result = result.replace(name, " " + name);
		return result;
	}

	/**
	 * Build folder name on string
	 * 
	 * @param name default name on string
	 * @param parent
	 * 
	 * @return string folder 'parent-name' 
	 */
	private static String getFolderNameString (String name, String parent){
		String result;
		if(!StringUtils.isEmpty(parent)){
			result = parent + TREE_LEVEL + name;
		}else{
			result = name;
		}
		return result;
	}
	
	/**
	 * Recursive tree build
	 * 
	 * @param folder parent at tree
	 * @param tree building
	 * @param level level on tree
	 */
	public static void getFolderTree(FolderDto folder, List<FolderDto> tree){
		getFolderTreeFiltered(folder, tree, null);
	}
	
	/**
	 * Recursive tree build
	 * 
	 * @param folder parent at tree
	 * @param tree building
	 * @param level level on tree
	 */
	public static void getFolderTreeFiltered(FolderDto folder, List<FolderDto> tree, Boolean onlyNotEmpty){
		getFolderTree(folder, tree, new String(), onlyNotEmpty);
	}
	
	/**
	 * Recursive tree build
	 * 
	 * @param folder parent at tree
	 * @param tree building
	 * @param level level on tree
	 */
	public static void getFolderTree(FolderDto folder, List<FolderDto> tree, String parent, Boolean onlyNotEmpty){
		getFolderTree(folder, tree, parent, FolderStyle.STRING, onlyNotEmpty);
	}

	/**
	 * Build folder name on tree
	 * 
	 * @param name default name on tree
	 * @param parent
	 * 
	 * @return tree folder '' 
	 */
	public static String getFolderName(String name, String parent) {
		return getFolderName(name, parent, FolderStyle.STRING);
	}
}