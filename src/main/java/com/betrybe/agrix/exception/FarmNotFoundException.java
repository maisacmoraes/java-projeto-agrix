package com.betrybe.agrix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a farm is not found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FarmNotFoundException extends RuntimeException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }

}
