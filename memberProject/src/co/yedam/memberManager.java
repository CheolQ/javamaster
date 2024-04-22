package co.yedam;

import java.util.Scanner;

public class memberManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.회원목록 2.회원등록 3.정보수정 4.정보삭제 5.종료.");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			
			case 1:
				System.out.println("회원번호  회원명     회원연락처    회원생일    성별");
				System.out.println("----------------------------------------");
				
				break;
			case 2:
				System.out.print("회원명>> ");
				String name = sc.nextLine();
				
				System.out.print("연락처>> ");
				String phone = sc.nextLine();
				
				System.out.print("생일>> ");
				String birth = sc.nextLine();
				
				System.out.print("성별>> ");
				String gen = sc.nextLine();
				
			case 3:
				System.out.print("수정 할 회원번호>> ");
				int change = Integer.parseInt(sc.nextLine());
				
				System.out.println("연락처>> ");
				phone = sc.nextLine();
				
				
			case 4:
				System.out.println("삭제 할 회원번호>> ");
				change = Integer.parseInt(sc.nextLine());
				System.out.println("정상처리");
				
				
				
			case 5:
				System.out.println("종료...");
				run = false;
			}
		}
			System.out.println("End Of Program");
	}//end
}
