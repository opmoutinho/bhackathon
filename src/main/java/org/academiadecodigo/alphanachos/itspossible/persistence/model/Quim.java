package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import org.academiadecodigo.alphanachos.itspossible.exception.AlreadyHasMissionException;
import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;

import javax.persistence.*;
import java.util.*;

@Entity
@Table("quim")
public class Quim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String phone;
    private String name;
    private String aboutMe;
    private Location location;

    @ElementCollection(targetClass = Skill.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "quim_skill",
            joinColumns = @JoinColumn(name = "quim_id"))
    private Set<Skill> skills;

    @OneToOne
    private Mission missionToExecute;

    @OneToOne
    private Mission missionRequest;

    @OneToMany
    private List<Mission> executedMissionHistory;

    @OneToMany
    private List<Mission> requestedMissionHistory;

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
        missionToExecute = null;
    }


    public List<Mission> getExecutedMissionHistory() {
        return executedMissionHistory;
    }


    public void setMissionToExecute(Mission mission) throws AlreadyHasMissionException {
        if(missionToExecute != null){
            throw new AlreadyHasMissionException();
        }
        missionToExecute = mission;
        missionToExecute.setHelper(this);
        missionToExecute.setStatus(MissionStatus.IN_PROGRESS);
    }

    public Mission getCurrentMission() {
        return missionToExecute;
    }

    public void createRequestMission(Mission mission) throws AlreadyHasMissionException {
        if(missionRequest != null)
            throw new AlreadyHasMissionException();
        missionRequest = mission;
        mission.setStatus(MissionStatus.OPEN);
        mission.setLocation(location);
        mission.setOwner(this);
    }

    public Mission getRequestMission() {
        return missionRequest;
    }


    public void completeMissionRequest() throws NoMissionToExecuteException {
        if (missionRequest == null)
            throw new NoMissionToExecuteException();
        requestedMissionHistory.add(missionRequest);
        missionRequest = null;
    }


    public void addSkill(Skill skill) {
        skills.add(skill);
    }


    public void removeSkill(Skill skill) {
        skills.remove(skill);
    }


    public Set<Skill> getSkills() {
        return skills;
    }


    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }


    public String getAboutMe() {
        return aboutMe;
    }


    public void setLocation(Location location) {
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
