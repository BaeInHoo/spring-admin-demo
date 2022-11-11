package com.example.springadmin.controller.ifs;

import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.ItemApiRequest;
import com.example.springadmin.model.network.request.UserApiRequest;
import com.example.springadmin.model.network.response.ItemApiResponse;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);    // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
