package com.io.pipeline.modeling.fundamentals.runner;

import com.io.pipeline.modeling.fundamentals.service.ValueFiller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebRunner {

  private final ValueFiller valueFiller;

  @GetMapping(value = "/upload")
  public ResponseEntity<String> uploadBaseData() {
    String response = valueFiller.fillAllTables();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
