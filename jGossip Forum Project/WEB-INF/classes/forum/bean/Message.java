package forum.bean;

import java.sql.*;
import java.util.*;

public class Message {

	private int id = 0;
	private int author = 0;
	private String notes = new String();
	private String datetimes = new String();
	private String ipaddress = new String();
	private int idtopic = 0;
	private User authorusr = new User();

        public void setId(int id){
        	this.id = id;
        }

        public int getId(){
        	return id;
        }

        public void setAuthor(int author){
        	this.author = author;
        }

        public int getAuthor(){
        	return author;
        }

        public void setNotes(String notes){
        	this.notes = notes;
        }

        public String getNotes(){
        	return notes;
        }

        public void setDatetimes(String datetimes){
        	this.datetimes = datetimes;
        }

        public String getDatetimes(){
        	return datetimes;
        }

        public void setIpaddress(String ipaddress){
        	this.ipaddress = ipaddress;
        }

        public String getIpaddress(){
        	return ipaddress;
        }

        public void setIdtopic(int idtopic){
        	this.idtopic = idtopic;
        }

        public int getIdtopic(){
        	return idtopic;
        }

        public void setAuthorusr(User authorusr){
        	this.authorusr = authorusr;
        }

        public User getAuthorusr(){
        	return authorusr;
        }

        public Vector listMessage(int idtopic){

		Vector list = new Vector();
		Message message = new Message();
		User authorusr = new User();

        	Connection con = null;
        	try {
                        Class.forName(DBConnection.getDBDriver());
			con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select msg.*, usr.*, msg.id as msgid, usr.id as usrid from messages msg, users usr where msg.idtopic="+idtopic+" and msg.author=usr.id order by msg.id");

			while(rs.next()){
				message = new Message();
				authorusr = new User();

				message.setId(rs.getInt("msgid"));
				message.setAuthor(rs.getInt("author"));
				message.setNotes(rs.getString("notes"));
				message.setDatetimes(rs.getString("datetimes"));
				message.setIpaddress(rs.getString("ipaddress"));
				message.setIdtopic(rs.getInt("idtopic"));

				authorusr.setId(rs.getInt("usrid"));
				authorusr.setUsername(rs.getString("username"));
				authorusr.setEmail(rs.getString("email"));
				authorusr.setSite(rs.getString("site"));
				authorusr.setYahooid(rs.getString("yahooid"));
				authorusr.setLocation(rs.getString("location"));
				authorusr.setBio(rs.getString("bio"));
				authorusr.setBirthday(rs.getString("birthday"));
				authorusr.setState(rs.getString("state"));

				message.setAuthorusr(authorusr);

				list.addElement(message);
			}
			con.close();
        	}
        	catch(Exception e){ }

        	return list;
        }
}
