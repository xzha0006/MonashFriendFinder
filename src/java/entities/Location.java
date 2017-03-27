/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xuanzhang
 */
@Entity
@Table(name = "LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId")
    , @NamedQuery(name = "Location.findByStudentId", query = "SELECT l FROM Location l WHERE l.studentId.studentId = :studentId")
    , @NamedQuery(name = "Location.findByLocationName", query = "SELECT l FROM Location l WHERE l.locationName = :locationName")
    , @NamedQuery(name = "Location.findByLatitude", query = "SELECT l FROM Location l WHERE l.latitude = :latitude")
    , @NamedQuery(name = "Location.findByLongitude", query = "SELECT l FROM Location l WHERE l.longitude = :longitude")
    , @NamedQuery(name = "Location.findByDateTime", query = "SELECT l FROM Location l WHERE l.dateTime = :dateTime")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOCATION_ID")
    private Integer locationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "LOCATION_NAME")
    private String locationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "LONGITUDE")
    private String longitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "DATE_TIME")
    private String dateTime;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID")
    @ManyToOne(optional = false)
    private Profile studentId;

    public Location() {
    }

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Location(Integer locationId, String locationName, String latitude, String longitude, String dateTime) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateTime = dateTime;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Profile getStudentId() {
        return studentId;
    }

    public void setStudentId(Profile studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Location[ locationId=" + locationId + " ]";
    }
    
}
