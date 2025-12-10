package com.movieflix.movieflix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "Nome da categoria é obrigatório.") String name) {
}
