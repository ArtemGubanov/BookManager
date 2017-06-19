package ru.reksoft.bookmanager.dao;

import ru.reksoft.bookmanager.model.PublicationHouse;

import java.util.List;

/**
 * Created by agubanov on 13.06.2017.
 */
public interface IPublicationHouseDao {

    public void addPublicationHouse(PublicationHouse book);

    public void updatePublicationHouse(PublicationHouse book);

    public  void  removePublicationHouse(int id);

    public PublicationHouse getPublicationHouseId(int id);

    public List<PublicationHouse> listPublicationHouse();
}
