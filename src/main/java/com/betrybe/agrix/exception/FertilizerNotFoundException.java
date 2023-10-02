package com.betrybe.agrix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a fertilize is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FertilizerNotFoundException extends RuntimeException {
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}

