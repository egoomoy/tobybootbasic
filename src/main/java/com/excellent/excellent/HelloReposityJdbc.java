package com.excellent.excellent;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HelloReposityJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello == null) jdbcTemplate.update("insert into member values(?,?)", name, 1);
        else jdbcTemplate.update("update member set count = ? where name = ?", hello.getCount() + 1, name);
    }

    @Override
    public Hello findHello(String name) {

        try {
            Hello hello = jdbcTemplate.queryForObject("select * from member where name = '" + name + "'", (rs, rowNum) -> new Hello(
                    rs.getString("name"), rs.getInt("count")
            ));
            return hello;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }
}
