package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.AuthenticationDto;
import com.betrybe.agrix.controller.dto.TokenDto;
import com.betrybe.agrix.service.PersonService;
import com.betrybe.agrix.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;

  private final TokenService tokenService;

  @Autowired
  public AuthenticationController(AuthenticationManager authenticationManager, PersonService personService,
      TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.tokenService = tokenService;
  }

  @PostMapping("/login")
  public TokenDto login(@RequestBody AuthenticationDto authenticationDTO){

  UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                    authenticationDTO.username(),
                    authenticationDTO.password()
                );
  Authentication auth = authenticationManager.authenticate(usernamePassword);

  UserDetails userDetails = (UserDetails) auth.getPrincipal();

  String token = tokenService.generateToken(userDetails);

  return new TokenDto(token);
}

}
