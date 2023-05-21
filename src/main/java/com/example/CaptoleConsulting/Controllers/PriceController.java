package com.example.CaptoleConsulting.Controllers;

import com.example.CaptoleConsulting.Entities.Price;
import com.example.CaptoleConsulting.Services.PriceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class PriceController {

    private static final Logger log = LoggerFactory.getLogger(PriceController.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    PriceService priceService;

    @GetMapping(value = "/getPriceAtThisMoment/brand/{brand_id}/product/{product_id}", produces = "application/json")
    public ObjectNode getPriceFromData(
            @RequestParam(value = "localDateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) //2011-12-03T10:15:30
            LocalDateTime localDateTime,
            @PathVariable("product_id")
            Integer product_id,
            @PathVariable("brand_id")
            Integer brand_id
            ){
        log.info("Request of brand_id: "+brand_id.toString()+", product_id: "+product_id.toString()+", localdatetime: "+localDateTime.toString());

        Optional<Price> price = priceService.getPriceAtThisMoment(brand_id, product_id, localDateTime);
        if(price.isEmpty()) {
            return mapper.createObjectNode();
        }
        return generateResponse(price.get());
    }

    private ObjectNode generateResponse(Price price){
        ObjectNode node = mapper.createObjectNode();
        node.put("product_id", price.getProduct().getProduct_id().toString());
        node.put("brand_id", price.getBrand().getBrand_id().toString());
        node.put("price", price.getPrice());
        node.put("price_list", price.getPrice_list());
        node.put("start_date", price.getStart_date().toString());
        node.put("end_date", price.getEnd_date().toString());
        return node;
    }
}
