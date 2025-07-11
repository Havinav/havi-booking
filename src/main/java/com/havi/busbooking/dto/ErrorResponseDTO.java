package com.havi.busbooking.dto;

public class ErrorResponseDTO {

    private int status;
    private String error;
    private String message;

    public ErrorResponseDTO(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    // Getters and setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }
    public String getError() { return error; }
    public void setError(String error) { this.error = error; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
