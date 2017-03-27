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
@Table(name = "FRIENDSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friendship.findAll", query = "SELECT f FROM Friendship f")
    , @NamedQuery(name = "Friendship.findByFriendshipId", query = "SELECT f FROM Friendship f WHERE f.friendshipId = :friendshipId")
    , @NamedQuery(name = "Friendship.findByStudOneId", query = "SELECT f FROM Friendship f WHERE f.studentOneId.studentId = :studentOneId")
    , @NamedQuery(name = "Friendship.findByStudTwoId", query = "SELECT f FROM Friendship f WHERE f.studentTwoId.studentId = :studentTwoId")
    , @NamedQuery(name = "Friendship.findByStartingDate", query = "SELECT f FROM Friendship f WHERE f.startingDate = :startingDate")
    , @NamedQuery(name = "Friendship.findByEndingDate", query = "SELECT f FROM Friendship f WHERE f.endingDate = :endingDate")})
public class Friendship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FRIENDSHIP_ID")
    private Integer friendshipId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "STARTING_DATE")
    private String startingDate;
    @Size(max = 64)
    @Column(name = "ENDING_DATE")
    private String endingDate;
    @JoinColumn(name = "STUDENT_TWO_ID", referencedColumnName = "STUDENT_ID")
    @ManyToOne(optional = false)
    private Profile studentTwoId;
    @JoinColumn(name = "STUDENT_ONE_ID", referencedColumnName = "STUDENT_ID")
    @ManyToOne(optional = false)
    private Profile studentOneId;

    public Friendship() {
    }

    public Friendship(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public Friendship(Integer friendshipId, String startingDate) {
        this.friendshipId = friendshipId;
        this.startingDate = startingDate;
    }

    public Integer getFriendshipId() {
        return friendshipId;
    }

    public void setFriendshipId(Integer friendshipId) {
        this.friendshipId = friendshipId;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public Profile getStudentTwoId() {
        return studentTwoId;
    }

    public void setStudentTwoId(Profile studentTwoId) {
        this.studentTwoId = studentTwoId;
    }

    public Profile getStudentOneId() {
        return studentOneId;
    }

    public void setStudentOneId(Profile studentOneId) {
        this.studentOneId = studentOneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendshipId != null ? friendshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friendship)) {
            return false;
        }
        Friendship other = (Friendship) object;
        if ((this.friendshipId == null && other.friendshipId != null) || (this.friendshipId != null && !this.friendshipId.equals(other.friendshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Friendship[ friendshipId=" + friendshipId + " ]";
    }
    
}
