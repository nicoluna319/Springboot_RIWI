package com.riwi.beautySalon.utils.messages;

public class ErrorMessages {
    
    public static String IdNotFound(String entity){

          final String message = "No hay registros en la entidad %s con el id suministrado.";
        return String.format(message, entity);
    }
}

//return "No se encontró el " + entity + " con el id proporcionado.";