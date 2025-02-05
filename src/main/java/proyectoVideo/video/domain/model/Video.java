package proyectoVideo.video.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import proyectoVideo.video.domain.dto.video.DtoVideo;

@Entity
@Table(name = "video")
@Getter
@Setter
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_video;
    private String titulo;
    private String imagen;
    private String video;
    private String detalles;
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Categoria categoria;

    public Video(DtoVideo dtoVideo, Categoria categori) {
        this.titulo= dtoVideo.titulo();
        this.imagen= dtoVideo.imagen();
        this.video= dtoVideo.video();
        this.detalles= dtoVideo.detalles();
        this.categoria=categori;
    }


}
