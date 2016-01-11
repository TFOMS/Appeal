package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PRESENT")
public class Present {
	
	private int presentId;	
	private String presentName;	
	
	public Present() {
		this.presentId = 0;
	}	
	
	public Present(String present, int presentId) {
		this.presentName = present;
		this.presentId = presentId;
	}	
	
	@Id
	@Column(name="PRESENT_ID")
	public int getPresentId() {
		return presentId;
	}
	
	@Column(name="PRESENT")
	public String getPresentName(){
		return presentName;
	}
	
	public void setPresentId(int i){
		this.presentId = i;		
	}
	
	public void setPresentName(String s){
		this.presentName = s;
	}	
	
}