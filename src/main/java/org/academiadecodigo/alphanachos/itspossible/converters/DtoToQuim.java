package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.QuimDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.academiadecodigo.alphanachos.itspossible.services.QuimService;

public class DtoToQuim {

    private QuimService quimService;

    public void setQuimService(QuimService quimService) {
        this.quimService = quimService;
    }

    /*public Quim convert(QuimDto quimDto) {

        Quim quim = quimDto.getId() != null ?
                        quimService.get(quimDto.getId()) :
                        new Quim();

        quim.setEmail(quimDto.getEmail());
        quim.setAboutMe(quimDto.getAboutMe());
        quim.setPhone(quimDto.getPhone());
        quim.setName(quimDto.getName());
        quim.setLocation(quimDto.getLocation());
        quim.setSkills(quimDto.getSkills());

        return quim;
    }*/

}
