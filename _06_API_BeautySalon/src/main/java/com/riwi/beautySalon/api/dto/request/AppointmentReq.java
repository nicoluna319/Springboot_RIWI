package com.riwi.beautySalon.api.dto.request;

import java.time.LocalDateTime;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentReq {
    @NotBlank(message = "La fecha y hora son requeridas.")
    private LocalDateTime dateTime;
    @Min(value = 10, message = "La duración mínima es de 10 minutos.")
    @Max(value = 720, message = "La duración máxima es de 12 horas.")
    private Integer duration;
    private String comments;
    @NotNull(message = "El id del cliente es obligatorio.")
    private Long clientId;
    @NotNull(message = "El id del servicio es obligatorio.")
    private Long serviceId;
    @NotNull(message = "El id del empleado es obligatorio.")
    private Long employeeId;
}
