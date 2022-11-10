package com.example.springadmin.controller.ifs;

import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.ItemApiRequest;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);    // todo request object 추가

    Header<Res> read(Header<ItemApiRequest> id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);
}
