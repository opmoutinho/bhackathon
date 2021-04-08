package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import org.academiadecodigo.alphanachos.itspossible.exception.AlreadyHasMissionException;
import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;

import java.util.*;

public class Quim implements QuimInterface{

    private Integer id;
    private MissionInterface missionToExecute;
    private MissionInterface missionRequest;
    private List<MissionInterface> executedMissionHistory;
    private List<MissionInterface> requestedMissionHistory;
    private String name;
    private Location location;
    private String aboutMe;
    private Set<Skill> skills;

    public Quim(){
        executedMissionHistory = new LinkedList<>();
        requestedMissionHistory = new LinkedList<>();
        skills = new LinkedHashSet<>();
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void executeMission() throws NoMissionToExecuteException{
        if(missionToExecute == null){
            throw new NoMissionToExecuteException();
        }
        missionToExecute.setStatus(MissionStatus.COMPLETED);
        missionToExecute.getOwner().completeMissionRequest();
        executedMissionHistory.add(missionToExecute);
    }

    @Override
    public List<MissionInterface> getExecutedMissionHistory() {
        return executedMissionHistory;
    }

    @Override
    public void setMissionToExecute(MissionInterface mission) throws AlreadyHasMissionException {
        if(missionToExecute != null){
            throw new AlreadyHasMissionException();
        }
        missionToExecute = mission;
        missionToExecute.setHelper(this);
        missionToExecute.setStatus(MissionStatus.IN_PROGRESS);
    }

    @Override
    public MissionInterface getCurrentMission() {
        return missionToExecute;
    }

    @Override
    public void createRequestMission(MissionInterface mission) throws AlreadyHasMissionException {
        if(missionRequest != null)
            throw new AlreadyHasMissionException();
        missionRequest = mission;
        mission.setStatus(MissionStatus.OPEN);
        mission.setLocation(location);
        mission.setOwner(this);
    }

    @Override
    public MissionInterface getRequestMission() {
        return missionRequest;
    }

    public void completeMissionRequest() throws NoMissionToExecuteException {
        if(missionRequest == null)
            throw new NoMissionToExecuteException();
        requestedMissionHistory.add(missionRequest);
        missionRequest = null;
    }

    @Override
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    @Override
    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }

    @Override
    public Set<Skill> getSkills() {
        return skills;
    }

    @Override
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public String getAboutMe() {
        return aboutMe;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
