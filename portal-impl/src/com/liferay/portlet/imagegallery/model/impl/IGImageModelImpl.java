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

package com.liferay.portlet.imagegallery.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.model.IGImageModel;
import com.liferay.portlet.imagegallery.model.IGImageSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the IGImage service. Represents a row in the &quot;IGImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.imagegallery.model.IGImageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IGImageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IGImageImpl
 * @see com.liferay.portlet.imagegallery.model.IGImage
 * @see com.liferay.portlet.imagegallery.model.IGImageModel
 * @generated
 */
@JSON(strict = true)
public class IGImageModelImpl extends BaseModelImpl<IGImage>
	implements IGImageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a i g image model instance should use the {@link com.liferay.portlet.imagegallery.model.IGImage} interface instead.
	 */
	public static final String TABLE_NAME = "IGImage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "imageId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "folderId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "smallImageId", Types.BIGINT },
			{ "largeImageId", Types.BIGINT },
			{ "custom1ImageId", Types.BIGINT },
			{ "custom2ImageId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table IGImage (uuid_ VARCHAR(75) null,imageId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,folderId LONG,name VARCHAR(75) null,description STRING null,smallImageId LONG,largeImageId LONG,custom1ImageId LONG,custom2ImageId LONG)";
	public static final String TABLE_SQL_DROP = "drop table IGImage";
	public static final String ORDER_BY_JPQL = " ORDER BY igImage.imageId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY IGImage.imageId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.imagegallery.model.IGImage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.imagegallery.model.IGImage"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static IGImage toModel(IGImageSoap soapModel) {
		IGImage model = new IGImageImpl();

		model.setUuid(soapModel.getUuid());
		model.setImageId(soapModel.getImageId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setFolderId(soapModel.getFolderId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setSmallImageId(soapModel.getSmallImageId());
		model.setLargeImageId(soapModel.getLargeImageId());
		model.setCustom1ImageId(soapModel.getCustom1ImageId());
		model.setCustom2ImageId(soapModel.getCustom2ImageId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<IGImage> toModels(IGImageSoap[] soapModels) {
		List<IGImage> models = new ArrayList<IGImage>(soapModels.length);

		for (IGImageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public Class<?> getModelClass() {
		return IGImage.class;
	}

	public String getModelClassName() {
		return IGImage.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.imagegallery.model.IGImage"));

	public IGImageModelImpl() {
	}

	public long getPrimaryKey() {
		return _imageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setImageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_imageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	@JSON
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_name = name;
	}

	@JSON
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	public long getSmallImageId() {
		return _smallImageId;
	}

	public void setSmallImageId(long smallImageId) {
		if (!_setOriginalSmallImageId) {
			_setOriginalSmallImageId = true;

			_originalSmallImageId = _smallImageId;
		}

		_smallImageId = smallImageId;
	}

	public long getOriginalSmallImageId() {
		return _originalSmallImageId;
	}

	@JSON
	public long getLargeImageId() {
		return _largeImageId;
	}

	public void setLargeImageId(long largeImageId) {
		if (!_setOriginalLargeImageId) {
			_setOriginalLargeImageId = true;

			_originalLargeImageId = _largeImageId;
		}

		_largeImageId = largeImageId;
	}

	public long getOriginalLargeImageId() {
		return _originalLargeImageId;
	}

	@JSON
	public long getCustom1ImageId() {
		return _custom1ImageId;
	}

	public void setCustom1ImageId(long custom1ImageId) {
		if (!_setOriginalCustom1ImageId) {
			_setOriginalCustom1ImageId = true;

			_originalCustom1ImageId = _custom1ImageId;
		}

		_custom1ImageId = custom1ImageId;
	}

	public long getOriginalCustom1ImageId() {
		return _originalCustom1ImageId;
	}

	@JSON
	public long getCustom2ImageId() {
		return _custom2ImageId;
	}

	public void setCustom2ImageId(long custom2ImageId) {
		if (!_setOriginalCustom2ImageId) {
			_setOriginalCustom2ImageId = true;

			_originalCustom2ImageId = _custom2ImageId;
		}

		_custom2ImageId = custom2ImageId;
	}

	public long getOriginalCustom2ImageId() {
		return _originalCustom2ImageId;
	}

	@Override
	public IGImage toEscapedModel() {
		if (isEscapedModel()) {
			return (IGImage)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (IGImage)Proxy.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					IGImage.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		IGImageImpl igImageImpl = new IGImageImpl();

		igImageImpl.setUuid(getUuid());
		igImageImpl.setImageId(getImageId());
		igImageImpl.setGroupId(getGroupId());
		igImageImpl.setCompanyId(getCompanyId());
		igImageImpl.setUserId(getUserId());
		igImageImpl.setUserName(getUserName());
		igImageImpl.setCreateDate(getCreateDate());
		igImageImpl.setModifiedDate(getModifiedDate());
		igImageImpl.setFolderId(getFolderId());
		igImageImpl.setName(getName());
		igImageImpl.setDescription(getDescription());
		igImageImpl.setSmallImageId(getSmallImageId());
		igImageImpl.setLargeImageId(getLargeImageId());
		igImageImpl.setCustom1ImageId(getCustom1ImageId());
		igImageImpl.setCustom2ImageId(getCustom2ImageId());

		igImageImpl.resetOriginalValues();

		return igImageImpl;
	}

	public int compareTo(IGImage igImage) {
		int value = 0;

		if (getImageId() < igImage.getImageId()) {
			value = -1;
		}
		else if (getImageId() > igImage.getImageId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		IGImage igImage = null;

		try {
			igImage = (IGImage)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = igImage.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		IGImageModelImpl igImageModelImpl = this;

		igImageModelImpl._originalUuid = igImageModelImpl._uuid;

		igImageModelImpl._originalGroupId = igImageModelImpl._groupId;

		igImageModelImpl._setOriginalGroupId = false;

		igImageModelImpl._originalSmallImageId = igImageModelImpl._smallImageId;

		igImageModelImpl._setOriginalSmallImageId = false;

		igImageModelImpl._originalLargeImageId = igImageModelImpl._largeImageId;

		igImageModelImpl._setOriginalLargeImageId = false;

		igImageModelImpl._originalCustom1ImageId = igImageModelImpl._custom1ImageId;

		igImageModelImpl._setOriginalCustom1ImageId = false;

		igImageModelImpl._originalCustom2ImageId = igImageModelImpl._custom2ImageId;

		igImageModelImpl._setOriginalCustom2ImageId = false;
	}

	@Override
	public CacheModel<IGImage> toCacheModel() {
		IGImageCacheModel igImageCacheModel = new IGImageCacheModel();

		igImageCacheModel.uuid = getUuid();

		if ((igImageCacheModel.uuid != null) &&
				(igImageCacheModel.uuid.length() == 0)) {
			igImageCacheModel.uuid = null;
		}

		igImageCacheModel.imageId = getImageId();
		igImageCacheModel.groupId = getGroupId();
		igImageCacheModel.companyId = getCompanyId();
		igImageCacheModel.userId = getUserId();
		igImageCacheModel.userName = getUserName();

		if ((igImageCacheModel.userName != null) &&
				(igImageCacheModel.userName.length() == 0)) {
			igImageCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			igImageCacheModel.createDate = createDate.getTime();
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			igImageCacheModel.modifiedDate = modifiedDate.getTime();
		}

		igImageCacheModel.folderId = getFolderId();
		igImageCacheModel.name = getName();

		if ((igImageCacheModel.name != null) &&
				(igImageCacheModel.name.length() == 0)) {
			igImageCacheModel.name = null;
		}

		igImageCacheModel.description = getDescription();

		if ((igImageCacheModel.description != null) &&
				(igImageCacheModel.description.length() == 0)) {
			igImageCacheModel.description = null;
		}

		igImageCacheModel.smallImageId = getSmallImageId();
		igImageCacheModel.largeImageId = getLargeImageId();
		igImageCacheModel.custom1ImageId = getCustom1ImageId();
		igImageCacheModel.custom2ImageId = getCustom2ImageId();

		return igImageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", smallImageId=");
		sb.append(getSmallImageId());
		sb.append(", largeImageId=");
		sb.append(getLargeImageId());
		sb.append(", custom1ImageId=");
		sb.append(getCustom1ImageId());
		sb.append(", custom2ImageId=");
		sb.append(getCustom2ImageId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.imagegallery.model.IGImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageId</column-name><column-value><![CDATA[");
		sb.append(getSmallImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImageId</column-name><column-value><![CDATA[");
		sb.append(getLargeImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>custom1ImageId</column-name><column-value><![CDATA[");
		sb.append(getCustom1ImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>custom2ImageId</column-name><column-value><![CDATA[");
		sb.append(getCustom2ImageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = IGImage.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			IGImage.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _imageId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _folderId;
	private String _name;
	private String _description;
	private long _smallImageId;
	private long _originalSmallImageId;
	private boolean _setOriginalSmallImageId;
	private long _largeImageId;
	private long _originalLargeImageId;
	private boolean _setOriginalLargeImageId;
	private long _custom1ImageId;
	private long _originalCustom1ImageId;
	private boolean _setOriginalCustom1ImageId;
	private long _custom2ImageId;
	private long _originalCustom2ImageId;
	private boolean _setOriginalCustom2ImageId;
	private transient ExpandoBridge _expandoBridge;
	private IGImage _escapedModelProxy;
}