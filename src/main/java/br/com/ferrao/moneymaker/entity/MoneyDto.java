package br.com.ferrao.moneymaker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "money")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyDto {
    @Id
    private Long id;

    private Double valor;
    private String animal;

}
