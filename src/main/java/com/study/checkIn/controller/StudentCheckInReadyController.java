package com.study.checkIn.controller;

import com.study.checkIn.dto.CheckInURLDTO;
import com.study.checkIn.service.IStudentCheckInService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
public class StudentCheckInReadyController {
    @Resource
    private IStudentCheckInService iStudentCheckInService;

    @GetMapping("/studentCheckInReady")
    public ModelAndView showAHtml() {
        return new ModelAndView("StudentCheckIn/StudentCheckInReady","time1",0);
    }

    @GetMapping("/studentCheckInReady-testURL")
    public String studentCheckInReadyTestURL(String checkInURL){
        return iStudentCheckInService.studyCheckInReadyTest(checkInURL);
    }

    @GetMapping("/studentCheckInReady-divideURL")
    public CheckInURLDTO studentCheckInReadyDivideURL(String checkInURL){
        return iStudentCheckInService.studyCheckInReadyDivideURL(checkInURL);
    }
}
