package org.academiadecodigo.alphanachos.itspossible;

import org.academiadecodigo.alphanachos.itspossible.services.QuimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/customer")
public class RESTController {

    QuimService quimService;



    @Autowired
    public void setQuimService(QuimService quimService) {
        this.quimService = quimService;
    }


}
