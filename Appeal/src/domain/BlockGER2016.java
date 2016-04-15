package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "T_BLOCK_GER")
public class BlockGER2016 {

	
	private Integer idblockger2016;
	
	private Petit petit;
	
	//дата завершения обращения
	private Date date_end;
	// Дата Закрытия обращения
	private String date_close = "15.04.2099";
	// Номер письма (исходящее)
	private String letter_out_num;
	// Дата письма (исходящее)
	private Date letter_out_date;
	
	public BlockGER2016() {
	}

	// Дата изменения редактирования
	private Date date_change;
	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public String getDate_close() {
		return date_close;
	}

	public void setDate_close(String date_close) {
		this.date_close = date_close;
	}

	public String getLetter_out_num() {
		return letter_out_num;
	}

	public void setLetter_out_num(String letter_out_num) {
		this.letter_out_num = letter_out_num;
	}

	public Date getLetter_out_date() {
		return letter_out_date;
	}

	public void setLetter_out_date(Date letter_out_date) {
		this.letter_out_date = letter_out_date;
	}

	public Date getDate_change() {
		return date_change;
	}

	public void setDate_change(Date date_change) {
		this.date_change = date_change;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	/*
	   статус записи
	   1-создан
	   2-в работе
	   3-завершен
	 */
	private int state;
	

	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "petit"))
	@Id
	@GeneratedValue(generator = "gen")
	@Column(name="ID_GER")
	public Integer getIdblockger2016() {
		return idblockger2016;
	}

	

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	//@JsonIgnore
	public Petit getPetit() {
		return petit;
	}

	public void setPetit(Petit petit) {
		this.petit = petit;
	}

	@Override
	public String toString() {
		return "BlockGER2016 [idblockger2016=" + idblockger2016 + ", date_end=" + date_end + ", date_close="
				+ date_close + ", letter_out_num=" + letter_out_num
				+ ", letter_out_date=" + letter_out_date + ", date_change="
				+ date_change + ", state=" + state + "]";
	}

	public void setIdblockger2016(Integer idblockger2016) {
		this.idblockger2016 = idblockger2016;
	}

}
