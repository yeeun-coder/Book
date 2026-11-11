package dbConnect;

import java.sql.*;
import java.io.IOException;

public class Database {

    public static void main(String[] args) throws SQLException, IOException {
        DB db = new DB();

        db.dbOpen();

        // DB 안의 모든 테이블 조회
        ResultSet rsTables = db.dbCon.getMetaData().getTables(null, null, "%", new String[] {"TABLE"});
        System.out.println("Tables in database:");
        while (rsTables.next()) {
            String tableName = rsTables.getString("TABLE_NAME");
            System.out.println("Table: " + tableName);

            // 컬럼 정보 조회
            ResultSet rsColumns = db.dbCon.getMetaData().getColumns(null, null, tableName, "%");
            while(rsColumns.next()) {
                String colName = rsColumns.getString("COLUMN_NAME");
                String colType = rsColumns.getString("TYPE_NAME");
                int colSize = rsColumns.getInt("COLUMN_SIZE");
                System.out.println("  " + colName + " - " + colType + "(" + colSize + ")");
            }
            rsColumns.close();
        }
        rsTables.close();

        db.dbClose();
    }

}
