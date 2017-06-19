package ru.reksoft.bookmanager.service;

import ru.reksoft.bookmanager.model.PublicationHouse;

import java.util.List;
import java.util.Map;

/**
 * Created by agubanov on 13.06.2017.
 */
public interface IPublicationHouseService {

    public PublicationHouse getPublicationHouseById(int id);

    List<PublicationHouse> listPublicationHouses();

    Map<Integer, String> publicationHouseMap();

}
