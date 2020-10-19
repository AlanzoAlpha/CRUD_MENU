package com.qa.menu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Menu not compatible with that ID")
public class MenuNotFoundException extends RuntimeException {

}
