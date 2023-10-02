package com.betrybe.agrix.advice;

import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global controller advice to handle exceptions.
 */
@ControllerAdvice
public class GlobalControllerAdvice {

  /**
   * Handle farm not found exceptions.
   *
   * @param exception the exception to be handled.
   * @return the response entity with the exception message.
   */
  @ExceptionHandler({
      FarmNotFoundException.class,
      CropNotFoundException.class,
      FertilizerNotFoundException.class
  })
  public ResponseEntity<String> handleNotFound(RuntimeException exception) {
    return ResponseEntity
      .status(HttpStatus.NOT_FOUND)
      .body(exception.getMessage());
  }
}
