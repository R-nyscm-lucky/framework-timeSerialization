package com.newhood.framework.timeserialization.testController.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * TestEntity
 * </p>
 *
 * @author ZJW
 * @date 2020/10/16 15:27
 */
@Data
public class TestEntity {

    private LocalDateTime localDateTime;

    private java.util.Date utilDate;

    private java.sql.Date sqlDate;

    private LocalDate localDate;

    private LocalTime localTime;
}
