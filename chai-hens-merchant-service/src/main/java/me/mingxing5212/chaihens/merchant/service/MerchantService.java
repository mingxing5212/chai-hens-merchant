package me.mingxing5212.chaihens.merchant.service;

import me.mingxing5212.chaihens.merchant.data.MerchantMapper;
import me.mingxing5212.chaihens.merchant.data.domain.Merchant;
import me.mingxing5212.chaihens.voucher.api.IVoucherDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MerchantService
 *
 * @author Mingxing Li
 * @date 23/1/16
 */
@Service
public class MerchantService {
    @Autowired
    private MerchantMapper merchantMapper;

    @Autowired
    private IVoucherDefinitionService vocherDefinationService;

    public Merchant getMerchant(Long merchantId){
        String x = vocherDefinationService.foo();
        return merchantMapper.findById(merchantId);
    }
}
