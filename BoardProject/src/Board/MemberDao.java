package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	// 로그인					로그인					로그인
	public boolean login(String logid, String logpw) {
		getConn();
		String sql = "select mem_id, mem_pw from mem where mem_id = ?" + "and mem_pw = ?";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, logid);
			psmt.setString(2, logpw);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberGS member = new MemberGS();
				member.setMemid(rs.getString("mem_id"));
				member.setMempw(rs.getString("mem_pw"));
				if (member.getMemid().equals(logid) && member.getMempw().equals(logpw)) {
					return true;
				} else {
					System.out.println("계정을 확인해 주세요.");
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	
	// 회원가입				회원가입					회원가입
	boolean Members(MemberGS mem) {
		getConn();
		String sql = "insert into mem (mem_id, mem_pw, mem_name, mem_birth )" + "values (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemid());
			psmt.setString(2, mem.getMempw());
			psmt.setString(3, mem.getMemname());
			psmt.setInt(4, mem.getMembirth());
			int r = psmt.executeUpdate(); // 처리된 건수 반환.
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 예외발생하거나 처리된 건수가 0일 경우.
	}
	
	
	
	// 아이디 찾기						아이디 찾기							아이디 찾기
	List<MemberGS> idfind(MemberGS mem) {
		getConn();
		List<MemberGS> findList = new ArrayList<>();
		String sql = "Select mem_id from mem where mem_name = ? and mem_birth = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getMemname());
			psmt.setInt(2, mem.getMembirth());
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberGS member = new MemberGS();
				member.setMemid(rs.getString("mem_id"));
				findList.add(member);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findList; // 예외발생하거나 처리된 건수가 0일 경우.
	}
	
	
	
	// 비밀번호 찾기						비밀번호 찾기						비밀번호 찾기
		List<MemberGS> pwfind(MemberGS mem) {
			getConn();
			List<MemberGS> findList1 = new ArrayList<>();
			String sql = "Select mem_pw from mem where mem_id = ? and mem_name = ? and mem_birth = ? ";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, mem.getMemid());
				psmt.setString(2, mem.getMemname());
				psmt.setInt(3, mem.getMembirth());
				
				rs = psmt.executeQuery();
				while(rs.next()) {
					MemberGS member = new MemberGS();
					member.setMempw(rs.getString("mem_pw"));
					findList1.add(member);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return findList1; // 예외발생하거나 처리된 건수가 0일 경우.
		}
	
	
	
	
	
	
	
	
}// end
