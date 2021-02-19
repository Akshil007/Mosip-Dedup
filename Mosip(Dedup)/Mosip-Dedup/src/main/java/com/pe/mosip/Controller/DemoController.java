package com.pe.mosip.Controller;

import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.service.Main_Table_Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/demo")
@RestController
public class DemoController {
    Main_Table_Service main_table_service=new Main_Table_Service();

    @PostMapping(path = "/insert")
    public int insert_demo_main(@RequestBody Demo_Details demo_details)
    {
        return main_table_service.addDemo(demo_details);
    }

    
}
