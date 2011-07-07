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
 * The base model interface for the Company service. Represents a row in the &quot;Company&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.CompanyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.CompanyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Company
 * @see com.liferay.portal.model.impl.CompanyImpl
 * @see com.liferay.portal.model.impl.CompanyModelImpl
 * @generated
 */
public interface CompanyModel extends BaseModel<Company> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a company model instance should use the {@link Company} interface instead.
	 */

	/**
	 * Returns the primary key of this company.
	 *
	 * @return the primary key of this company
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this company.
	 *
	 * @param primaryKey the primary key of this company
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the company ID of this company.
	 *
	 * @return the company ID of this company
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this company.
	 *
	 * @param companyId the company ID of this company
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the account ID of this company.
	 *
	 * @return the account ID of this company
	 */
	public long getAccountId();

	/**
	 * Sets the account ID of this company.
	 *
	 * @param accountId the account ID of this company
	 */
	public void setAccountId(long accountId);

	/**
	 * Returns the web ID of this company.
	 *
	 * @return the web ID of this company
	 */
	@AutoEscape
	public String getWebId();

	/**
	 * Sets the web ID of this company.
	 *
	 * @param webId the web ID of this company
	 */
	public void setWebId(String webId);

	/**
	 * Returns the key of this company.
	 *
	 * @return the key of this company
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this company.
	 *
	 * @param key the key of this company
	 */
	public void setKey(String key);

	/**
	 * Returns the mx of this company.
	 *
	 * @return the mx of this company
	 */
	@AutoEscape
	public String getMx();

	/**
	 * Sets the mx of this company.
	 *
	 * @param mx the mx of this company
	 */
	public void setMx(String mx);

	/**
	 * Returns the home u r l of this company.
	 *
	 * @return the home u r l of this company
	 */
	@AutoEscape
	public String getHomeURL();

	/**
	 * Sets the home u r l of this company.
	 *
	 * @param homeURL the home u r l of this company
	 */
	public void setHomeURL(String homeURL);

	/**
	 * Returns the logo ID of this company.
	 *
	 * @return the logo ID of this company
	 */
	public long getLogoId();

	/**
	 * Sets the logo ID of this company.
	 *
	 * @param logoId the logo ID of this company
	 */
	public void setLogoId(long logoId);

	/**
	 * Returns the system of this company.
	 *
	 * @return the system of this company
	 */
	public boolean getSystem();

	/**
	 * Returns <code>true</code> if this company is system.
	 *
	 * @return <code>true</code> if this company is system; <code>false</code> otherwise
	 */
	public boolean isSystem();

	/**
	 * Sets whether this company is system.
	 *
	 * @param system the system of this company
	 */
	public void setSystem(boolean system);

	/**
	 * Returns the max users of this company.
	 *
	 * @return the max users of this company
	 */
	public int getMaxUsers();

	/**
	 * Sets the max users of this company.
	 *
	 * @param maxUsers the max users of this company
	 */
	public void setMaxUsers(int maxUsers);

	/**
	 * Returns the active of this company.
	 *
	 * @return the active of this company
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this company is active.
	 *
	 * @return <code>true</code> if this company is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this company is active.
	 *
	 * @param active the active of this company
	 */
	public void setActive(boolean active);

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

	public int compareTo(Company company);

	public int hashCode();

	public CacheModel<Company> toCacheModel();

	public Company toEscapedModel();

	public String toString();

	public String toXmlString();
}