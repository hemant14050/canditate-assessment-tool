package com.hemant.hr;

public class HrData 
{
	static int id;
	static String name;
	static String email;
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		HrData.id = id;
	}
	public static String getName() {
		return name;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		HrData.email = email;
	}
	public static void setName(String name) {
		HrData.name = name;
	}
}
