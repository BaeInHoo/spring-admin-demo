package com.example.springadmin.controller.api;

import com.example.springadmin.controller.CrudController;
import com.example.springadmin.controller.ifs.CrudInterface;
import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.UserApiRequest;
import com.example.springadmin.model.network.response.ItemApiResponse;
import com.example.springadmin.model.network.response.UserApiResponse;
import com.example.springadmin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = userApiLogicService;
    }
}
