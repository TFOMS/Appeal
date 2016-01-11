package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_INSUR")
public class Insur {
	
	private int insurId;	
	private String insurName;	
	
	public Insur() {
		this.insurId = 0;
	}	
	
	public Insur(String insur, int insurId) {
		this.insurName = insur;
		this.insurId = insurId;
	}	
	
	@Id
	@Column(name="INSUR_ID")
	public int getInsurId() {
		return insurId;
	}
	
	@Column(name="INSUR")
	public String getInsurName(){
		return insurName;
	}
	
	public void setInsurId(int i){
		this.insurId = i;		
	}
	
	public void setInsurName(String s){
		this.insurName = s;
	}	
	
}