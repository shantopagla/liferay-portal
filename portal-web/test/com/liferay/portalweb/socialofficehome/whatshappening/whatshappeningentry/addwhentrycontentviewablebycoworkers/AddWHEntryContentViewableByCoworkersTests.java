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

package com.liferay.portalweb.socialofficehome.whatshappening.whatshappeningentry.addwhentrycontentviewablebycoworkers;

import com.liferay.portalweb.portal.BaseTests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Brian Wing Shun Chan
 */
public class AddWHEntryContentViewableByCoworkersTests extends BaseTests {

	public static Test suite() {
		TestSuite testSuite = new TestSuite();

		testSuite.addTestSuite(AddUserSOCoworkerTest.class);
		testSuite.addTestSuite(AddWHEntryContentViewableByCoworkersTest.class);
		testSuite.addTestSuite(ViewWHEntryContentViewableByCoworkersTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SOCo_NewPasswordTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SOCo_SignInTest.class);
		testSuite.addTestSuite(SOCo_ViewWHContentViewableByCoworkersTest.class);
		testSuite.addTestSuite(SOCo_AddAsCoworkerCCTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SOSignInTest.class);
		testSuite.addTestSuite(ConfirmCoworkerRequestTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SOCo_SignInTest.class);
		testSuite.addTestSuite(
			SOCo_ViewCoworkerWHContentViewableByCoworkersTest.class);
		testSuite.addTestSuite(SignOutTest.class);
		testSuite.addTestSuite(SOSignInTest.class);
		testSuite.addTestSuite(TearDownWHEntryContentTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);

		return testSuite;
	}

}