package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    /*
     Endpoint: /api/v1/address/{addressNo}
     HTTP Status Code: 200

     JSON Response Body:
     "success": true
     "message": "Address <addressNo> is successfully retrieved."
     "code":200
     "data":<address data>
    */

    @GetMapping("/{addressNo}")
    public ResponseEntity<ResponseWrapper> getAddressByNo(@PathVariable("addressNo") String addressNo) {
        //I need to find address info based on addressNo  --> AddressDTO
        AddressDTO foundAddress = addressService.findByAddressNo(addressNo);

        //Build our custom JSON response which includes Address information --> ResponseWrapper
        ResponseWrapper responseWrapper = ResponseWrapper.builder()
                .success(true)
                .message("Address " + addressNo + " is successfully retrieved.")
                .code(HttpStatus.OK.value())
                .data(foundAddress).build();

        //return JSON Response Body along with 200 status code --> ResponseEntity status code 200 and Json Body
        return ResponseEntity.ok(responseWrapper);

        //writing everything in one statement
//        return ResponseEntity.ok(ResponseWrapper.builder()
//                .success(true)
//                .message("Address " + addressNo + " is successfully retrieved.")
//                .code(HttpStatus.OK.value())
//                .data(addressService.findByAddressNo(addressNo)).build());
    }


//    @GetMapping("{addressNo}")
//    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("addressNo") String addressNo){
//        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
//                .header("Version", "Cydeo.V1")
//                .header("Operation", "Get Address")
//                .body(new ResponseWrapper("Address successfully retrieved!", addressService.findByAddressNo(addressNo)));
//                }



    /*
      Endpoint: /api/v1/address/{addressNo}

      JSON Response Body:
      <updated address data>
     */
//    @PutMapping("{addressNo}")
//    public ResponseEntity<ResponseWrapper> updateAddress(@PathVariable("addressNo") String addressNo, @RequestBody AddressDTO addressDTO){
////        return ResponseEntity
////                .status(HttpStatus.CREATED)
////                .header("Version", "Cydeo.V1")
////                .header("Operation", "Create Address")
////                .body(new ResponseWrapper("Course successfully Created!", addressService.update(addressNo, addressDTO)));
//
//            return ResponseEntity.ok(ResponseWrapper.builder()
//                .success(true)
//                .message("Address " + addressNo + " is successfully updated.")
//                .code(HttpStatus.CREATED.value())
//                .data(addressService.update(addressNo, addressDTO)).build());
//
//    }

    @PutMapping("/{addressNo}")
    public AddressDTO updateAddress(@PathVariable("addressNo") String addressNo,
                                    @RequestBody AddressDTO addressDTO){
        //using the service to update the address
        return addressService.update(addressNo,addressDTO);
    }
}
