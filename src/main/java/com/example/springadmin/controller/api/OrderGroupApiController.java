package com.example.springadmin.controller.api;

import com.example.springadmin.controller.CrudController;
import com.example.springadmin.controller.ifs.CrudInterface;
import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.OrderGroupApiRequest;
import com.example.springadmin.model.network.request.UserApiRequest;
import com.example.springadmin.model.network.response.ItemApiResponse;
import com.example.springadmin.model.network.response.OrderGroupApiResponse;
import com.example.springadmin.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = orderGroupApiLogicService;
    }

}
