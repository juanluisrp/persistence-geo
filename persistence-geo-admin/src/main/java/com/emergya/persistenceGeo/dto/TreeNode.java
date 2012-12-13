/*
 * TreeNode.java
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
 * Authors:: Antonio Hernández (mailto:ahernandez@emergya.com)
 */
package com.emergya.persistenceGeo.dto;

//import java.util.Date;
//import java.util.LinkedList;

import com.emergya.persistenceGeo.dto.Treeable;
import com.emergya.persistenceGeo.dto.AbstractDto;

/**
 * Folder DTO for show in folder tree
 *
 * @author <a href="mailto:ahernandez@emergya.com">ahernandez</a>
 *
 */
public class TreeNode implements Treeable {

	private static final long serialVersionUID = 7848394150785096968L;

    // The original object
    private AbstractDto data;

    // TRUE if this node isn't a container of nodes
	private boolean leaf;

    // A string that indicates what was the original class
    private String type;


	public TreeNode(AbstractDto origin, boolean isLeaf, String type) {
		super();
        this.data = origin;
        this.leaf = leaf;
        this.type = type;
	}

	public TreeNode(AbstractDto origin, boolean isLeaf) {
        this(origin, isLeaf, "");
	}

	public TreeNode(AbstractDto origin) {
        this(origin, true, "");
	}

    public Long getId() {
        return data.getId() != null ? new Long(data.getId()) : null;
    }

	public String getText() {
        return data.getName() != null ? new String(data.getName()) : null;
	}

    public void setText(String text) {
        //data.setId(id);
    }

	public boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getType() {
		return type;
	}

    public void setType(String type) {
        this.type = type;
    }

}
