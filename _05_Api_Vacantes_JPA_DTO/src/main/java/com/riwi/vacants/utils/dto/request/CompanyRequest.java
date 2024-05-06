package com.riwi.vacants.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // Patron de diseño para crear clases
@AllArgsConstructor
@NoArgsConstructor

public class CompanyRequest {
    @Size(min = 0, max = 40, message = "El nombre supera la cantidad de caracteres")
    @NotBlank(message= "EL nombre supera la cantidad de caracteres")
    private String name;
    @NotBlank(message= "EL nombre de la locacion es requerida")
    private String location;
    @Size(min = 0, max = 15, message = "El contacto supera la cantidad de caracteres")
    @NotBlank
    private String contact;

}
