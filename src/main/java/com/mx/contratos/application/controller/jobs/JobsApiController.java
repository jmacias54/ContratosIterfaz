package com.mx.contratos.application.controller.jobs;


import com.mx.contratos.application.configuration.constant.GlobalConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.JOBS_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
public class JobsApiController {
}
