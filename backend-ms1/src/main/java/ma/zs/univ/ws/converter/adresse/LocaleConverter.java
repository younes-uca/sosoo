package  ma.zs.univ.ws.converter.adresse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.univ.ws.converter.adresse.RueConverter;
import ma.zs.univ.ws.converter.taxe.CategorieLocaleConverter;



import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.adresse.Locale;
import ma.zs.univ.ws.dto.adresse.LocaleDto;

@Component
public class LocaleConverter extends AbstractConverter<Locale, LocaleDto> {

    @Autowired
    private RueConverter rueConverter ;
    @Autowired
    private CategorieLocaleConverter categorieLocaleConverter ;
    private boolean rue;
    private boolean categorieLocale;

    public  LocaleConverter() {
        super(Locale.class, LocaleDto.class);
        init(true);
    }

    @Override
    public Locale toItem(LocaleDto dto) {
        if (dto == null) {
            return null;
        } else {
        Locale item = new Locale();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getComplementAdresse()))
                item.setComplementAdresse(dto.getComplementAdresse());
            if(StringUtil.isNotEmpty(dto.getDernierAnneeDePaiement()))
                item.setDernierAnneeDePaiement(dto.getDernierAnneeDePaiement());
            if(StringUtil.isNotEmpty(dto.getDernierTrimestre()))
                item.setDernierTrimestre(dto.getDernierTrimestre());
            if(StringUtil.isNotEmpty(dto.getSuperficie()))
                item.setSuperficie(dto.getSuperficie());
            if(this.rue && dto.getRue()!=null &&  dto.getRue().getId() != null)
                item.setRue(rueConverter.toItem(dto.getRue())) ;

            if(this.categorieLocale && dto.getCategorieLocale()!=null &&  dto.getCategorieLocale().getId() != null)
                item.setCategorieLocale(categorieLocaleConverter.toItem(dto.getCategorieLocale())) ;




        return item;
        }
    }

    @Override
    public LocaleDto toDto(Locale item) {
        if (item == null) {
            return null;
        } else {
            LocaleDto dto = new LocaleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getComplementAdresse()))
                dto.setComplementAdresse(item.getComplementAdresse());
            if(StringUtil.isNotEmpty(item.getDernierAnneeDePaiement()))
                dto.setDernierAnneeDePaiement(item.getDernierAnneeDePaiement());
            if(StringUtil.isNotEmpty(item.getDernierTrimestre()))
                dto.setDernierTrimestre(item.getDernierTrimestre());
            if(StringUtil.isNotEmpty(item.getSuperficie()))
                dto.setSuperficie(item.getSuperficie());
            if(this.rue && item.getRue()!=null) {
                dto.setRue(rueConverter.toDto(item.getRue())) ;

            }
            if(this.categorieLocale && item.getCategorieLocale()!=null) {
                dto.setCategorieLocale(categorieLocaleConverter.toDto(item.getCategorieLocale())) ;

            }


        return dto;
        }
    }

    public void copy(LocaleDto dto, Locale t) {
    super.copy(dto, t);
    if (dto.getRue() != null)
        rueConverter.copy(dto.getRue(), t.getRue());
    if (dto.getCategorieLocale() != null)
        categorieLocaleConverter.copy(dto.getCategorieLocale(), t.getCategorieLocale());
    }



    public void initObject(boolean value) {
        this.rue = value;
        this.categorieLocale = value;
    }


    public RueConverter getRueConverter(){
        return this.rueConverter;
    }
    public void setRueConverter(RueConverter rueConverter ){
        this.rueConverter = rueConverter;
    }
    public CategorieLocaleConverter getCategorieLocaleConverter(){
        return this.categorieLocaleConverter;
    }
    public void setCategorieLocaleConverter(CategorieLocaleConverter categorieLocaleConverter ){
        this.categorieLocaleConverter = categorieLocaleConverter;
    }
    public boolean  isRue(){
        return this.rue;
    }
    public void  setRue(boolean rue){
        this.rue = rue;
    }
    public boolean  isCategorieLocale(){
        return this.categorieLocale;
    }
    public void  setCategorieLocale(boolean categorieLocale){
        this.categorieLocale = categorieLocale;
    }
}
