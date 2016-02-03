package me.mingxing5212.chaihens.merchant.web;

import me.mingxing5212.chaihens.merchant.data.domain.Merchant;
import me.mingxing5212.chaihens.merchant.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取商户信息
 *
 * @author Mingxing Li
 * @date 24/1/16
 */
@RestController
@RequestMapping("/merchant")
public class MerchantApi {
    private Logger logger = LoggerFactory.getLogger(MerchantApi.class);

    @Autowired
    public MerchantService merchantService;

    @RequestMapping(method = RequestMethod.GET)
    public Merchant getMerchant(@RequestParam Long merchantId) {
        logger.info("getMerchant by merchantId:{}", merchantId);
        return merchantService.getMerchant(merchantId);
    }
}
