package com.subir.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails{
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

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street",column = @Column(name="HOME_STREET_NAME")),
            @AttributeOverride(name="city",column = @Column(name="HOME_CITY_NAME")),
            @AttributeOverride(name="state",column = @Column(name="HOME_STATE")),
            @AttributeOverride(name="pincode",column = @Column(name="HOME_PIN_CODE"))
    })
    private Address homeAddress;
    @Embedded
    private Address officeAddress;
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
}
