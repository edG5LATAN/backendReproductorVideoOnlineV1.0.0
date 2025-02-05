package proyectoVideo.video.domain.dto.video;

import jakarta.validation.constraints.NotNull;

public record DtoVideo(
        @NotNull String titulo,
        @NotNull String imagen,
        @NotNull String video,
        @NotNull String detalles,
        @NotNull String categoria
) {
}
