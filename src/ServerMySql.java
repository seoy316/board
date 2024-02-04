import java.sql.*;
import java.time.LocalDate;

public class ServerMySql {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //1. JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Ok!");

            //연결하기
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/boarddb", "root", "4245");

            //매개변수화된 SQL문 작성
            String sql = "insert into board(btitle, bcontent, bwriter, bdate)" +
                    "values(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            //sql문 실행
            Date currentDate = Date.valueOf(LocalDate.now());
            pstmt.setString(1,"첫번째 게시물");
            pstmt.setString(2,"첫번째로 작성한 게시물 입니다요잉");
            pstmt.setString(3,"윤여빈");
            pstmt.setDate(4, currentDate);
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : "+rows);

            pstmt.close();


            System.out.println("연결 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //3. 연결 끊기
                    conn.close();

                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }
    }
}
