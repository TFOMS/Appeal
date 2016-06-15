package domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;







import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "T_BLOCK_OUTBOUNDMESS")
public class blOutboindLETTER2016 {

	private Integer idletter;
	
	private Petit petit;
	
	public blOutboindLETTER2016() {
	}
	
	//Дата промежуточного ответа
	private String date_between;
	//Дата запроса мед.документации
	private String date_querymedDoc;
	//Дата передачи мед.документации в ОМЭР
	private String date_passmedDoc;
	//Дата получения Актов МЭ
	private String date_obtainAkt;
	//Дата окончательного ответа
	private String date_response;  
	//Номер исходящего письма
	private String numOutLetter;
	//Ответственный
	private String responsible;
	
	
	private List<Outboundmany> many;
	

	@GenericGenerator(name = "genoutletter", strategy = "foreign", parameters = @Parameter(name = "property", value = "petit"))
	@Id
	@GeneratedValue(generator = "genoutletter")
	@Column(name="ID_OUTLETTER")
	public Integer getIdletter() {
		return idletter;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	//@JsonIgnore
	public Petit getPetit() {
		return petit;
	}

	public void setIdletter(Integer idletter) {
		this.idletter = idletter;
	}



	public String getDate_between() {
		return date_between;
	}



	public void setDate_between(String date_between) {
		this.date_between = date_between;
	}



	public String getDate_querymedDoc() {
		return date_querymedDoc;
	}



	public void setDate_querymedDoc(String date_querymedDoc) {
		this.date_querymedDoc = date_querymedDoc;
	}



	public String getDate_passmedDoc() {
		return date_passmedDoc;
	}



	public void setDate_passmedDoc(String date_passmedDoc) {
		this.date_passmedDoc = date_passmedDoc;
	}



	public String getDate_obtainAkt() {
		return date_obtainAkt;
	}



	public void setDate_obtainAkt(String date_obtainAkt) {
		this.date_obtainAkt = date_obtainAkt;
	}



	public String getDate_response() {
		return date_response;
	}



	public void setDate_response(String date_response) {
		this.date_response = date_response;
	}



	public String getNumOutLetter() {
		return numOutLetter;
	}



	public void setNumOutLetter(String numOutLetter) {
		this.numOutLetter = numOutLetter;
	}



	public String getResponsible() {
		return responsible;
	}



	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}



	public void setPetit(Petit petit) {
		this.petit = petit;
	}



/*	@Override
	public String toString() {
		return "blOutboindLETTER2016 [idletter=" + idletter + ", "
				+ "date_between=" + date_between
				+ ", date_querymedDoc=" + date_querymedDoc
				+ ", date_passmedDoc=" + date_passmedDoc + ", date_obtainAkt="
				+ date_obtainAkt + ", date_response=" + date_response
				+ ", numOutLetter=" + numOutLetter + ", responsible="
				+ responsible + "]";
	}*/

	@OneToMany(mappedBy="bloutboindletter2016", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@ElementCollection(targetClass=Outboundmany.class)
	@Column(name = "TEST")
	@JsonIgnore
	public List<Outboundmany> getMany() {
		return many;
	}

	public void setMany(List<Outboundmany> many) {
		this.many = many;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("blOutboindLETTER2016 [idletter=");
		builder.append(idletter);
		//builder.append(", petit=");
		//builder.append(petit);
		builder.append(", date_between=");
		builder.append(date_between);
		builder.append(", date_querymedDoc=");
		builder.append(date_querymedDoc);
		builder.append(", date_passmedDoc=");
		builder.append(date_passmedDoc);
		builder.append(", date_obtainAkt=");
		builder.append(date_obtainAkt);
		builder.append(", date_response=");
		builder.append(date_response);
		builder.append(", numOutLetter=");
		builder.append(numOutLetter);
		builder.append(", responsible=");
		builder.append(responsible);
		builder.append(", many=");
		builder.append(many);
		builder.append("]");
		return builder.toString();
	}

	


	
}
