package com.plainprog.duotexts.model;

import javax.persistence.*;

@Entity
@Table(name = "shared_text")
public class SharedDuoTextModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "text_id")
    private Integer textId;
    @Column(name = "receiver_id")
    private Integer receiverId;
    @Column(name = "wasOpened")
    private Boolean wasOpened;

    public SharedDuoTextModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Boolean getWasOpened() {
        return wasOpened;
    }

    public void setWasOpened(Boolean wasOpened) {
        this.wasOpened = wasOpened;
    }
}
