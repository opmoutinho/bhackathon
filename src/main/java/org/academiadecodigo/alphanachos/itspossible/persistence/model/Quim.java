package org.academiadecodigo.alphanachos.itspossible.persistence.model;

import org.academiadecodigo.alphanachos.itspossible.exception.AlreadyHasMissionException;
import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
public class Quim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String phone;
    private String name;
    private Integer points;
    private Integer count;
    @Column(length = 500)
    private String aboutMe;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @ElementCollection(targetClass = Skill.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "quim_skill",
            joinColumns = @JoinColumn(name = "quim_id"))
    private Set<Skill> skills;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Mission missionToExecute;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Mission missionRequest;
    public Quim() {
        skills = new LinkedHashSet<>();
        count = 0;
        points = 0;
    }

    public void executeMission(){
        if (missionRequest == null) {
            return;
        }
        missionRequest.setStatus(MissionStatus.COMPLETED);
        if(missionRequest.getHelper() != null)
            missionRequest.getHelper().completeMissionRequest();
        missionRequest = null;
    }


    public void setMissionToExecute(Mission mission){
        if (missionToExecute != null) {
            return;
        }
        missionToExecute = mission;
        missionToExecute.setHelper(this);
        missionToExecute.setStatus(MissionStatus.IN_PROGRESS);
    }

    public void createRequestMission(Mission mission){
        if (missionRequest != null)
            return;
        missionRequest = mission;
        mission.setStatus(MissionStatus.OPEN);
        mission.setLocation(location);
        mission.setOwner(this);
        mission.setDate(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));
    }


    public void completeMissionRequest() {
        if (missionToExecute == null)
            return;
        missionToExecute = null;
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

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
