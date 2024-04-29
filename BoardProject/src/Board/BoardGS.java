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
		
		String gaptitle = Brtitle, gapname=Brname, gapcon = Brcontent;
		
//		if(Brname.length()<10) {	//이름 크기 제한
//			for(int i=0; i<9-Brname.length(); i++)
//			{gapname = " ";}
//		} else {gapname = Brname.substring(0,9)+" ";}
		
		if(Brtitle.length()<7) {	//제목 크기 제한
			for(int i=0; i<7-Brtitle.length(); i++)
			{gaptitle+= " ";}
		} else {gaptitle = Brtitle.substring(0,6)+"..";}
		
		if(Brcontent.length()<14) {	//내용 크기 제한
			for(int i=0; i<14-Brcontent.length(); i++)
			{gapcon+= " ";}
		} else {gapcon = Brcontent.substring(0,9)+"...";}
		
		return String.format("┃ %-3d┃  %-4s ┃ %-3s ┃ %4s ┃ %s ┃", Brno, Brname, gaptitle, gapcon, Brdate);
//		return String.format("%-4d %-6s %-5s %15s %s", Brno, Brtitle, Brname, Brcontent, Brdate);
	}
	public String showDetail() {
		return String.format("Title   : %-5s\nWriter  : %-5s\nContent : %5s\nTime    : %s", 
								Brtitle, Brname, Brcontent, Brdate);
	}
	
}
