package org.academiadecodigo.alphanachos.itspossible.command;

import org.academiadecodigo.alphanachos.itspossible.converters.QuimToDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.MissionStatus;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Skill;

public class MissionDto {

    private Integer id;
    private QuimDto owner;
    private QuimDto helper;
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

    public QuimDto getOwner() {
        return owner;
    }

    public void setOwner(QuimDto owner) {
        this.owner = owner;
    }

    public QuimDto getHelper() {
        return helper;
    }

    public void setHelper(QuimDto helper) {
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
