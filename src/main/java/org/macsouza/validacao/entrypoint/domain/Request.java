package org.macsouza.validacao.entrypoint.domain;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class Request {

    @NotBlank(message = "Campo1 Não pode ser branco!")
    @NotNull(message = "Campo1 é obrigatório!")
    private String campo1;

    @NotBlank(message = "Campo2 Não pode ser branco!")
    @NotNull(message = "Campo2 é obrigatório!")
    private String campo2;

    @Pattern(regexp = "^[0-9]{11}$|^[0-9]{14}$", message = "O Valor deve ser 11 ou 14 números")
    @NotNull(message = "Campo document é obrigatório!")
    private String document;

}
