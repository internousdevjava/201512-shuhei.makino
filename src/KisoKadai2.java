import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class KisoKadai2 {

	public static void main(String[] args) {
		Random rnd =new Random();
		int y = rnd.nextInt(100);
		System.out.print(y);
		while(true){
			Scanner scan=new Scanner(System.in);
			int x=0;
			try {
				while(x!=y){
					x =scan.nextInt();
				if(x>100){
					System.out.println("100まででお願いします。");
					}
				else{
					System.out.println("残念・・");
				}
				}
				System.out.println("おめでとう！！");
				break;
			}


			catch (InputMismatchException e){
				System.out.println("数字を入れてね！！"+e);
		}
	}


	}
}







