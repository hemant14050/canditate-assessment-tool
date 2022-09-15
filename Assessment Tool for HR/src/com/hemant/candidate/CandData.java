package com.hemant.candidate;

public class CandData 
{
	static String name;
	static int candid;

	public static int getCandid() {
		return candid;
	}

	public static void setCandid(int candid) {
		CandData.candid = candid;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		CandData.name = name;
	}
	
}
