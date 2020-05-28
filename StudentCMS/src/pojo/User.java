package pojo;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String sex;
	private Date birthday;

	public User() {
	}

	public User(int id, String name, String sex, Date birthday) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}

	public User(int id) {
		this.id = id;
	}

	public User(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "编号：\t" + this.getId() + "\t姓名：\t" + this.getName() + "\t性别：\t" + this.getSex() + "\t出生日期：" + this.getBirthday();
	}
}
