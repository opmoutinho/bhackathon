package org.academiadecodigo.alphanachos.itspossible;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
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
@RequestMapping("/api/customer")
public class RESTController {

    private QuimServiceInterface quimService;

    @Autowired
    public void setQuimService(QuimService quimService) {
        this.quimService = quimService;
    }

    @RequestMapping(value = {"/",""})
    public ResponseEntity<List<Quim>> getCustomerList() {
        List<Quim> result = quimService.list();

        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
