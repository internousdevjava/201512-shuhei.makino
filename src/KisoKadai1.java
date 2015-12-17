
import java.util.InputMismatchException;
import java.util.Scanner;

public class KisoKadai1 {

	public static void main(String args[]) {
		while (true) {
			System.out.println("九九の表");
			System.out.println("たての数入力");

			int x = new Scanner(System.in).nextInt();

			try {

				while (true) {

					if (x == 0) {
						System.out.println("0はダメです。");
						x = new Scanner(System.in).nextInt();
						continue;
					} else if (x > 100) {
						System.out.println("100より上はダメです,100以下を入力してください。");
						x = new Scanner(System.in).nextInt();
						continue;
					} else {
						break;
					}
				}

				System.out.println("横の数入力");
				int y = new Scanner(System.in).nextInt();

				while (true) {

					if (y == 0) {
						System.out.println("0はダメです。");
						y = new Scanner(System.in).nextInt();
						continue;
					} else if (y > 99) {
						System.out.println("100より上はダメです,100以下を入力してください。");
						y = new Scanner(System.in).nextInt();
						continue;
					} else {
						break;
					}

				}

				int kuku[][] = new int[100][100];

				for (int i = 0; i < x; i++) {
					for (int j = 0; j < y; j++) {
						kuku[i][j] = (i + 1) * (j + 1);
					}
				}
				for (int i = 0; i < x; i++) {
					for (int j = 0; j < y; j++) {
						System.out.print(kuku[i][j] + " ");
					}
					System.out.println();
				}

				break;
			}

			catch (

			InputMismatchException e)

			{
				System.out.println("型が違います。最初から数字を入れてください。");
			}
		}
	}
}
