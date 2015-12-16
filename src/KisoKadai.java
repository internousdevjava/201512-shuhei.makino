
import java.util.InputMismatchException;
import java.util.Scanner;

public class KisoKadai {


	public static void main(String args[]){

		System.out.println("九九の表");
		Scanner scan=new Scanner(System.in);
		try {
			int x =scan.nextInt();
			int y=scan.nextInt();
			int kuku[][]=new int[x][y];

			for(int i=0; i<x; i++){
				for(int j=0; j<y; j++){
					kuku[i][j]=(i+1)*(j+1);
				}
			}
			for(int i=0; i<x; i++){
				for(int j=0; j<y; j++){
					System.out.print(kuku[i][j]+" ");
				}
				System.out.println();
			}

		} catch (InputMismatchException e){
			System.out.println("型が違います:"+e);
		}

	}

}

