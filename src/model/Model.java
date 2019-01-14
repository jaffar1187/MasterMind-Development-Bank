package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Model 
{
	private String name;
	private String account_no;
	private String balance;
	private String customer_id;
	private String password;
	private String email;
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private String un="cool";
	private String pwd="abcfortech123@";
	private Connection con;
	private ResultSet res;
	private PreparedStatement pstmt;
	private String temp;
	private String to;
	private ArrayList al1;		
	private ArrayList al2;
	private ArrayList al3;
	private ArrayList al4;
	private ArrayList al5;
	private String confirmpassword;
	private String admin_id;
	private String admin_password;
	public Model() {
		// TODO Auto-generated constructor stub
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Successfully");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Driver Not Loaded Successfully");
		}
		try 
		{
			con=DriverManager.getConnection(url, un, pwd);
			System.out.println("Connection Established Successfully");
		} 
		catch (SQLException e) 
		{
			System.out.println("Connection Not Established Successfully");
		}
	}
	public void setName(String name) {
			this.name = name;
		}
		public void setAccount_no(String account_no) {
			this.account_no = account_no;
		}
		public void setBalance(String balance) {
			this.balance = balance;
		}
		public void setCustomer_id(String customer_id) {
			this.customer_id = customer_id;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public String getAccount_no() {
			return account_no;
		}
		public String getBalance() {
			return balance;
		}
		public String getCustomer_id() {
			return customer_id;
		}
		public String getPassword() {
			return password;
		}
		public String getEmail() {
			return email;
		}
		public ArrayList getAl1() {
			return al1;
		}
		public void setAl1(ArrayList al1) {
			this.al1 = al1;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public ArrayList getAl2() {
			return al2;
		}
		public ArrayList getAl3() {
			return al3;
		}
		public ArrayList getAl4() {
			return al4;
		}
		public ArrayList getAl5() {
			return al5;
		}
		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}
		public void setAdmin_id(String admin_id) {
			this.admin_id = admin_id;
		}
		public void setAdmin_password(String admin_password) {
			this.admin_password = admin_password;
		}
		public boolean login()
		{
			
			try
			{
					String s="select * from bank_app where customer_id=? and password=?";
					pstmt = con.prepareStatement(s);
					pstmt.setString(1, customer_id);
					pstmt.setString(2, password);
					res=pstmt.executeQuery();
					
					if(res.next()==true)
					{
						account_no=res.getString("account_no");
						name=res.getString("name");
						return true;
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Problem in executing query");
			}
			return false;
		}
		
		public boolean balance()
		{
			try
			{
				String s="select * from bank_app where ACCOUNT_NO=?";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, account_no);
				res=pstmt.executeQuery();
				if(res.next()==true)
				{
					balance=res.getString("balance");
					return true;
				}
			} 
			catch (SQLException e) 
			{
	
			}
			return false;
		}
		
		public boolean changePassword()
		{
			
				try
				{
					
					String verification = null;
					String p="select password from bank_app where account_no=?";
					pstmt=con.prepareStatement(p);
					pstmt.setString(1, account_no);
					res=pstmt.executeQuery();
					if(res.next()==true)
					{
						verification=res.getString("password");
					}
					if(confirmpassword.equals(verification)==true)
					{
						String s="update bank_app set password=? where account_no=?";
						pstmt=con.prepareStatement(s);
						pstmt.setString(1, password);
						pstmt.setString(2, account_no);
						int status=pstmt.executeUpdate();
						
						if(status==0)
						{
							return false;
						}
					}
					else
					{
						return false;
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return true;
			}
		
		public boolean transferAmount(String transferamount)
		{
			try 
			{
				String j="select account_no from bank_app";
				pstmt=con.prepareStatement(j);
				res=pstmt.executeQuery();
				while(res.next()==true)
				{
					if(to.equals(res.getString("account_no")))
					{
						String s="update bank_app set balance=balance-? where account_no=?";
						pstmt=con.prepareStatement(s);
						pstmt.setString(1, transferamount);
						pstmt.setString(2, account_no);
						int status=pstmt.executeUpdate();
						
						String q="update bank_app set balance=balance+? where account_no=?";
						pstmt=con.prepareStatement(q);
						pstmt.setString(1, transferamount);
						pstmt.setString(2, to);
						pstmt.executeUpdate();
						
						DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
						LocalDateTime now=LocalDateTime.now();
						temp=dtf.format(now);
						
						String r="insert into bank_statement values(?,?,?,?)";
						pstmt = con.prepareStatement(r);
						pstmt.setString(1, to);
						pstmt.setString(2, transferamount);
						pstmt.setString(3, temp);
						pstmt.setString(4, account_no);
						pstmt.executeUpdate();
						
						String p="insert into bank_debited values(?,?,?,?)";
						pstmt=con.prepareStatement(p);
						pstmt.setString(1, to);
						pstmt.setString(2, transferamount);
						pstmt.setString(3, temp);
						pstmt.setString(4, account_no);
						pstmt.executeUpdate();
						if(status==0)
						{
							return false;
						}
						else
						{
							return true;
						}
					}
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return false;
		}
		public ArrayList getStatement()
		{
			ArrayList al=new ArrayList();
			al1=new ArrayList();
			al2=new ArrayList();
			try 
			{
				String p="select * from bank_debited where account_no=?";
				pstmt=con.prepareStatement(p);
				pstmt.setString(1, account_no);
				res=pstmt.executeQuery();
				al3=new ArrayList();
				al4=new ArrayList();
				al5=new ArrayList();
				while(res.next()==true)
				{
					al3.add(res.getString("to_account"));
					al4.add(res.getString("amount"));
					al5.add(res.getString("transaction_time"));
				}
				
				String s="select * from bank_statement where account_no=?";
				pstmt=con.prepareStatement(s);
				pstmt.setString(1, account_no);
				res=pstmt.executeQuery();
				while(res.next()==true)
				{
					al.add(res.getString("amount"));
					al1.add(res.getString("transaction_time"));
					al2.add(res.getString("from_account"));
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return al;
		}
		public boolean deactivate()
		{
			try
			{
				String names = null;
				String account_nos = null;
				String balances = null;
				String passwords =null;
				String emails = null;
				String customer_ids = null;
				String g="select * from bank_app where account_no=?";
				pstmt=con.prepareStatement(g);
				pstmt.setString(1, account_no);
				res=pstmt.executeQuery();
				while(res.next()==true)
				{
					names = res.getString("NAME");
					account_nos=res.getString("ACCOUNT_NO");
					balances=res.getString("BALANCE");
					customer_ids=res.getString("CUSTOMER_ID");
					passwords=res.getString("PASSWORD");
					emails=res.getString("EMAIL");
					
				}
				
				String h="insert into bank_deleted values(?,?,?,?,?,?)";
				pstmt=con.prepareStatement(h);
				pstmt.setString(1, names);
				pstmt.setString(2, account_nos);
				pstmt.setString(3, balances);
				pstmt.setString(4, customer_ids);
				pstmt.setString(5, passwords);
				pstmt.setString(6, emails);
				pstmt.executeUpdate();
				
				
				
				
				
				String d="delete from bank_app where account_no=?";
				pstmt=con.prepareStatement(d);
				pstmt.setString(1, account_no);
				int status=pstmt.executeUpdate();
				if(status==0)
				{
					return false;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return true;
		}
		
		public boolean adminLogin()
		{
			try 
			{
				String s="select * from admin where admin_id=? and admin_password=?";
				pstmt=con.prepareStatement(s);
				pstmt.setString(1, admin_id);
				pstmt.setString(2, admin_password);
				res=pstmt.executeQuery();
				if(res.next()==true)
				return true;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return false;
			
		}
		
		public boolean activate()
		{
			try 
			{
				String s="select * from bank_app where account_no=?";
				pstmt=con.prepareStatement(s);
				pstmt.setString(1, account_no);
				res=pstmt.executeQuery();
				if(res.next()==true)
				{
					return false;
				}
				else
				{
					String j="select * from bank_deleted where account_no=?";
					pstmt=con.prepareStatement(j);
					pstmt.setString(1,account_no);
					res=pstmt.executeQuery();
					if(res.next()==true)
					{
						name=res.getString("NAME");
						balance=res.getString("BALANCE");
						customer_id=res.getString("CUSTOMER_ID");
						password=res.getString("PASSWORD");
						email=res.getString("EMAIL");
					}
					String q="insert into bank_app values(?,?,?,?,?,?)";
					pstmt=con.prepareStatement(q);
					pstmt.setString(1,name);
					pstmt.setString(2,account_no);
					pstmt.setString(3,balance);
					pstmt.setString(4,customer_id);
					pstmt.setString(5,password);
					pstmt.setString(6,email);
					int status=pstmt.executeUpdate();
					
					String h="delete from bank_deleted where account_no=?";
					pstmt=con.prepareStatement(h);
					pstmt.setString(1, account_no);
					pstmt.executeUpdate();
					
					if(status==0)
						return false;
						else 
						return true;
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean validateActivation()
		{
			boolean b=false;
			boolean c=false;
			try
			{
				String s="select * from bank_app where account_no=?";
				pstmt=con.prepareStatement(s);
				pstmt.setString(1, account_no);
				res=pstmt.executeQuery();
				if(res.next()==true)
				{
					b=true;
				}
				String r="select * from bank_deleted where account_no=?";
				pstmt=con.prepareStatement(r);
				pstmt.setString(1, account_no);
				res=pstmt.executeQuery();
				if(res.next()==true)
				{
					c=true;
				}
				if(b!=c)
				{
					return true;
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		return false;
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
	}

