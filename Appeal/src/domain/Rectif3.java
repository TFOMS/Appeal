package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_RECTIF3")
public class Rectif3 {
	
	private int rectif3Id;	
	private String rectif3Name;	
	
	public Rectif3() {
		this.rectif3Id = 0;
	}	
	
	public Rectif3(String rectif3, int rectif3Id) {
		this.rectif3Name = rectif3;
		this.rectif3Id = rectif3Id;
	}	
	
	@Id
	@Column(name="RECTIF3_ID")
	public int getRectif3Id() {
		return rectif3Id;
	}
	
	@Column(name="RECTIF3")
	public String getRectif3Name(){
		return rectif3Name;
	}
	
	public void setRectif3Id(int i){
		this.rectif3Id = i;		
	}
	
	public void setRectif3Name(String s){
		this.rectif3Name = s;
	}	
	
}