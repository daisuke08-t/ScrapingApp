package scraping_app;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scraping scrap = new Scraping();

		WriteFileData writeFile = new WriteFileData();

		String fname = null;

		String url = "";//スクレイピング対象のURL

		ArrayList<Scraping> titleList = scrap.reTitle(url);

		for(int i = 0; i < titleList.size(); i++) {
			System.out.println(titleList.get(i).getTitle());
			writeFile.create("csv/" + titleList.get(i).getTitle() + ".csv");
			fname = "csv/" + titleList.get(i).getTitle() + ".csv";
		}

		ArrayList<Scraping> contentList = scrap.reContent(url);
		writeFile.open(fname);

		for(int i = 0; i < contentList.size(); i++) {
			System.out.println(contentList.get(i).getContent());
			writeFile.writeln(contentList.get(i).getContent());
		}


		writeFile.close();


	}

}
