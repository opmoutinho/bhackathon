package org.academiadecodigo.alphanachos.itspossible;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Skill;
import org.academiadecodigo.alphanachos.itspossible.services.QuimService;
import org.academiadecodigo.alphanachos.itspossible.services.QuimServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class RESTController {

    private QuimServiceInterface quimService;

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

    @RequestMapping(value = "api/customer/")
    public ResponseEntity<List<Quim>> list(){
        return new ResponseEntity<>(quimService.list(), HttpStatus.OK);
    }


}
