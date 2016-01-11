package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_TYPE")
public class Type {
	
	private int typeId;	
	private String typeName;	
	
	public Type() {
		this.typeId = 0;
	}	
	
	public Type(String type, int typeId) {
		this.typeName = type;
		this.typeId = typeId;
	}	
	
	@Id
	@Column(name="TYPE_ID")
	public int getTypeId() {
		return typeId;
	}
	
	@Column(name="TYPE")
	public String getTypeName(){
		return typeName;
	}
	
	public void setTypeId(int i){
		this.typeId = i;		
	}
	
	public void setTypeName(String s){
		this.typeName = s;
	}	
	
}