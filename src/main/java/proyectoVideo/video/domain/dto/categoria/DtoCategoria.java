package proyectoVideo.video.domain.dto.categoria;

import jakarta.validation.constraints.NotNull;

public record DtoCategoria(
        @NotNull String nombre,
        @NotNull String informacion,
        @NotNull String usuario
) {
}
