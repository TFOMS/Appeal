package domain;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ReportParams {
	
	@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}", message="Дата начала отчета должна быть в формате дд.мм.гггг")
	@NotEmpty(message="Поле \"Дата начала отчета\" обязательно для заполнения")
	private String dateBegin;
	@Pattern(regexp = "(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}", message="Дата окончания отчета должна быть в формате дд.мм.гггг")
	@NotEmpty(message="Поле \"Дата окончания отчета\" обязательно для заполнения")
    private String dateEnd;
    private boolean clinic;
    private boolean eachMedicalOrg;
    private String insurcomp;
    
    public String getInsurcomp() {
		return insurcomp;
	}

	public void setInsurcomp(String insurcomp) {
		this.insurcomp = insurcomp;
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

	public boolean isClinic() {
		return clinic;
	}

	public void setClinic(boolean clinic) {
		this.clinic = clinic;
	}

	public boolean isEachMedicalOrg() {
		return eachMedicalOrg;
	}

	public void setEachMedicalOrg(boolean eachMedicalOrg) {
		this.eachMedicalOrg = eachMedicalOrg;
	}
	
}