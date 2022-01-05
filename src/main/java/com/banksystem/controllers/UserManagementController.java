package com.banksystem.controllers;

import com.banksystem.models.AppUserRole;
import com.banksystem.models.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserManagementController {
//    private static List<User> USERS = new ArrayList<>( Arrays.asList(
//            new User("mouad1","mouad"),
//            new User("ayoub","ayoub")
//    ));
//
//   @PutMapping(path = "/{userId}")
//   @Secured("ROLE_ADMIN")
//    public User getUser(@PathVariable("userId")Long userId,@RequestBody User user2) {
//         USERS.stream()
//                .filter(user -> userId.equals(user.getUserId()))
//                .findFirst()
//                .get().setUserId(user2.getUserId());
//       USERS.stream()
//               .filter(user -> userId.equals(user.getUserId()))
//               .findFirst()
//               .get().setUsername(user2.getUsername());
//       USERS.stream()
//               .filter(user -> userId.equals(user.getUserId()))
//               .findFirst()
//               .get().setPassword((user2.getPassword()));
//        return USERS.stream()
//                .filter(user -> userId.equals(user.getUserId()))
//                .findFirst().orElseThrow();
//   }
//    @GetMapping
//    @Secured("ROLE_USER")
//    public List<User> getUsers() {
//        return USERS;
//    }
//
//    @DeleteMapping(path = "/{userId}")
//    @Secured("ROLE_ADMIN")
//    public boolean deleteUser(@PathVariable("userId")Long userId) {
//        return USERS.removeIf(user -> userId.equals(user.getUserId()));
//    }
//
//    @PostMapping
//    @Secured("ROLE_ADMIN")
//    public boolean addUser(@RequestBody User user){
//        return USERS.add(user);
////    }
//
//
}
