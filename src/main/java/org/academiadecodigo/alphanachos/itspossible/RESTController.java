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
        Quim quim = new Quim();
        quim.setEmail("paulo@mail.com");
        quim.setPhone("903094887");
        quim.setName("João");
        quim.setAboutMe("Strong, confident, a winner!");
        quim.addSkill(Skill.HANDYMAN);
        quim.setLocation(Location.LISBON);

        Quim quim1 = new Quim();
        quim1.setAboutMe("QuimBé");
        quim1.setEmail("KinsRule");
        quim1.setPhone("9090110");
        quim1.setLocation(Location.OPORTO);
        quim1.setName("Pablo");
        quim1.addSkill(Skill.TECHNOLOGY);

        Quim quim2 = new Quim();
        quim2.setAboutMe("Strange Man");
        quim2.setEmail("meman.merman");
        quim2.setPhone("9133113");
        quim2.setLocation(Location.LISBON);
        quim2.setName("RUI");


        Mission mission = new Mission();
        Mission mission1 = new Mission();
        Mission mission2 = new Mission();
        mission.setLocation(Location.OPORTO);
        mission.setDescription("Help me dumb");
        mission.setSkill(Skill.ERRANDS);
        mission.setDate(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));
        quim1.createRequestMission(mission);
        mission1.setLocation(Location.LISBON);
        mission1.setDescription("Please Help is needed");
        mission1.setSkill(Skill.CARE);
        mission1.setDate(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));
        quim2.createRequestMission(mission1);

        quimService.saveOrUpdate(quim);
        quimService.saveOrUpdate(quim2);
        quimService.saveOrUpdate(quim1);

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
        if(quimService.getQuimByID(id).getRequestMission() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        quimService.createMission(dtoToMission.convert(mission), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/quim/{id}")
    public ResponseEntity<QuimDto> getCustomer(@PathVariable Integer id){

        return new ResponseEntity<>(quimToDto.convert(quimService.getQuimByID(id)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim/{id}/executeMission")
    public ResponseEntity<?> executeMission (@PathVariable Integer id){
        quimService.executeMission(id);
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
        quimService.requestMission(qid, mid);

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
