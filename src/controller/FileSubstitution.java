package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileSubstitution {

	public static  void main(String[] args) {	
		//Fileクラスのオブジェクトdirectryを生成する
		String pathName = "C:\\Users\\endo\\Desktop\\StringSubstitution";
				File directry = new File(pathName);
				//この抽象パス名fileが示すファイルまたはディレクトリが存在する場合はtrue、そうでない場合はfalse
				if (!directry.exists()) {
					System.out.print("ファイルが存在しません");
					}
				//listFilesメソッドを使用して、指定したパスに存在するファイルディレクトリを取得する。
				File[] list = directry.listFiles();
				//該当ディレクトリ内のファイルが無くなるまで置換を続ける。
				for (int index = 0; index < list.length; index++) {   
					
					replaceFile(list[index],pathName);
				}
			}
	
	private static String replaceFile(File filePath , String pathName){
		//Directry判定 
		if (filePath.isDirectory()) {
             System.out.println(  filePath.getName() + "はディレクトリです");
          
         }
		
         if (filePath.isFile()) {
             System.out.println( filePath.getName() + "]はファイルです");
           
         }
         System.out.println("[12][]はディレクトリでもファイルでもありません");
         
         
         try {
 			FileReader fileReader = new FileReader(filePath);
 			BufferedReader bufferedReader = new BufferedReader(fileReader);
 	
 			//--------------------------------------------------------------------------------------------
 			String originalData;

 			while ((originalData = bufferedReader.readLine()) != null) {

 				System.out.println("元の内容:" + originalData);

 				//コマンドラインから入力する値String input1 = args[0];String input2 = args[1];
 				//置換後のデータをファイルに書き込む
 				String replacedData = originalData.replace("a", "あ");

 				System.out.println("置換後の内容:" + replacedData);
// 				//ファイル名取得
// 				String fileName = filePath.getName();
//
// 				// File型をPath型に変換
// 				Path path = filePath.toPath();
 		
 		
 				//新しく作成したファイルの中に置換したデータを書き出す
 				PrintWriter pw = new PrintWriter(
 						new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8")));

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


