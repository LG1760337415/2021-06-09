package com.liu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public final class ResultCode {
    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 50001;
    public static final Integer NOT_TOKEN = 50002;
    public static final Integer FAILURE_OF_THE_TOKEN = 50003;
    public static final Integer USER_NOT_FOUND = 50004;
}