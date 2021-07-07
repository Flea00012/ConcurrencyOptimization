package com.lee.packaging;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Package {

    private int ID;
    private String name;
    private String origin;
    private String destination;
    private String customer;

}
