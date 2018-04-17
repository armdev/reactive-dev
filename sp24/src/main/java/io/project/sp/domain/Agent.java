package io.project.sp.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author armdev
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agent implements Serializable{

    private static final long serialVersionUID = -2222835174918861272L;
    
    private String message;
    
}
