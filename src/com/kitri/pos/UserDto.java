package com.kitri.pos;

public class UserDto {
	
	private String user_code; // À¯ÀúÄÚµå
	private String pw; // ÆÐœº¿öµå
	private String id; // ŸÆÀÌµð
	private String authority; // ±ÇÇÑ
	private String name; // ÀÌž§

	public String getUserCode() {
		return user_code;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserCode(String string) {
		this.user_code = string;
	}

	public void setId(String id) {
		this.id = id;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}