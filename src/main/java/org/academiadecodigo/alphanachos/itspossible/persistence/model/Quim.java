package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import org.academiadecodigo.alphanachos.itspossible.exception.AlreadyHasMissionException;
import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;
import org.graalvm.compiler.nodes.memory.SingleMemoryKill;

import javax.persistence.*;
import java.util.*;

@Entity
public class Quim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String phone;
    private String name;

    @Column(length = 500)
    private String aboutMe;


    @ElementCollection(targetClass = Skill.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "quim_skill",
            joinColumns = @JoinColumn(name = "quim_id"))
    private Set<Skill> skills;

    private Integer missionToExecute;

    private Integer missionRequest;
    public Quim() {
        skills = new LinkedHashSet<>();
    }

    public void executeMission() throws NoMissionToExecuteException {
        if (missionToExecute == null) {
            throw new NoMissionToExecuteException();
        }
        missionToExecute.setStatus(MissionStatus.COMPLETED);
        missionToExecute.getOwner().completeMissionRequest();
        missionToExecute = null;
    }


    public void setMissionToExecute(Mission mission) throws AlreadyHasMissionException {
        if (missionToExecute != null) {
            throw new AlreadyHasMissionException();
        }
        missionToExecute = mission;
        missionToExecute.setHelper(this);
        missionToExecute.setStatus(MissionStatus.IN_PROGRESS);
    }

    public void createRequestMission(Mission mission) throws AlreadyHasMissionException {
        if (missionRequest != null)
            throw new AlreadyHasMissionException();
        missionRequest = mission;
        mission.setStatus(MissionStatus.OPEN);
        mission.setLocation(location);
        mission.setOwner(this);
    }


    public void completeMissionRequest() throws NoMissionToExecuteException {
        if (missionRequest == null)
            throw new NoMissionToExecuteException();
        missionRequest = null;
    }


    public Mission getCurrentMission() {
        return missionToExecute;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Mission getRequestMission() {
        return missionRequest;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private Location location;

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

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
    public void setMissionRequest(Mission missionRequest) {
        this.missionRequest = missionRequest;
    }

}
