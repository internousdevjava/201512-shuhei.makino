import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class KisoKadai3 {

	public static void main(String[] args) throws IOException {
		while (true) {
			System.out.println("--開始--");
			System.out.println("ファイル,フォルダ関連は1. 読み込みは2. 書き込みは3.作業を終了します。9.");
			String str;
			String file_name;
			String file_kizonn;
			String folder_name;
			String write;
			int n = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			str = br.readLine();
			if (str.matches("^[0-9]*$")) {
				n = Integer.parseInt(str);
			} else {
				System.out.println("半角数字で入力して下さい");
			}
			// ①－①ファイル作成
			if (n == 1) {
				while (true) {

					int n1 = 0;
					System.out.println("選択してください, 1.ファイル作成 2.ファイル削除 3.フォルダ作成 4.フォルダ削除" + " 5.メニューに戻る");
					BufferedReader br01 = new BufferedReader(new InputStreamReader(System.in));
					str = br01.readLine();
					if (str.matches("^[0-9]*$")) {
						n1 = Integer.parseInt(str);
					} else {
						System.out.println("半角数字で入力して下さい");
					}
					// メニュー選択11

					if (n1 == 1) {
						System.out.println("新しいファイル名を書いてください。");
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						file_name = br1.readLine();
						File newfile = new File(file_name + ".txt");
						// ファイルが存在するかどうかを判定
						try {
							if (newfile.exists()) {
								System.out.println("そのファイルは既に存在");
								continue;
							} else {
								System.out.println("ファイルを作成します。" + newfile.getAbsolutePath());
								try {
									if (newfile.createNewFile()) {
										// ファイルの作成に成功
										String path = newfile.getPath();
										System.out.println(path + "を作成");
									} else {
										// ファイルの作成に失敗
										System.out.println("ファイルの作成に失敗");
									}

								} catch (IOException e) {
									// 例外処理
									System.out.println(e);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						continue;
					}

					// ①-②ファイル削除
					else if (n1 == 2) {
						System.out.println("削除するファイル名を書いてください。");
						BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
						file_name = br2.readLine();
						if ("file_name".length() == 0) {
							System.out.println("パラメータが未指定");

						}

						// Fileクラスをインスタンス化
						File deletefile = new File(file_name + ".txt");

						if (!deletefile.exists()) {
							// ファイルが存在しない場合は処理終了
							System.out.println("ファイルが存在しない");
							continue;
						}

						if (deletefile.delete()) {
							System.out.println("ファイルの削除に成功");
							continue;
						} else {
							System.out.println("ファイルの削除に失敗");
							continue;
						}
					}

					// ①-③フォルダ作成

					else if (n1 == 3) {
						System.out.println("新しいフォルダー名を書いてください。");
						BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
						folder_name = br3.readLine();
						File newfile = new File(folder_name);
						// ファイルが存在するかどうかを判定
						try {
							if (newfile.exists()) {
								System.out.println("そのフォルダーは既に存在");
								continue;
							} else {
								System.out.println("フォルダーを作成します。" + newfile.getAbsolutePath());

								try {
									if (newfile.createNewFile()) {
										// ファイルの作成に成功
										String path = newfile.getPath();
										System.out.println(path + "を作成");
									} else {
										// ファイルの作成に失敗
										System.out.println("フォルダーの作成に失敗");
									}

								} catch (IOException e) {
									// 例外処理
									System.out.println(e);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						continue;
					}
					// ①-④フォルダ削除
					else if (n1 == 4) {
						System.out.println("削除するフォルダ名を書いてください。");
						BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
						folder_name = br4.readLine();
						if ("folder_name".length() == 0) {
							System.out.println("パラメータが未指定");
							return;
						}

						// Fileクラスをインスタンス化
						File deletefile = new File(folder_name);

						if (!deletefile.exists()) {
							// ファイルが存在しない場合は処理終了
							System.out.println("フォルダが存在しない");
							continue;
						}

						if (deletefile.delete()) {
							System.out.println("フォルダの削除に成功");
							continue;
						} else {
							System.out.println("フォルダの削除に失敗");
							continue;
						}
					} else if (n1 == 5) {
						System.out.println("開始に戻ります。");
						break;
					} else {
						System.out.println("選択し以外の数字は入れないでください");
						continue;
					}

				}
				continue;
			}
			// ②読み込み
			else if (n == 2) {
				while (true) {
					int n2 = 0;
					System.out.println("選択してください, 1.読み込み 2.メニューに戻る。");
					BufferedReader br01 = new BufferedReader(new InputStreamReader(System.in));
					str = br01.readLine();
					if (str.matches("^[0-9]*$")) {
						n2 = Integer.parseInt(str);
					} else {
						System.out.println("半角数字で入力して下さい");
					}
					if (n2 == 1) {
						System.out.println("読み込むためのファイル名を書いてください。");
						BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
						file_kizonn = br5.readLine();
						File file2 = new File(file_kizonn + ".txt");
						if (("0".equals(file_kizonn+".txt"))) {
							continue;
						} // ファイル・ディレクトリの判別
						if (!file2.exists()) {
							System.out.println("ファイルが見つかりません");
							continue;
						}

						else if (!file2.isFile()) {
							// ディレクトリを指定した場合は処理終了
							System.out.println("ファイル以外を指定");
							continue;
						}

						// ファイルが読み込み可能かどうかを判定
						else if (!file2.canRead()) {
							// ファイルが読み込み不可の場合は処理終了
							System.out.println("ファイルが読み込み不可");
							continue;
						}

						try {
							List<String> lines = Files.readAllLines(Paths.get(file_kizonn + ".txt"),
									StandardCharsets.UTF_8);
							for (String line : lines) {
								System.out.println(line);
							}

						} catch (FileNotFoundException e) {
							System.out.println(e);

						}

					}

					else if (n == 2) {
						break;
					}

				}
			}

			// ③書き込み
			else if(n==3){
				System.out.println("書き込むファイル名を指定して下さい,[0]:メニューに戻る");
				try{
					BufferedReader br02=new BufferedReader(new InputStreamReader(System.in));
					file_name=br02.readLine();
					if(("0".equals(file_name + ".txt"))){
						continue;
						}//ファイル・ディレクトリの判別
					File file = new File(file_name + ".txt");
					if(!file.exists()){
						System.out.println("ファイルが見つかりません");
						continue;
					}if (file.isDirectory()) {
						System.out.println("ファイルでなく、ディレクトリが選択されています。");
						continue;
					}
					System.out.println(file_name+".txt"+"に書き込みます。");
					System.out.println("1.上書き,2.追記,3.メニューに戻る");
					BufferedReader br6=new BufferedReader(new InputStreamReader(System.in));
					str=br6.readLine();
					int num=0;
					if(("0".equals(str))){
						continue;
						};
					if(str.matches("^[0-9]*$")){
						num=Integer.parseInt(str);
					}else{
						System.out.println("半角数字で入力して下さい");
					}
					//上書き処理
					if(num==1){
						try{
							System.out.println("書き込む内容を入力して下さい,[0]:メニューに戻る");
							PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file,false)));
							BufferedReader br7=new BufferedReader(new InputStreamReader(System.in));
							write=br7.readLine();
							if("0".equals(write)){
								continue;
							}
							pw.println(write);
							pw.close();
							System.out.println("上書きが完了しました");
						}catch (IOException e) {
							System.out.println(e);//例外エラー
						}
						//追記処理
					}else if(num==2){
						try{
							System.out.println("書き込む内容を入力して下さい,[0]:メニューに戻る");
							PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
							BufferedReader br7=new BufferedReader(new InputStreamReader(System.in));
							write=br7.readLine();
							if("0".equals(write)){
								continue;
							}
							pw.println(write);
							pw.close();
							System.out.println("追記が完了しました");
						}catch (IOException e) {
							System.out.println(e);//例外エラー
						}
					}else{
						System.out.println("メニューに表示されている数値から選択して下さい");
						continue;
					}
				} catch (IOException e) {
				System.out.println(e);
				}
			}

			else if (n == 9) {
				System.out.println("作業を終了します");
				System.out.println("ありがとうございました");
				break;
			} else {
				System.out.println("メニューに表示されている数値から選択して下さい");
				continue;
			}
		}

	}
}
