package fr.gouv.mte.capqualif.capqualif.request.adapters.out.persistence;

import fr.gouv.mte.capqualif.capqualif.request.domain.marin.request.Document;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.request.Requestor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "requests")
public class RequestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String requestorId;

    @Column
    private String requestorFirstName;

    @Column
    private String requestorLastName;

    @Column
    public String requestedTitreId;

    @Column
    private String requestStatus;

    @Column
    private LocalDateTime startDate;

    @Column
    @OneToMany(mappedBy = "requestId")
    private Set<Document> documents;
}
