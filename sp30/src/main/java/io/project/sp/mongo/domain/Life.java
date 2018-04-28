package io.project.sp.mongo.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author armdev
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "life")
public class Life implements Serializable {

    private static final long serialVersionUID = 5803757207294029907L;

    @Id
    private String id;

    @TextIndexed
    private String name;

    private String details;

}
