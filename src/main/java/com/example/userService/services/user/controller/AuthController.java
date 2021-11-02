package com.example.userService.services.user.controller;
import com.example.userService.config.MyUserDetailService;
import com.example.userService.model.AuthenticationRequest;
import com.example.userService.model.AuthenticationResponse;
import com.example.userService.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController()
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public ResponseEntity<?> auth(@RequestBody() AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest.getUserName());
        System.out.println(authenticationRequest.getPassword());
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw  new Exception("incorrect username and password");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
