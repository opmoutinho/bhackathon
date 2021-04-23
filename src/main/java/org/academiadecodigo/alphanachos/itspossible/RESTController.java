package org.academiadecodigo.alphanachos.itspossible;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.command.QuimDto;
import org.academiadecodigo.alphanachos.itspossible.converters.DtoToMission;
import org.academiadecodigo.alphanachos.itspossible.converters.DtoToQuim;
import org.academiadecodigo.alphanachos.itspossible.converters.MissionToDto;
import org.academiadecodigo.alphanachos.itspossible.converters.QuimToDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Skill;
import org.academiadecodigo.alphanachos.itspossible.services.QuimServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class RESTController {

    private QuimServiceInterface quimService;
    private DtoToMission dtoToMission;
    private MissionToDto missionToDto;
    private DtoToQuim dtoToQuim;
    private QuimToDto quimToDto;

    @Autowired
    public void setDtoToMission(DtoToMission dtoToMission){
        this.dtoToMission = dtoToMission;
    }

    @Autowired
    public void setMissionToDto(MissionToDto missionToDto){
        this.missionToDto = missionToDto;
    }

    @Autowired
    public void setDtoToQuim(DtoToQuim dtoToQuim){
        this.dtoToQuim = dtoToQuim;
    }

    @Autowired
    public void setQuimToDto(QuimToDto quimToDto){
        this.quimToDto = quimToDto;
    }

    @Autowired
    public void setQuimService(QuimServiceInterface quimService) {
        this.quimService = quimService;
    }

    @RequestMapping(value = {"/",""})
    public ResponseEntity<?> populate() {

        // Empty DB before repopulate
        /*List<Quim> allQuinsInDB = quimService.list();
        for (Quim quim : allQuinsInDB) {
            quimService.deleteById(quim.getId());
        }*/
        
        Quim quim = new Quim();
        quim.setName("João");
        quim.setEmail("joaopaulo@mail.com");
        quim.setPhone("963094887");
        quim.setAboutMe("Strong, confident, a winner!");
        quim.addSkill(Skill.HANDYMAN);
        quim.setLocation(Location.LISBON);

        Quim quim1 = new Quim();
        quim1.setName("Pablo");
        quim1.setEmail("escobar@gmail.com");
        quim1.setPhone("919011023");
        quim1.setAboutMe("Plata o plomo?");
        quim1.addSkill(Skill.TECHNOLOGY);
        quim1.setLocation(Location.OPORTO);

        Quim quim2 = new Quim();
        quim2.setName("Luis Camões");
        quim2.setEmail("oslusiadas@hotmail.com");
        quim2.setPhone("913311323");
        quim2.setAboutMe("Love is fire that burns in hide");
        quim2.setLocation(Location.LISBON);

        Quim quim3 = new Quim();
        quim3.setName("Eduard");
        quim3.setEmail("smellycat@hotmail.com");
        quim3.setPhone("914477856");
        quim3.setAboutMe("I love to help and am here to do just that!");
        quim3.setLocation(Location.LISBON);

        Quim quim4 = new Quim();
        quim4.setName("Maria Grande");
        quim4.setEmail("mariaaiaiaimaria@gmail.com");
        quim4.setPhone("911376896");
        quim4.setAboutMe("I've spare time you help others");
        quim4.setLocation(Location.LISBON);

        Quim quim6 = new Quim();
        quim6.setName("Arturito");
        quim6.setEmail("arturito@yahoo.com");
        quim6.setPhone("913737373");
        quim6.setAboutMe("Amigo de mi amigo");
        quim6.setLocation(Location.OPORTO);

        Quim quim7 = new Quim();
        quim7.setName("Manuela");
        quim7.setEmail("manuela@hotmail.com");
        quim7.setPhone("214578899");
        quim7.setAboutMe("I join the get free help!");
        quim7.setLocation(Location.OPORTO);


        Mission mission = new Mission();
        mission.setLocation(Location.OPORTO);
        mission.setDescription("I don't understand how anything works. Can someone explain?");
        mission.setSkill(Skill.ERRANDS);
        mission.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        quim1.createRequestMission(mission);

        Mission mission1 = new Mission();
        mission1.setLocation(Location.LISBON);
        mission1.setDescription("Can someone help me change a lightbulb?");
        mission1.setSkill(Skill.CARE);
        mission1.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        quim2.createRequestMission(mission1);

        Mission mission3 = new Mission ();
        mission3.setLocation(Location.LISBON);
        mission3.setDescription("I need help to format my laptop");
        mission3.setSkill(Skill.TECHNOLOGY);
        mission3.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        quim3.createRequestMission(mission3);

        Mission mission4 = new Mission ();
        mission4.setLocation(Location.LISBON);
        mission4.setDescription("I need someone to take care of my grandmother for 1 hour.");
        mission4.setSkill(Skill.CARE);
        mission4.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        quim4.createRequestMission(mission4);

        Mission mission5 = new Mission ();
        mission5.setLocation(Location.FARO);
        mission5.setDescription("I really really need help from someone, I'm in quarantine and I need to buy food!!");
        mission5.setSkill(Skill.TRANSPORT);
        mission5.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        quim1.createRequestMission(mission5);

        Mission mission6 = new Mission ();
        mission6.setLocation(Location.OPORTO);
        mission6.setDescription("HELPPPPPPP! I need to get to the hospital right away!");
        mission6.setSkill(Skill.PLUMBING);
        mission6.setDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        quim6.createRequestMission(mission6);

        List<Quim> list = new ArrayList<>();
        list.add(quim);
        list.add(quim1);
        list.add(quim2);
        list.add(quim3);
        list.add(quim4);
        list.add(quim6);
        list.add(quim7);

        quimService.saveOrUpdate(list);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/quim")
    public ResponseEntity<List<QuimDto>> list(){

        return new ResponseEntity<>(quimToDto.convertList(quimService.list()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim")
    public ResponseEntity<QuimDto> createQuim(@RequestBody QuimDto quimDto){

        quimService.saveOrUpdate(dtoToQuim.convert(quimDto));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value ="api/skills")
    public ResponseEntity<?> listSkills(){

        List<Skill> skillist = Arrays.stream(Skill.values()).collect(Collectors.toList());

        return new ResponseEntity<>(skillist, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim/{id}")
    public ResponseEntity<?> createRequest(@PathVariable Integer id, @RequestBody MissionDto mission){

        if (quimService.getQuimByID(id).getRequestMission() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        quimService.createMission(dtoToMission.convert(mission), id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/quim/{id}")
    public ResponseEntity<QuimDto> getQuim(@PathVariable Integer id){

        return new ResponseEntity<>(quimToDto.convert(quimService.getQuimByID(id)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim/{id}/executeMission/{rating}")
    public ResponseEntity<?> executeMission(@PathVariable Integer id, @PathVariable Integer rating){

        if (rating == -1) {
            quimService.executeMission(id);
        } else {
            quimService.executeMission(id, rating);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "api/quim/{id}")
    public ResponseEntity<?> editQuim(@PathVariable Integer id, @RequestBody QuimDto dto){

        dto.setId(id);
        quimService.saveOrUpdate(dtoToQuim.convert(dto));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"api/missions/","api/missions"})
    public ResponseEntity<List<MissionDto>> getMissions(){

        List<MissionDto>activeMissions = missionToDto.convertList(quimService.listActiveMissions());

        return new ResponseEntity<>(activeMissions, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim/{qid}/requestmission/{mid}")
    public ResponseEntity<?> requestMission(@PathVariable Integer qid, @PathVariable Integer mid) {

        if(quimService.getQuimCurrentMission(qid) != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        quimService.requestMission(mid, qid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/missions/{id}/quim")
    public ResponseEntity<QuimDto> getQuimFromMission(@PathVariable Integer id){

        QuimDto quimDto = quimToDto.convert(quimService.getQuimByMission(id));

        return new ResponseEntity<>(quimDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/missions/{id}")
    public ResponseEntity<MissionDto> getMission(@PathVariable Integer id){

        MissionDto missionDto = missionToDto.convert(quimService.getMissionById(id));

        return new ResponseEntity<>(missionDto, HttpStatus.OK);
    }

}
