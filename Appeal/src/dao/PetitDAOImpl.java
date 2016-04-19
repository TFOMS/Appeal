package dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.Petit;

@Repository
public class PetitDAOImpl implements PetitDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public void addPetit(Petit petit) {
        sessionFactory.getCurrentSession().saveOrUpdate(petit);
    }

    @SuppressWarnings("unchecked")
    public List<Petit> listPetit(String username) {
    	Query query = sessionFactory.getCurrentSession().createQuery(
    			"from Petit where username = :username and to_char(date_input, 'yyyy')>=to_char(sysdate, 'yyyy')  order by substr(num,0,2) desc,to_number(substr(num,4)) desc");
    			//"from Petit where username = :username  order by substr(num,0,2) desc,to_number(substr(num,4)) desc");
        query.setParameter("username", username);
        return query.list();
    }

    public void removePetit(Integer id) {
    	Petit petit = (Petit) sessionFactory.getCurrentSession().load(
    			Petit.class, id);
        if (null != petit) {
            sessionFactory.getCurrentSession().delete(petit);
        }
    }
    
    @SuppressWarnings("unchecked")
	public List<Petit> listSearch(Petit petit, String username) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    	
    	Criteria criteria =  sessionFactory.getCurrentSession().createCriteria(Petit.class);

    	Method[] methods = Petit.class.getMethods();
    	for (Method method : methods) {
    		if (isGetter(method)) {
    			
        		if(method.invoke(petit) != null && !"".equals(method.invoke(petit)) && !"getClass".equals(method.getName()) 
        				&& !"0".equals(method.invoke(petit).toString())
        				&& !"getDateBegin".equals(method.getName()) && !"getDateEnd".equals(method.getName())) {
        			String fieldName = method.getName().replaceAll("get", "").substring(0, 1);
        			fieldName = fieldName.toLowerCase().concat(method.getName().replaceAll("get", "").substring(1));
        			
        			criteria.add(Restrictions.eq(fieldName, method.invoke(petit)));
        		}
   		   	}
   	   	}

    	Pattern p = Pattern.compile("(0[1-9]|1[0-9]|2[0-9]|3[01]).(0[1-9]|1[012]).[0-9]{4}");
    	if(p.matcher(petit.getDateBegin()).matches()) {
    		criteria.add(Restrictions.ge("dateInput", petit.getDateBegin()));
    	}
    	if(p.matcher(petit.getDateEnd()).matches()) {
    		criteria.add(Restrictions.le("dateInput", petit.getDateEnd()));
    	}
    	
    	if(username.equals("smo_simaz") || username.equals("smo_rosno") || username.equals("smo_ingos")) {
    		criteria.add(Restrictions.eq("username", username));
    	}
    	
    	criteria.addOrder(Order.desc("dateInput"));
    	
    	criteria.setMaxResults(10000);

    	return criteria.list();
    }
    
    public static boolean isGetter(Method method) {
    	if (Modifier.isPublic(method.getModifiers()) && method.getParameterTypes().length == 0) {
    		if (method.getName().matches("^get[A-Z].*") && !method.getReturnType().equals(void.class)) return true;
    	}
    	return false;
   	}

	public Petit getPetit(Integer petitId) {
	 	Petit petit = (Petit) sessionFactory.getCurrentSession().get(Petit.class, petitId);
    	
	 	if(petit.getDateInput() !=null)
		petit.setDateInput(petit.getDateInput().substring(8, 10) + "." + petit.getDateInput().substring(5, 7) + "." + petit.getDateInput().substring(0, 4));
	 	//petit.getBlockger2016().setDate_close(petit.getBlockger2016().getDate_close().substring(8, 10) + "."+petit.getBlockger2016().getDate_close().substring(5, 7) + "."+petit.getBlockger2016().getDate_close().substring(0, 4));
	 	
		return petit;
	}
}