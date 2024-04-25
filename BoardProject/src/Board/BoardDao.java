package Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import java.util.*;

public class BoardDao {

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

	
	
	// 게시판 등록 기능.			게시판 등록 기능.			게시판 등록 기능.
	boolean insertBoard(BoardGS Board) {
		getConn();
		String sql = "insert into Board (br_no, br_title, br_name, br_content) "
				   + " values(Board_seq.nextval, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, Board.getBrtitle());
			psmt.setString(2, Board.getBrname());
			psmt.setString(3, Board.getBrcontent());

			int r = psmt.executeUpdate(); // 처리된 건수 반환.
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 예외발생하거나 처리된 건수가 0일 경우.
	}

	
	
	// 게시판 목록 기능.			게시판 목록 기능.			게시판 목록 기능.
	List<BoardGS> BoardList() {
		getConn();
		List<BoardGS> list = new ArrayList<>();
		String sql = "select * from Board order by Br_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// 조회결과.

			while (rs.next()) {
				BoardGS Board = new BoardGS();
				Board.setBrno(rs.getInt("br_no"));
				Board.setBrtitle(rs.getString("br_title"));
				Board.setBrname(rs.getString("br_name"));
				Board.setBrcontent(rs.getString("br_content"));
				Board.setBrdate(rs.getString("br_date"));
				list.add(Board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	// 게시판 상세보기			게시판 상세보기			 게시판 상세보기
	public String showDetail(int memberId) {
		getConn();
		
		String sql = "select br_title, br_name, br_content, br_date from Board where br_no = ?";
		
			BoardGS board = new BoardGS();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, memberId);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
				board.setBrtitle(rs.getString("br_title"));
				board.setBrname(rs.getString("br_name"));
				board.setBrcontent(rs.getString("br_content"));
				board.setBrdate(rs.getString("br_date"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return board.showDetail();
	}
	
	
	
	
	// 게시판 수정기능. 			게시판 수정기능. 			게시판 수정기능.
	boolean updateBoard(BoardGS Board) {
		getConn();
		String sql = "update Board";
		sql += " set br_title = ?";
		sql += " ,br_name = ?";
		sql += " ,br_content = ?";
		sql += " where Br_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Board.getBrtitle());
			psmt.setString(2, Board.getBrname());
			psmt.setString(3, Board.getBrcontent());
			psmt.setInt(4, Board.getBrno());

			int r = psmt.executeUpdate(); //
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	// 게시판 삭제기능. 			게시판 삭제기능.	 			게시판 삭제기능.
	boolean deleteBoard(int eno) {
		getConn();
		String sql = "delete Board where br_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eno);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	


}// end