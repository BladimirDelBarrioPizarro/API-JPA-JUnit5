package com.example.demo.model.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class LanguageDTO {
    private Long id;
    private String name;
    private Date created_at;
}
