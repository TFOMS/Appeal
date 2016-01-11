package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_SOURCE")
public class Source {
	
	private int sourceId;	
	private String sourceName;	
	
	public Source() {
		this.sourceId = 0;
	}	
	
	public Source(String source, int sourceId) {
		this.sourceName = source;
		this.sourceId = sourceId;
	}	
	
	@Id
	@Column(name="SOURCE_ID")
	public int getSourceId() {
		return sourceId;
	}
	
	@Column(name="SOURCE")
	public String getSourceName(){
		return sourceName;
	}
	
	public void setSourceId(int i){
		this.sourceId = i;		
	}
	
	public void setSourceName(String s){
		this.sourceName = s;
	}	
	
}