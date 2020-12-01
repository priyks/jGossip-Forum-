package forum.bean;

import java.sql.*;
import java.util.*;

public class Topic {

	private int id = 0;
	private String name = new String();
	private int views = 0;
	private int idforum = 0;
	private int author = 0;
	private User authorusr = new User();
	private int replies = 0;
	private User lastauthorusr = new User();
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

        public void setViews(int views){
        	this.views = views;
        }

        public int getViews(){
        	return views;
        }

        public void setIdforum(int idforum){
        	this.idforum = idforum;
        }

        public int getIdforum(){
        	return idforum;
        }

        public void setAuthor(int author){
        	this.author = author;
        }

        public int getAuthor(){
        	return author;
        }

        public void setAuthorusr(User user){
        	this.authorusr = user;
        }

        public User getAuthorusr(){
        	return authorusr;
        }

        public void setReplies(int replies){
        	this.replies = replies;
        }

        public int getReplies(){
        	return replies;
        }

        public void setLastauthorusr(User lastauthorusr){
        	this.lastauthorusr = lastauthorusr;
        }

        public User getLastauthorusr(){
        	return lastauthorusr;
        }

        public void setMessage(Message message){
        	this.message = message;
        }

        public Message getMessage(){
        	return message;
        }

        /*------------------------------------------
		    Start database Method
	------------------------------------------*/

        public Vector listTopic(int idforum){

		Topic topic = new Topic();
		User authorusr = new User();
		User lastauthorusr = new User();
		Message message = new Message();
		Vector list = new Vector();
		Connection con = null;

		try {
                        Class.forName(DBConnection.getDBDriver());
			con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

                        Statement stmt1 = con.createStatement();
                        ResultSet rs1 = stmt1.executeQuery("select * from topics where idforum="+idforum);

                        while (rs1.next()){
				topic = new Topic();
				topic.setId(rs1.getInt("id"));
				topic.setName(rs1.getString("name"));
				topic.setAuthor(rs1.getInt("author"));
				topic.setViews(rs1.getInt("views"));
				topic.setIdforum(rs1.getInt("idforum"));

				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery("select usr.*, tp.* from users usr, topics tp where tp.id="+topic.getId()+" and tp.author=usr.id");

				if (rs2.next()){
					authorusr = new User();
					authorusr.setUsername(rs2.getString("username"));
					topic.setAuthorusr(authorusr);
				}

				Statement stmt3 = con.createStatement();
				ResultSet rs3 = stmt3.executeQuery("select count(msg.id)-1 as replies from topics tp, messages msg where tp.id="+topic.getId()+" and tp.id=msg.idtopic");

				if (rs3.next()){
					topic.setReplies(rs3.getInt("replies"));
				}

				Statement stmt4 =con.createStatement();
				ResultSet rs4 = stmt4.executeQuery("select msg.datetimes, usr.username from messages msg, topics tp, users usr where tp.id="+topic.getId()+" and tp.id=msg.idtopic and msg.author=usr.id order by msg.datetimes desc");

				if (rs4.next()){
					lastauthorusr = new User();
					message = new Message();
					lastauthorusr.setUsername(rs4.getString("username"));
					message.setDatetimes(rs4.getString("datetimes"));
					topic.setLastauthorusr(lastauthorusr);
					topic.setMessage(message);
				}

				list.addElement(topic);
                        }
                        con.close();
		}
		catch (Exception e){ }

		return list;
        }
}
