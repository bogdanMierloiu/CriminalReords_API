//package com.bogdanmierloiu.CriminalRecords.controller;
//
//import com.bogdanmierloiu.CriminalRecords.dto.auth.LoginRequest;
//import com.bogdanmierloiu.CriminalRecords.dto.auth.WebResponse;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.ExampleObject;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthenticationController {
//    @PostMapping("/signIn")
//    @Operation(
//            description = "Sign In Service",
//            responses = {
//                    @ApiResponse(responseCode = "400", ref = "badRequestAPI"),
//                    @ApiResponse(responseCode = "500", ref = "internalServerErrorAPI"),
//                    @ApiResponse(
//                            responseCode = "200",
//                            description = "Successfully Signed In!",
//                            content = @Content(
//                                    mediaType = "application/json",
//                                    examples = {
//                                            @ExampleObject(
//                                                    value = "{\"code\": 200, \"Status\": \"Ok\", \"Message\": \"Successfully Signed In\" }"
//                                            )
//                                    }
//                            )
//                    )
//            }
//    )
//    public ResponseEntity<?> signIn(@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
//            mediaType = "application/json",
//            examples = {
//                    @ExampleObject(
//                            value = "{\"username\": admin, \"password\": \"admin\"}"
//                    )
//            }
//    ))
//                                    @RequestBody LoginRequest request) {
//        return new ResponseEntity<>(
//                new WebResponse(
//                        HttpStatus.OK.value(),
//                        HttpStatus.OK.getReasonPhrase(),
//                        "Successfully signed in!"
//                ), HttpStatus.OK
//        );
//    }
//}
