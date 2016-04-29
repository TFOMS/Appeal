package service;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRTextElement;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.Appeal;
import dao.PetitDAO;
import domain.CauseL;
import domain.Petit;
import domain.Rectif1L;
import domain.Rectif2L;
import domain.Rectif3L;
import domain.Rectif4L;
import domain.ReportParams;
import domain.TypeL;
 
@Service
public class PetitServiceImpl implements PetitService {
 
    @Autowired
    private PetitDAO petitDAO;
 
    @Transactional
    public void addPetit(Petit petit) {
    	petitDAO.addPetit(petit);
    }
 
    @Transactional
    public List<Petit> listPetit(String username) {
        return petitDAO.listPetit(username);
    }
 
    @Transactional
    public void removePetit(Integer id) {
    	petitDAO.removePetit(id);
    }
    
    private Map<Integer, TypeL> types = new LinkedHashMap<Integer, TypeL>();
    private Map<Integer, CauseL> causes = new LinkedHashMap<Integer, CauseL>();
    private Map<Integer, Rectif1L> rectifs1 = new LinkedHashMap<Integer, Rectif1L>();
    private Map<Integer, Rectif2L> rectifs2 = new LinkedHashMap<Integer, Rectif2L>();
    private Map<Integer, Rectif3L> rectifs3 = new LinkedHashMap<Integer, Rectif3L>();
    
	public PetitServiceImpl() {
		this.types = Appeal.fieldsDepends.types;
		this.causes = Appeal.fieldsDepends.causes;
		this.rectifs1 = Appeal.fieldsDepends.rectifs1;
		this.rectifs2 = Appeal.fieldsDepends.rectifs2;
		this.rectifs3 = Appeal.fieldsDepends.rectifs3;
	}
	
	public Map<Integer, TypeL> getTypes() {
		return types;
	}

	public Map<Integer, CauseL> getCauses() {
		return causes;
	}

	public Map<Integer, Rectif1L> getRectifs1() {
		return rectifs1;
	}

	public Map<Integer, Rectif2L> getRectifs2() {
		return rectifs2;
	}

	public Map<Integer, Rectif3L> getRectifs3() {
		return rectifs3;
	}

	@Override
	public Set<TypeL> findAllTypes() {
		Set<TypeL> set = new TreeSet<TypeL>();
		set.addAll(this.types.values());
		return set;
	}
	
	@Override
	public Set<CauseL> findCausesForTypes(int typeName) {
		Set<CauseL> nullSet = new HashSet<CauseL>();
		nullSet.add(new CauseL("-", 0));
		
		TypeL type = this.types.get(typeName);
		return type != null ? type.getCauses() : nullSet;
	}
	
	@Override
	public Set<Rectif1L> findRectifs1ForCauses(int causeName) {
		Set<Rectif1L> nullSet = new HashSet<Rectif1L>();
		nullSet.add(new Rectif1L("-", 0));
		
		CauseL cause = this.causes.get(causeName);

		return cause != null ? cause.getRectifs1() : nullSet;
	}
	
	@Override
	public Set<Rectif2L> findRectifs2ForRectifs1(int rectif1Name) {
		Set<Rectif2L> nullSet = new HashSet<Rectif2L>();
		nullSet.add(new Rectif2L("-", 0));
		
		Rectif1L rectif1 = this.rectifs1.get(rectif1Name);
		return rectif1 != null ? rectif1.getRectifs2() : nullSet;
	}
	
	@Override
	public Set<Rectif3L> findRectifs3ForRectifs2(int rectif2Name) {
		Set<Rectif3L> nullSet = new HashSet<Rectif3L>();
		nullSet.add(new Rectif3L("-", 0));
		
		Rectif2L rectif2 = this.rectifs2.get(rectif2Name);
		return rectif2 != null ? rectif2.getRectifs3() : nullSet;
	}
	
	@Override
	public Set<Rectif4L> findRectifs4ForRectifs3(int rectif3Name) {
		Set<Rectif4L> nullSet = new HashSet<Rectif4L>();
		nullSet.add(new Rectif4L("-", 0));
		
		Rectif3L rectif3 = this.rectifs3.get(rectif3Name);
		return rectif3 != null ? rectif3.getRectifs4() : nullSet;
	}
	
	private Petit petit = new Petit();
	
	@Override
	public void setSearchParams(Petit petit) {
		this.petit = petit;
	}
	
    @Transactional
    public List<Petit> listSearch(String username) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    	
    	List<Petit> lp = petitDAO.listSearch(petit, username);
    	
