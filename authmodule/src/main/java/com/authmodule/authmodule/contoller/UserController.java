package com.authmodule.authmodule.contoller;

import com.authmodule.authmodule.dto.UserDataDTO;
import com.authmodule.authmodule.model.User;
import com.authmodule.authmodule.service.UserService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@Api(tags = "users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping(value = "/signup")
    @ApiOperation(value = " ${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 422, message = "username is already in use")
    })
    public String signUp(@ApiParam("Signup User") @RequestBody UserDataDTO userDataDTO) {
        return userService.signUp(modelMapper.map(userDataDTO, User.class));

    }

}
