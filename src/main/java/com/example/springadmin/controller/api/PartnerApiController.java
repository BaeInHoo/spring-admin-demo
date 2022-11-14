package com.example.springadmin.controller.api;

import com.example.springadmin.controller.CrudController;
import com.example.springadmin.model.entity.Partner;
import com.example.springadmin.model.network.request.PartnerApiRequest;
import com.example.springadmin.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
