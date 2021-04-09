package org.academiadecodigo.alphanachos.itspossible.command;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.MissionStatus;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Skill;

import java.util.Date;

public class MissionDto {

    private Integer id;
    private Integer ownerId;
    private Integer helperId;
    private String description;
    private MissionStatus status;
    private Skill skill;
    private Location location;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwner() {
        return ownerId;
    }

    public void setOwner(Integer owner) {
        this.ownerId = owner;
    }

    public Integer getHelper() {
        return helperId;
    }

    public void setHelper(Integer helper) {
        this.helperId = helper;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public void setStatus(MissionStatus status) {
        this.status = status;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
