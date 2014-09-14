package homework;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		
		//Scanner클래스를 가지고 만들어진 객체의 레퍼런스를 담을 수 있는
		//변수 scan을 선언
		Scanner scan;
				
		//new라는 키워드를 통해서 heap메모리공간의 영역을 할당받고
		//Scanner()생성자를 호출하여 Scanner객체를 생성 후 레퍼런스를 
		//scan변수에 대입
		scan = new Scanner(System.in);
				
		//유저에게 단을 입력하세요라고 출력
		System.out.println("단을 입력하세요 ^.~");
				
		//유저에게 구구단(2~9)까지를 입력받아서 
		//num변수에 대입
				
		int num;
				
		num = scan.nextInt();
				
		//유저에게 입력받은 num에 대한 구구단 결과를 출력
		for (int i = 1; i < 10 ; i++) {
			System.out.println(num + " * " + i + " = " + (num*i));
		} //for() end
				
	}//main() end
	
}//Ex1 end
