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

package com.liferay.portlet.documentlibrary.sharepoint;

import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.sharepoint.BaseSharepointStorageImpl;
import com.liferay.portal.sharepoint.SharepointRequest;
import com.liferay.portal.sharepoint.SharepointUtil;
import com.liferay.portal.sharepoint.Tree;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;

import java.io.InputStream;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Bruno Farache
 */
public class DLSharepointStorageImpl extends BaseSharepointStorageImpl {

	@Override
	public void addDocumentElements(
			SharepointRequest sharepointRequest, Element element)
		throws Exception {

		String parentFolderPath = sharepointRequest.getRootPath();

		long groupId = SharepointUtil.getGroupId(parentFolderPath);
		long parentFolderId = getLastFolderId(
			groupId, parentFolderPath,
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		if (parentFolderId == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			return;
		}

		List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(
			groupId, parentFolderId);

		for (FileEntry fileEntry : fileEntries) {
			String documentPath = parentFolderPath.concat(
				StringPool.SLASH).concat(fileEntry.getTitle());

			addDocumentElement(
				element, documentPath, fileEntry.getCreateDate(),
				fileEntry.getModifiedDate(), fileEntry.getUserName());
		}
	}

	@Override
	public void createFolder(SharepointRequest sharepointRequest)
		throws Exception {

		String folderPath = sharepointRequest.getRootPath();
		String parentFolderPath = getParentFolderPath(folderPath);

		long groupId = SharepointUtil.getGroupId(parentFolderPath);
		long parentFolderId = getLastFolderId(
			groupId, parentFolderPath,
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		String folderName = getResourceName(folderPath);
		String description = StringPool.BLANK;

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		DLAppServiceUtil.addFolder(
			groupId, parentFolderId, folderName, description, serviceContext);
	}

	@Override
	public InputStream getDocumentInputStream(
			SharepointRequest sharepointRequest)
		throws Exception {

		FileEntry fileEntry = getFileEntry(sharepointRequest);

		return fileEntry.getContentStream();
	}

	@Override
	public Tree getDocumentTree(SharepointRequest sharepointRequest)
		throws Exception {

		String documentPath = sharepointRequest.getRootPath();
		String parentFolderPath = getParentFolderPath(documentPath);

		FileEntry fileEntry = getFileEntry(sharepointRequest);

		return getFileEntryTree(fileEntry, parentFolderPath);
	}

	@Override
	public Tree getDocumentsTree(SharepointRequest sharepointRequest)
		throws Exception {

		Tree documentsTree = new Tree();

		String parentFolderPath = sharepointRequest.getRootPath();

		long groupId = SharepointUtil.getGroupId(parentFolderPath);
		long parentFolderId = getLastFolderId(
			groupId, parentFolderPath,
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		if (parentFolderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(
				groupId, parentFolderId);

			for (FileEntry fileEntry : fileEntries) {
				documentsTree.addChild(
					getFileEntryTree(fileEntry, parentFolderPath));
			}
		}

		return documentsTree;
	}

	@Override
	public Tree getFolderTree(SharepointRequest sharepointRequest)
		throws Exception {

		String folderPath = sharepointRequest.getRootPath();
		String parentFolderPath = getParentFolderPath(folderPath);

		long groupId = SharepointUtil.getGroupId(folderPath);
		long folderId = getLastFolderId(
			groupId, folderPath, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		Folder folder = DLAppServiceUtil.getFolder(folderId);

		return getFolderTree(folder, parentFolderPath);
	}

	@Override
	public Tree getFoldersTree(SharepointRequest sharepointRequest)
		throws Exception {

		Tree foldersTree = new Tree();

		String parentFolderPath = sharepointRequest.getRootPath();

		long groupId = SharepointUtil.getGroupId(parentFolderPath);
		long parentFolderId = getLastFolderId(
			groupId, parentFolderPath,
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		List<Folder> folders = DLAppServiceUtil.getFolders(
			groupId, parentFolderId);

		for (Folder folder : folders) {
			foldersTree.addChild(getFolderTree(folder, parentFolderPath));
		}

		foldersTree.addChild(getFolderTree(parentFolderPath));

		return foldersTree;
	}

	@Override
	public void getParentFolderIds(
			long groupId, String path, List<Long> folderIds)
		throws Exception {

		String[] pathArray = SharepointUtil.getPathArray(path);

		if (pathArray.length == 0) {
			return;
		}

		long parentFolderId = folderIds.get(folderIds.size() - 1);
		Folder folder = DLAppServiceUtil.getFolder(
			groupId, parentFolderId, pathArray[0]);

		folderIds.add(folder.getFolderId());

		if (pathArray.length > 1) {
			path = removeFoldersFromPath(path, 1);

			getParentFolderIds(groupId, path, folderIds);
		}
	}

	@Override
	public Tree[] moveDocument(SharepointRequest sharepointRequest)
		throws Exception {

		String parentFolderPath = sharepointRequest.getRootPath();

		long groupId = SharepointUtil.getGroupId(parentFolderPath);

		Folder folder = null;
		FileEntry fileEntry = null;

		try {
			long parentFolderId = getLastFolderId(
				groupId, parentFolderPath,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

			folder = DLAppServiceUtil.getFolder(parentFolderId);
		}
		catch (Exception e1) {
			if (e1 instanceof NoSuchFolderException) {
				try {
					fileEntry = getFileEntry(sharepointRequest);
				}
				catch (Exception e2) {
				}
			}
		}

		Tree movedDocsTree = new Tree();
		Tree movedDirsTree = new Tree();

		String newPath = sharepointRequest.getParameterValue("newUrl");
		String newParentFolderPath = getParentFolderPath(newPath);

		long newGroupId = SharepointUtil.getGroupId(newParentFolderPath);

		long newParentFolderId = getLastFolderId(
			newGroupId, newParentFolderPath,
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		String newName = getResourceName(newPath);

		ServiceContext serviceContext = new ServiceContext();

		if (fileEntry != null) {
			long fileEntryId = fileEntry.getFileEntryId();

			long folderId = fileEntry.getFolderId();
			String mimeType = fileEntry.getMimeType();
			String description = fileEntry.getDescription();
			String changeLog = StringPool.BLANK;

			InputStream is = fileEntry.getContentStream();

			byte[] bytes = FileUtil.getBytes(is);

			String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(
				FileEntry.class.getName(), fileEntry.getFileEntryId());

			serviceContext.setAssetTagNames(assetTagNames);

			fileEntry = DLAppServiceUtil.updateFileEntry(
				fileEntryId, newName, mimeType, newName, description, changeLog,
				false, bytes, serviceContext);

			if (folderId != newParentFolderId) {
				fileEntry = DLAppServiceUtil.moveFileEntry(
					fileEntryId, newParentFolderId, serviceContext);
			}

			Tree documentTree = getFileEntryTree(
				fileEntry, newParentFolderPath);

			movedDocsTree.addChild(documentTree);
		}
		else if (folder != null) {
			long folderId = folder.getFolderId();

			folder = DLAppServiceUtil.moveFolder(
				folderId, newParentFolderId, serviceContext);

			Tree folderTree = getFolderTree(folder, newParentFolderPath);

			movedDirsTree.addChild(folderTree);
		}

		return new Tree[] {movedDocsTree, movedDirsTree};
	}

	@Override
	public void putDocument(SharepointRequest sharepointRequest)
		throws Exception {

		HttpServletRequest request = sharepointRequest.getHttpServletRequest();

		String documentPath = sharepointRequest.getRootPath();
		String parentFolderPath = getParentFolderPath(documentPath);

		long groupId = SharepointUtil.getGroupId(parentFolderPath);
		long parentFolderId = getLastFolderId(
			groupId, parentFolderPath,
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		String title = getResourceName(documentPath);
		String description = StringPool.BLANK;
		String changeLog = StringPool.BLANK;
		InputStream is = new UnsyncByteArrayInputStream(
			sharepointRequest.getBytes());
		long contentLength = sharepointRequest.getBytes().length;

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		String contentType = GetterUtil.get(
			request.getHeader(HttpHeaders.CONTENT_TYPE),
			ContentTypes.APPLICATION_OCTET_STREAM);

		if (contentType.equals(ContentTypes.APPLICATION_OCTET_STREAM)) {
			contentType = MimeTypesUtil.getContentType(is, title);
		}

		try {
			FileEntry fileEntry = getFileEntry(sharepointRequest);

			long fileEntryId = fileEntry.getFileEntryId();

			description = fileEntry.getDescription();

			String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(
				FileEntry.class.getName(), fileEntry.getFileEntryId());

			serviceContext.setAssetTagNames(assetTagNames);

			DLAppServiceUtil.updateFileEntry(
				fileEntryId, title, contentType, title, description, changeLog,
				false, is, contentLength, serviceContext);
		}
		catch (NoSuchFileEntryException nsfee) {
			DLAppServiceUtil.addFileEntry(
				groupId, parentFolderId, title, contentType, title, description,
				changeLog, is, contentLength, serviceContext);
		}
	}

	@Override
	public Tree[] removeDocument(SharepointRequest sharepointRequest) {
		String parentFolderPath = sharepointRequest.getRootPath();

		long groupId = SharepointUtil.getGroupId(parentFolderPath);

		Folder folder = null;
		FileEntry fileEntry = null;

		try {
			long parentFolderId = getLastFolderId(
				groupId, parentFolderPath,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

			folder = DLAppServiceUtil.getFolder(parentFolderId);
		}
		catch (Exception e1) {
			if (e1 instanceof NoSuchFolderException) {
				try {
					fileEntry = getFileEntry(sharepointRequest);
				}
				catch (Exception e2) {
				}
			}
		}

		Tree documentTree = new Tree();

		Tree removedDocsTree = new Tree();
		Tree failedDocsTree = new Tree();

		Tree folderTree = new Tree();

		Tree removedDirsTree = new Tree();
		Tree failedDirsTree = new Tree();

		if (fileEntry != null) {
			try {
				documentTree = getFileEntryTree(fileEntry, parentFolderPath);

				DLAppServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());

				removedDocsTree.addChild(documentTree);
			}
			catch (Exception e1) {
				try {
					failedDocsTree.addChild(documentTree);
				}
				catch (Exception e2) {
				}
			}
		}
		else if (folder != null) {
			try {
				folderTree = getFolderTree(folder, parentFolderPath);

				DLAppServiceUtil.deleteFolder(folder.getFolderId());

				removedDirsTree.addChild(folderTree);
			}
			catch (Exception e1) {
				try {
					failedDirsTree.addChild(folderTree);
				}
				catch (Exception e2) {
				}
			}
		}

		return new Tree[] {
			removedDocsTree, removedDirsTree, failedDocsTree, failedDirsTree};
	}

	protected Tree getFolderTree(Folder folder, String parentFolderPath) {
		String folderPath = parentFolderPath.concat(StringPool.SLASH).concat(
			folder.getName());

		return getFolderTree(
			folderPath, folder.getCreateDate(), folder.getModifiedDate(),
			folder.getLastPostDate());
	}

	protected FileEntry getFileEntry(SharepointRequest sharepointRequest)
		throws Exception {

		String documentPath = sharepointRequest.getRootPath();
		String parentFolderPath = getParentFolderPath(documentPath);

		long groupId = SharepointUtil.getGroupId(parentFolderPath);
		long parentFolderId = getLastFolderId(
			groupId, parentFolderPath,
			DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		String title = getResourceName(documentPath);

		return DLAppServiceUtil.getFileEntry(
			groupId, parentFolderId, title);
	}

	protected Tree getFileEntryTree(
		FileEntry fileEntry, String parentFolderPath) {

		String documentPath = parentFolderPath.concat(StringPool.SLASH).concat(
			fileEntry.getTitle());

		return getDocumentTree(
			documentPath, fileEntry.getCreateDate(),
			fileEntry.getModifiedDate(), fileEntry.getSize(),
			fileEntry.getUserName(), fileEntry.getVersion());
	}

}