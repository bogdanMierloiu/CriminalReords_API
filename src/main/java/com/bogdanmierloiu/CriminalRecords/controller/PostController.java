//package com.bogdanmierloiu.CriminalRecords.controller;
//
//import com.bogdanmierloiu.CriminalRecords.dto.auth.LoginRequest;
//import com.bogdanmierloiu.CriminalRecords.dto.auth.PostRequest;
//import com.bogdanmierloiu.CriminalRecords.dto.auth.WebResponse;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.ExampleObject;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/post")
//public class PostController {
//    @PostMapping("")
//    @Operation(
//            description = "Create Post service",
//            responses = {
//                    @ApiResponse(responseCode = "400", ref = "badRequestAPI"),
//                    @ApiResponse(responseCode = "500", ref = "internalServerErrorAPI"),
//                    @ApiResponse(
//                            responseCode = "200",
//                            description = "Successfully created post!",
//                            content = @Content(
//                                    mediaType = "application/json",
//                                    examples = {
//                                            @ExampleObject(
//                                                    value = "{\"code\": 200, \"Status\": \"Ok\", \"Message\": \"Successfully created post\" }"
//                                            )
//                                    }
//                            )
//                    )
//            }
//    )
//    public ResponseEntity<?> createPost(@RequestBody PostRequest request) {
//        return new ResponseEntity<>(
//                new WebResponse(
//                        HttpStatus.OK.value(),
//                        HttpStatus.OK.getReasonPhrase(),
//                        "Successfully created post!"
//                ), HttpStatus.OK
//        );
//    }
//
//    @PatchMapping("/{id}")
//    @Operation(
//            description = "Update Post service",
//            responses = {
//                    @ApiResponse(responseCode = "400", ref = "badRequestAPI"),
//                    @ApiResponse(responseCode = "500", ref = "internalServerErrorAPI"),
//                    @ApiResponse(
//                            responseCode = "200",
//                            description = "Successfully updated post!",
//                            content = @Content(
//                                    mediaType = "application/json",
//                                    examples = {
//                                            @ExampleObject(
//                                                    value = "{\"code\": 200, \"Status\": \"Ok\", \"Message\": \"Successfully updated post\" }"
//                                            )
//                                    }
//                            )
//                    )
//            }
//    )
//    public ResponseEntity<?> updatePost(@PathVariable Integer id,
//            @RequestBody PostRequest request) {
//        return new ResponseEntity<>(
//                new WebResponse(
//                        HttpStatus.OK.value(),
//                        HttpStatus.OK.getReasonPhrase(),
//                        "Successfully updated post!"
//                ), HttpStatus.OK
//        );
//    }
//}
