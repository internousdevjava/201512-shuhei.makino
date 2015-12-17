import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class KisoKadai2 {

	public static void main(String[] args) {
		Random rnd = new Random();
		int ran = rnd.nextInt(100);
		System.out.println("数当てゲーム");
		System.out.println(ran);
		System.out.println("整数を入力してください。");
		int x = new Scanner(System.in).nextInt();
		while (true) {
			try {

				if (x > 100) {
					System.out.println("100以上はダメです。");
					x =  new Scanner(System.in).nextInt();
					continue;
				} else if (x == 0) {
					System.out.println("0はダメです。");
					x = new Scanner(System.in).nextInt();
					continue;
				} else if (x > ran) {
					System.out.println("入力値より小さいです。もう一回!!");
					x = new Scanner(System.in).nextInt();
					continue;
				} else if (x < ran) {
					System.out.println("入力値より大きいです。もう一回!!");
					x = new Scanner(System.in).nextInt();
					continue;
				} else {
					System.out.println("おめでとう");
					break;
				}

			}

			catch (

			InputMismatchException e)

			{
				System.out.println("型が違います。最初から数字を入れてください。");
				x = new Scanner(System.in).nextInt();
			}
		}

	}

}
