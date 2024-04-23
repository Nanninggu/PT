package com.example.HexagonalArchitecture.Infrastructure;

import com.example.HexagonalArchitecture.domain.NewRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("h2")
@Repository
public class H2NewRepository implements NewRepository {


}
