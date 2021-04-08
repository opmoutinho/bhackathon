package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import org.academiadecodigo.alphanachos.itspossible.exception.AlreadyHasMissionException;
import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;

import java.util.List;
import java.util.Set;

public interface QuimInterface {

    /**
     * Executes the current mission and adds current mission to executed missions history
     */
    void executeMission() throws NoMissionToExecuteException;
    List<MissionInterface> getExecutedMissionHistory();


    void setMissionToExecute(MissionInterface mission) throws AlreadyHasMissionException;
    MissionInterface getCurrentMission();


    /**
     *  Opens a request for other quins to respond
     */
    void createRequestMission(MissionInterface mission) throws AlreadyHasMissionException;
    MissionInterface getRequestMission();


    void addSkill(Skill skill);
    void removeSkill(Skill skill);
    Set<Skill> getSkills();


    void setAboutMe(String aboutMe);
    String getAboutMe();


    void setLocation(Location location);
    Location getLocation();

    void setName(String name);
    String getName();

    void completeMissionRequest() throws NoMissionToExecuteException;

}
