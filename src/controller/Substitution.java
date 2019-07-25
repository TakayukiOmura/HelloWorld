package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Substitution {

	public static void main(String[] args) {

		//==========================================================================================

		try {
			// ファイルのパスを指定する
			File file = new File("C:\\Users\\endo\\Desktop\\StringSubstitution\\test1.txt");
			//この抽象パス名fileが示すファイルまたはディレクトリが存在する場合はtrue、そうでない場合はfalse
			if (!file.exists()) {
				System.out.print("ファイルが存在しません");
				return;
			}

			// BufferedReaderクラスのreadLineメソッドを使ってファイルの内容を1行ずつ読み込み表示する
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			//置換した結果を出力するための新しいファイルを作成
			File newfile = new File("C:\\Users\\endo\\Desktop\\StringSubstitution\\t.txt");

			PrintWriter pw = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile), "UTF-8")));
			if (newfile.createNewFile()) {
				System.out.println("outputファイルの作成に成功しました。");
			} else {
				System.out.println("ファイルの作成に失敗しました。");
			}

			//--------------------------------------------------------------------------------------------
			//読み取った内容を変換する処理、後で関数として切リ取る必要あり
			String data;

			while ((data = bufferedReader.readLine()) != null) {

				System.out.println("元の内容:" + data);

				//コマンドラインから入力する値
				//juuutoyoku[
				//String input1 = args[0];
				//String input2 = args[1];

				//置換後のデータをファイルに書き込む
				String data2 = data.replace("a", "あ");

				System.out.println("置換後の内容:" + data2);

				pw.write(data2);
				pw.write("\r\n");
			}
			pw.close();
			// ファイルを閉じてリソースを開放する
			bufferedReader.close();
			//--------------------------------------------------------------------------------------------

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//=================================================================================

}
