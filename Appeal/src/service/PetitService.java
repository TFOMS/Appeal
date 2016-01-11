package service;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jasperreports.engine.JRException;
import domain.CauseL;
import domain.ReportParams;
import domain.Petit;
import domain.Rectif1L;
import domain.Rectif2L;
import domain.Rectif3L;
import domain.Rectif4L;
import domain.TypeL;

public interface PetitService {

    public void addPetit(Petit petit);

    public List<Petit> listPetit(String username);

    public void removePetit(Integer id);

	Set<TypeL> findAllTypes();

	Set<CauseL> findCausesForTypes(int stateName);

	Set<Rectif1L> findRectifs1ForCauses(int causeName);

	Set<Rectif2L> findRectifs2ForRectifs1(int rectif1Name);
	
	Set<Rectif3L> findRectifs3ForRectifs2(int rectif2Name);

	Set<Rectif4L> findRectifs4ForRectifs3(int rectif3Name);

	void setSearchParams(Petit petit);
	
	public List<Petit> listSearch(String username) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException;
	
	public void pgForm(ReportParams dateReport, String username) throws SQLException, ClassNotFoundException, JRException;

	public Petit getPetit(Integer petitId);
	
	public void reportAppealPay(ReportParams dateReport, String username) throws SQLException, ClassNotFoundException, JRException;

	public void reportConsultOther(ReportParams dateReport) throws SQLException, ClassNotFoundException, JRException;

	public void reportCountDetail(ReportParams dateReport) throws SQLException, ClassNotFoundException, JRException;
	
	public Map<Integer, TypeL> getTypes();

	public Map<Integer, CauseL> getCauses();
	
	public Map<Integer, Rectif1L> getRectifs1();

	public Map<Integer, Rectif2L> getRectifs2();

	public Map<Integer, Rectif3L> getRectifs3();

}