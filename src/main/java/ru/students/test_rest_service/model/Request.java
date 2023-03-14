package ru.students.test_rest_service.model;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class Request {

        @NotBlank
        @Size(max = 32)
        private String uid;
        private String    operationUid;
        private String    systemName;
        @NotBlank
        private String    systemTime;
        private String    source;
        private int    communicationId;
        private int     templateId;
        private int     productCode;
        private int     smsCode;
    }



