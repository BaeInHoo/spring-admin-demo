package com.example.springadmin.controller.api;

import com.example.springadmin.controller.CrudController;
import com.example.springadmin.controller.ifs.CrudInterface;
import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.ItemApiRequest;
import com.example.springadmin.model.network.response.ItemApiResponse;
import com.example.springadmin.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = itemApiLogicService;
    }
}
