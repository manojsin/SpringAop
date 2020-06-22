package com.learning.springAop.service;

import com.learning.springAop.annotation.TrackExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @TrackExecutionTime
    public void print()
    {
        for(int i=0;i<=100;i++)
        {
            System.out.println("number"+i);
        }
    }
}
