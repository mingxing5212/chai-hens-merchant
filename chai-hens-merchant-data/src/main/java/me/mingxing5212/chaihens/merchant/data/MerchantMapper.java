package me.mingxing5212.chaihens.merchant.data;

import me.mingxing5212.chaihens.merchant.data.domain.Merchant;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * MerchantDao
 *
 * @author Mingxing Li
 * @date 23/1/16
 */
public interface MerchantMapper {
    @Select("SELECT * FROM merchant WHERE id = #{merchantId}")
    Merchant findById(@Param("merchantId") Long merchantId);
}
