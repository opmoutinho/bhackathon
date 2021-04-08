package org.academiadecodigo.alphanachos.itspossible.persistence.model;


public interface MissionInterface {

    void setOwner(QuimInterface quim);
    QuimInterface getOwner();

    void setHelper(QuimInterface quim);
    QuimInterface getHelper();

    void setDescription(String description);
    String getDescription();

    void setStatus(MissionStatus missionStatus);
    MissionStatus getStatus();

    void setSkill(Skill skill);
    Skill getSkill();

    void setLocation(Location location);
    Location getLocation();

}
