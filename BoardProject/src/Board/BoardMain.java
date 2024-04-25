package Board;

import java.util.List;
import java.util.Scanner;

import Board.BoardDao;

import java.awt.Menu;
import java.util.*;

public class BoardMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		boolean run2 = true;	
		BoardDao dao = new BoardDao();
		MemberDao dao1 = new MemberDao();

		while (run) { // 로그인 while문
			System.out.println("=========================== Login ============================");
			System.out.println("   1.로그인     2.회원가입     3.아이디찾기     4.비밀번호찾기     5.종료");
			System.out.println("==============================================================");
			System.out.print("선택>> ");
			int login = Integer.parseInt(sc.nextLine());

			switch (login) { // 로그인 switch

			case 1: // 게시판 로그인
				MemberGS user = new MemberGS();
				MemberDao mdao = new MemberDao();
				System.out.print("ID      : ");
				String id = sc.nextLine();


				System.out.print("Password: ");
				String pw = sc.nextLine();
				if(mdao.login(id, pw)) {
					System.out.println("-------------------- 로그인 성공하였습니다 ╭◉␣◉╮ --------------------");
					run2 = true;
				}else {
					System.out.println("-------------------- 로그인 실패하였습니다 ╭◉␣◉╮ --------------------");
				run2 = false;
				}
//				user.setMempw(pw);
				System.out.println("");

				while (run2) { // 게시판 while문
					System.out.println("=========================== MENU =============================");
					System.out.println(" 1.글작성  2.목록보기  3.상세보기  4.수정하기  5.삭제하기  6.뒤로가기  7.종료 ");
					System.out.println("==============================================================");
					System.out.print("선택>> ");
					int menu = Integer.parseInt(sc.nextLine());

					switch (menu) { // 게시판 switch문

					case 1: // 게시판 글 작성 기능
						System.out.println("--------------------------- 글작성 ------------------------------");
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

						if (dao.insertBoard(Board)) {
							System.out.println("--------------------- 작성이 완료되었습니다 ᴖ ᴈ ᴖ -------------------");
							System.out.println("");
						} else {
							System.out.println("--------------------- 작성 실패했어요 ̗̀(ꀬ⏖ꀬ∴) ---------------------");
							System.out.println("");
						}
						break;

					case 2: // 게시판 목록보기 기능
						List<BoardGS> Boards = dao.BoardList();
						System.out.println("------------------------- 게시판 목록 ---------------------------");
						System.out.println("--------------------------------------------------------------");

						// 타이틀.
						System.out.println("번호 |  제목  | 작성자 |      내용             |       작성시간     ");
						System.out.println("--------------------------------------------------------------");
						for (BoardGS Board1 : Boards) {
							System.out.println(Board1.toString());
						}
					    System.out.println("--------------------------------------------------------------");
					    System.out.println("");
						break;

					case 3: // 게시판 상세보기

						System.out.print("보고 싶은 게시판 번호를 선택하세요 >> ");
						int boardnum = Integer.parseInt(sc.nextLine());
						System.out.println(dao.showDetail(boardnum));
						System.out.println("");

						break;

					case 4: // 게시판 글 수정
						System.out.println("-------------------------- 게시판 수정 ---------------------------");
						System.out.print("수정하실 게시판 번호를 선택하세요 >> ");
						int eno = Integer.parseInt(sc.nextLine());

						System.out.print("제목   >> ");
						title = sc.nextLine();

						System.out.print("작성자  >> ");
						name = sc.nextLine();

						System.out.print("내용   >> ");
						content = sc.nextLine();

						Board = new BoardGS();
						Board.setBrno(eno);
						Board.setBrtitle(title);
						Board.setBrname(name);
						Board.setBrcontent(content);

						if (dao.updateBoard(Board)) {
							System.out.println("게시판 수정 완료.");
							System.out.println("");
						} else {
							System.out.println("수정 오류입니다.");
							System.out.println("");
						}

						break;

					case 5: // 게시판 글 삭제 기능
						System.out.println("------------------------- 게시판 삭제 --------------------------");
						System.out.print("삭제하실 게시판 번호를 선택하세요 >> ");
						eno = Integer.parseInt(sc.nextLine());

						if (dao.deleteBoard(eno)) {
							System.out.println("------------------- 글이 삭제 되었습니다 ( •̅_•̅ ) -------------------");
							System.out.println("");
						} else {
							System.out.println("-------------------------- 삭제 실패 ----------------------------");
							System.out.println("");
						}

						break;

						
					case 6:
						System.out.println("-------------------- 로그인화면으로 되돌아갑니다 ---------------------");
						System.out.println("");
						run2 = false;	// 게시판화면만 종료하기
						
						break;
						
					case 7:
						System.out.println("");
						System.out.println("------------------- 게시판 프로그램 종료 (ᐡᴗ ̫ ᴗᐡ) -------------------");
						
						run2 = false;
						run = false;  // (게시판을 종료하면 로그인화면도 종료 해줘야함)
						
						break;
							
					}// 게시판 switch
				} // 게시판 while 문
				
				break;			// 브레이크도 2개인 이유가 두번 종료해야하기 때문인거같음
				
				
				
			case 2: // 회원가입					회원가입						회원가입
				System.out.print("사용하실 ID를 입력하세요 : ");
				String id2 = sc.nextLine();

				System.out.print("사용하실 PW를 입력하세요 : ");
				String pw2 = sc.nextLine();

				System.out.print("이름을 입력하세요       : ");
				String name = sc.nextLine();

				System.out.print("생년월일을 입력하세요    : ");
				int birth = Integer.parseInt(sc.nextLine());

			MemberGS members = new MemberGS();
			members.setMemid(id2);
			members.setMempw(pw2);
			members.setMemname(name);
			members.setMembirth(birth);

			if(dao1.Members(members)){
				System.out.println("----------------------- 회원가입 완료 ᴖ ᴈ ᴖ ----------------------");
				System.out.println("");
			} else {
				System.out.println("------------------- 회원가입 실패했어요 ̗̀(ꀬ⏖ꀬ∴) --------------------");
				System.out.println("");
			}
			break;

			
			case 3:		// 아이디 찾기					아이디 찾기					아이디 찾기
				MemberGS idfind = new MemberGS();

				System.out.println("------------------------ 아이디찾기 -----------------------------");
				System.out.print("이름을 입력하세요     : ");
				String name3 = sc.nextLine();

				System.out.print("생년월일을 입력하세요  : ");
				int birth3 = Integer.parseInt(sc.nextLine());

				System.out.println("------------------------ Loding... ---------------------------");
				System.out.print("ヾ(＾∇＾) 찾으시는 아이디는 ▶ ");
				
				MemberGS findid = new MemberGS();
				idfind.setMemname(name3);
				idfind.setMembirth(birth3);
				
				List<MemberGS> findList = dao1.idfind(idfind);
				for(MemberGS mem : findList) {
					System.out.println(mem.toFindID());
				}
				System.out.println("");
				break;

			case 4:
				MemberGS pwfind = new MemberGS();
				System.out.print("ID를 입력하세요     : ");
				String id4 = sc.nextLine();

				System.out.print("이름을 입력하세요     : ");
				String name4 = sc.nextLine();

				System.out.print("생년월일을 입력하세요  : ");
				int birth4 = Integer.parseInt(sc.nextLine());

				System.out.println("------------------------ Loding.... --------------------------");
				System.out.print("/ᐠ｡ꞈ｡ᐟ\\\\ 찾으시는 비밀번호는 ▶ ");
		
				MemberGS findpw = new MemberGS();
				pwfind.setMemid(id4);
				pwfind.setMemname(name4);
				pwfind.setMembirth(birth4);
				
				List<MemberGS> findList1 = dao1.pwfind(pwfind);
				for(MemberGS mem : findList1) {
					System.out.println(mem.toFindPW());
				}
				System.out.println("");
				
				break;

			case 5:
				System.out.println("------------------ 로그인 페이지 종료 (ᴗ˳ᴗ) ---------------------");
				run = false;

			}// 로그인 switch

		} // 로그인 while

	}// end
}
