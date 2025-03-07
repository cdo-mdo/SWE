package org.edu.miu.cs.cs452.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private String phone;
    private String address;

    @Override
    public String toString() {
        return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
    }
}
