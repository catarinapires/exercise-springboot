package com.example.ManagementEOS.developer;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Ticket {
    @NonNull
    @Id
    private int id;
    @NonNull
    private String description;
    @OneToOne
    private Developer devAssigned;
    private boolean finished;


    public Ticket(int id, @NonNull String description, Developer devAssigned, boolean finished) {
        this.id = id;
        this.description = description;
        this.devAssigned = devAssigned;
        this.finished = finished;
    }

    public Ticket(int id, @NonNull String description) {
        this.id = id;
        this.description = description;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public Developer getDevAssigned() {
        return devAssigned;
    }

    public void setDevAssigned(Developer devAssigned) {
        this.devAssigned = devAssigned;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", devAssigned=" + devAssigned +
                ", finished=" + finished +
                '}';
    }
}
