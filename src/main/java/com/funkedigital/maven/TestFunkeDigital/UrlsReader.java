package com.funkedigital.maven.TestFunkeDigital;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;

public class UrlsReader {

	public URL pageLocation = null;
	public String line = null;
	public String code = null;

	public String readFrom(String url) {

		try {

			pageLocation = new URL(url);

		} catch (MalformedURLException e) {
			System.out.println(e);
		}

		try (Scanner in = new Scanner(pageLocation.openStream());

				BufferedWriter bw = new BufferedWriter(new FileWriter("file.html"))) {

			while (in.hasNext()) {

				line = in.nextLine();
				bw.write(line + "\n");
				code = code + "\n" + line;
			}

		} catch (IOException e) {
			System.out.println(e);
		}
		return (code);
	}
}