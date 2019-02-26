package com.funkedigital.maven.TestFunkeDigital;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestConditions {

	public static boolean isHValid(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();

		return doc.getElementsByTag("h1").size() < 2;
	}

	public static boolean pHasNoRestrictedElements(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();
		Elements e = doc.body().children().select("p");
		String s = e.toString();

		return !(s.contains("<img>") || s.contains("<div>") || s.contains("<table>"));
	}

	public static boolean isPValid(String url) {

		UrlsReader reader = new UrlsReader();
		String pagesource = reader.readFrom(url);
		int popening = StringUtils.countMatches(pagesource, "<p ") + StringUtils.countMatches(pagesource, "<p>");
		int pclosing = StringUtils.countMatches(pagesource, "</p>");

		return (popening == pclosing);
	}

}
