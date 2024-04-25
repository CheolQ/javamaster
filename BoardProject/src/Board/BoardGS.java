package Board;

public class BoardGS {

	
	// 게시판
	private int Brno;
	private String Brtitle;
	private String Brname;
	private String Brcontent;
	private String Brdate;
	
	
	public int getBrno() {
		return Brno;
	}
	public void setBrno(int brno) {
		Brno = brno;
	}
	public String getBrtitle() {
		return Brtitle;
	}
	public void setBrtitle(String brtitle) {
		Brtitle = brtitle;
	}
	public String getBrname() {
		return Brname;
	}
	public void setBrname(String brname) {
		Brname = brname;
	}
	public String getBrcontent() {
		return Brcontent;
	}
	public void setBrcontent(String brcontent) {
		Brcontent = brcontent;
	}
	public String getBrdate() {
		return Brdate;
	}
	public void setBrdate(String brdate) {
		Brdate = brdate;
	}
	
	@Override
	public String toString() {
		return String.format("%-4d %-6s %-5s %-20s %-4s", Brno, Brtitle, Brname, Brcontent, Brdate);
//		return String.format("%-4d %-6s %-5s %15s %s", Brno, Brtitle, Brname, Brcontent, Brdate);
	}
	public String showDetail() {
		return String.format("제목  : %-5s\n작성자 : %-5s\n내용  :%15s\n작성일 : %s", 
								Brtitle, Brname, Brcontent, Brdate);
	}
	
}
