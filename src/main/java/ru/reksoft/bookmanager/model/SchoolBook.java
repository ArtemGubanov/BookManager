package ru.reksoft.bookmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Школьный учебник
 * Created by agubanov on 19.06.2017.
 */
@Entity
@Table(name = "SCHOOLBOOK")
public class SchoolBook extends  Book {

    @Column(name = "SCHOOL_SUBJECT")
    private String schoolSubject;

    @Column(name = "SCHOOL_CLASS")
    private byte schoolClass;

    public String getSchoolSubject() {
        return schoolSubject;
    }

    public void setSchoolSubject(String schoolSubject) {
        this.schoolSubject = schoolSubject;
    }

    public byte getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(byte schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return "SchoolBook{" + super.toString() +
                ", schoolSubject='" + schoolSubject + '\'' +
                ", schoolClass=" + schoolClass +
                '}';
    }
}
