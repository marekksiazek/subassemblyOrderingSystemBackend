package pl.marekksiazek.CableManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "production_database")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdData {

    @Id
    @Column(name = "model_suffix")
    private String modelSuffix;

    @Column(name = "week_1")
    private int week1;

    @Column(name = "week_2")
    private int week2;

    @Column(name = "week_3")
    private int week3;

    @Column(name = "week_4")
    private int week4;

    @Column(name = "week_5")
    private int week5;

    @Column(name = "week_6")
    private int week6;

    @Column(name = "week_7")
    private int week7;

    @Column(name = "week_8")
    private int week8;

    @Column(name = "week_9")
    private int week9;

    @Column(name = "week_10")
    private int week10;

    @Column(name = "week_11")
    private int week11;

    @Column(name = "week_12")
    private int week12;

    @Column(name = "week_13")
    private int week13;

    @Column(name = "week_14")
    private int week14;

    @Column(name = "week_15")
    private int week15;

    @Column(name = "week_16")
    private int week16;

    @Column(name = "total")
    private int total;

    @Column(name = "bom")
    private String bom;
}
