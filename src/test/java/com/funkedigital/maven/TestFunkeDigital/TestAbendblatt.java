package com.funkedigital.maven.TestFunkeDigital;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAbendblatt {

	private String url;
	private Boolean expected;

	public TestAbendblatt(String url, Boolean expected) {
		super();
		this.expected = expected;
		this.url = url;
	}

	@Parameters(name = "{index} : {0}")
	public static Collection<Object[]> data() throws IOException {

		UrlsGrabber grabber = new UrlsGrabber(2);
		ArrayList<String> urlList = grabber.getFrom("https://www.abendblatt.de/sitemaps/news.xml");

		Object[][] urls = new Object[urlList.size()][2];

		for (int i = 0; i < urlList.size(); i++) {

			urls[i][0] = new String(urlList.get(i));
			urls[i][1] = new Boolean(true);

		}

		return Arrays.asList(urls);
	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void isPValidTest() throws IOException {

		assertEquals(expected, TestConditions.isPValid(url));

	}

	@Test
	public void isHValidTest() throws IOException {

		assertEquals(expected, TestConditions.isHValid(url));

	}

	@Test
	public void pHasNoRestrictedElementsTest() throws IOException {

		assertEquals(expected, TestConditions.pHasNoRestrictedElements(url));
	}

	@After
	public void tearDown() throws Exception {

	}
}