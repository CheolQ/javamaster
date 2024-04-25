//package Board;
//
//import java.awt.Menu;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class LoginDao {
//	
//	Connection conn;
//	PreparedStatement psmt;
//	ResultSet rs;
//
//	public void loginUser(String id, String pw) {
//	 conn = dataSource.getConn();
//     String sql = "SELECT USER_PASSWORD FROM USERS WHERE USER_ID = ?";
//     try {
//        psmt = conn.prepareStatement(sql);
//        psmt.setString(1, user.getLoginId());
//        rs = psmt.executeQuery();
//        if (rs.next()) {
//           if (rs.getString(1).contentEquals(user.getUserPassword())) {
//              
//              System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//              System.out.println("로그인 성공");
//              System.out.println(user.getloginid() + " 계정에 접속했습니다.");
//              System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//              return 1;
//           } else {
//              
//              System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//              System.out.println("비밀번호 불일치");
//              System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//              return 0;
//           }
//        }
//        System.out.println("아이디가 없음");
//        return -1;
//     } catch (SQLException e) {
//        e.printStackTrace();
//     } finally {
//        close();
//     }
//
//     return -2;
//  }
//}
