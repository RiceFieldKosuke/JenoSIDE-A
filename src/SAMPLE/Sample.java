package SAMPLE;

import static util.DBUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Sample {

    public static void main(String[] args) throws Exception{

        //変数定義
        Connection conn = null;
        PreparedStatement ps = null;

        //SQL文を定義する
        String sql = "CREATE TABLE TEST(name char(20) PRIMARY KEY ,tell char(20))";

        try {

            //DBへのコネクションを作成する
            conn = getConnection();

            //実行するSQL文とパラメータを指定する
            ps = conn.prepareStatement(sql);

            //INSERT文を実行する
             ps.execute();
            //コミット
            commit(conn);

        } catch (Exception ex) {
            //例外発生時の処理
        	rollback(conn);       //ロールバックする
            ex.printStackTrace();  //エラー内容をコンソールに出力する
        } finally {
            //クローズ処理
            close(conn);
        }

    }

}
