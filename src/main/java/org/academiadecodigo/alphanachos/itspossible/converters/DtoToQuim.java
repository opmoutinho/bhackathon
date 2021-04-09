package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.QuimDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.academiadecodigo.alphanachos.itspossible.services.QuimService;
import org.academiadecodigo.alphanachos.itspossible.services.QuimServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoToQuim {

    private QuimServiceInterface quimService;

    @Autowired
    public void setQuimService(QuimServiceInterface quimService) {
        this.quimService = quimService;
    }

    public Quim convert(QuimDto quimDto) {

        Quim quim = quimDto.getId() != null ?
                        quimService.getQuimByID(quimDto.getId()) :
                        new Quim();
        if(quimDto.getEmail() == null)
            return null;
        quim.setEmail(quimDto.getEmail());
        quim.setAboutMe(quimDto.getAboutMe());
        quim.setPhone(quimDto.getPhone());
        quim.setName(quimDto.getName());
        quim.setLocation(quimDto.getLocation());
        quim.setSkills(quimDto.getSkills());

        return quim;
    }

}
