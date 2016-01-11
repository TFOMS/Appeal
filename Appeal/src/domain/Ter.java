package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_TER")
public class Ter {
	
	private int terId;	
	private String terName;	
	
	public Ter() {
		this.terId = 0;
	}	
	
	public Ter(String ter, int terId) {
		this.terName = ter;
		this.terId = terId;
	}	
	
	@Id
	@Column(name="TER_ID")
	public int getTerId() {
		return terId;
	}
	
	@Column(name="TER")
	public String getTerName(){
		return terName;
	}
	
	public void setTerId(int i){
		this.terId = i;		
	}
	
	public void setTerName(String s){
		this.terName = s;
	}	
	
}