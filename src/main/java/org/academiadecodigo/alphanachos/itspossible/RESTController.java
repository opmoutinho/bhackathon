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

import java.util.List;

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
        quim.setName("Me");
        quim.setAboutMe("Whatever");
        quim.setLocation(Location.FARO);
        quim.setEmail("abc.abc");
        quim.setPhone("909090");
        Quim quim1 = new Quim();
        quim1.setAboutMe("LLALALALA");
        quim1.setEmail("lolol.lolol");
        quim1.setPhone("9090110");
        quim1.setLocation(Location.OPORTO);
        quim1.setName("Pablo");
        Quim quim2 = new Quim();
        quim2.setAboutMe("Strange");
        quim2.setEmail("meman.merman");
        quim2.setPhone("9133113");
        quim2.setLocation(Location.LISBON);
        quim2.setName("RUI");


        Mission mission = new Mission();
        Mission mission1 = new Mission();
        Mission mission2 = new Mission();
        mission.setLocation(Location.OPORTO);
        mission.setOwner(quim1);
        mission.setDescription("Help me dumb");
        mission.setSkill(Skill.ERRANDS);
        quim1.createRequestMission(mission);

        quimService.saveOrUpdate(quim);
        quimService.saveOrUpdate(quim2);
        quimService.saveOrUpdate(quim1);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/quim")
    public ResponseEntity<List<QuimDto>> list(){

        return new ResponseEntity<>(quimToDto.convertList(quimService.list()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim/{id}")
    public ResponseEntity<?> createRequest(@PathVariable Integer id, @RequestBody MissionDto mission){
        quimService.createMission(dtoToMission.convert(mission), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "api/quim/{id}")
    public ResponseEntity<QuimDto> getCustomer(@PathVariable Integer id){

        return new ResponseEntity<>(quimToDto.convert(quimService.getQuimByID(id)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim/{id}/executeMission")
    public ResponseEntity<?> executeMission (@PathVariable Integer id){
        quimService.getQuimByID(id).executeMission();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "api/quim/{id}")
    public ResponseEntity<?> editQuim(@PathVariable Integer id, @RequestBody QuimDto dto){
        dto.hashCode();
        dtoToQuim.hashCode();
        dto.setId(id);
        quimService.saveOrUpdate(dtoToQuim.convert(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = {"api/missions/","api/missions"})
    public ResponseEntity<List<MissionDto>> getMissions(){
        List<MissionDto>activeMissions = missionToDto.convertList(quimService.listActiveMissions());

        return new ResponseEntity<>(activeMissions, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "api/quim/{id}/requestmission")
    public ResponseEntity<?> requestMission(Integer qid, Integer mid) {
        quimService.requestMission(qid, mid);

       return new ResponseEntity<>(HttpStatus.OK);
    }

}
