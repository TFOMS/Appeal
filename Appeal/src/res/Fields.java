package res;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;


public class Fields {
	
	public  static Map<String, String> getfirsttfoms() {
		return getPropertiesStr("D:\\Appeals3\\Appeal\\res\\listfortfoms.txt");
	}
	public  static Map<String, String> getfirstingos() {
		return getPropertiesStr("D:\\Appeals3\\Appeal\\res\\listforingos.txt");
	}
	
	public  static Map<String, String> getfirstsimaz() {
		return getPropertiesStr("D:\\Appeals3\\Appeal\\res\\listforsimaz.txt");
	}
	
	public  static Map<String, String> getfirstrosno() {
		return getPropertiesStr("D:\\Appeals3\\Appeal\\res\\listforrosno.txt");
	}
	
	public  static Map<String, String> getProperties() {
		return getPropertiesStr("D:\\Appeals3\\Appeal\\res\\listforger.txt");
	}
	
	public static Map<Integer, String> getSource() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\source.txt");
	}
	
	public static Map<Integer, String> getPresent() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\present.txt");
	}
	
	public static Map<Integer, String> getPresentforFL() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\presentforfl.txt");
	}
	
	public static Map<Integer, String> getConect() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\conect.txt");
	}
	
	public static Map<Integer, String> getConectforFL() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\conectforfl.txt");
	}
	
	public static Map<Integer, String> getIntermed() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\intermed.txt");
	}
	
	public static Map<Integer, String> getType() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\type.txt");
	}
	
	public static Map<Integer, String> getTer() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\ter.txt");
	}
	
	public static Map<Integer, String> getMo() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\mo.txt");
	}
	
	public static Map<Integer, String> getInsur() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\insur.txt");
	}
	
	public static Map<Integer, String> getPlace() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\place.txt");
	}
	
	public static Map<Integer, String> getValid() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\valid.txt");
	}
	
	public static Map<Integer, String> getHsp() {
		return getProperties("D:\\Appeals3\\Appeal\\res\\hsp.txt");
	}

	private static Map<Integer, String> getProperties(String filename) {
		Properties prop = new Properties();
		Map<Integer, String> map = new TreeMap<Integer, String>(
					new Comparator<Integer>() {
		 
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
		 
				});
		try {
		    InputStream stream = new FileInputStream(new File(filename));
		    InputStreamReader  reader = new InputStreamReader(stream,"UTF-8");
			prop.load(reader);

			Enumeration e = prop.keys();
			while(e.hasMoreElements()) {
				String key = (String)e.nextElement();
				map.put(Integer.parseInt(key), prop.getProperty(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	private static Map<String, String> getPropertiesStr(String filename) {
		Properties prop = new Properties();
		Map<String, String> map = new TreeMap<String, String>();
		
		try {
		    InputStream stream = new FileInputStream(new File(filename));
		    InputStreamReader  reader = new InputStreamReader(stream,"UTF-8");
			prop.load(reader);

			Enumeration e = prop.keys();
			while(e.hasMoreElements()) {
				String key = (String)e.nextElement();
				map.put(prop.getProperty(key), prop.getProperty(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return map;
	}

	
}
