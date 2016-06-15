package domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "T_BLOCK_OUTBOUNDMESS_MANY")
public class Outboundmany {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="ID_lettermany")
	private Integer idlettermany;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "T_BLOCK_OUTBOUNDMESS_ID", referencedColumnName="ID_OUTLETTER")
    @JsonIgnore
	private blOutboindLETTER2016 bloutboindletter2016;
	
	//Дата дополнительного запроса/ответа
	private String date_subquery;
	//Пояснение
	private String note;
	public Integer getIdlettermany() {
		return idlettermany;
	}
	public void setIdlettermany(Integer idlettermany) {
		this.idlettermany = idlettermany;
	}
	public blOutboindLETTER2016 getBloutboindletter2016() {
		return bloutboindletter2016;
	}
	public void setBloutboindletter2016(blOutboindLETTER2016 bloutboindletter2016) {
		this.bloutboindletter2016 = bloutboindletter2016;
	}
	public String getDate_subquery() {
		return date_subquery;
	}
	public void setDate_subquery(String date_subquery) {
		this.date_subquery = date_subquery;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Outboundmany [idlettermany=");
		builder.append(idlettermany);
		//builder.append(", bloutboindletter2016=");
		//builder.append(bloutboindletter2016);
		builder.append(", date_subquery=");
		builder.append(date_subquery);
		builder.append(", note=");
		builder.append(note);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
