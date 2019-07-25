package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

public class FileSearch {

	public static void main(String[] args) {
		//Fileクラスのオブジェクトdirectryを生成する
		File directry = new File("C:\\Users\\endo\\Desktop\\StringSubstitution");
		//この抽象パス名fileが示すファイルまたはディレクトリが存在する場合はtrue、そうでない場合はfalse
		if (!directry.exists()) {
			System.out.print("ファイルが存在しません");
			return;
		}
		//listFilesメソッドを使用して、指定したパスに存在するファイルディレクトリを取得する。
		File[] list = directry.listFiles();
		//該当ディレクトリ内のファイルが無くなるまで置換を続ける。
		for (int i = 0; i < list.length; i++) {
			System.out.println(replaceFile(list[i]));
		}
	}

	//---------------------------------------------------------------------------------------------------
	private static String replaceFile(File filePath) {
		// BufferedReaderクラスのreadLineメソッドを使ってファイルの内容を1行ずつ読み込み表示する
		try {
			FileReader fileReader = new FileReader(filePath);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//--------------------------------------------------------------------------------------------
			//読み取った内容を変換する処理、後で関数として切リ取る必要あり
			String originalData;

			while ((originalData = bufferedReader.readLine()) != null) {

				System.out.println("元の内容:" + originalData);

				//コマンドラインから入力する値String input1 = args[0];String input2 = args[1];
				//置換後のデータをファイルに書き込む
				String replacedData = originalData.replace("a", "あ");

				System.out.println("置換後の内容:" + replacedData);
				//ファイル名取得
				String fileName = filePath.getName();

				// File型をPath型に変換
				Path path = filePath.toPath();
				// ファイル名より前のパスを取得
				Path pathParentName = path.getParent();
				// ファイル名を置換 PathParentNameは最後の\が取れないため置換後のファイル名に\\を追加
				String changedName = fileName.replace(".txt", "Replaced.txt");
				System.out.println(pathParentName + "\\" + changedName);

				//置換した結果を出力するための新しいファイルを作成
				File newfile = new File(pathParentName +"\\"+changedName);
				//System.out.println("パス"+filePath.getPath());
				System.out.println("新しいファイル名" + newfile);

				try {
					newfile.createNewFile();
				
					
				} catch (IOException e) {
					System.out.println(e);
				}

				//新しく作成したファイルの中に置換したデータを書き出す
				PrintWriter pw = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile), "UTF-8")));

				System.out.println(filePath);

				pw.write(replacedData);
				//改行処理
				pw.write("\r\n");
				pw.close();

			}
			// ファイルを閉じてリソースを開放する
			bufferedReader.close();
			//--------------------------------------------------------------------------------------------

		} catch (IOException e) {
			e.printStackTrace();

		}
	return null;

	}

}
