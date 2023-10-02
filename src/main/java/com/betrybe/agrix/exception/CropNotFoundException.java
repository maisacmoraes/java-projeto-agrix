package com.betrybe.agrix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a crop is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CropNotFoundException extends RuntimeException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}



