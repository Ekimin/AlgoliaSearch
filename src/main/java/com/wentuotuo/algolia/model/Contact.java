package com.wentuotuo.algolia.model;

/**
 * Created by Ekimin on 2017/3/1.
 * AlgoliaSearch
 */
public class Contact {
    private String firstname;
    private String lastname;
    private int followers;
    private String company;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
