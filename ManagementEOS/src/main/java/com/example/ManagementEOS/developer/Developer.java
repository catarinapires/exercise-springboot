package com.example.ManagementEOS.developer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Developer {
    @Id
    private int idDev;
    @NonNull
    private String name;
    @NonNull
    private String jobDescription;
    @NonNull
    private String email;
    // tickets

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "devAssigned")
    @JsonBackReference // prevent loop
    private List<Ticket> tickets;

    @Transient
    List<String> typesDeveloper;

    public void generateTypesOfDeveloper(){
        typesDeveloper = new ArrayList<>();
        typesDeveloper.add("Backend Developer");
        typesDeveloper.add("Frontend Developer");
        typesDeveloper.add("DevOps");
        typesDeveloper.add("QA");
    }

    public Developer() {
        generateTypesOfDeveloper();
    }

    public Developer(int idDev, @NonNull String name, @NonNull String jobDescription, @NonNull String email, List<Ticket> tickets) {
        this.idDev = idDev;
        this.name = name;
        this.jobDescription = jobDescription;
        this.email = email;
        this.tickets = tickets;
        generateTypesOfDeveloper();


    }

    public Developer(int idDev, @NonNull String name, @NonNull String jobDescription, @NonNull String email) {
        this.idDev = idDev;
        this.name = name;
        this.jobDescription = jobDescription;
        this.email = email;
        generateTypesOfDeveloper();
    }

    public int getIdDev() {
        return idDev;
    }

    public void setIdDev(int idDev) {
        this.idDev = idDev;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(@NonNull String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "idDev=" + idDev +
                ", name='" + name + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", email='" + email + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
