package org.macsouza.validacao.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiError {

    private HttpStatus code;
    private String title;
    private String detail;

}
