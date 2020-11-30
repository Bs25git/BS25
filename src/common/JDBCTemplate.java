package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
   // DB연결을 1번만 생성하여 사용할 수 있도록 함
   // 1번만 생성하는 이유는 DB부하를 줄이기 위해서
   // 1번만 생성하는 기법 싱글톤 디자인 패턴 기법
   // 나는 김수연이다.
   public JDBCTemplate() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (Exception e) {
    	 e.printStackTrace();
      }
   }
   
   private static JDBCTemplate instance;
   public static JDBCTemplate getConnection() {
      if( instance == null) {
         instance = new JDBCTemplate();
      }
      return instance;
   }
   public Connection createConnection() throws SQLException{
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String user = "BS";
      String password = "BS";
      
      return DriverManager.getConnection(url, user, password);
      
   }
   public static void close(Connection conn) {
      try {
         if (conn != null && !conn.isClosed()) {
            conn.close();
         }
      } catch (Exception e) {
         
         e.printStackTrace();
      }
   }
   // PreparedStatement는 Statement를 상속 받아서 만들었기 떄문에
   // Statement로 close() 가능함.
   public static void close(Statement stmt) {
      try {
         if (stmt != null && !stmt.isClosed()) {
            stmt.close();
         }
      } catch (Exception e) {
         
         e.printStackTrace();
      }
   }
   public static void close(ResultSet rset) {
      try {
         if (rset != null && !rset.isClosed()) {
            rset.close();
         }
      } catch (Exception e) {
         
         e.printStackTrace();
      }
   }
   public static void commit(Connection conn) {
      try {
         if (conn != null && !conn.isClosed()) {
            conn.commit();
         }
      } catch (Exception e) {
         
         e.printStackTrace();
      }
   }
   public static void rollback(Connection conn) {
      try {
         if (conn != null && !conn.isClosed()) {
            conn.rollback();
         }
      } catch (Exception e) {
         
         e.printStackTrace();
      }
   }
   
}
