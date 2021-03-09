package com.pe.mosip.Controller;

import com.pe.mosip.bean.Demo_Details;
import com.pe.mosip.bean.Request_Body;
import com.pe.mosip.bean.Responce_Body;
import com.pe.mosip.service.Compare_Table_Service;
import com.pe.mosip.service.Main_Table_Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import java.io.IOException;

@RequestMapping("api/demo")
@RestController
public class DemoController {
    Main_Table_Service main_table_service=new Main_Table_Service();
    Compare_Table_Service compare_table_service=new Compare_Table_Service();
    @PostMapping(path = "/request")
    public Responce_Body demo_main(@RequestBody Request_Body request_body) throws IOException, SAXException {
        //System.out.println(request_body.toString(request_body));
        return main_table_service.request(request_body);
    }

    @PostMapping(path = "/request_compare")
    public Responce_Body demo_compare(@RequestBody Request_Body request_body)
    {
        return compare_table_service.addDemo(request_body);
    }

}
