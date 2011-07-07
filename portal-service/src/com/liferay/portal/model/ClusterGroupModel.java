/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ClusterGroup service. Represents a row in the &quot;ClusterGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.ClusterGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.ClusterGroupImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClusterGroup
 * @see com.liferay.portal.model.impl.ClusterGroupImpl
 * @see com.liferay.portal.model.impl.ClusterGroupModelImpl
 * @generated
 */
public interface ClusterGroupModel extends BaseModel<ClusterGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cluster group model instance should use the {@link ClusterGroup} interface instead.
	 */

	/**
	 * Returns the primary key of this cluster group.
	 *
	 * @return the primary key of this cluster group
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cluster group.
	 *
	 * @param primaryKey the primary key of this cluster group
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cluster group ID of this cluster group.
	 *
	 * @return the cluster group ID of this cluster group
	 */
	public long getClusterGroupId();

	/**
	 * Sets the cluster group ID of this cluster group.
	 *
	 * @param clusterGroupId the cluster group ID of this cluster group
	 */
	public void setClusterGroupId(long clusterGroupId);

	/**
	 * Returns the name of this cluster group.
	 *
	 * @return the name of this cluster group
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this cluster group.
	 *
	 * @param name the name of this cluster group
	 */
	public void setName(String name);

	/**
	 * Returns the cluster node IDs of this cluster group.
	 *
	 * @return the cluster node IDs of this cluster group
	 */
	@AutoEscape
	public String getClusterNodeIds();

	/**
	 * Sets the cluster node IDs of this cluster group.
	 *
	 * @param clusterNodeIds the cluster node IDs of this cluster group
	 */
	public void setClusterNodeIds(String clusterNodeIds);

	/**
	 * Returns the whole cluster of this cluster group.
	 *
	 * @return the whole cluster of this cluster group
	 */
	public boolean getWholeCluster();

	/**
	 * Returns <code>true</code> if this cluster group is whole cluster.
	 *
	 * @return <code>true</code> if this cluster group is whole cluster; <code>false</code> otherwise
	 */
	public boolean isWholeCluster();

	/**
	 * Sets whether this cluster group is whole cluster.
	 *
	 * @param wholeCluster the whole cluster of this cluster group
	 */
	public void setWholeCluster(boolean wholeCluster);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ClusterGroup clusterGroup);

	public int hashCode();

	public CacheModel<ClusterGroup> toCacheModel();

	public ClusterGroup toEscapedModel();

	public String toString();

	public String toXmlString();
}