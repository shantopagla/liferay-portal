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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Lock service. Represents a row in the &quot;Lock_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.LockModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.LockImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Lock
 * @see com.liferay.portal.model.impl.LockImpl
 * @see com.liferay.portal.model.impl.LockModelImpl
 * @generated
 */
public interface LockModel extends BaseModel<Lock> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a lock model instance should use the {@link Lock} interface instead.
	 */

	/**
	 * Returns the primary key of this lock.
	 *
	 * @return the primary key of this lock
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this lock.
	 *
	 * @param primaryKey the primary key of this lock
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this lock.
	 *
	 * @return the uuid of this lock
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this lock.
	 *
	 * @param uuid the uuid of this lock
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the lock ID of this lock.
	 *
	 * @return the lock ID of this lock
	 */
	public long getLockId();

	/**
	 * Sets the lock ID of this lock.
	 *
	 * @param lockId the lock ID of this lock
	 */
	public void setLockId(long lockId);

	/**
	 * Returns the company ID of this lock.
	 *
	 * @return the company ID of this lock
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this lock.
	 *
	 * @param companyId the company ID of this lock
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this lock.
	 *
	 * @return the user ID of this lock
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this lock.
	 *
	 * @param userId the user ID of this lock
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this lock.
	 *
	 * @return the user uuid of this lock
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this lock.
	 *
	 * @param userUuid the user uuid of this lock
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this lock.
	 *
	 * @return the user name of this lock
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this lock.
	 *
	 * @param userName the user name of this lock
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this lock.
	 *
	 * @return the create date of this lock
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this lock.
	 *
	 * @param createDate the create date of this lock
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the class name of this lock.
	 *
	 * @return the class name of this lock
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this lock.
	 *
	 * @param className the class name of this lock
	 */
	public void setClassName(String className);

	/**
	 * Returns the key of this lock.
	 *
	 * @return the key of this lock
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this lock.
	 *
	 * @param key the key of this lock
	 */
	public void setKey(String key);

	/**
	 * Returns the owner of this lock.
	 *
	 * @return the owner of this lock
	 */
	@AutoEscape
	public String getOwner();

	/**
	 * Sets the owner of this lock.
	 *
	 * @param owner the owner of this lock
	 */
	public void setOwner(String owner);

	/**
	 * Returns the inheritable of this lock.
	 *
	 * @return the inheritable of this lock
	 */
	public boolean getInheritable();

	/**
	 * Returns <code>true</code> if this lock is inheritable.
	 *
	 * @return <code>true</code> if this lock is inheritable; <code>false</code> otherwise
	 */
	public boolean isInheritable();

	/**
	 * Sets whether this lock is inheritable.
	 *
	 * @param inheritable the inheritable of this lock
	 */
	public void setInheritable(boolean inheritable);

	/**
	 * Returns the expiration date of this lock.
	 *
	 * @return the expiration date of this lock
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this lock.
	 *
	 * @param expirationDate the expiration date of this lock
	 */
	public void setExpirationDate(Date expirationDate);

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

	public int compareTo(Lock lock);

	public int hashCode();

	public Lock toEscapedModel();

	public String toString();

	public String toXmlString();
}