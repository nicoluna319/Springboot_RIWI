package com.riwi.beautySalon.api.dto.request;



import com.riwi.beautySalon.utils.enums.RoleEmployee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeReq {
    @NotBlank(message = "El nombre es requerido.")
    private String name;
    @NotBlank(message = "El apellido es requerido.")
    private String lastName;
    @Size(min = 10, max = 20, message = "El nombre es requerido.")
    private String phone;
    @Email(message = "El email NO es valido.")
    @Size(min = 5, max = 100, message = "El email debe tener entre 5 y 100 caracteres.")
    private String email;
    @NotBlank(message = "El rol es requerido.")
    private RoleEmployee role;

}
