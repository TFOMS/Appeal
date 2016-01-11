package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_VALID")
public class Valid {
	
	private int validId;	
	private String validName;	
	
	public Valid() {
		this.validId = 0;
	}	
	
	public Valid(String valid, int validId) {
		this.validName = valid;
		this.validId = validId;
	}	
	
	@Id
	@Column(name="VALID_ID")
	public int getValidId() {
		return validId;
	}
	
	@Column(name="VALID")
	public String getValidName(){
		return validName;
	}
	
	public void setValidId(int i){
		this.validId = i;		
	}
	
	public void setValidName(String s){
		this.validName = s;
	}	
	
}