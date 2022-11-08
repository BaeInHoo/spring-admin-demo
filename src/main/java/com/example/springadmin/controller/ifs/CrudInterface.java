package com.example.springadmin.controller.ifs;

import com.example.springadmin.model.network.Header;

public interface CrudInterface {

    Header create();    // todo request object 추가

    Header read(Long id);

    Header update();

    Header delete(Long id);
}
