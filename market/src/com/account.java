package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by bb67ao on 2019/6/18
 */
public class account extends javax.servlet.http.HttpServlet {
	//账户存取参数
	String auser = null;
	String apassword = null;
	UpdateAccount ua = new UpdateAccount();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		//登陆账号
		if (request.getParameter("op").equals("L")){
			String username = request.getParameter("name");
			String password = request.getParameter("password");
			//账户不存在，重新登陆
			if (!ua.findAccount(username)){
				response.sendRedirect("/market_war_exploded/page/Login.jsp");
				return;
			}
			//存在，返回主界面
			else {
				//System.out.println(ua.getPassword(username));
			//	System.out.println(password);
				if (ua.getPassword(username).equals(password)){
					session.setAttribute("login",username);
					response.sendRedirect("/market_war_exploded/page/Market.jsp");
					//request.getRequestDispatcher("/page/Market.jsp");
					return;
				}
				else{
					response.sendRedirect("/market_war_exploded/page/Login.jsp");
					return;
				}
			}
		}
		//账号申请
		else if (request.getParameter("op").equals("R")){
			String username = request.getParameter("uname");
			//	String realname = request.getParameter("rname");
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			if(checkcor(username,password1,password2)){
				//账户是否合理
				ua.addAccount(username,password1);
				//合理即登陆
				response.sendRedirect("/market_war_exploded/page/Login.jsp");
				return;
			}
			else{
				//否侧重新申请
				response.sendRedirect("/market_war_exploded/page/Regist.jsp");
				return;
			}


		}
		//未登录自动跳转
		else if (session.getAttribute("login").equals("0")){
			response.sendRedirect("/market_war_exploded/page/Login.jsp");
			return;
		}

		//添加购物车
		else if (request.getParameter("op").equals("F")){
			request.setCharacterEncoding("utf-8");
			String good = request.getParameter("good");
			double price = Double.parseDouble(request.getParameter("price"));
			int number = Integer.parseInt(request.getParameter("number"));
			String user = (String) session.getAttribute("login");
		//	System.out.println(good);
		//	System.out.println(user);
			ua.addGood(user,good,price,number);
			response.sendRedirect("/market_war_exploded/page/Market.jsp");
			return;
		}

		//下线
		else if (request.getParameter("op").equals("O")){
			session.setAttribute("login","0");
			response.sendRedirect("/market_war_exploded/page/Market.jsp");
			return;
		}

		//注销账户
		else if (request.getParameter("op").equals("U")){
			String username = (String) session.getAttribute("login");
			ua.delAccount(username);
			session.setAttribute("login","0");
			response.sendRedirect("/market_war_exploded/page/Market.jsp");
			return;
		}

		//更改密码
		else if (request.getParameter("op").equals("A")){
			String pass1 = request.getParameter("password1");
			String pass2 = request.getParameter("password2");
			String username = (String) session.getAttribute("login");
			if (pass1.equals(pass2)){
				ua.altPass(username,pass1);
				session.setAttribute("login","0");
				response.sendRedirect("/market_war_exploded/page/Login.jsp");
				return;
			}
			else {
				response.sendRedirect("/market_war_exploded/page/Altpass.jsp");
				return;
			}
		}
	}

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
		doPost(request,response);
	}

	boolean checkcor(String name,String pass1,String pass2){
		if (ua.findAccount(name)){
			return false;
		}
		else if ("".equals(pass1)){
			return false;
		}
		else if (pass1.equals(pass2)){
			return true;
		}
		return false;
	}
}
