package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_MO")
public class Mo {
	
	private int moId;	
	private String moName;
	private String mocode;
	
	@Column(name="MO_CODE")
	public String getMocode() {
		return mocode;
	}

	public void setMocode(String mocode) {
		this.mocode = mocode;
	}

	public Mo() {
		this.moId = 0;
	}	
	
	public Mo(String mo, int moId) {
		this.moName = mo;
		this.moId = moId;
	}	
	
	@Id
	@Column(name="MO_ID")
	public int getMoId() {
		return moId;
	}
	
	@Column(name="MO")
	public String getMoName(){
		return moName;
	}
	
	public void setMoId(int i){
		this.moId = i;		
	}
	
	public void setMoName(String s){
		this.moName = s;
	}	
	
}