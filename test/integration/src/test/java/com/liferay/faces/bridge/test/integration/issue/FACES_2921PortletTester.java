/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.bridge.test.integration.issue;

import org.junit.Test;

import com.liferay.faces.bridge.test.integration.BridgeTestUtil;
import com.liferay.faces.test.selenium.IntegrationTesterBase;
import com.liferay.faces.test.selenium.browser.BrowserDriver;
import com.liferay.faces.test.selenium.browser.BrowserStateAsserter;


/**
 * @author  Kyle Stiemann
 */
public class FACES_2921PortletTester extends IntegrationTesterBase {

	@Test
	public void runFACES_2921PortletTest() {

		BrowserDriver browserDriver = getBrowserDriver();
		browserDriver.navigateWindowTo(BridgeTestUtil.getIssuePageURL("faces-2921"));
		browserDriver.sendKeysToElement("//input[contains(@id,':text')]", "text");
		browserDriver.clickElement("//div[contains(@id,':switch')]");
		browserDriver.sendKeysToElement("//input[contains(@id,':slider2')]", "10");
		browserDriver.sendKeysToElement("//input[contains(@id,':slider1')]", "5");
		browserDriver.clickElementAndWaitForRerender("//button[contains(@id,'submit')]");

		BrowserStateAsserter browserStateAsserter = getBrowserStateAsserter();
		browserStateAsserter.assertTextPresentInElement("text", "//span[contains(@id,':textOutput')]");
		browserStateAsserter.assertTextPresentInElement("true", "//span[contains(@id,':switchOutput')]");
		browserStateAsserter.assertTextPresentInElement("5", "//span[contains(@id,':slider1Output')]");
		browserStateAsserter.assertTextPresentInElement("10", "//span[contains(@id,':slider2Output')]");
	}
}
