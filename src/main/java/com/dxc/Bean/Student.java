package com.dxc.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private String sid;
	
	@Column(name = "sname")
	private String sname;
	
	@Column(name = "saddr")
	private String saddr;

	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getSaddr() {
		return saddr;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	
	@Override
	public String toString() {
		return "id: " + sid + "\t|\tname: " + sname + "\t|\taddress: " + saddr;
	}
}
