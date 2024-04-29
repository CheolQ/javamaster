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
			System.out.println("╔══════════════════════════ °LOGIN° ════════════════════════════╗ ");
			System.out.println("║   1.Login    2.Sign up   3.Forgot ID   4.Forgot PW    5.End   ║ ");
			System.out.println("╚═══════════════════════════════════════════════════════════════╝ ");
			System.out.print("Choice ➤ ");
//			int login = Integer.parseInt(sc.nextLine());
			   int login = 0;
		         try {
		         login = Integer.parseInt(sc.nextLine());
		         }catch(NumberFormatException e) {
		            System.out.println("숫자 1~5번을 입력해주세요");
		         }
			switch (login) { // 로그인 switch

			case 1: // 게시판 로그인
				MemberGS user = new MemberGS();
				MemberDao mdao = new MemberDao();
				System.out.print("ID      : ");
				String id = sc.nextLine();


				System.out.print("Password: ");
				String pw = sc.nextLine();
				if(mdao.login(id, pw)) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.println("┃        　            Login Success. ╭◉␣◉╮                       ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					run2 = true;
				}else {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");	
					System.out.println("┃                     Login Failed ( ˙ỏ˙ )？╮    　  　            ┃");
					System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				run2 = false;
				}
//				user.setMempw(pw);
				System.out.println("");

				while (run2) { // 게시판 while문
					System.out.println("╔═══════════════════════════ MENU ══════════════════════════════╗");
					System.out.println("║   1.Write  2.List  3.View  4.Modify  5.Delete  6.Back  7.End  ║");
					System.out.println("╚═══════════════════════════════════════════════════════════════╝");
					System.out.print("선택>> ");
//					int menu = Integer.parseInt(sc.nextLine());
					int menu = 0;
					try {
				         menu = Integer.parseInt(sc.nextLine());
				         }catch(NumberFormatException e) {
				            System.out.println("숫자 1~7번을 입력해주세요");
				         }
					switch (menu) { // 게시판 switch문

					case 1: // 게시판 글 작성 기능
						System.out.println("╔═══════════════════════════════════════════════════════════════╗");
						System.out.println("║                          Writing                              ║");
						System.out.println("╚═══════════════════════════════════════════════════════════════╝");
						System.out.print("Title     >> ");
						String title = sc.nextLine();

						System.out.print("Writer    >> ");
						String name = sc.nextLine();

						System.out.print("Content   >> ");
						String content = sc.nextLine();

						BoardGS Board = new BoardGS();
						Board.setBrtitle(title);
						Board.setBrname(name);						
						Board.setBrcontent(content);

						if (dao.insertBoard(Board)) {
							System.out.println("╔═══════════════════════════════════════════════════════════════╗");
							System.out.println("║                       Write Success                           ║");
							System.out.println("╚═══════════════════════════════════════════════════════════════╝");
							System.out.println("");
						} else {
							System.out.println("╔═══════════════════════════════════════════════════════════════╗");
							System.out.println("║                      Writeing Fail ` ̗̀(ꀬ⏖ꀬ∴)              　   ║");
						    System.out.println("╚═══════════════════════════════════════════════════════════════╝");
							System.out.println("");
						}
						break;

					case 2: // 게시판 목록보기 기능
						List<BoardGS> Boards = dao.BoardList();
						System.out.println("");
						System.out.println("╔═══════════════════════════════════════════════════════════════╗");
						System.out.println("║                            List                               ║");
						System.out.println("╚═══════════════════════════════════════════════════════════════╝");

						// 타이틀.
						System.out.println("┏━━━━┳━━━━━━━━┳━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┓");
						System.out.println("┃ No ┃ Writer ┃  Title   ┃     Content      ┃       time         ┃");
						System.out.println("┣━━━━╋━━━━━━━━╋━━━━━━━━━━╋━━━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━━━━━━┫");
						for (BoardGS Board1 : Boards) {
							System.out.println(Board1.toString());
						}
					    System.out.println("┗━━━━┻━━━━━━━━┻━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┛");
					    System.out.println("");
						break;

					case 3: // 게시판 상세보기

						System.out.print("보고 싶은 게시판 번호를 선택하세요 >> ");
						int boardnum = Integer.parseInt(sc.nextLine());
						System.out.println(dao.showDetail(boardnum));
						System.out.println("");

						break;

					case 4: // 게시판 글 수정
						System.out.println("╔═══════════════════════════════════════════════════════════════╗");
						System.out.println("║                            Modify                             ║");
						System.out.println("╚═══════════════════════════════════════════════════════════════╝");
						System.out.print("수정하실 게시판 번호를 선택하세요 >> ");
						int eno = Integer.parseInt(sc.nextLine());

						System.out.print("Title     >> ");
						title = sc.nextLine();

						System.out.print("Writer    >> ");
						name = sc.nextLine();

						System.out.print("Content   >> ");
						content = sc.nextLine();

						Board = new BoardGS();
						Board.setBrno(eno);
						Board.setBrtitle(title);
						Board.setBrname(name);
						Board.setBrcontent(content);

						if (dao.updateBoard(Board)) {
							System.out.println("Modify Complete");
							System.out.println("");
						} else {
							System.out.println("Error");
							System.out.println("");
						}

						break;

					case 5: // 게시판 글 삭제 기능
						System.out.println("╔═══════════════════════════════════════════════════════════════╗");
						System.out.println("║                            Delete                             ║");
						System.out.println("╚═══════════════════════════════════════════════════════════════╝");
						System.out.print("Delete Number >> ");
						eno = Integer.parseInt(sc.nextLine());

						if (dao.deleteBoard(eno)) {
							System.out.println("╔═══════════════════════════════════════════════════════════════╗");
							System.out.println("║                       Delete Success                          ║");
							System.out.println("╚═══════════════════════════════════════════════════════════════╝");
							System.out.println("");
						} else {
							System.out.println("╔═══════════════════════════════════════════════════════════════╗");
							System.out.println("║                        Delete Fail                            ║");
							System.out.println("╚═══════════════════════════════════════════════════════════════╝");
							System.out.println("");
						}

						break;

						
					case 6:
						System.out.println("╔═══════════════════════════════════════════════════════════════╗");
						System.out.println("║                        Login Return                           ║");
						System.out.println("╚═══════════════════════════════════════════════════════════════╝");
						System.out.println("");
						run2 = false;	// 게시판화면만 종료하기
						
						break;
					
					case 7:
						System.out.println("");
						System.out.println(".　　　　　  ,-､　　　 　 　 　　        　..-､");
						System.out.println("　　　　 ./:::::＼　　　　 　 　       ／:::::ヽ");
						System.out.println("　　　　/::::::::::::;ゝ--──-- ､._/::::::::::ヽ");
						System.out.println("　　　 /,.-‐''\"′ 　　　　　　　    　 ＼::::::::|");
						System.out.println("　　 ／　 　　　　　　　　　　　                ヽ､::|");
						System.out.println("　  /　　  　　●　　　 　 　 　 　          　 　 ヽ|");
						System.out.println("  |　　        　､､､　　 　 　 　 　 　 ●　　    　 |");
						System.out.println(" .|　　　 　　　　       (_人__丿　　  ､､､　 　    /");
						System.out.println("  |　　　　　　　　　             　　　　　　　 　/");
						System.out.println("　 `､　　　　　　　　 　 　 　　 　           　 /");
						System.out.println("　　　`ｰ ､__　　　 　 　 　END         　　 .／");
						System.out.println("　　　　  　　/`'''ｰ‐‐──‐─‐──‐┬---------／");
						
						run2 = false;
						run = false;  // (게시판을 종료하면 로그인화면도 종료 해줘야함)
						
						break;
							
					}// 게시판 switch
				} // 게시판 while 문
				
				break;			// 브레이크도 2개인 이유가 두번 종료해야하기 때문인거같음
				
				
				
			case 2: // 회원가입					회원가입						회원가입
				System.out.print("ID             : ");
				String id2 = sc.nextLine();

				System.out.print("Password       : ");
				String pw2 = sc.nextLine();

				System.out.print("Name           : ");
				String name = sc.nextLine();

				System.out.print("Date Of Birth  : ");
				int birth = Integer.parseInt(sc.nextLine());

			MemberGS members = new MemberGS();
			members.setMemid(id2);
			members.setMempw(pw2);
			members.setMemname(name);
			members.setMembirth(birth);

			if(dao1.Members(members)){
				System.out.println("╔═══════════════════════════════════════════════════════════════╗");
				System.out.println("║                       Sign Success ᴖ ᴈ ᴖ                      ║");
				System.out.println("╚═══════════════════════════════════════════════════════════════╝");
				System.out.println("");
				System.out.println("");
			} else {

				System.out.println("╔═══════════════════════════════════════════════════════════════╗");
				System.out.println("║                　      Sign Fail  ̗̀(ꀬ⏖ꀬ∴)                      ║");
				System.out.println("╚═══════════════════════════════════════════════════════════════╝");
				System.out.println("");
			}
			break;

			
			case 3:		// 아이디 찾기					아이디 찾기					아이디 찾기
				MemberGS idfind = new MemberGS();

				System.out.println("╔═══════════════════════════════════════════════════════════════╗");
				System.out.println("║                           Find ID                             ║");
				System.out.println("╚═══════════════════════════════════════════════════════════════╝");
				System.out.print("Name           : ");
				String name3 = sc.nextLine();

				System.out.print("Date Of Birth  : ");
				int birth3 = Integer.parseInt(sc.nextLine());

				System.out.println("------------------------ Loding... ---------------------------");
				System.out.print("ヾ(＾∇＾) Your ID ▶ ");
				
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
				System.out.print("ID             : ");
				String id4 = sc.nextLine();

				System.out.print("Name           : ");
				String name4 = sc.nextLine();

				System.out.print("Date Of Birth  : ");
				int birth4 = Integer.parseInt(sc.nextLine());

				System.out.println("------------------------ Loding.... --------------------------");
				System.out.print("/ᐠ｡ꞈ｡ᐟ\\\\ Your PW ▶ ");
		
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
				System.out.println(".　　　　　  ,-､　　　 　 　 　　        　..-､");
				System.out.println("　　　　 ./:::::＼　　　　 　 　       ／:::::ヽ");
				System.out.println("　　　　/::::::::::::;ゝ--──-- ､._/::::::::::ヽ");
				System.out.println("　　　 /,.-‐''\"′ 　　　　　　　    　 ＼::::::::|");
				System.out.println("　　 ／　 　　　　　　　　　　　                ヽ､::|");
				System.out.println("　  /　　  　　●　　　 　 　 　 　          　 　 ヽ|");
				System.out.println("  |　　        　､､､　　 　 　 　 　 　 ●　　    　 |");
				System.out.println(" .|　　　 　　　　       (_人__丿　　  ､､､　 　    /");
				System.out.println("  |　　　　　　　　　             　　　　　　　 　/");
				System.out.println("　 `､　　　　　　　　 　 　 　　 　           　 /");
				System.out.println("　　　`ｰ ､__　　　 　 　 　END         　　 .／");
				System.out.println("　　　　  　　/`'''ｰ‐‐──‐─‐──‐┬---------／");

				run = false;

			}// 로그인 switch

		} // 로그인 while

	}// end
}

