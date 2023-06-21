package com.excellent.excellent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@MyBootTest
@Rollback(false)
public class JdbcTemplateTEst {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists member(name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into member values(?,?)", "ko", 3);

        Long count = jdbcTemplate.queryForObject("select count(*) from member", Long.class);
        assertThat(count).isEqualTo(1);
    }


    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("insert into member values(?,?)", "ko1", 3);

        Long count = jdbcTemplate.queryForObject("select count(*) from member", Long.class);
        assertThat(count).isEqualTo(1);
    }

}