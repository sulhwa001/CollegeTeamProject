package kr.ac.ync.zoomgobackend.domain.gosu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
@ToString
@Table(name ="gosu_question")
public class GosuQuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @JoinColumn(name = "gosuId")
    @OneToOne
    private GosuEntity gosuId;

    @Column
    private String question1;
    @Column
    private String question2;
    @Column
    private String question3;
    @Column
    private String question4;
    @Column
    private String question5;
}
