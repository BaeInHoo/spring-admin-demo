package com.example.springadmin.repository;

import com.example.springadmin.model.entity.Item;
import com.example.springadmin.model.network.Header;
import com.example.springadmin.model.network.request.ItemApiRequest;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
