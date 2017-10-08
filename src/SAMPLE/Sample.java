package SAMPLE;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sample {

    public static void main(String[] args) throws Exception{

        //変数定義
        Connection conn = null;
        PreparedStatement ps = null;

        //DB接続情報を設定する
        String path = "jdbc:mysql://localhost:3306/test";  //接続パス
        String id = "root";    //ログインID
        String pw = "";  //ログインパスワード

        //SQL文を定義する
        String sql = "CREATE TABLE TEST(name char(20) PRIMARY KEY ,tell char(20))";

        try {
            //JDBCドライバをロードする
            Class.forName("com.mysql.jdbc.Driver");

            //DBへのコネクションを作成する
            conn = DriverManager.getConnection(path, id, pw);
            conn.setAutoCommit(false);  //オートコミットはオフ

            //実行するSQL文とパラメータを指定する
            ps = conn.prepareStatement(sql);

            //INSERT文を実行する
             ps.execute();
            //コミット
            conn.commit();

        } catch (Exception ex) {
            //例外発生時の処理
       //    conn.rollback();       //ロールバックする
            ex.printStackTrace();  //エラー内容をコンソールに出力する

        } finally {
            //クローズ処理
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

    }

}
