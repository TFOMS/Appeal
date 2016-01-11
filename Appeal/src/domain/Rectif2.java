package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_RECTIF2")
public class Rectif2 {
	
	private int rectif2Id;	
	private String rectif2Name;	
	
	public Rectif2() {
		this.rectif2Id = 0;
	}	
	
	public Rectif2(String rectif2, int rectif2Id) {
		this.rectif2Name = rectif2;
		this.rectif2Id = rectif2Id;
	}	
	
	@Id
	@Column(name="RECTIF2_ID")
	public int getRectif2Id() {
		return rectif2Id;
	}
	
	@Column(name="RECTIF2")
	public String getRectif2Name(){
		return rectif2Name;
	}
	
	public void setRectif2Id(int i){
		this.rectif2Id = i;		
	}
	
	public void setRectif2Name(String s){
		this.rectif2Name = s;
	}	
	
}