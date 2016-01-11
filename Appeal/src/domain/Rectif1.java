package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_RECTIF1")
public class Rectif1 {
	
	private int rectif1Id;	
	private String rectif1Name;	
	
	public Rectif1() {
		this.rectif1Id = 0;
	}	
	
	public Rectif1(String rectif1, int rectif1Id) {
		this.rectif1Name = rectif1;
		this.rectif1Id = rectif1Id;
	}	
	
	@Id
	@Column(name="RECTIF1_ID")
	public int getRectif1Id() {
		return rectif1Id;
	}
	
	@Column(name="RECTIF1")
	public String getRectif1Name(){
		return rectif1Name;
	}
	
	public void setRectif1Id(int i){
		this.rectif1Id = i;		
	}
	
	public void setRectif1Name(String s){
		this.rectif1Name = s;
	}	
	
}