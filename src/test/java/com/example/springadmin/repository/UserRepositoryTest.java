package com.example.springadmin.repository;

import com.example.springadmin.SpringAdminApplicationTests;
import com.example.springadmin.model.entity.Item;
import com.example.springadmin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends SpringAdminApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {

            System.out.println("------------------------주문묶음-------------------------");
            System.out.println("수령지 : " + orderGroup.getRevAddress());
            System.out.println("수령인 : " + orderGroup.getRevName());
            System.out.println("총금액 : " + orderGroup.getTotalPrice());
            System.out.println("총수량 : " + orderGroup.getTotalQuantity());

            System.out.println("------------------------주문상세-------------------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태 : " + orderDetail.getStatus());
                System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());
            });

        });

        Assertions.assertNotNull(user);

    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdateBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        Assertions.assertFalse(deleteUser.isPresent());
    }
}
