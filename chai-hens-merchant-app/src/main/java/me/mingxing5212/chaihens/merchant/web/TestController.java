package me.mingxing5212.chaihens.merchant.web;

import me.mingxing5212.chaihens.merchant.data.domain.Merchant;
import me.mingxing5212.chaihens.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    public MerchantService merchantService;

    @RequestMapping(method = RequestMethod.GET)
    public Merchant testGet(@RequestParam Long merchantId) {
        return merchantService.getMerchant(merchantId);
    }
}
