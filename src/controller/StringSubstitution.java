package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class StringSubstitution {

	public static void main(String[] args) {

		//==========================================================================================

		//文字コードの確認
		System.out.println(System.getProperty("file.encoding"));

		try {
			// ファイルのパスを指定する
			File file = new File("C:\\Users\\t_omu\\Desktop\\Test\\test.txt");
			// output1のパスを指定する

			// ファイルが存在しない場合に例外が発生するので確認する
			//この抽象パス名が示すファイルまたはディレクトリが存在する場合はtrue、そうでない場合はfalse
			if (!file.exists()) {
				System.out.print("ファイルが存在しません");
				return;
			}

			// BufferedReaderクラスのreadLineメソッドを使ってファイルの内容を1行ずつ読み込み表示する
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// PrintWriterクラスのオブジェクトを生成する

			//--------------------------------------------------------------------------------------------

			//読み取った内容を変換する処理、後で関数として切リ取る必要あり
			//置換結果を出力
			String data;

			while ((data = bufferedReader.readLine()) != null) {

				System.out.println("元の  " + data);
				//コマンドラインから入力する値
				//juuutoyoku[
				//String input1 = args[0];
				//String input2 = args[1];

				//置換後のデータをファイルに書き込む
				String data2 = data.replace("a","あ" );
				System.out.println("置換後  "+ data2);
				PrintWriter pw = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8")));
				pw.close();
				pw.println(data2);
			}

			// ファイルを閉じてリソースを開放する
			bufferedReader.close();
			//ファイルを閉じる

			//--------------------------------------------------------------------------------------------

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//=================================================================================

}
