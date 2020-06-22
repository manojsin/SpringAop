package com.learning.springAop.service;

import com.learning.springAop.annotation.TrackExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @TrackExecutionTime
    public String print(String name)
    {
        for(int i=0;i<=5;i++)
        {
            System.out.println("number"+i);
        }
        return name;
    }
}
