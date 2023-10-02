package com.betrybe.agrix.controller.dto;

/**
 * Response DTO.
 *
 * @param <T> data type
 */
public record ResponseDto<T>(String message, T data) {
}
