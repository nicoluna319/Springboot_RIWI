package com.riwi.vacants.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 60, nullable = false)
    private String location;
    @Column(length = 15, nullable = false)
    private String contact;


    /*@OneToMany (Uno a Muchos) Una empresa puede tener muchas vacantes
     * MapedBy: Debemos especificar en propiedad se esta mapeando en la otra entidad
     * Cascade.All: Especificamos el tipo cascada, All quiere decir que tendra todos
     * los tipos de cascada
     * orphanRmoval = Especificar que un objeto huerfano sera eliminado
     */

    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude //Excluimos esta propiedad del to String
    @EqualsAndHashCode.Exclude //Excluimos las propiedades dentro de la lista

    private List<Vacant> vacants;



}
