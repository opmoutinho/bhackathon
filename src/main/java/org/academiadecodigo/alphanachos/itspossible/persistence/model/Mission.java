package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    private Quim owner;

    @OneToOne(fetch = FetchType.LAZY)
    private Quim helper;

    private String description;
    private MissionStatus status;
    @Enumerated(EnumType.STRING)
    private Skill skill;
    private Location location;
    private String date;


    public void setOwner(Quim quim) {
        owner = quim;
    }

    public Quim getOwner() {
        return owner;
    }

    public void setHelper(Quim quim) {
        helper = quim;
    }

    public Quim getHelper() {
        return helper;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(MissionStatus missionStatus) {
        status = missionStatus;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
