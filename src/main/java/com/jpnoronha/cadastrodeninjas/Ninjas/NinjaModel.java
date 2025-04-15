package com.jpnoronha.cadastrodeninjas.Ninjas;

import com.jpnoronha.cadastrodeninjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro_de_ninja")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoModel missao;
}
