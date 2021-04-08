package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import java.util.List;

public interface MissionInterface {

    void setOwner(Quim quim);
    Quim getOwner();

    void setHelper(Quim quim);
    Quim getHelper();

    void setDescription(String description);
    String getDescription();

    void setStatus(MissionStatus missionStatus);
    MissionStatus getStatus();

    void addSkill(Skill skill);
    List<Skill> getSkills();

    void setLocation(Location location);
    Location getLocation();

}
