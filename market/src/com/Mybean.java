package com;

/**
 * Created by bb67ao on 2019/6/23
 */
public class Mybean {
	String name = null;
	String pass = null;
	String goods = null;
	UpdateAccount ua = new UpdateAccount();
	public Mybean(){}

	public void setName(String name){
		this.name = name;
	}
	void getPass(){
		this.pass = ua.getPassword(this.name);
	}
	public String getGoods(){
		goods = ua.getGoods(this.name);
		//System.out.println(goods);
		return goods;
	}
	public double getsum(){
		return ua.getSMoney(name);
	}
}
