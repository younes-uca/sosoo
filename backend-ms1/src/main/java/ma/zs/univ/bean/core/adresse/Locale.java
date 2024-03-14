package ma.zs.univ.bean.core.adresse;

import java.util.Objects;





import ma.zs.univ.bean.core.adresse.Rue;
import ma.zs.univ.bean.core.taxe.CategorieLocale;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "locale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="locale_seq",sequenceName="locale_seq",allocationSize=1, initialValue = 1)
public class Locale   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String complementAdresse;
    private Integer dernierAnneeDePaiement = 0;
    private Integer dernierTrimestre = 0;
    private BigDecimal superficie = BigDecimal.ZERO;

    private Rue rue ;
    private CategorieLocale categorieLocale ;


    public Locale(){
        super();
    }

    public Locale(Long id){
        this.id = id;
    }

    public Locale(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Locale(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="locale_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getComplementAdresse(){
        return this.complementAdresse;
    }
    public void setComplementAdresse(String complementAdresse){
        this.complementAdresse = complementAdresse;
    }
    public Integer getDernierAnneeDePaiement(){
        return this.dernierAnneeDePaiement;
    }
    public void setDernierAnneeDePaiement(Integer dernierAnneeDePaiement){
        this.dernierAnneeDePaiement = dernierAnneeDePaiement;
    }
    public Integer getDernierTrimestre(){
        return this.dernierTrimestre;
    }
    public void setDernierTrimestre(Integer dernierTrimestre){
        this.dernierTrimestre = dernierTrimestre;
    }
    public BigDecimal getSuperficie(){
        return this.superficie;
    }
    public void setSuperficie(BigDecimal superficie){
        this.superficie = superficie;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rue")
    public Rue getRue(){
        return this.rue;
    }
    public void setRue(Rue rue){
        this.rue = rue;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_locale")
    public CategorieLocale getCategorieLocale(){
        return this.categorieLocale;
    }
    public void setCategorieLocale(CategorieLocale categorieLocale){
        this.categorieLocale = categorieLocale;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locale locale = (Locale) o;
        return id != null && id.equals(locale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

