package com.example.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Crear la carpeta logs si no existe
        File logDir = new File("logs");
        if (!logDir.exists()) {
            boolean created = logDir.mkdirs();
            if (created) {
                System.out.println("Carpeta 'logs' creada.");
            } else {
                System.err.println("No se pudo crear la carpeta 'logs'.");
            }
        }

        for (int i = 0; i < 10; i++) {
            logger.info("Inicio de la aplicación");
            logger.debug("Esto es un mensaje de depuración");
            logger.warn("Advertencia: algo podría salir mal");
            logger.error("¡Error fatal!");
        }

    }
}
