import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class SSample14_1 extends JFrame {

	JTextArea area;
	JTextField filemei;

	public static void main(String args[]) {
		SSample14_1 frame = new SSample14_1("タイトル");
		frame.setVisible(true);



	}

	SSample14_1(String title) {
		setTitle(title);
		setBounds(100, 500, 400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel(); // パネル作成

		area = new JTextArea();
		area.setLineWrap(true);
		JScrollPane scrollpane = new JScrollPane(area);
		scrollpane.setPreferredSize(new Dimension(200, 120));// テキストエリア

		p.add(scrollpane);

		JPanel bottomp = new JPanel();

		filemei= new JTextField(10);


		JButton button1 = new JButton("追加");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
								area.append(filemei.getText());

			}
		});


		JButton button3 = new JButton("ファイル作成");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				File newfile = new File("C:/aaa/test4.txt");
				// ファイルが存在するかどうかを判定
				if (newfile.exists()) {
					System.out.println("そのファイルは既に存在");
					return;
				}

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
		});
		JButton button4 = new JButton("ファイル削除");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				  if ( "test4".length() == 0 ) {
			            System.out.println( "パラメータが未指定" );
			            return;
			        }

			        // Fileクラスをインスタンス化
			        File deletefile = new File("C:/aaa/test4.txt");


				if ( !deletefile.exists() ) {
		            // ファイルが存在しない場合は処理終了
		            System.out.println( "ファイルが存在しない" );
		            return;
		        }

		        if ( deletefile.delete() ) {
		            System.out.println( "ファイルの削除に成功" );
		        }else{
		            System.out.println( "ファイルの削除に失敗" );
		        }

			}
		});
		JButton button5 = new JButton("コンソールに文字出力");
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				File file = new File("C:/aaa/test4.txt");

				// 指定されたパスがファイルかどうかを判定
				if (!file.isFile()) {
					// ディレクトリを指定した場合は処理終了
					System.out.println("ファイル以外を指定");
					return;
				}

				// ファイルが読み込み可能かどうかを判定
				if (!file.canRead()) {
					// ファイルが読み込み不可の場合は処理終了
					System.out.println("ファイルが読み込み不可");
					return;
				}

				try {
					List<String>lines
						=Files.readAllLines(Paths.get("C:/aaa/test4"+".txt"),
								StandardCharsets.UTF_8);
					for(String line:lines){
						System.out.println(line);
					}

				} catch (FileNotFoundException ex) {
					System.out.println(ex);
				} catch (IOException ex) {
					System.out.println(ex);
				}
			}



		});

		JButton button6 = new JButton("ディレクトリ作成");
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				 File newfile = new File("C:/aaa/temp3");

				    if (newfile.mkdirs()){
				      System.out.println("ディレクトリの作成に成功しました");
				    }else{
				      System.out.println("ディレクトリの作成に失敗しました");
				    }
				  }
		});
		JButton button7 = new JButton("テキストの文字表示");
		button7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String data="";
				try{
					//ファイルから読み込む仕組みを作成
					BufferedReader br =new BufferedReader(new FileReader
							("C:/aaa/test4"+".txt"));
					String temp="";
					while((temp=br.readLine())!=null){
						data+=temp+"\n";
					}
					br.close();
					area.setText(data);
				}
				catch(Exception ex){
					System.out.println("ファイルエラー");
				}

			}
		});
		JButton button8 = new JButton("テキストに保存");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try{
					BufferedWriter bw=new BufferedWriter(new FileWriter("C:/aaa/test4"+".txt"));
					bw.write(area.getText().replace("\n","\r\n"));
					bw.flush();
				bw.close();
				}
				catch(IOException ex){
					System.out.println("ファイルエラー");
				}


			}
		});


		bottomp.add(filemei);
		bottomp.add(button1);
		bottomp.add(button3);
		bottomp.add(button4);
		bottomp.add(button5);
		bottomp.add(button6);
		bottomp.add(button7);
		bottomp.add(button8);




		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.PAGE_START);
		contentPane.add(bottomp, BorderLayout.CENTER);
	}
}
