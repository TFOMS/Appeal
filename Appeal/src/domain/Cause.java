package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_CAUSE")
public class Cause {
	
	private int causeId;	
	private String causeName;	
	
	public Cause() {
		this.causeId = 0;
	}	
	
	public Cause(String cause, int causeId) {
		this.causeName = cause;
		this.causeId = causeId;
	}	
	
	@Id
	@Column(name="CAUSE_ID")
	public int getCauseId() {
		return causeId;
	}
	
	@Column(name="CAUSE")
	public String getCauseName(){
		return causeName;
	}
	
	public void setCauseId(int i){
		this.causeId = i;		
	}
	
	public void setCauseName(String s){
		this.causeName = s;
	}	
	
}