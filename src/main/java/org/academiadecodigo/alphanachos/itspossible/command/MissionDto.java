package org.academiadecodigo.alphanachos.itspossible.command;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.MissionStatus;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.QuimInterface;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Skill;

public class MissionDto {

    private Integer id;
    private QuimInterface owner;
    private QuimInterface helper;
    private String description;
    private MissionStatus status;
    private Skill skill;
    private Location location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuimInterface getOwner() {
        return owner;
    }

    public void setOwner(QuimInterface owner) {
        this.owner = owner;
    }

    public QuimInterface getHelper() {
        return helper;
    }

    public void setHelper(QuimInterface helper) {
        this.helper = helper;
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
}
