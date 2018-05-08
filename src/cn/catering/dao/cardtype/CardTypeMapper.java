package cn.catering.dao.cardtype;

import cn.catering.pojo.CardType;
import cn.catering.pojo.CardTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardTypeMapper {
    int countByExample(CardTypeExample example);

    int deleteByExample(CardTypeExample example);

    int deleteByPrimaryKey(Integer cardId);

    int insert(CardType record);

    int insertSelective(CardType record);

    List<CardType> selectByExample(CardTypeExample example);

    CardType selectByPrimaryKey(Integer cardId);

    int updateByExampleSelective(@Param("record") CardType record, @Param("example") CardTypeExample example);

    int updateByExample(@Param("record") CardType record, @Param("example") CardTypeExample example);

    int updateByPrimaryKeySelective(CardType record);

    int updateByPrimaryKey(CardType record);
}