package forum.bean;

import java.sql.*;
import java.util.*;

public class Forum {

	private int id = 0;
	private String name = new String();
	private String category = new String();
	private String details = new String();
	private int moderator = 0;
	private int counttopic = 0;
	private int countpost = 0;
	private String lastpost = new String();
	private User moderatorusr = new User();
	private User usrpost = new User();
	private Message message = new Message();

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setDetails(String details){
		this.details = details;
	}

	public String getDetails(){
		return details;
	}

	public void setModerator(int moderator){
		this.moderator = moderator;
	}

	public int getModerator(){
		return moderator;
	}

	public void setCounttopic(int counttopic){
		this.counttopic = counttopic;
	}

	public int getCounttopic(){
		return counttopic;
	}

	public void setCountpost(int countpost){
		this.countpost = countpost;
	}

	public int getCountpost(){
		return countpost;
	}

	public void setLastpost(String lastpost){
		this.lastpost = lastpost;
	}

	public String getLastpost(){
		return lastpost;
	}

	public void setModeratorusr(User user){
		this.moderatorusr = user;
	}

	public User getModeratorusr(){
		return moderatorusr;
	}

	public void setUsrpost(User user){
		this.usrpost = user;
	}

	public User getUsrpost(){
		return usrpost;
	}

	public void setMessage(Message msg){
		this.message = msg;
	}

	public Message getMessage(){
		return message;
	}

	/*------------------------------------------
		    Start database Method
	------------------------------------------*/

	public Vector listCategory(){

		Forum frm;
		Vector list = new Vector();
		Connection con = null;

		try {
                        Class.forName(DBConnection.getDBDriver());
			con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select distinct category from forums order by category asc");

                        while (rs.next()){
                        	frm = new Forum();
                        	frm.setCategory(rs.getString("category"));
                                list.addElement(frm);
                        }

			con.close();
		}
		catch (Exception e){ }

		return list;
	}

	public Vector listForum(String category){

		Forum frm = new Forum();
		User moderator = new User();
		User usrpost = new User();
		Message msg = new Message();
		Vector list = new Vector();
		Connection con = null;

		try {
			Class.forName(DBConnection.getDBDriver());
			con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery("select * from forums where category='"+category+"' order by id");

			while (rs1.next()){
				frm = new Forum();
				frm.setName(rs1.getString("name"));
				frm.setDetails(rs1.getString("details"));
				frm.setId(rs1.getInt("id"));
				frm.setModerator(rs1.getInt("moderator"));

				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery("select count(tp.id) as counttopic from forums fr, topics tp where fr.id="+frm.getId()+" and tp.idforum=fr.id");

				if (rs2.next()){
				frm.setCounttopic(rs2.getInt("counttopic"));
				}

				Statement stmt3 = con.createStatement();
				ResultSet rs3 = stmt3.executeQuery("select count(mg.idtopic) as countpost from forums fr, topics tp, messages mg where fr.id="+frm.getId()+" and fr.id=tp.idforum and tp.id=mg.idtopic");

				if (rs3.next()){
					frm.setCountpost(rs3.getInt("countpost"));
				}

				Statement stmt4 = con.createStatement();
				ResultSet rs4 = stmt4.executeQuery("select usr.* from users usr, forums fr where fr.id="+frm.getId()+" and fr.moderator=usr.id");

				if (rs4.next()){
					moderator = new User();
					moderator.setUsername(rs4.getString("username"));
					frm.setModeratorusr(moderator);
				}

				Statement stmt5 = con.createStatement();
				ResultSet rs5 = stmt5.executeQuery("select usr.*, msg.* from users usr, messages msg, forums fr, topics tp where fr.id="+frm.getId()+" and tp.idforum=fr.id and msg.idtopic=tp.id and msg.author=usr.id order by msg.datetimes desc");

				if (rs5.next()){
					usrpost = new User();
					msg = new Message();
					usrpost.setUsername(rs5.getString("username"));
					msg.setDatetimes(rs5.getString("datetimes"));
					frm.setUsrpost(usrpost);
					frm.setMessage(msg);
				}

				list.addElement(frm);
			}

			con.close();
		}
		catch (Exception e){ }

		return list;
	}
}
