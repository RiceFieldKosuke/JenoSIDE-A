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
        String sql = "CREATE TABLE TEST)";

        try {
            //JDBCドライバをロードする
            Class.forName("com.mysql.jdbc.Driver");

            //DBへのコネクションを作成する
            conn = DriverManager.getConnection(path, id, pw);
            conn.setAutoCommit(false);  //オートコミットはオフ

            //実行するSQL文とパラメータを指定する
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setString(2, "上垣　光介");
            ps.setString(3, "北海道札幌市");
            ps.setString(4, "011-999-9999");

            //INSERT文を実行する
            ResultSet i = ps.executeQuery();

            //処理件数を表示する
            System.out.println("結果：" + i);

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
