package forum.bean;

public class User {

	private int id = 0;
	private String username = new String();
	private String password1 = new String();
	private String password2 = new String();
	private String password = new String();
	private String email = new String();
	private String site = new String();
	private String yahooid = new String();
	private String location = new String();
	private String birthday = new String();
	private String bio = new String();
	private String state = new String();
	private String name = new String();

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword1(String password1){
		this.password1 = password1;
	}

	public String getPassword1(){
		return password1;
	}

	public void setPassword2(String password2){
		this.password2 = password2;
	}

	public String getPassword2(){
		return password2;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setSite(String site){
		this.site = site;
	}

	public String getSite(){
		return site;
	}

	public void setYahooid(String yahooid){
		this.yahooid = yahooid;
	}

	public String getYahooid(){
		return yahooid;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	public String getBirthday(){
		return birthday;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
