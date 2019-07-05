package com;

import java.sql.*;

/**
 * Created by bb67ao on 2019/6/18
 */

public class UpdateAccount {
	//数据库连接参数
	String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
	String user = "root";
	String password = "Iloveyou521..";
	Connection conn = null;
	UpdateAccount(){
		try{
			//System.out.println("shujvku");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			//System.out.println("shujvku");
		}catch (ClassNotFoundException e){
			System.out.print(e);
		}catch (SQLException e){
			System.out.print(e);
		}
	}
	/*void creatTable(){
		try{
			Statement stmt = conn.createStatement();
			String account= "create table account(\n" +
					"    user varchar(20) not null ,\n" +
					"    passwprd varchar(20) not null ,\n" +
					"    primary key (user)\n" +
					")";
			String goods = "create  table goods(\n" +
					"    user varchar(20) not null ,\n" +
					"    good varchar(20) not null ,\n" +
					"    foreign key (user) references account(user)\n" +
					")\n";
			stmt.executeUpdate(account);
			stmt.executeUpdate(goods);
			stmt.close();
		}catch (SQLException e){
			System.out.print(e);
		}
	}*/

	void addAccount(String name,String pass){
		try {
			String aa = "INSERT INTO account" +
					"(user,password)" +
					"VALUES(?,?)";
			PreparedStatement stmt = conn.prepareStatement(aa);
			stmt.setString(1,name);
			stmt.setString(2,pass);
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e){
			System.out.println(e);
		}
	}

	boolean findAccount(String name){
		try {
			//Statement stmt = conn.createStatement();
			String fc = "select user from account\n" +
					"where user = ?";
			PreparedStatement stmt = conn.prepareStatement(fc);
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			//System.out.println(rs.getRow());
			if (rs.next()){
				return true;
			}
			else{
				return false;
			}
		}catch (SQLException e){
			System.out.println(e);
		}
		return false;
	}

	String getPassword(String name){
		String pass = null;
		try {
			//Statement stmt = conn.createStatement();
			String gp = "select password from account\n" +
					"where user = ?";
			PreparedStatement stmt = conn.prepareStatement(gp);
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				pass = rs.getString(1);
			}
		}catch (SQLException e){
			System.out.println(e);
		}
		return pass;
	}

	String getGoods(String name){
		String goods = "";
		try{
			String gg = "select good,number,price,number*price from goods\n" +
					"where user = ?";
			PreparedStatement stmt = conn.prepareStatement(gg);
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				goods+=rs.getString(1);
				goods+="&nbsp&nbsp&nbsp&nbsp&nbsp";
				goods+=rs.getInt(2);
				goods+="个";
				goods+="&nbsp&nbsp&nbsp&nbsp&nbsp单价：";
				goods+=rs.getDouble(3);
				goods+="元&nbsp&nbsp&nbsp&nbsp&nbsp共计：";
				goods+=rs.getDouble(4);
				goods+="元</br>";
				System.out.println(goods);
			}
		}catch (SQLException e){
			System.out.println(e);
		}
		return goods;
	}

	void delAccount(String name){
		String ad ;
		try{
			ad = "delete from goods\n" +
					"where user= ?";
			PreparedStatement stmt = conn.prepareStatement(ad);
			stmt.setString(1,name);
			stmt.executeUpdate();
			stmt.close();

			ad = "delete from account\n" +
					"where user= ?";
			stmt = conn.prepareStatement(ad);
			stmt.setString(1,name);
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e){
			System.out.println(e);
		}
	}

	void altPass(String name,String pass){
		String ap = null;
		try{
			ap = "update account\n" +
					"    set password = ?\n" +
					"where user = ?";
			PreparedStatement stmt = conn.prepareStatement(ap);
			stmt.setString(1,pass);
			stmt.setString(2,name);
			stmt.executeUpdate();
		}catch (SQLException e){
			System.out.println(e);
		}
	}

	void addGood(String name,String good,double price,int number){
		try{
			String ag = "select number from goods\n" +
					"where user = ? and good = ?";
			PreparedStatement stmt = conn.prepareStatement(ag);
			stmt.setString(1,name);
			stmt.setString(2,good);
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()){
				addGood1(name, good, price, number);
			}
			else{
				number += rs.getInt(1);
				alterGood(name, good, number);
			}
			stmt.close();
		}catch (SQLException e){
			System.out.println(e);
		}
	}

	void addGood1(String name,String good,double price,int number){
		try{
			int num = 0;
			String ag = "insert into goods(user, good, price, number)\n" +
					"VALUES (?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(ag);
			stmt.setString(1,name);
			stmt.setString(2,good);
			stmt.setDouble(3,price);
			stmt.setInt(4,number);
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e){
			System.out.println(e);
		}
	}

	void alterGood(String name,String good,int number){
		try{
			String ag = "update goods set number = ?\n" +
					"where good = ? and user = ?";
			PreparedStatement stmt = conn.prepareStatement(ag);
			stmt.setInt(1,number);
			stmt.setString(2,good);
			stmt.setString(3,name);
			stmt.executeUpdate();
			stmt.close();
		}catch (SQLException e){
			System.out.println(e);
		}
	}

	double getSMoney(String name){
		double me=0;
		try{
			String sm = "select sum(number*price)\n" +
					"from goods where user = ?";
			PreparedStatement stmt = conn.prepareStatement(sm);
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				me = rs.getDouble(1);
			}
		}catch (SQLException e){
			System.out.println(e);
		}
		finally {
			return me;
		}
	}
}
