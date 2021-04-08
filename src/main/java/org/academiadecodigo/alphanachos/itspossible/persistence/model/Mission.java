package org.academiadecodigo.alphanachos.itspossible.persistence.model;

public class Mission implements MissionInterface {

    private Integer id;
    private QuimInterface owner;
    private QuimInterface helper;
    private String description;
    private MissionStatus status;
    private Skill skill;
    private Location location;

    @Override
    public void setOwner(QuimInterface quim) {
        owner = quim;
    }

    @Override
    public QuimInterface getOwner() {
        return owner;
    }

    @Override
    public void setHelper(QuimInterface quim) {
        helper = quim;
    }

    @Override
    public QuimInterface getHelper() {
        return helper;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setStatus(MissionStatus missionStatus) {
        status = missionStatus;
    }

    @Override
    public MissionStatus getStatus() {
        return status;
    }

    @Override
    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public Skill getSkill() {
        return skill;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
