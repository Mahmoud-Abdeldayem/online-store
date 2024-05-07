package com.estore.users.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {


    @Id
    @Column(name = "customer_id")
    private Long customerId;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private User user;
    @Column(name = "phone_no")
    private String phoneNumer;
    private String address;
    private Date RegistrationDate;



    public CustomerDetails() {

    }

    public CustomerDetails(String phoneNumer, String address, Date registrationDate) {

        this.phoneNumer = phoneNumer;
        this.address = address;
        RegistrationDate = registrationDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setPhoneNumer(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public String getPhoneNumer() {
        return phoneNumer;
    }

    public String getAddress() {
        return address;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }



    public void setPhoneNum(String phoneNumer) {
        this.phoneNumer = phoneNumer;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegistrationDate(Date registrationDate) {
        RegistrationDate = registrationDate;
    }

}
