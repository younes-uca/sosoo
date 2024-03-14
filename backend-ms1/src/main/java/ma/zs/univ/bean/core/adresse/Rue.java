package ma.zs.univ.bean.core.adresse;

import java.util.Objects;





import ma.zs.univ.bean.core.adresse.Quartier;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.univ.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "rue")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="rue_seq",sequenceName="rue_seq",allocationSize=1, initialValue = 1)
public class Rue   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;

    private Quartier quartier ;


    public Rue(){
        super();
    }

    public Rue(Long id){
        this.id = id;
    }

    public Rue(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Rue(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="rue_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quartier")
    public Quartier getQuartier(){
        return this.quartier;
    }
    public void setQuartier(Quartier quartier){
        this.quartier = quartier;
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
        Rue rue = (Rue) o;
        return id != null && id.equals(rue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

