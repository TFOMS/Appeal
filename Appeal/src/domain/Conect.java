package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_CONECT")
public class Conect {
	
	private int conectId;	
	private String conectName;	
	
	public Conect() {
		this.conectId = 0;
	}	
	
	public Conect(String conect, int conectId) {
		this.conectName = conect;
		this.conectId = conectId;
	}	
	
	@Id
	@Column(name="CONECT_ID")
	public int getConectId() {
		return conectId;
	}
	
	@Column(name="CONECT")
	public String getConectName(){
		return conectName;
	}
	
	public void setConectId(int i){
		this.conectId = i;		
	}
	
	public void setConectName(String s){
		this.conectName = s;
	}	
	
}