package Board;

import java.sql.Date;

public class MemberGS { 


	// 회원가입
	private String Memid;
	private String Mempw;
	private String Memname;
	private int Membirth;
	
	
	
	public String getMemid() {
		return Memid;
	}
	
	public void setMemid(String memid) {
		Memid = memid;
	}
	public String getMempw() {
		return Mempw;
	}
	public void setMempw(String mempw) {
		Mempw = mempw;
	}
	public String getMemname() {
		return Memname;
	}
	public void setMemname(String memname) {
		Memname = memname;
	}
	public int getMembirth() {
		return Membirth;
	}
	public void setMembirth(int membirth) {
		Membirth = membirth;
	}
	
	public String toFindID() {
		return String.format("%-10s",Memid);
	}

	public String toFindPW() {
		return String.format("%-10s",Mempw);
	}


	@Override
	public String toString() {
		return "MemberGS [Memid=" + Memid + ", Mempw=" + Mempw + ", Memname=" + Memname + ", Membirth=" + Membirth
				+ "]";
	}
	

	
	
	
	


	
	
	
	
	
	
}//end
