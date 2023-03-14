package ru.students.test_rest_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.students.test_rest_service.model.Response;



@Service
@RequiredArgsConstructor
@Qualifier("id1")
public class ModifyUid implements MyModifyService {
    @Override
    public Response modify(Response response) {
        response.setUid("New uid");
        return response;
    }
}
