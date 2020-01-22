package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    WhiskyRepositoryCustom whiskyRepositoryCustom;

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> banana(String name, int year){
        List<Whisky> result=null;
        Session session = entityManager.unwrap(Session.class);

        Criteria criteria = session.createCriteria(Whisky.class);
        criteria.createAlias("distilleries","dist");
        criteria.add(Restrictions.eq("dist.name",name));
        criteria.add(Restrictions.eq("dist.year",year));

        result=criteria.list();


        return result;

    }

}
