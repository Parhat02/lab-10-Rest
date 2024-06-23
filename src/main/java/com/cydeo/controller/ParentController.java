package com.cydeo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class ParentController {

     /*
           Endpoint: /api/v1/parent
           HTTP Status Code: 200
           Custom Response Header: "Parents", "Returned"

           JSON Response Body:
           "success": true
           "message": "Parents are successfully retrieved."
           "code":200
           "data":<parents data>
     */
}
