package ru.students.test_rest_service.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.students.test_rest_service.model.Request;
import ru.students.test_rest_service.model.Response;
import ru.students.test_rest_service.service.ModifyRequestService;
import ru.students.test_rest_service.service.MyModifyService;


@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(@Qualifier("ModifySystemTime") MyModifyService myModifyService, ModifyRequestService modifyRequestService1) {

        this.myModifyService = myModifyService;
        this.modifyRequestService = modifyRequestService1;
    }



    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request){

        System.out.println("hello");

        log.info("Входящий request : " + request);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("just success")
                .errorCode("")
                .errorMessage("")
                .build();

        modifyRequestService.modifyRq(request);

        Response responseAfterModify = myModifyService.modify(response);
        log.info("Исходящий response : " + response);



        log.warn("Опасно");
        log.warn("Очень опасно");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
