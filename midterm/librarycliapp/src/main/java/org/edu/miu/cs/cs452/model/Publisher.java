package org.edu.miu.cs.cs452.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Publisher {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;

    @Override
    public String toString() {
        return "Publisher [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
    }
}
