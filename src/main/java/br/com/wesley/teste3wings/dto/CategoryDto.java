package br.com.wesley.teste3wings.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoryDto {
    @NotEmpty(message = "name can't be empty")
    @Size(max = 50, message = "name must be lower than 51 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
