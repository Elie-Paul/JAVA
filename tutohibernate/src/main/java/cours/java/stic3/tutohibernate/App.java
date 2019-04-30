package cours.java.stic3.tutohibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import cours.java.stic3.model.User;
import cours.java.stic3.service.Utils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session = Utils.buildSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
       CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class); 
        criteriaQuery.from(User.class);
    }
}
