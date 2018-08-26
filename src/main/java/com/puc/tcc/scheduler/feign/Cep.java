package com.puc.tcc.scheduler.feign;
import lombok.Data;
 
@Data
public class Cep {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
}