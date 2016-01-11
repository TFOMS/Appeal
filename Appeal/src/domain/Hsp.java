package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_HSP")
public class Hsp {
	
	private int hspId;	
	private String hspName;	
	
	public Hsp() {
		this.hspId = 0;
	}	
	
	public Hsp(String s, int i) {
		this.hspName = s;
		this.hspId = i;
	}	
	
	@Id
	@Column(name="HSP_ID")
	public int getHspId() {
		return hspId;
	}
	
	@Column(name="HSP")
	public String getHspName() {
		return hspName;
	}
	
	public void setHspId(int i) {
		this.hspId = i;		
	}
	
	public void setHspName(String s) {
		this.hspName = s;
	}	
	
}