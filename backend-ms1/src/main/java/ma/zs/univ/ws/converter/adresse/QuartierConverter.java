package  ma.zs.univ.ws.converter.adresse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.adresse.Quartier;
import ma.zs.univ.ws.dto.adresse.QuartierDto;

@Component
public class QuartierConverter extends AbstractConverter<Quartier, QuartierDto> {


    public  QuartierConverter() {
        super(Quartier.class, QuartierDto.class);
    }

    @Override
    public Quartier toItem(QuartierDto dto) {
        if (dto == null) {
            return null;
        } else {
        Quartier item = new Quartier();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public QuartierDto toDto(Quartier item) {
        if (item == null) {
            return null;
        } else {
            QuartierDto dto = new QuartierDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
