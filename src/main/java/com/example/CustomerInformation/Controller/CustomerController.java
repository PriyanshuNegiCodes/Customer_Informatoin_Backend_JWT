package com.example.CustomerInformation.Controller;

import com.example.CustomerInformation.Domain.Customer;
import com.example.CustomerInformation.Services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/customer/v1")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    //http://localhost:5555/api/customer/v1/getUser
    @GetMapping("/getUser")
    public ResponseEntity<?> getCustomerById(HttpServletRequest httpServletRequest){
        String customerName=(String) httpServletRequest.getAttribute("attr1");
        return new ResponseEntity<>(iCustomerService.getCustomerById(customerName), HttpStatus.OK);
    }
    //http://localhost:5555/api/customer/v1/addCustomer
   @PostMapping("/addCustomer")
   public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
       return new ResponseEntity<>(iCustomerService.addCustomer(customer), HttpStatus.CREATED);
   }
   @DeleteMapping("/deleteByID")
    public ResponseEntity<?> deleteCustomer(HttpServletRequest httpServletRequest){
       String customerName=(String) httpServletRequest.getAttribute("attr1");

       return new ResponseEntity<>(iCustomerService.deleteByCustomerId(customerName), HttpStatus.OK);
   }


}
