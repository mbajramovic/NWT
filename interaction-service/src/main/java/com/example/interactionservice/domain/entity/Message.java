package com.example.interactionservice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(max=1000)
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName ="id", nullable=false)
    private Person sender;

    @NotNull
    @ManyToOne
    @JoinColumn(referencedColumnName ="id", nullable=false)
    private Person recipient;

    public Message() {}

    public Message(Person sender, Person recipient, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the sender
     */
    public Person getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(Person sender) {
        this.sender = sender;
    }

    /**
     * @return the recipient
     */
    public Person getRecipient() {
        return recipient;
    }

    /**
     * @param recipient the recipient to set
     */
    public void setRecipient(Person recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "Sender: " + this.sender.getUsername() + "\nRecipient: " + this.recipient.getUsername() + "\nText: " + this.text + "\n";
    }
}