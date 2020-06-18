/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

 
public class user {
    private int id;
    private String email_canonical;
    private String password;
    private String username;
    private int phoneNumber;
    private Date birthDate;
    private String city;
    private String address;
    private int zipCode;
    private int status;
    private String roles;
    private int desactivate;
    private int code;
    private String image;
    private int nbRaiting;
    private int warning;
    private String claims;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", email_canonical=" + email_canonical + ", password=" + password + ", username=" + username + ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", city=" + city + ", address=" + address + ", zipCode=" + zipCode + ", status=" + status + ", roles=" + roles + ", desactivate=" + desactivate + ", code=" + code + ", image=" + image + ", nbRaiting=" + nbRaiting + ", warning=" + warning + ", claims=" + claims + '}';
    }

    public user() {
    }

    public user(int id, String email_canonical, String password, String username, int phoneNumber, Date birthDate, String city, String address, int zipCode, int status, String roles, int desactivate, int code, String image, int nbRaiting, int warning, String claims) {
        this.id = id;
        this.email_canonical = email_canonical;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.status = status;
        this.roles = roles;
        this.desactivate = desactivate;
        this.code = code;
        this.image = image;
        this.nbRaiting = nbRaiting;
        this.warning = warning;
        this.claims = claims;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getDesactivate() {
        return desactivate;
    }

    public void setDesactivate(int desactivate) {
        this.desactivate = desactivate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNbRaiting() {
        return nbRaiting;
    }

    public void setNbRaiting(int nbRaiting) {
        this.nbRaiting = nbRaiting;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public String getClaims() {
        return claims;
    }

    public void setClaims(String claims) {
        this.claims = claims;
    }
    
}
