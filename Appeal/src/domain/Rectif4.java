package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_RECTIF4")
public class Rectif4 {
	
	private int rectif4Id;	
	private String rectif4Name;	
	
	public Rectif4() {
		this.rectif4Id = 0;
	}	
	
	public Rectif4(String rectif4, int rectif4Id) {
		this.rectif4Name = rectif4;
		this.rectif4Id = rectif4Id;
	}	
	
	@Id
	@Column(name="RECTIF4_ID")
	public int getRectif4Id() {
		return rectif4Id;
	}
	
	@Column(name="RECTIF4")
	public String getRectif4Name(){
		return rectif4Name;
	}
	
	public void setRectif4Id(int i){
		this.rectif4Id = i;		
	}
	
	public void setRectif4Name(String s){
		this.rectif4Name = s;
	}	
	
}