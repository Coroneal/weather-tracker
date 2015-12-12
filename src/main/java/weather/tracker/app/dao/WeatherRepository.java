package weather.tracker.app.dao;

import weather.tracker.app.model.Weather;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepository {

    private static final Logger LOGGER = Logger.getLogger(WeatherRepository.class);

    @PersistenceContext
    EntityManager em;

    /**
     * counts the matching meals, given the bellow criteria
     * @return -  a list of matching meals, or an empty collection if no match found
     */
    public Integer avgTemperature() {

        Query query = em.createQuery("select avg(w.temperature) from Weather w");
        Object avg = query.getSingleResult();

        //        CriteriaBuilder cb = em.getCriteriaBuilder();
        //        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        //        Root<Weather> avgRoot = cq.from(Weather.class);
        //
        //        Expression avgExpression = cb.min(avgRoot.get("temperature"));
        //        CriteriaQuery<Integer> select = cq.select(avgExpression);
        //
        //        Integer resultsAvg = em.createQuery(select).getSingleResult();
        //
        //        LOGGER.info("Found " + resultsAvg + " avg.");
        LOGGER.info("Found " + (Integer) avg + " avg.");

        return (Integer) avg;
    }

    public List<Weather> getWeathers() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        // the actual search query that returns one page of results
        CriteriaQuery<Weather> searchQuery = cb.createQuery(Weather.class);
        Root<Weather> searchRoot = searchQuery.from(Weather.class);
        searchQuery.select(searchRoot);
        TypedQuery<Weather> filterQuery = em.createQuery(searchQuery)
                .setMaxResults(100);

        List<Weather> resultList = filterQuery.getResultList();
        return resultList;
    }
}
