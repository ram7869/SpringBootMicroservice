package com.dailycodebuffer.user.service;

import VO.Department;
import VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(id);


        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
