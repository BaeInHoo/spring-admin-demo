package com.example.springadmin.controller.api;

import com.example.springadmin.controller.CrudController;
import com.example.springadmin.controller.ifs.CrudInterface;
import com.example.springadmin.model.entity.User;
import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.UserApiRequest;
import com.example.springadmin.model.network.response.ItemApiResponse;
import com.example.springadmin.model.network.response.UserApiResponse;
import com.example.springadmin.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.awt.print.Pageable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, User> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 15) Pageable pageable) {
        log.info("{}", pageable);
        return userApiLogicService.search(pageable);
    }

}
