package com.jpnoronha.cadastrodeninjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpnoronha.cadastrodeninjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro_de_ninja")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missao")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private int idade;

    @Column(name = "rank")
    private String rank;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    @JsonIgnore
    private MissaoModel missao;
}
