package scraping_app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraping {

	private String title;
	private String img;
	private String content;



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<Scraping> reTitle(String url) {

		ArrayList<Scraping> scrapList = new ArrayList<Scraping>();

		try {
			Document doc = Jsoup.connect(url).get();
			Elements elms = doc.select("title");


			for(Element elm : elms) {
				Scraping scrap = new Scraping();
				scrap.title = elm.text();
				scrapList.add(scrap);

			}

		}catch(IOException e) {
			e.printStackTrace();
		}

		return scrapList;

	}

	public ArrayList<Scraping> reContent(String url) {

		ArrayList<Scraping> scrapList = new ArrayList<Scraping>();

		try {
			Document doc = Jsoup.connect(url).get();
			Elements elms = doc.select("a");


			for(Element elm : elms) {
				Scraping scrap = new Scraping();
				scrap.content = elm.text();
				scrapList.add(scrap);

			}

		}catch(IOException e) {
			e.printStackTrace();
		}

		return scrapList;

	}


	public void reImage(String url){

		ArrayList<Scraping> scrapList = new ArrayList<Scraping>();

		try {
			Response resultImage = Jsoup.connect(url).ignoreContentType(true).execute();

			FileOutputStream out = new FileOutputStream(new File("image/image.jpg"));
			out.write(resultImage.bodyAsBytes());
			out.close();


		}catch(IOException e) {
			e.printStackTrace();
		}
	}





}

