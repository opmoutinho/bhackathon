package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import java.util.List;

public interface QuimInterface {

    /**
     * Executes the current mission and adds current mission to executed missions history
     */
    void executeMission();
    List<Mission> getExecutedMissionHistory();


    void setMissionToExecute(Mission mission);
    Mission getCurrentMission();


    /**
     *  Opens a request for other quins to respond
     */
    void createRequestMission();
    Mission getRequestMission();


    void addSkill(Skill skill);
    void removeSkill(Skill skill);
    List<Skill> getSkills();


    void setAboutMe(String aboutMe);
    String getAboutMe();


    void setLocation(Location location);
    Location getLocation();

}
