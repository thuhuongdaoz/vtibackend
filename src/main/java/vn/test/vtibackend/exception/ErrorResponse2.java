package vn.test.vtibackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse2 {
    int code;
    List<String> message;

}
