package scraping_app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileData {

	private BufferedWriter bw = null;

	public void create(String fname) {
		boolean sts = true;

		try {

			File file = new File(fname);
			if(file.createNewFile()) {
				System.out.println("新規ファイルを作成しました。");
			}else {
				System.out.println("ファイルを作成できませんでした。");
			}

		}catch(IOException e) {
			System.out.println("ファイルを作成できませんでした。\n" + e);
			sts = false;
			e.printStackTrace();
		}


	}

	public void open(String fname) {
		boolean sts = true;

		try {

			bw = new BufferedWriter(new FileWriter(fname));

		}catch(IOException e) {
			System.out.println("ファイル名に誤りがあります。\n" + e);
			sts = false;
			e.printStackTrace();
		}

	}

	public void writeln(String str) {

		boolean sts = true;

		try {

			bw.write(str);
			bw.newLine();


		}catch(IOException e) {
			System.out.println("書き込みエラー\n" + e);
			sts = false;
			e.printStackTrace();
		}

	}

	public void close() {
		boolean sts = true;

		try {

			bw.close();

		}catch(IOException e) {
			System.out.println("ファイルクローズエラー\n" + e);
			sts = false;
			e.printStackTrace();
		}

	}


}
