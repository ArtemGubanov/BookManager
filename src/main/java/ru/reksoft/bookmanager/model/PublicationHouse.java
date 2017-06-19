package ru.reksoft.bookmanager.model;

import javax.persistence.*;
import java.util.List;

/**
 * Издательство
 * <p>
 * Created by agubanov on 13.06.2017.
 */
@Entity
@Table(name = "PUBLICATION_HOUSE")
public class PublicationHouse {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PUBLICATION_HOUSE_NAME")
    private String publicationHouseName;

    @Column(name = "PUBLICATION_HOUSE_PLACE")
    private String publicationHousePlace;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publicationHouse")
    private List<Book> publicationHouseBooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublicationHouseName() {
        return publicationHouseName;
    }

    public void setPublicationHouseName(String publicationHouseName) {
        this.publicationHouseName = publicationHouseName;
    }

    public String getPublicationHousePlace() {
        return publicationHousePlace;
    }

    public void setPublicationHousePlace(String publicationHousePlace) {
        this.publicationHousePlace = publicationHousePlace;
    }

    public List<Book> getPublicationHouseBooks() {
        return publicationHouseBooks;
    }

    public void setPublicationHouseBooks(List<Book> publicationHouseBooks) {
        this.publicationHouseBooks = publicationHouseBooks;
    }

    @Override
    public String toString() {
        return "PublicationHouse{" +
                "id=" + id +
                ", publicationHouseName='" + publicationHouseName + '\'' +
                ", publicationHousePlace='" + publicationHousePlace + '\'' +
                '}';
    }
}
