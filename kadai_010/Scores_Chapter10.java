package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scores_Chapter10 {

  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    try {
      con = DriverManager.getConnection("jdbc:mysql://localhost/challenge_java",
          "root", "kfm3d35Z");
      
      System.out.println("データベース接続成功：" + con);
      stmt = con.createStatement();
      String sql = "UPDATE scores SET score_math = 95, score_english = 80 WHERE id = 5";
      
      int rowCnt = stmt.executeUpdate(sql);
      System.out.println("レコード更新を実行します");
      System.out.println(rowCnt + "件のレコードが更新されました");
      
      sql = "SELECT * FROM scores ORDER BY score_math DESC, score_english DESC";
      
      ResultSet rs = stmt.executeQuery(sql);
      System.out.println("数学・英語の点数が高い順に並べ替えました");
      while(rs.next()) {
        rowCnt = rs.getRow();
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int scoreMath = rs.getInt("score_math");
        int scoreEnglish = rs.getInt("score_english");
        System.out.println(rowCnt+"件目：生徒ID="+id+"／氏名="+name+"／数学="+scoreMath+"／英語="+ scoreEnglish);
      }
    } catch(SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if(con != null) {
        try{con.close();}catch(SQLException ignore) {}
      }
      if(stmt != null) {
        try{stmt.close();}catch(SQLException ignore) {}
      }
    }

  }

}
