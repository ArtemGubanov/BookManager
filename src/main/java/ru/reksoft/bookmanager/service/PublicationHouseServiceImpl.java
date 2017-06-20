package ru.reksoft.bookmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.reksoft.bookmanager.dao.IPublicationHouseDao;
import ru.reksoft.bookmanager.model.PublicationHouse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Сервис издательсвта
 * Created by agubanov on 13.06.2017.
 */
@Service
public class PublicationHouseServiceImpl implements IPublicationHouseService {

    @Autowired
    private IPublicationHouseDao publicationHouseDao;

    @Override
    @Transactional
    public PublicationHouse getPublicationHouseById(int id) {
        return publicationHouseDao.getPublicationHouseId(id);
    }


    @Override
    @Transactional
    public List<PublicationHouse> listPublicationHouses() {
        return publicationHouseDao.listPublicationHouse();
    }

    @Override
    @Transactional
    public Map<Integer, String> publicationHouseMap() {
        List<PublicationHouse> publicationHouseList = publicationHouseDao.listPublicationHouse();
        return publicationHouseList.stream().collect(Collectors.toMap(PublicationHouse::getId,
                PublicationHouse::getPublicationHouseName,  (oldValue, newValue) -> newValue));
    }


}
