package com.jpnoronha.cadastrodeninjas.Ninjas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;

}
