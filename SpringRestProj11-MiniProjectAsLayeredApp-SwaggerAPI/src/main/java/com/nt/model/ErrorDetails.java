//ErrorDetails.java
package com.nt.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
 private LocalDateTime  time;
 private  String status;
 private   String  message;
}
