package io.github.renatonobrega.auth_api.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
