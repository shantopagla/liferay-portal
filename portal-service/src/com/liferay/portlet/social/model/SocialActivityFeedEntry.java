/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.social.model;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Brian Wing Shun Chan
 */
public class SocialActivityFeedEntry {

	public SocialActivityFeedEntry(String title, String body) {
		this(null, title, body);
	}

	public SocialActivityFeedEntry(String link, String title, String body) {
		setLink(link);
		setTitle(title);
		setBody(body);
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = GetterUtil.getString(portletId);
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = GetterUtil.getString(link);
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = GetterUtil.getString(title);
	}

	public String getBody() {
		return _body;
	}

	public void setBody(String body) {
		_body = GetterUtil.getString(body);
	}

	private String _portletId = StringPool.BLANK;
	private String _link = StringPool.BLANK;
	private String _title = StringPool.BLANK;
	private String _body = StringPool.BLANK;

}