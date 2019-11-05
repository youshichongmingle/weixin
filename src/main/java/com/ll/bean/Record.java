package com.ll.bean;

public class Record {
	private String Recordid;
	private String Recordthings;
	public String getRecordid() {
		return Recordid;
	}
	public void setRecordid(String recordid) {
		Recordid = recordid;
	}
	public String getRecordthings() {
		return Recordthings;
	}
	public void setRecordthings(String recordthings) {
		Recordthings = recordthings;
	}
	public Record(String recordid, String recordthings) {
		super();
		Recordid = recordid;
		Recordthings = recordthings;
	}
	
	public Record() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "时间是"+Recordid+"事情"+Recordthings;
	}
	
}
