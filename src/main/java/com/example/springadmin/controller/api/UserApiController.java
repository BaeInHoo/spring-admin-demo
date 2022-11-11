package com.example.springadmin.controller.api;

import com.example.springadmin.controller.ifs.CrudInterface;
import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.UserApiRequest;
import com.example.springadmin.model.network.response.ItemApiResponse;
import com.example.springadmin.model.network.response.UserApiResponse;
import com.example.springadmin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;


    @Override
    @PostMapping("")    // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable Long id) {
        log.info("read : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {

        return userApiLogicService.update(request);

    }


    @Override
    @DeleteMapping("{id}")  // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        log.info("delete : {]", id);
        return userApiLogicService.delete(id);
    }
}
