package pl.marekksiazek.CableManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PolishRnD {

    @Id
    @Column(name = "model_suffix")
    private String modelSuffix;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "part_1")
    private String part1;

    @Column(name = "part_2")
    private String part2;

    @Column(name = "part_3")
    private String part3;

    @Column(name = "part_4")
    private String part4;

    @Column(name = "c_bom_model_suffix")
    private String CBomModelSuffix;

    @Column(name = "bom_suffix")
    private String bomSuffix;

    @Column(name = "bom_part_1")
    private String bomPart1;

    @Column(name = "bom_part_2")
    private String bomPart2;

    @Column(name = "bom_part_3")
    private String bomPart3;

    @Column(name = "bom_part_4")
    private String bomPart4;

    @Column(name = "status")
    private int status;

}
