package ek.ianb.countries.repository;

import ek.ianb.countries.model.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Country> findAll() {
        String sql = "SELECT id, name FROM countries";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Country(rs.getInt("id"), rs.getString("name"))
        );
    }
}




