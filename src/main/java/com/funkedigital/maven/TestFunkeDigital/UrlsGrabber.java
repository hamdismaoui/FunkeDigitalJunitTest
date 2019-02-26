package com.funkedigital.maven.TestFunkeDigital;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class UrlsGrabber {

	public UrlsGrabber(int maxUrls) {
		super();
		this.maxUrls = maxUrls;
	}

	private ArrayList<String> urls = new ArrayList<>();
	private Element e;
	private String s;
	private int maxUrls;

	public ArrayList<String> getFrom(String url) throws IOException {

		Document doc = Jsoup.connect(url).get();

		for (int i = 0; i < maxUrls; i++) {

			e = doc.select("loc").get(i);
			s = e.ownText();
			urls.add(s);
		}
		return urls;
	}
}
