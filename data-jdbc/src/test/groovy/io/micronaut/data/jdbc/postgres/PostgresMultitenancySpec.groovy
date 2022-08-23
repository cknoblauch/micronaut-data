package io.micronaut.data.jdbc.postgres

import io.micronaut.data.jdbc.AbstractJdbcMultitenancySpec

class PostgresMultitenancySpec extends AbstractJdbcMultitenancySpec {

    @Override
    Map<String, String> getExtraProperties() {
        return [
                'bookRepositoryClass': PostgresBookRepository.name
        ]
    }

    @Override
    Map<String, String> getDataSourceProperties() {
        return [
                'db-type'        : 'postgresql',
                'schema-generate': 'CREATE_DROP',
                'dialect'        : 'POSTGRES'
        ]
    }
}
