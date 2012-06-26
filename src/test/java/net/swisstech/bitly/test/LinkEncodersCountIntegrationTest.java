/*
 * Copyright (c) Patrick Huber (gmail: stackmagic)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.swisstech.bitly.test;

import static net.swisstech.bitly.test.util.TestUtil.printAndVerify;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import net.swisstech.bitly.model.Response;
import net.swisstech.bitly.model.v3.LinkEncodersCountResponse;

import org.testng.annotations.Test;

/**
 * <p>
 * Integration Test for the <code>/v3/link/encoders_count</code> call
 * </p>
 * 
 * <p>
 * Please see the bit.ly documentation for the <a href="http://dev.bitly.com/link_metrics.html#v3_link_encoders_count">/v3/link/encoders_count</a>
 * request.
 * </p>
 * 
 * @author Patrick Huber (gmail: stackmagic)
 */
public class LinkEncodersCountIntegrationTest extends AbstractBitlyClientIntegrationTest {

	@Test
	public void callLinkEncodersCount() {
		Response<LinkEncodersCountResponse> resp = getClient().linkEncodersCount() //
				.setLink("http://bit.ly/cJ8Hst") //
				.call();

		printAndVerify(resp, LinkEncodersCountResponse.class);

		assertTrue(resp.data.count > 0);
		assertEquals(resp.data.aggregate_link, "http://bitly.com/CjiA");
	}
}
