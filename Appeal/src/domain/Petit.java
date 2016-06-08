package domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "T_PETIT")
public class Petit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
	
	@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}", message="Дата поступления должна быть в формате дд.мм.гггг")
	@Column(name = "DATE_INPUT")
    private String dateInput;
	
    @Column(name = "SOURCE_ID")
    private int sourceId;
    
    @Column(name = "PRESENT_ID")
    private int presentId;
    
    @Column(name = "CONECT_ID")
    private int conectId;
    
    @Column(name = "INTERMED")
    private int intermedId;
    //@Range(min = 1, max = 150, message="Поле Тип обязательно для заполнения")
    @Column(name = "TYPE_ID")
    private int typeId;

	//@NotEmpty(message="Поле \"Имя\" обязательно для заполнения")
    @Column(name = "NAME")
    private String name;
    
	//@NotEmpty(message="Поле \"Фамилия\" обязательно для заполнения")
    @Column(name = "SURNAME")
    private String surname;
    
	//@NotEmpty(message="Поле \"Отчество\" обязательно для заполнения")
    @Column(name = "PATRONY")
    private String patrony;
    
	//@NotEmpty(message="Поле \"Полис\" обязательно для заполнения")
    @Column(name = "POLICY")
    private String policy;
    
	//@NotEmpty(message="Поле \"Телефон\" обязательно для заполнения")
    @Column(name = "TEL")
    private String tel;
    
	//@NotEmpty(message="Поле \"Адрес\" обязательно для заполнения")
    @Column(name = "ADRESS")
    private String adress;
    
    @Column(name = "TER_ID")
    private int terId;
    
    @Column(name = "TER_ANSWER_ID")
    private int terAnswerId;
    
    @Column(name = "LAST1")
    private int last1;
    
    @Column(name = "LAST2")
    private int last2;
    
    @Column(name = "MO_ID")
    private int moId;
    
	@Column(name = "HSP_ID")
    private int hspId;
    
    @Column(name = "INSUR_ID")
    private int insurId;
    
    @Column(name = "PLACE")
    private int placeId;
    
    @Column(name = "USERNAME")
    private String username;
    
    //@Range(min = 1, max = 150, message="Поле Причина обязательно для заполнения")
    @Column(name = "CAUSE_ID")
    private int causeId;
    
    @Column(name = "RECTIF1_ID")
    private int rectif1Id;
    
    @Column(name = "RECTIF2_ID")
    private int rectif2Id;
    
    @Column(name = "RECTIF3_ID")
    private int rectif3Id;
    
    @Column(name = "RECTIF4_ID")
    private int rectif4Id;
    
    @Column(name = "VALID_ID")
    private int validId;
    
    //@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}", message="Дата компенсации должна быть в формате дд.мм.гггг")
	@Column(name = "COMPENS")
    private String compens;// new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    
    @Column(name = "SATISF")
    private String satisf;
    
    @Column(name = "COMPENS_SOURCE")
    private String compensSource;
    
    @Column(name = "COMPENS_CODE")
    private String compensCode;
    
    @Pattern(regexp = "^(\\d|-)?(\\d|,)*\\.?\\d*$", message="Сумма может быть только числом")
    @Size(max = 8, message="Длина суммы не более 8 символов")
    @Column(name = "COMPENS_SUM")
    private String compensSum;
    
    @Column(name = "PROPOS")
    private String propos;
    
    @Column(name = "LETTER_NUM")
    private String letterNum;
    
    @Column(name = "LETTER_DATE")
    private String letterDate;
    
    @Column(name = "DATE_BEGIN")
    private String dateBegin;
    
    @Column(name = "DATE_END")
    private String dateEnd;
    
    @Size(max =501, message="Длина примечания не более 500 символов")
    @Column(name = "CAUSE_NOTE")
    private String causeNote;
    
    @Column(name = "NUM")
    private String num;
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SOURCE_ID", referencedColumnName = "SOURCE_ID", insertable = false, updatable = false)
	private Source source;
	
	public void setSource(Source source) {
		this.source = source;
	}
	
	public Source getSource() {
	        return source;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="PRESENT_ID", referencedColumnName = "PRESENT_ID", insertable = false, updatable = false)
	private Present present;
	
	public void setPresent(Present present) {
		this.present = present;
	}
	
	public Present getPresent() {
	        return present;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CONECT_ID", referencedColumnName = "CONECT_ID", insertable = false, updatable = false)
	private Conect conect;
	
	public void setConect(Conect conect) {
		this.conect = conect;
	}
	
	public Conect getConect() {
	        return conect;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TYPE_ID", referencedColumnName = "TYPE_ID", insertable = false, updatable = false)
	private Type type;
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
	        return type;
	}
	
	@OneToOne(mappedBy="petit",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BlockGER2016 blockger2016;
	@OneToOne(mappedBy="petit",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private blOutboindLETTER2016 bloutboindletter2016;
	
	
    public BlockGER2016 getBlockger2016() {
		return blockger2016;
	}

	public void setBlockger2016(BlockGER2016 blockger2016) {
		this.blockger2016 = blockger2016;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TER_ID", referencedColumnName = "TER_ID", insertable = false, updatable = false)
	private Ter ter;
	
	public void setTer(Ter ter) {
		this.ter = ter;
	}
	
	public Ter getTer() {
	        return ter;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="TER_ANSWER_ID", referencedColumnName = "TER_ID", insertable = false, updatable = false)
	private Ter terAnswer;
	
	public void setTerAnswer(Ter terAnswer) {
		this.terAnswer = terAnswer;
	}
	
	public Ter getTerAnswer() {
	        return terAnswer;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="VALID_ID", referencedColumnName = "VALID_ID", insertable = false, updatable = false)
	private Valid valid;
	
	public void setValid(Valid valid) {
		this.valid = valid;
	}
	
	public Valid getValid() {
	        return valid;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CAUSE_ID", referencedColumnName = "CAUSE_ID", insertable = false, updatable = false)
	private Cause cause;
	
	public void setCause(Cause cause) {
		this.cause = cause;
	}
	
	public Cause getCause() {
	        return cause;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RECTIF1_ID", referencedColumnName = "RECTIF1_ID", insertable = false, updatable = false)
	private Rectif1 rectif1;
	
	public void setRectif1(Rectif1 rectif1) {
		this.rectif1 = rectif1;
	}
	
	public Rectif1 getRectif1() {
	        return rectif1;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RECTIF2_ID", referencedColumnName = "RECTIF2_ID", insertable = false, updatable = false)
	private Rectif2 rectif2;
	
	public void setRectif2(Rectif2 rectif2) {
		this.rectif2 = rectif2;
	}
	
	public Rectif2 getRectif2() {
	        return rectif2;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RECTIF3_ID", referencedColumnName = "RECTIF3_ID", insertable = false, updatable = false)
	private Rectif3 rectif3;
	
	public void setRectif3(Rectif3 rectif3) {
		this.rectif3 = rectif3;
	}
	
	public Rectif3 getRectif3() {
	        return rectif3;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RECTIF4_ID", referencedColumnName = "RECTIF4_ID", insertable = false, updatable = false)
	private Rectif4 rectif4;
	
	public void setRectif4(Rectif4 rectif4) {
		this.rectif4 = rectif4;
	}
	
	public Rectif4 getRectif4() {
	        return rectif4;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="INSUR_ID", referencedColumnName = "INSUR_ID", insertable = false, updatable = false)
	private Insur insur;
	
	public void setInsur(Insur insur) {
		this.insur = insur;
	}
	
	public Insur getInsur() {
	        return insur;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MO_ID", referencedColumnName = "MO_ID", insertable = false, updatable = false)
	private Mo mo;
	
	public void setMo(Mo mo) {
		this.mo = mo;
	}
	
	public Mo getMo() {
	        return mo;
	}
	
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="HSP_ID", referencedColumnName = "HSP_ID", insertable = false, updatable = false)
	private Hsp hsp;
	
	public void setHsp(Hsp hsp) {
		this.hsp = hsp;
	}
	
	public Hsp getHsp() {
	    return hsp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if(this.id == null || this.id == 0) this.id = id;
	}

	public String getDateInput() {
		return dateInput;
	}

	public void setDateInput(String dateInput) {
		this.dateInput = dateInput;
	}

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public int getPresentId() {
		return presentId;
	}

	public void setPresentId(int presentId) {
		this.presentId = presentId;
	}

	public int getConectId() {
		return conectId;
	}

	public void setConectId(int conectId) {
		this.conectId = conectId;
	}

	public int getIntermedId() {
		return intermedId;
	}

	public void setIntermedId(int intermedId) {
		this.intermedId = intermedId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatrony() {
		return patrony;
	}

	public void setPatrony(String patrony) {
		this.patrony = patrony;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getTerId() {
		return terId;
	}

	public void setTerId(int terId) {
		this.terId = terId;
	}

	public int getTerAnswerId() {
		return terAnswerId;
	}

	public void setTerAnswerId(int terAnswerId) {
		this.terAnswerId = terAnswerId;
	}

	public int getLast1() {
		return last1;
	}

	public void setLast1(int last1) {
		this.last1 = last1;
	}

	public int getLast2() {
		return last2;
	}

	public void setLast2(int last2) {
		this.last2 = last2;
	}

	public int getMoId() {
		return moId;
	}

	public void setMoId(int moId) {
		this.moId = moId;
	}
	
    public int getHspId() {
		return hspId;
	}

	public void setHspId(int hspId) {
		this.hspId = hspId;
	}

	public int getInsurId() {
		return insurId;
	}

	public void setInsurId(int insurId) {
		this.insurId = insurId;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCauseId() {
		return causeId;
	}

	public void setCauseId(int causeId) {
		this.causeId = causeId;
	}

	public int getRectif1Id() {
		return rectif1Id;
	}

	public void setRectif1Id(int rectif1) {
		this.rectif1Id = rectif1;
	}

	public int getRectif2Id() {
		return rectif2Id;
	}

	public void setRectif2Id(int rectif2Id) {
		this.rectif2Id = rectif2Id;
	}

	public int getRectif3Id() {
		return rectif3Id;
	}

	public void setRectif3Id(int rectif3Id) {
		this.rectif3Id = rectif3Id;
	}

	public int getRectif4Id() {
		return rectif4Id;
	}

	public void setRectif4Id(int rectif4Id) {
		this.rectif4Id = rectif4Id;
	}

	public int getValidId() {
		return validId;
	}

	public void setValidId(int validId) {
		this.validId = validId;
	}

	public String getCompens() {
		return compens;
	}

	public void setCompens(String compens) {
		this.compens = compens;
	}

	public String getSatisf() {
		return satisf;
	}

	public void setSatisf(String satisf) {
		this.satisf = satisf;
	}

	public String getCompensSource() {
		return compensSource;
	}

	public void setCompensSource(String compensSource) {
		this.compensSource = compensSource;
	}

	public String getCompensCode() {
		return compensCode;
	}

	public void setCompensCode(String compensCode) {
		this.compensCode = compensCode;
	}

	public String getCompensSum() {
		return compensSum;
	}

	public void setCompensSum(String compensSum) {
		this.compensSum = compensSum;
	}

	public String getPropos() {
		return propos;
	}

	public void setPropos(String propos) {
		this.propos = propos;
	}

	public String getLetterNum() {
		return letterNum;
	}

	public void setLetterNum(String letterNum) {
		this.letterNum = letterNum;
	}

	public String getLetterDate() {
		return letterDate;
	}

	public void setLetterDate(String letterDate) {
		this.letterDate = letterDate;
	}

	public String getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getCauseNote() {
		return causeNote;
	}

	public void setCauseNote(String causeNote) {
		this.causeNote = causeNote;
	}
	
    public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Petit [id=" + id + ", dateInput=" + dateInput + ", sourceId="
				+ sourceId + ", presentId=" + presentId + ", conectId="
				+ conectId + ", intermedId=" + intermedId + ", typeId="
				+ typeId + ", name=" + name + ", surname=" + surname
				+ ", patrony=" + patrony + ", policy=" + policy + ", tel="
				+ tel + ", adress=" + adress + ", terId=" + terId
				+ ", terAnswerId=" + terAnswerId + ", last1=" + last1
				+ ", last2=" + last2 + ", moId=" + moId + ", hspId=" + hspId
				+ ", insurId=" + insurId + ", placeId=" + placeId
				+ ", username=" + username + ", causeId=" + causeId
				+ ", rectif1Id=" + rectif1Id + ", rectif2Id=" + rectif2Id
				+ ", rectif3Id=" + rectif3Id + ", rectif4Id=" + rectif4Id
				+ ", validId=" + validId + ", compens=" + compens + ", satisf="
				+ satisf + ", compensSource=" + compensSource
				+ ", compensCode=" + compensCode + ", compensSum=" + compensSum
				+ ", propos=" + propos + ", letterNum=" + letterNum
				+ ", letterDate=" + letterDate + ", dateBegin=" + dateBegin
				+ ", dateEnd=" + dateEnd + ", causeNote=" + causeNote
				+ ", num=" + num + ", source=" + source + ", present="
				+ present + ", conect=" + conect + ", type=" + type
				+ ", blockger2016=" + blockger2016 + ", ter=" + ter
				+ ", terAnswer=" + terAnswer + ", valid=" + valid + ", cause="
				+ cause + ", rectif1=" + rectif1 + ", rectif2=" + rectif2
				+ ",bloutboindletter2016="+ bloutboindletter2016+", rectif3=" + rectif3 + ", rectif4=" + rectif4 + ", insur="
				+ insur + ", mo=" + mo + ", hsp=" + hsp + "]";
	}

	public blOutboindLETTER2016 getBloutboindletter2016() {
		return bloutboindletter2016;
	}

	public void setBloutboindletter2016(blOutboindLETTER2016 bloutboindletter2016) {
		this.bloutboindletter2016 = bloutboindletter2016;
	}
	
}