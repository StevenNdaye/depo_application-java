package com.depot.app.model;

import com.sun.istack.internal.NotNull;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by steven on 2014/08/01.
 */
@Entity
@Table(name = "feedback")
public class Feedback {
    private Long id;

    @NotNull
    @Length(min = 1, max = 100)
    private String fullName;

    @NotNull
    @Length(min = 1, max = 100)
    @Email
    private String email;

    @NotNull
    @Length(min = 1, max = 4000)
    private String comments;
    private Date date;

    public Feedback() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "date_created")
    public Date getDate() {
        return date;
    }

    public String toString(){
        return new ToStringBuilder(this)
                .append("fullName", fullName)
                .append("email", email)
                .append("comments", comments)
                .append("dateCreated", date)
                .toString();
    }
}