    	if (lp != null) {
    		return lp;
    	} else {
    		return new ArrayList<Petit>(Arrays.asList(petit));
    	}
    }
    
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void pgForm(ReportParams dateReport, String username) throws SQLException, ClassNotFoundException, JRException {
    	Connection conn = connectForJasper();
		Map mapReport = mapForJasper(dateReport, username);
			
		JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Appeals3\\Appeal\\reports\\pg_form_1_1.jrxml");
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\Appeals3\\Appeal\\reports\\pg_form_1_1.xls"));
		exporter.exportReport();
		
		jasperReport = JasperCompileManager.compileReport("D:\\Appeals3\\Appeal\\reports\\pg_form_1_2.jrxml");
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
		exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\Appeals3\\Appeal\\reports\\pg_form_1_2.xls"));
		exporter.exportReport();
		
		jasperReport = JasperCompileManager.compileReport("D:\\Appeals3\\Appeal\\reports\\pg_form_2_3.jrxml");
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
		exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\Appeals3\\Appeal\\reports\\pg_form_2_3.xls"));
		exporter.exportReport();
		
		jasperReport = JasperCompileManager.compileReport("D:\\Appeals3\\Appeal\\reports\\pg_form_2_1.jrxml");
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
		exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\Appeals3\\Appeal\\reports\\pg_form_2_1.xls"));
		exporter.exportReport();
		
   		disconnectForJasper(conn);
	}

    @Transactional
	public Petit getPetit(Integer petitId) {
    	return petitDAO.getPetit(petitId);
	}
    
    @Transactional
	public void closeAppeal(Integer petitId) {
    	petitDAO.close(petitId);
	}
    
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void reportAppealPay(ReportParams dateReport, String username) throws SQLException, ClassNotFoundException, JRException {
    	
    	Connection conn = connectForJasper();
		Map mapReport = mapForJasper(dateReport, username);
			
		JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Appeals3\\Appeal\\reports\\appeal_pay.jrxml");
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
	
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\Appeals3\\Appeal\\reports\\appeal_pay.xls"));
		exporter.exportReport();
		
   		disconnectForJasper(conn);
	}

    // isDetectCellType()
    // xlsExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, true);
    
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void reportConsultOther(ReportParams dateReport) throws SQLException, ClassNotFoundException, JRException {
	
    	Connection conn = connectForJasper();
		Map mapReport = mapForJasper(dateReport);
		
		JasperReport jasperReport;
		if(dateReport.isClinic()) jasperReport = JasperCompileManager.compileReport("D:\\Appeals3\\Appeal\\reports\\consult_other.jrxml");
		else jasperReport = JasperCompileManager.compileReport("D:\\Appeals3\\Appeal\\reports\\consult_other.jrxml");
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
		
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\Appeals3\\Appeal\\reports\\consult_other.xls"));
		exporter.exportReport();
			
   		disconnectForJasper(conn);
	}
    
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void reportCountDetail(ReportParams dateReport) throws SQLException, ClassNotFoundException, JRException {
	
    	Connection conn = connectForJasper();
		Map mapReport = mapForJasper(dateReport);
		
		String report = "D:\\Appeals3\\Appeal\\reports\\count_detail.jrxml";
		if(dateReport.isClinic()) report = "D:\\Appeals3\\Appeal\\reports\\count_detail_polyclinic.jrxml";
		if(dateReport.isEachMedicalOrg()) report = "D:\\Appeals3\\Appeal\\reports\\count_detail_eachMedicalOrg.jrxml";
		if(dateReport.isClinic() && dateReport.isEachMedicalOrg()) report = "D:\\Appeals3\\Appeal\\reports\\count_detail_polyclinic_eachMedicalOrg.jrxml";
		
		JasperReport jasperReport = JasperCompileManager.compileReport(report);
		jasperReport.setProperty(JRTextElement.PROPERTY_PRINT_KEEP_FULL_TEXT, "true");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mapReport, conn);
		
		JRXlsExporter exporter = new JRXlsExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\Appeals3\\Appeal\\reports\\count_detail.xls"));
		exporter.exportReport();
			
   		disconnectForJasper(conn);
	}

	private void disconnectForJasper(Connection conn) throws SQLException {
		conn.close();
	}

	private Map mapForJasper(ReportParams dateReport, String username) {
		Map mapReport = mapForJasper(dateReport);
		if(username.equals("sasha") ||
				username.equals("mityanina") ||
				username.equals("vasilyeva") ||
				username.equals("popova") ||
				username.equals("eremina") ||
				username.equals("hamitov") ||
				username.equals("filimonova") ||
				username.equals("osipova")) {
			username = "sashamityaninavasilyevapopovaereminahamitovfilimonovaosipovasmo_simazsmo_rosnosmo_ingos";
		}
		mapReport.put("username", username);
		return mapReport;
	}
	
	private Map mapForJasper(ReportParams dateReport) {
		Map mapReport = new HashMap();
		mapReport.put("dateBegin", dateReport.getDateBegin());
		mapReport.put("dateEnd", dateReport.getDateEnd());
		return mapReport;
	}

	private Connection connectForJasper() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("D:\\Appeals3\\Appeal\\WebContent\\WEB-INF\\jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
		
		 // Class.forName(properties.getProperty("jdbc.driverClassName")).newInstance();
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
      	conn = DriverManager.getConnection(
      			properties.getProperty("jdbc.databaseurl"), 
      			properties.getProperty("jdbc.username"), 
      			properties.getProperty("jdbc.password"));
		
		return conn;
	}
}