
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Types;

public class JDBC_GetData_1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		Connection conn = null;
		int lowNumber = 0;
		try {
			//1、加载JDBC的本地驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2、定义数据库位置和库名称
			String url1 = "jdbc:sqlserver://localhost:1433; DatabaseName=test";
		
			//3、定义数据库访问所需的用户名和密码
			String user = "lylelove";
			String password = "lylelove2000A";
			
			//4、获取数据库连接
			conn = DriverManager.getConnection(url1, user, password);
			
			//5、创建SQL语句对象
			stmt = conn.createStatement();
			String sql = "select * from D_ShipList_Main";
			ResultSet rs = stmt.executeQuery(sql);

//			while (rs.next()) {
//				lowNumber++;
//			}
//			System.out.println("共有 " + lowNumber + " 条记录");
			while (rs.next()) {
				System.out.println(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getString(3) + ";"
						+ rs.getString(4) + ";" + rs.getString(5));
				lowNumber++;

			}
			System.out.println("******** 共有 " + lowNumber + " 条记录 ********");
			//在T_User表中加入一行记录
			
			insert(conn, "mical", 12);
			
			testSP1(conn);
			testSP2(conn);
			testSP3(conn);
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception ex) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			}
		}
		
		
	}

	// 使用PreparedStatement对象向数据库中写入记录
	private static void insert(Connection conn, String userName, Integer password) throws SQLException {
		String strSql = "insert into T_User(username,password) values(?,?)";
		try (PreparedStatement statement = conn.prepareStatement(strSql)) {
			statement.setString(1, userName);
			statement.setInt(2, password);
			System.out.println("SQL语句：" + statement.toString());
			statement.executeUpdate();
		}
	}

//  利用CallableStatement对象运行不带参数的存储过程
//	ALTER PROCEDURE [dbo].[USP_getD_ShipList_Main]
//		AS
//		BEGIN
//		    select * from D_ShipList_Main
//		END
	private static void testSP1(Connection conn) throws SQLException {
		try {
			CallableStatement csmt = conn.prepareCall("{call USP_getD_ShipList_Main()}");
			ResultSet rs = csmt.executeQuery();
			int sn=0;
			while (rs.next()) {
				int pkid = rs.getInt(1);
				String goodsBillCode = rs.getString(2);
				String sendGoodsCustomer = rs.getString(4);
				sn++;
				System.out.println(sn + ": PKID=" + pkid + ",GoodsBillCode=" +goodsBillCode + ", SendGoodsCustomer=" + sendGoodsCustomer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//			finally {
//			conn.close();
//		}
	}

//  利用CallableStatement对象运行带输入参数的存储过程
//	    CREATE PROCEDURE [dbo].[USP_InsertTo_T_User] 
//		     @userName varchar(50),
//			 @password int
//		AS
//		BEGIN
//			insert into T_User(username, password) values(@userName, @password)
//		END
	private static void testSP2(Connection conn) throws SQLException {
		try {
			CallableStatement csmt = conn.prepareCall("{call USP_InsertTo_T_User(?,?)}");
			csmt.setString(1, "Mical Jordan");
			csmt.setInt(2, 100);
			csmt.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			conn.close();
//		}
	}

//  利用CallableStatement对象运行带输入和输出参数的存储过程
//  CREATE PROCEDURE [dbo].[USP_GetPassByName] 
//    @userName varchar(50) ,
//	  @password int out
//  AS
//  BEGIN
//	  select @password=password from T_User where username = @userName
//  END
	private static void testSP3(Connection conn) throws SQLException {
		try {
			CallableStatement csmt = conn.prepareCall("{call USP_GetPassByName(?,?)}");
			csmt.setString(1, "mical");
			csmt.registerOutParameter(2, Types.INTEGER);
			csmt.execute();
			int intPassword = csmt.getInt(2);
			System.out.println("password=" + intPassword);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			conn.close();
//		}
	}
}
