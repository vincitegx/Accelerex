package com.neptunesoftware.Accelerex.user;

import com.neptunesoftware.Accelerex.config.JWTService;
import com.neptunesoftware.Accelerex.universal.ApiResponse;
import com.neptunesoftware.Accelerex.user.requests.ChangePasswordRequest;
import com.neptunesoftware.Accelerex.user.requests.UserAuthenticationRequests;
import com.neptunesoftware.Accelerex.user.requests.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
        private final JWTService jwtService;

        @Autowired
        public UserController(UserService userService, JWTService jwtService) {
            this.userService = userService;
            this.jwtService = jwtService;
        }

        @PostMapping()
        public ResponseEntity<ApiResponse> saveUser(@RequestBody @Validated UserRegistrationRequest request){
            userService.createNewUser(request);
            return  new ResponseEntity<>(
                    new ApiResponse("user created successfully"), HttpStatus.CREATED);
        }

        @PostMapping("/login")
        public ResponseEntity<ApiResponse> authenticateUser(
                @RequestBody @Validated UserAuthenticationRequests userAuthenticationRequests){

            String jwt = userService.authenticateUser(userAuthenticationRequests);
            return new ResponseEntity<>(
                    new ApiResponse("user logged in successfully",jwt),HttpStatus.OK);
        }

        @PutMapping("/change-password")
        public ResponseEntity<ApiResponse> changeUserPassword(@RequestHeader("Authorization") String jwt,
                                                              @RequestBody @Validated ChangePasswordRequest request){
            userService.changeUserPassword(request,jwtService.extractUserIdFromToken(jwt));
            return new ResponseEntity<>(new ApiResponse("password changed"),HttpStatus.OK);
        }

}
