package com.mint.task.Controller;

import com.google.gson.Gson;
import com.mint.task.Model.customTask1Response;
import com.mint.task.Model.payload;
import com.mint.task.Model.task1Response;

import com.mint.task.TaskApplication;
//import com.sun.deploy.association.utility.AppConstants;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.ResultSet;
import java.util.HashMap;

@RestController
public class taskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskApplication.class);
    Gson gson=new Gson();

    //@Autowired
   // private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${task1.endpoint}")
    String endpoint;

    @RequestMapping(value = "/card-scheme/verify/{dynamic}", method = RequestMethod.GET)
    public customTask1Response verifyTask(@PathVariable("dynamic") String dynamic) {
        String errorMessage = null;
        try {
            HttpEntity entity = new HttpEntity<>(dynamic);
            String url1 = endpoint + "/{digitno}";
            String resp = restTemplate.getForObject(url1, String.class, dynamic);
           // Gson gson = new Gson();

            task1Response resp1 = gson.fromJson(resp, task1Response.class);
            payload pload = new payload();
            pload.setBank(resp1.getBank().getName());
            pload.setScheme(resp1.getScheme());
            pload.setType(resp1.getType());

            customTask1Response ctresp = new customTask1Response();
            ctresp.setSuccess("Success");
            ctresp.setPayload(pload);

            int count = 1;
            String query="insert into tbl_task1(digits, counts) values('" + dynamic + "','" + count + "') ON DUPLICATE KEY UPDATE counts=counts+1";
            jdbcTemplate.update(query);
            return ctresp;
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            logger.error("\n \n" + errorMessage);
        }
        customTask1Response ctresp = new customTask1Response();
        ctresp.setSuccess(errorMessage);
        return ctresp;
    }

    @RequestMapping(value = "/card-scheme/stats", method = RequestMethod.GET)
    public JSONObject saveTask(@RequestParam int start, int limit) {
        HashMap<String,String> results = new HashMap<>();
        JSONObject main = new JSONObject();
        JSONObject payload = new JSONObject();
        main.put("success", "success");
        main.put("start", start);
        main.put("limit", limit);
        jdbcTemplate.query("Select count(id) from tbl_task1", (ResultSet rst) -> {
            main.put("size", rst.getString(1));
        });
        try {
            int offsets=Integer.valueOf(start)-Integer.valueOf(1);
            jdbcTemplate.query("Select digits, counts from tbl_task1 limit "+limit+" offset "+offsets+"", (ResultSet rs) -> {
                while (rs.next()) {
                    payload.put(rs.getString("digits"), rs.getString("counts"));
                }
                return main;
            });
        } catch (Exception ex) {
            logger.error("\n \n" + ex.getMessage());
        }
        main.put("payload", payload);
         return main;
    }




}
