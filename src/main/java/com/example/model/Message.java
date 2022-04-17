package com.example.model;

import java.io.Serializable;

public class Message implements Serializable {

    String relatedReference;

    String transactionReferenceNumber;

    String sndrFinInstnld;

    String rcvrFinInstnld;

    String narrative;

    public String getRelatedReference() {
        return relatedReference;
    }

    public void setRelatedReference(String relatedReference) {
        this.relatedReference = relatedReference;
    }

    public String getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    public void setTransactionReferenceNumber(String transactionReferenceNumber) {
        this.transactionReferenceNumber = transactionReferenceNumber;
    }

    public String getSndrFinInstnld() {
        return sndrFinInstnld;
    }

    public void setSndrFinInstnld(String sndrFinInstnld) {
        this.sndrFinInstnld = sndrFinInstnld;
    }

    public String getRcvrFinInstnld() {
        return rcvrFinInstnld;
    }

    public void setRcvrFinInstnld(String rcvrFinInstnld) {
        this.rcvrFinInstnld = rcvrFinInstnld;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }
}
