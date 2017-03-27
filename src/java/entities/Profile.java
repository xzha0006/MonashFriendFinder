/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xuanzhang
 */
@Entity
@Table(name = "PROFILE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findByStudentId", query = "SELECT p FROM Profile p WHERE p.studentId = :studentId")
    , @NamedQuery(name = "Profile.findByFirstName", query = "SELECT p FROM Profile p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Profile.findByLastName", query = "SELECT p FROM Profile p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Profile.findByDateOfBirth", query = "SELECT p FROM Profile p WHERE p.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Profile.findByGender", query = "SELECT p FROM Profile p WHERE p.gender = :gender")
    , @NamedQuery(name = "Profile.findByCourse", query = "SELECT p FROM Profile p WHERE p.course = :course")
    , @NamedQuery(name = "Profile.findByStudyMode", query = "SELECT p FROM Profile p WHERE p.studyMode = :studyMode")
    , @NamedQuery(name = "Profile.findByAddress", query = "SELECT p FROM Profile p WHERE p.address = :address")
    , @NamedQuery(name = "Profile.findBySuburb", query = "SELECT p FROM Profile p WHERE p.suburb = :suburb")
    , @NamedQuery(name = "Profile.findByNationality", query = "SELECT p FROM Profile p WHERE p.nationality = :nationality")
    , @NamedQuery(name = "Profile.findByNativeLanguage", query = "SELECT p FROM Profile p WHERE p.nativeLanguage = :nativeLanguage")
    , @NamedQuery(name = "Profile.findByFavouriteSport", query = "SELECT p FROM Profile p WHERE p.favouriteSport = :favouriteSport")
    , @NamedQuery(name = "Profile.findByFavouriteMovie", query = "SELECT p FROM Profile p WHERE p.favouriteMovie = :favouriteMovie")
    , @NamedQuery(name = "Profile.findByFavouriteUnit", query = "SELECT p FROM Profile p WHERE p.favouriteUnit = :favouriteUnit")
    , @NamedQuery(name = "Profile.findByCurrentJob", query = "SELECT p FROM Profile p WHERE p.currentJob = :currentJob")
    , @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email")
    , @NamedQuery(name = "Profile.findBySubscriptionDatetime", query = "SELECT p FROM Profile p WHERE p.subscriptionDatetime = :subscriptionDatetime")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "STUDENT_ID")
    private Integer studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "GENDER")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "COURSE")
    private String course;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "STUDY_MODE")
    private String studyMode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SUBURB")
    private String suburb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NATIVE_LANGUAGE")
    private String nativeLanguage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "FAVOURITE_SPORT")
    private String favouriteSport;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "FAVOURITE_MOVIE")
    private String favouriteMovie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "FAVOURITE_UNIT")
    private String favouriteUnit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CURRENT_JOB")
    private String currentJob;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SUBSCRIPTION_DATETIME")
    private String subscriptionDatetime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<Location> locationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentTwoId")
    private Collection<Friendship> friendshipCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentOneId")
    private Collection<Friendship> friendshipCollection1;

    public Profile() {
    }

    public Profile(Integer studentId) {
        this.studentId = studentId;
    }

    public Profile(Integer studentId, String firstName, String lastName, String dateOfBirth, String gender, String course, String studyMode, String address, String suburb, String nationality, String nativeLanguage, String favouriteSport, String favouriteMovie, String favouriteUnit, String currentJob, String email, String subscriptionDatetime) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.course = course;
        this.studyMode = studyMode;
        this.address = address;
        this.suburb = suburb;
        this.nationality = nationality;
        this.nativeLanguage = nativeLanguage;
        this.favouriteSport = favouriteSport;
        this.favouriteMovie = favouriteMovie;
        this.favouriteUnit = favouriteUnit;
        this.currentJob = currentJob;
        this.email = email;
        this.subscriptionDatetime = subscriptionDatetime;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getFavouriteSport() {
        return favouriteSport;
    }

    public void setFavouriteSport(String favouriteSport) {
        this.favouriteSport = favouriteSport;
    }

    public String getFavouriteMovie() {
        return favouriteMovie;
    }

    public void setFavouriteMovie(String favouriteMovie) {
        this.favouriteMovie = favouriteMovie;
    }

    public String getFavouriteUnit() {
        return favouriteUnit;
    }

    public void setFavouriteUnit(String favouriteUnit) {
        this.favouriteUnit = favouriteUnit;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubscriptionDatetime() {
        return subscriptionDatetime;
    }

    public void setSubscriptionDatetime(String subscriptionDatetime) {
        this.subscriptionDatetime = subscriptionDatetime;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @XmlTransient
    public Collection<Friendship> getFriendshipCollection() {
        return friendshipCollection;
    }

    public void setFriendshipCollection(Collection<Friendship> friendshipCollection) {
        this.friendshipCollection = friendshipCollection;
    }

    @XmlTransient
    public Collection<Friendship> getFriendshipCollection1() {
        return friendshipCollection1;
    }

    public void setFriendshipCollection1(Collection<Friendship> friendshipCollection1) {
        this.friendshipCollection1 = friendshipCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Profile[ studentId=" + studentId + " ]";
    }
    
}
