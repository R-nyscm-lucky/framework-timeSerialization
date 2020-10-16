package com.newhood.framework.timeserialization.testController;

import com.newhood.framework.timeserialization.testController.entity.TestEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *     测试接口：
 *         1.如果直接使用liocalDateTime对象接收时间戳的话，存在解析问题。
 *         2.如果涉及到时间的话，请使用对象接收，2020-10-16记录
 * </p>
 *
 * @author ZJW
 * @date 2020/10/16 14:54
 */
@RestController
public class TestController {

    @PostMapping("/get")
    public TestEntity put(@RequestBody TestEntity testEntity){
        return testEntity;
    }

}
