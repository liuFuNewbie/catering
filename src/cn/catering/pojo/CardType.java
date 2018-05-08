package cn.catering.pojo;

import java.io.Serializable;

public class CardType implements Serializable {
    private Integer cardId;

    private String cardName;

    private static final long serialVersionUID = 1L;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }
}