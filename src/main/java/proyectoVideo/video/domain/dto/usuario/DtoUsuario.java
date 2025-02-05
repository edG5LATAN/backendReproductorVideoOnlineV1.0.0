package proyectoVideo.video.domain.dto.usuario;

import jakarta.validation.constraints.NotNull;

public record DtoUsuario(
        @NotNull String usuario,
        @NotNull String clave
) {
}
