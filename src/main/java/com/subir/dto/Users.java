package com.subir.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class Users{
    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private int userId;
    @Column(name="USER_NAME")
    private String userName;
    @Temporal(TemporalType.DATE)
    @Column(name="JOINED_DATE")
    private Date joinedDate;
    @Lob
    @Column(name="USER_DESCRIPTION")
    private String description;
    @ElementCollection
    @JoinTable(name="USER_ADDRESS",joinColumns = @JoinColumn(name="USER_ID"))
    @GenericGenerator(name="sequence",strategy = "increment")
//    @GeneratedValue(generator = "sequence", strategy= GenerationType.TABLE)
    @CollectionId(columns = {@Column(name="ADDRESS_ID")},generator = "sequence", type = @Type(type="long"))
    private Collection<Address> listOfAddress = new ArrayList<>();

    @Transient
    private String instanceDesc;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstanceDesc() {
        return instanceDesc;
    }

    public void setInstanceDesc(String instanceDesc) {
        this.instanceDesc = instanceDesc;
    }

    public Collection<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Collection<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", joinedDate=" + joinedDate +
                ", description='" + description + '\'' +
                ", listOfAddress=" + listOfAddress +
                ", instanceDesc='" + instanceDesc + '\'' +
                '}';
    }
}
