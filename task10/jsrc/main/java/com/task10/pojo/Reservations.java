package com.task10.pojo;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "cmtr-57544369-Reservations")
public class Reservations {
    @DynamoDBHashKey
    private String reservationId;
    private int tableNumber;
    private String clientName;
    private String phoneNumber;
    private String date;
    private String slotTimeStart;
    private String slotTimeEnd;

    public String getReservationId() {
        return reservationId;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public String getSlotTimeStart() {
        return slotTimeStart;
    }

    public String getSlotTimeEnd() {
        return slotTimeEnd;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSlotTimeStart(String slotTimeStart) {
        this.slotTimeStart = slotTimeStart;
    }

    public void setSlotTimeEnd(String slotTimeEnd) {
        this.slotTimeEnd = slotTimeEnd;
    }
} 