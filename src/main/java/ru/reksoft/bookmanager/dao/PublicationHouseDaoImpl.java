package ru.reksoft.bookmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.reksoft.bookmanager.model.PublicationHouse;

import java.util.List;

/**
 * Created by agubanov on 13.06.2017.
 */
@Repository
public class PublicationHouseDaoImpl implements IPublicationHouseDao {

    private static final Logger LOG
            = LoggerFactory.getLogger(BookDaoIml.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPublicationHouse(PublicationHouse publicationHouse) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(publicationHouse);
        LOG.info("PublicationHouse succesful saved. PublicationHouse details: " + publicationHouse);
    }

    @Override
    public void updatePublicationHouse(PublicationHouse publicationHouse) {
        Session session = sessionFactory.getCurrentSession();
        session.update(publicationHouse);
        LOG.info("PublicationHouse succesful update. PublicationHouse details: " + publicationHouse);
    }

    @Override
    public void removePublicationHouse(int id) {
        Session session = sessionFactory.getCurrentSession();
        PublicationHouse publicationHouse = (PublicationHouse) session.load(PublicationHouse.class, id);
        if (publicationHouse != null) {
            session.delete(publicationHouse);
            LOG.info("PublicationHouse succesful removed. PublicationHouse details: " + publicationHouse);
        }
        LOG.info("Unsuccessful remove PublicationHouse! PublicationHouse details: " + publicationHouse);
    }

    @Override
    public PublicationHouse getPublicationHouseId(int id) {
        Session session = sessionFactory.getCurrentSession();
        PublicationHouse publicationHouse = (PublicationHouse) session.load(PublicationHouse.class, id);
        LOG.info("PublicationHouse succesful loaded. PublicationHouse details: " + publicationHouse);
        return publicationHouse;
    }

    @Override
    public List<PublicationHouse> listPublicationHouse() {
        Session session = sessionFactory.getCurrentSession();
        List<PublicationHouse> publicationHouseList = session.createQuery("from PublicationHouse").list();
        LOG.info("PublicationHouse list: " + publicationHouseList);
        return publicationHouseList;
    }
}
