package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//============指定したディレクトリ内のファイルの文字列を置換して別のディレクトリに出力するクラス====================
public class StringSubstitution {
	//static修飾子を使用する為にフィールドを宣言しておく
	
//現在時刻
	static String nowDate;
	static String beforeReplacementData;
	static String afterReplacementData;

	public static void main(String[] args) {
		//変数replacePathに置換を開始するディレクトリの絶対パスを入力
		String replacePath = "C:\\Users\\endo\\Desktop\\StringSubstitution";

		beforeReplacementData = args[0];
		afterReplacementData = args[1];

		readFile(new File(replacePath));
	}

	//============ 指定したディレクトリ以下のディレクトリとファイル一覧を取得するメソッド====================
	private static void readFile(File replacePath) {

		//replacePathが示すディレクトリ内のファイルを示す抽象パス名の配列filesを定義。
		File[] files = replacePath.listFiles();

		//拡張for文で抽象パス一覧を取得する。
		for (File filePath : files) {

			// ディレクトリの場合
			if (filePath.isDirectory()) {
				System.out.println(filePath.getName() + "はディレクトリです");
				
				createDirectory(filePath);
				// 再帰的にreadFileｍそっどえおディレクトリ間を移動
				readFile(filePath);
				// ファイルの場合
			} else {
				System.out.println(filePath.getName() + "はファイルです");
				replaceFile(filePath);
			}
		}
	}

	//======================================ディレクトリを作成するメソッド==============================================
	private static void createDirectory(File directoryPath) {
		//ディレクトリを出力用のファイルに複製する処理
		File newDirectory = new File(directoryPath.toString().replace("StringSubstitution", "Output"));
		System.out.println("ディレクトリーパスは" + newDirectory);
		if (newDirectory.mkdir()) {
			System.out.println("ディレクトリの作成に成功しました。");
		} else if (newDirectory.exists()) {
			System.out.println("既にディレクトリが存在しています。");
		} else {
			System.out.println("ディレクトリの作成に失敗しました。");
		}
	}

	//======================================ファイルを作成するメソッド==============================================
	private static void replaceFile(File filePath) {
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String originalData;
			//置換したファイルを出力するディレクトリのパス
			String outputPath;
			//-------------------------------一行ずつファイルの中身を読み取っていく処理--------------------------------
			while ((originalData = bufferedReader.readLine()) != null) {

				System.out.println("元々の内容:" + originalData);

				//コマンドラインから入力する値
				String replacedData = originalData.replace(beforeReplacementData,afterReplacementData );

				System.out.println("置換後内容:" + replacedData);
				//------------パスを書き換えてOutputファイルの中に置換したデータを書き出す処理-------------------
				outputPath = filePath.toString().replace("StringSubstitution", "Output");

				//データクラスを導入して現在時刻を取得する	
				Date now = new Date();
				SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
				nowDate = date.format(now);
				
				//ファイル名に作成時の時刻nowDateを付け足して作成
				File newfile = new File(outputPath + "." + nowDate + ".txt");
				System.out.println("ファイルのパス" + outputPath);
				//if (newfile.getParentFile() == null) {
				//newfile.getParentFile().mkdir();
				newfile.createNewFile();
				
				PrintWriter pw = new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream(newfile), "UTF-8")));
				//置換後のデータをファイルに書き込む
				pw.write(replacedData);
				//改行処理
				pw.write("\r\n");
				pw.close();
			}
			// ファイルを閉じてリソースを開放する
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		return;
	}

}
