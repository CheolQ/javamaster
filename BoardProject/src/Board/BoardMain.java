package Board;

import java.util.List;
import java.util.Scanner;

import Board.BoardDao;
import co.yedam.Employee;


public class BoardMain {
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	boolean run = true;
	boolean run2 = true;
	BoardDao boarddao= new BoardDao();
	
	while(run) {
			System.out.println("======================= Login ==========================");
			System.out.println(" 1.로그인    2.회원가입    3.아이디찾기    4.비밀번호찾기    5.종료");
			System.out.println("========================================================");
			System.out.print("선택>> ");
		int login = Integer.parseInt(sc.nextLine());

		
		
		switch(login) {
		
		case 1 :
			
			System.out.print("ID      : ");
			String id = sc.nextLine();
			
			System.out.print("Password: ");
			String pw = sc.nextLine();
			System.out.println("----------------- 로그인 성공하였습니다 ╭◉␣◉╮ -----------------");
			System.out.println("");
			
			while(run2) {
			System.out.println("======================== MENU ==========================");
			System.out.println(" 1.글작성   2.목록보기   3.상세보기  4.수정하기   5.삭제하기   6.종료 ");
			System.out.println("========================================================");
			System.out.print("선택>> ");
				int menu = Integer.parseInt(sc.nextLine());
				
		switch(menu) {
		
		case 1 :
			System.out.println("------------------------ 글작성 ---------------------------");		
			System.out.print("제목   >> ");	
			String title = sc.nextLine();
			
			System.out.print("작성자  >> ");	
			String name = sc.nextLine();
			
			System.out.print("내용   >> ");	
			String content = sc.nextLine();
			
			
			BoardGS Board = new BoardGS();
			Board.setBrtitle(title);
			Board.setBrname(name);
			Board.setBrcontent(content);


			if(boarddao.insertBoard(Board)){
				System.out.println("------------------ 작성이 완료되었습니다 ᴖ ᴈ ᴖ -------=---------");
			} else {
				System.out.println("----------------- 작성 실패했어요 ̗̀(ꀬ⏖ꀬ∴) ---------------------");
			}
			break;
			
		case 2 :	
			List<BoardDao> Boards = Board;
			System.out.println("----------------------- 게시판 목록 -------------------------");
			System.out.println("----------------------------------------------------------");
			
			// 타이틀.
			System.out.println("번호 |        제목        | 작성자   |      작성시간     ");
			System.out.println("-----------------------------------------------------------");
			for(BoardDao Board1 : Boards) {
				System.out.println(Board1.toString());
			}
			break;
			
		case 3 :
			
			
		case 4 :	
			
			
		case 5 :	
			
			
				}// 게시판 switch
			}// 게시판 while 문
			
			
			
		
		case 2 :
			System.out.print("사용하실 ID를 입력하세요 : ");
			String lid = sc.nextLine();
			
			System.out.print("사용하실 PW를 입력하세요 : ");
			String lpw = sc.nextLine();
			
			System.out.print("이름을 입력하세요       : ");
			String name = sc.nextLine();
			
			System.out.print("생년월일을 입력하세요    : ");
			int birth = Integer.parseInt(sc.nextLine());
			break;
		
		case 3 :
			System.out.println("-------------------- 아이디찾기 -------------------------");
			System.out.print("이름을 입력하세요     : ");
			String name3 = sc.nextLine();
			
			System.out.print("생년월일을 입력하세요  : ");
			int birth3 = Integer.parseInt(sc.nextLine());
			
			System.out.println("-------------------- Loding... -----------------------");
			System.out.println("찾으시는 아이디는 /ᐠ｡ꞈ｡ᐟ\\ ▶ ");
			break;
		
		case 4 :
			System.out.print("ID를 입력하세요     : ");
			String id4 = sc.nextLine();
			
			System.out.print("이름을 입력하세요     : ");
			String name4 = sc.nextLine();
			
			System.out.print("생년월일을 입력하세요  : ");
			int birth4 = Integer.parseInt(sc.nextLine());
			
			System.out.println("-------------------- Loding.... ----------------------");
			System.out.println("찾으시는 비밀번호는 /ᐠ｡ꞈ｡ᐟ\\ ▶ ");
			break;
		
		case 5 :
			System.out.println("--------------- 로그인 페이지 종료 (ᴗ˳ᴗ) ------------------");
			run = false;
			
		}// 로그인 switch
		
		}// 로그인 while
	

}//end
}
